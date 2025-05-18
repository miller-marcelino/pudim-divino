package com.apifull.demo.Service;

import com.apifull.demo.Models.Produtos;
import com.apifull.demo.Repository.ProdutoRepository;
import com.apifull.demo.dto.ProdutoDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produtos salvar(ProdutoDto produtoDto) {
        var produto = new Produtos();
        BeanUtils.copyProperties(produtoDto, produto);
        return produtoRepository.save(produto);
    }

    public List<Produtos> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produtos> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produtos atualizar(Long id, ProdutoDto produtoDto) {
        Optional<Produtos> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()) {
            var produto = produtoExistente.get();
            BeanUtils.copyProperties(produtoDto, produto);
            produto.setCod(id);
            return produtoRepository.save(produto);
        }
        return null;
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
} 