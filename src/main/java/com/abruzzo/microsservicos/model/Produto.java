package com.abruzzo.microsservicos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "produto", type="catalog")
public class Produto {

    private Long id;
    private String nome;
    private Integer quantidade;

}
