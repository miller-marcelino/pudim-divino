package com.apifull.demo.Service;

import com.apifull.demo.Models.Clientes;
import com.apifull.demo.Repository.ClienteRepository;
import com.apifull.demo.dto.ClienteDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Clientes salvar(ClienteDto clienteDto) throws Exception {
        // Verifica se o email já está cadastrado
        if (clienteRepository.findByEmail(clienteDto.getEmail()).isPresent()) {
            throw new Exception("Email já cadastrado");
        }

        // Verifica se as senhas coincidem
        if (!clienteDto.getSenha().equals(clienteDto.getConfirmasenha())) {
            throw new Exception("As senhas não coincidem");
        }

        // Remove formatação do WhatsApp
        clienteDto.setWhatsapp(clienteDto.getWhatsapp().replaceAll("\\D", ""));

        var cliente = new Clientes();
        BeanUtils.copyProperties(clienteDto, cliente);
        return clienteRepository.save(cliente);
    }

    public List<Clientes> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Clientes> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Clientes atualizar(Long id, ClienteDto clienteDto) {
        Optional<Clientes> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            var cliente = clienteExistente.get();
            BeanUtils.copyProperties(clienteDto, cliente);
            cliente.setCod(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }
} 