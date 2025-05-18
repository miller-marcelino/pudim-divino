package com.apifull.demo.Controller;

import com.apifull.demo.Models.Clientes;
import com.apifull.demo.Service.ClienteService;
import com.apifull.demo.dto.ClienteDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("cadastrar")
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteDto clienteDto) {
        try {
            if (!clienteDto.getSenha().equals(clienteDto.getConfirmasenha())) {
                Map<String, String> erro = new HashMap<>();
                erro.put("message", "As senhas não coincidem");
                return ResponseEntity.badRequest().body(erro);
            }

            Clientes novoCliente = clienteService.salvar(clienteDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        } catch (Exception e) {
            Map<String, String> erro = new HashMap<>();
            erro.put("message", "Erro ao cadastrar cliente: " + e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping("listar-todos")
    public ResponseEntity<List<Clientes>> listarClientes() {
        List<Clientes> clientes = clienteService.listarTodos();
        if(clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientes);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Object> buscarCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clienteService.buscarPorId(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cliente.get());
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable Long id, @RequestBody @Valid ClienteDto clienteDto) {
        Clientes clienteAtualizado = clienteService.atualizar(id, clienteDto);
        if (clienteAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clienteAtualizado);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable Long id) {
        Optional<Clientes> cliente = clienteService.buscarPorId(id);
        if (cliente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        clienteService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Erro de validação");
        response.put("errors", errors);
        return ResponseEntity.badRequest().body(response);
    }
} 