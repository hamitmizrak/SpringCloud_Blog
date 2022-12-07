package com.hamitmizrak.accountservice.data.repository;

import com.hamitmizrak.accountservice.data.entity.AccountEntity;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CassandraRepository<AccountEntity,String> {
}
