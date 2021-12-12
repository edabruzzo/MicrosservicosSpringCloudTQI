package com.abruzzo.microsservicos.controller;

import com.abruzzo.microsservicos.model.Produto;
import com.abruzzo.microsservicos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping(produces=MediaType.APPLICATION_JSON_VALUE)
    public Produto create(@RequestBody Produto produto){
        return produtoService.create(produto);
    }



}
