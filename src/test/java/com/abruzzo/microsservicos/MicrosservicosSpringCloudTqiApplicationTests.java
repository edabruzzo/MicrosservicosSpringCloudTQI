package com.abruzzo.microsservicos;

import com.abruzzo.microsservicos.controller.ProdutoController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicrosservicosSpringCloudTqiApplicationTests {

	@Autowired
	ProdutoController produtoController;

	@Test
	void contextLoads() {
		// https://spring.io/guides/gs/testing-web/
		Assertions.assertThat(produtoController).isNotNull();
	}

}
