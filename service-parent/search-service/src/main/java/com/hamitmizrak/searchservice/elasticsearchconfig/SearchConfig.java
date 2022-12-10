package com.hamitmizrak.searchservice.elasticsearchconfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
// repository görmezse
@EnableJpaRepositories("com.hamitmizrak")
@EnableElasticsearchRepositories
@ComponentScan("com.hamitmizrak")
public class SearchConfig {

    @Bean
    public ModelMapper modelMapperMethod(){
        return new ModelMapper();
    }
}
