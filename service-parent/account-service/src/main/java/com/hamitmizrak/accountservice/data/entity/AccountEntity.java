package com.hamitmizrak.accountservice.data.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

//Lombok
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
//@SneakyThrows

//Entity Cassandra
@Table(value="accounts")
public class AccountEntity implements Serializable {

    @PrimaryKey
    private String id= UUID.randomUUID().toString();

    @Setter
    @Column(value="name")
    private String name;

    @Setter
    @Column(value="username")
    private String username;

    @Setter
    @Column(value="surname")
    private String surname;

    @Setter
    @Column(value="user_password")
    private String passwd;

    @Setter
    @Column(value="user_email")
    private String email;

    @Column(value="is_active")
    private Boolean active;

    @Column(value="created_date")
    private Date createdDate;

    //parametreli constructor
    public AccountEntity(String id) {
        this.id = id;
    }
}
