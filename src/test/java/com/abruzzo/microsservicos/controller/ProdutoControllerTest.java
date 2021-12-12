package com.abruzzo.microsservicos.controller;

import com.abruzzo.microsservicos.model.Produto;
import com.abruzzo.microsservicos.service.ProdutoService;
import com.google.gson.Gson;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@RunWith(SpringRunner.class)
@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {


    @MockBean
    ProdutoService produtoService;

    @Autowired
    private MockMvc mockMvc;

    Produto produto1 = new Produto(1L, "TV-50''", 200);

    String URL_BASE = "http://localhost:8080";
    String path_produtos = "/produtos";



    @Test
    void whenCallPOSTRequest_saveNewHeroOnDatabase() throws Exception {
        /**
         * @link https://stackoverflow.com/questions/55172843/testing-post-request-controller-with-mockito
         */

        Gson gson = new Gson();
        String jsonString = gson.toJson(produto1);

        when(produtoService.create(any(Produto.class))).thenReturn(produto1);

        mockMvc.perform(post(this.URL_BASE.concat(path_produtos))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString)
                        .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("TV 50''"))
                .andExpect(jsonPath("$.quantidade").value(200));

        ArgumentCaptor<Produto> produtoArgumentCaptor = ArgumentCaptor.forClass(Produto.class);
        verify(produtoService, times(1)).create(produtoArgumentCaptor.capture());
        verifyNoMoreInteractions(produtoService);

        Produto produtoArgument = produtoArgumentCaptor.getValue();
        assertThat(produtoArgument.getId()).isEqualTo(1L);
        assertThat(produtoArgument.getNome()).isEqualTo("TV 50''");
        assertThat(produtoArgument.getQuantidade()).isEqualTo(200);

    }




}
