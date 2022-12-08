package com.hamitmizrak.accountservice.business.service;
import com.hamitmizrak.accountservice.bean.ModelMapperBean;
import com.hamitmizrak.accountservice.business.dto.AccountDto;
import com.hamitmizrak.accountservice.data.entity.AccountEntity;
import com.hamitmizrak.accountservice.data.repository.AccountRepository;
import com.hamitmizrak.accountservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Lombok
@RequiredArgsConstructor

//service
@Service
//@Transactional
public class AccountService {

    //injection constructor
    private final AccountRepository accountRepository;
    private final ModelMapperBean modelMapperBean;

    // Model Mapper
    public AccountDto entityToDto(AccountEntity dailyEntity) {
        return modelMapperBean.modelMapperMethod().map(dailyEntity, AccountDto.class);
    }

    public AccountEntity dtoToEntity(AccountDto accountDto) {
        return modelMapperBean.modelMapperMethod().map(accountDto, AccountEntity.class);
    }

    //CREATE
    @Transactional
    public AccountDto save(AccountDto accountDto) {
        AccountEntity registerEntity = dtoToEntity(accountDto);
        accountRepository.save(registerEntity);
        return accountDto;
    }

    //LIST
    public List<AccountDto> getAllList() {
        List<AccountEntity> registerEntityList = accountRepository.findAll();
        List<AccountDto> dtoList = new ArrayList<>();
        for (AccountEntity temp : registerEntityList) {
            AccountDto entityToDto = entityToDto(temp);
            dtoList.add(entityToDto);
        }
        return dtoList;
    }


    //FIND
    public AccountDto getFindId(String id) {
        AccountEntity registerEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        AccountDto entityToDto = entityToDto(registerEntity);
        return entityToDto;
    }

    //UPDATE
    @Transactional
    public AccountDto update(String id, AccountDto accountDto ) {
        AccountEntity accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        if (accountEntity != null) {
            accountEntity.setName(accountDto.getName());
            accountEntity.setEmail(accountDto.getEmail());
            accountEntity.setSurname(accountDto.getSurname());
            accountEntity.setPasswd(accountDto.getPasswd());
            accountEntity.setUsername(accountDto.getUsername());
            accountRepository.save(accountEntity);
        }
        return accountDto;
    }


    //DELETE
    @Transactional
    public Map<String, Boolean> delete(String id) {
        AccountEntity registerEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        accountRepository.delete(registerEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
