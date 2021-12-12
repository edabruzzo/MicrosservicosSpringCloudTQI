package com.abruzzo.microsservicos.service;

import com.abruzzo.microsservicos.model.Produto;
import com.abruzzo.microsservicos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto create(Produto produto) {
        return produtoRepository.save(produto);
    }
}
