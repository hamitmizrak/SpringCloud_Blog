package com.hamitmizrak.searchservice.elasticsearchmodel;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchElasticRepository extends ElasticsearchRepository <SearchElasticModel,String>{
}
