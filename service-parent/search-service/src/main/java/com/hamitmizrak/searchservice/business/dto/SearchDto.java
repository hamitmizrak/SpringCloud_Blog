package com.hamitmizrak.searchservice.business.dto;
import com.hamitmizrak.searchservice.enums.ESearch;
import lombok.*;
import java.util.Date;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@SneakyThrows
public class SearchDto {
    private Long id;
    private String searchValue;
    //Enum sadece String olarak görünmesini isteyelim.
    private ESearch eSearch;
    private Date createdDate;
}
