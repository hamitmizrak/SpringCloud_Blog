package com.hamitmizrak.accountservice.service;
import com.hamitmizrak.accountservice.data.entity.AccountEntity;
import com.hamitmizrak.accountservice.data.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;

//Lombok
@RequiredArgsConstructor

@Service
//@Transactional
public class AccountService {

    //injection constructor
    private final AccountRepository accountRepository;

    //SAVE
    public AccountEntity save(AccountEntity account) {
        return accountRepository.save(account);
    }

    //LIST
    public List<AccountEntity> getAllList() {
        return accountRepository.findAll();
    }

    //FIND
    public AccountEntity getFindId(String id) {
        return accountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    //UPDATE
    public AccountEntity update(String id, AccountEntity account) {
        Assert.isNull(id, "id not null");
        return accountRepository.save(account);
    }

    //DELETE
    public void delete(String id) {
        accountRepository.deleteById(id);
    }
}
