package com.abruzzo.microsservicos.config;

import lombok.SneakyThrows;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration
@EnableElasticsearchRepositories(basePackages = "com.abruzzo.MicrosservicosSpringCloudTQI.repository")
public class ElasticSearchConfig {


    private static Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    @SneakyThrows
    @Bean
    public RestHighLevelClient client() {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo("localhost:9200", "localhost:9300")
                .build();

        RestHighLevelClient restHighLevelClient = null;
        try(RestClients.ElasticsearchRestClient elasticsearchRestClient = RestClients.create(clientConfiguration)){
            restHighLevelClient = elasticsearchRestClient.rest();
        }catch (Exception exception){
            logger.debug(exception.getLocalizedMessage());
        }finally {
            if(restHighLevelClient != null)
                restHighLevelClient.close();
        }
        return restHighLevelClient;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(client());
    }

}
