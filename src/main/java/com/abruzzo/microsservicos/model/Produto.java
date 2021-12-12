package com.abruzzo.microsservicos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "produto")
public class Produto {

    private Long id;
    private String nome;
    private Integer quantidade;

    public Produto(Long id, String nome, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }
}
