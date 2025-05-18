package com.apifull.demo.Controller;

import com.apifull.demo.Models.Produtos;
import com.apifull.demo.Service.ProdutoService;
import com.apifull.demo.dto.ProdutoDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    private final Path fileStorageLocation = Paths.get("uploads/produtos");

    @Autowired
    private ProdutoService produtoService;

    public ProdutoController() {
        try {
            Files.createDirectories(fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível criar o diretório de upload", ex);
        }
    }

    @PostMapping(value = "cadastrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Produtos> cadastrarProduto(
            @RequestPart("fotoproduto") MultipartFile file,
            @RequestPart("nomeProduto") String nomeProduto,
            @RequestPart("sabor") String sabor,
            @RequestPart("tamanho") String tamanho,
            @RequestPart("peso") String peso,
            @RequestPart("quantidade") String quantidade,
            @RequestPart("preco") String preco,
            @RequestPart("ingredientes") String ingredientes,
            @RequestPart("disponivelparavenda") String disponivelparavenda
    ) {
        try {
            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            Path targetLocation = fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);

            ProdutoDto produtoDto = new ProdutoDto();
            produtoDto.setNomeProduto(nomeProduto);
            produtoDto.setSabor(sabor);
            produtoDto.setTamanho(tamanho);
            produtoDto.setPeso(Double.parseDouble(peso));
            produtoDto.setQuantidade(Integer.parseInt(quantidade));
            produtoDto.setPreco(Double.parseDouble(preco));
            produtoDto.setIngredientes(ingredientes);
            produtoDto.setDisponivelparavenda(Boolean.parseBoolean(disponivelparavenda));
            produtoDto.setFotoproduto(fileName);

            return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvar(produtoDto));
        } catch (IOException ex) {
            throw new RuntimeException("Não foi possível salvar o arquivo", ex);
        }
    }

    @GetMapping("imagem/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String fileName) {
        try {
            Path filePath = fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            
            if(resource.exists()) {
                return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (IOException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("listar-todos")
    public ResponseEntity<List<Produtos>> listarProdutos() {
        List<Produtos> produtos = produtoService.listarTodos();
        if(produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtos);
    }

    @GetMapping("listar/{id}")
    public ResponseEntity<Object> buscarProduto(@PathVariable Long id) {
        Optional<Produtos> produto = produtoService.buscarPorId(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produto.get());
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Object> atualizarProduto(@PathVariable Long id, @RequestBody @Valid ProdutoDto produtoDto) {
        Produtos produtoAtualizado = produtoService.atualizar(id, produtoDto);
        if (produtoAtualizado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Object> deletarProduto(@PathVariable Long id) {
        Optional<Produtos> produto = produtoService.buscarPorId(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        produtoService.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso.");
    }
} 