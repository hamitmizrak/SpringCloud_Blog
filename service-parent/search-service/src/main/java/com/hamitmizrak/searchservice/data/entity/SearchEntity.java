package com.hamitmizrak.searchservice.data.entity;
import com.hamitmizrak.searchservice.enums.ESearch;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//Lombok
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id"})
@ToString
//@SneakyThrows

//Entity Cassandra
@Entity
@Table(name="search_data")
public class SearchEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Setter
    @Column(name = "search_data_value")
    private String searchValue;

    //Enums
    @Setter
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "search_data_search")
    private ESearch eSearch;

    @Setter
    @Column(name = "created_date")
    private Date createdDate;
}
