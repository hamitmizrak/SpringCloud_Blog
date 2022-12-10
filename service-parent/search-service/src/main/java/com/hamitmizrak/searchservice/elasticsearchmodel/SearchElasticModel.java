package com.hamitmizrak.searchservice.elasticsearchmodel;
import com.hamitmizrak.searchservice.enums.ESearch;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

//Lombok
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//farklın iki nesnenin birbirine eşit olup olmadığını anlamanın yoludur.
@EqualsAndHashCode(of={"id"})

//ElasticSearch
@Document(indexName = "elastic_search")
public class SearchElasticModel implements Serializable {

    //org.springframework.data.annotation.Id;
    @Id
    private Long id;
    private String searchValue;
    private ESearch eSearch;
    private Date createdDate;
}
