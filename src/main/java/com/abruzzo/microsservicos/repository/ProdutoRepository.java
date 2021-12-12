package com.abruzzo.microsservicos.repository;

import com.abruzzo.microsservicos.model.Produto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProdutoRepository extends ElasticsearchRepository<Produto, String> {}
