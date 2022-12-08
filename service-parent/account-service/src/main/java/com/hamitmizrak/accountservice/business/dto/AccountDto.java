package com.hamitmizrak.accountservice.business.dto;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Date;
import java.util.UUID;

//Lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
//@SneakyThrows
public class AccountDto {

    private String id;
    private String name;
    private String username;
    private String surname;
    private String email;
    private String passwd;
    private Boolean active;

}
