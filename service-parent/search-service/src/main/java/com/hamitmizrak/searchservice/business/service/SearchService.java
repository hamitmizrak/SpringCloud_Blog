package com.hamitmizrak.searchservice.business.service;
import com.hamitmizrak.searchservice.business.dto.SearchDto;
import com.hamitmizrak.searchservice.data.entity.SearchEntity;
import com.hamitmizrak.searchservice.data.repository.SearchRepository;
import com.hamitmizrak.searchservice.elasticsearchconfig.SearchConfig;
import com.hamitmizrak.searchservice.elasticsearchmodel.SearchElasticModel;
import com.hamitmizrak.searchservice.elasticsearchmodel.SearchElasticRepository;
import com.hamitmizrak.searchservice.enums.ESearch;
import com.hamitmizrak.searchservice.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Lombok
//@RequiredArgsConstructor

//service
@Service
public class SearchService {

    //injection constructor
    private final SearchRepository searchRepository;
    private final SearchConfig modelMapperBean;

    //Elastic Search Ekledikten sonra injection ekledim
    private final SearchElasticRepository searchElasticRepository;

    @Autowired
    public SearchService(SearchRepository searchRepository, SearchConfig modelMapperBean, SearchElasticRepository searchElasticRepository) {
        this.searchRepository = searchRepository;
        this.modelMapperBean = modelMapperBean;
        this.searchElasticRepository = searchElasticRepository;
    }

    // Model Mapper
    public SearchDto entityToDto(SearchEntity searchEntity) {
        return modelMapperBean.modelMapperMethod().map(searchEntity, SearchDto.class);
    }

    public SearchEntity dtoToEntity(SearchDto searchDto) {
        return modelMapperBean.modelMapperMethod().map(searchDto, SearchEntity.class);
    }

    //CREATE
   @Transactional
    public SearchDto save(SearchDto searchDto) {
        //model mapper
        SearchEntity registerEntity = dtoToEntity(searchDto);

        // mysql
        SearchEntity registerEntity2= searchRepository.save(registerEntity);

        //elastich search
        SearchElasticModel searchElasticModel= SearchElasticModel
                .builder()
                    .id(registerEntity2.getId())
                    .eSearch(ESearch.SEARCHIN)
                    .searchValue(registerEntity2.getSearchValue())
                    .createdDate(registerEntity2.getCreatedDate())
                .build();
        searchElasticRepository.save(searchElasticModel);

        //database kaydedilmiş nesnein ID ile dönüş olsun
        searchDto.setId(registerEntity2.getId());
        return searchDto;
    }

    //LIST
    public List<SearchDto> getAllList() {
        List<SearchEntity> registerEntityList = searchRepository.findAll();
        List<SearchDto> dtoList = new ArrayList<>();
        for (SearchEntity temp : registerEntityList) {
            SearchDto entityToDto = entityToDto(temp);
            dtoList.add(entityToDto);
        }
        return dtoList;
    }


    //FIND
    public SearchDto getFindId(Long id) {
        SearchEntity registerEntity = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        SearchDto entityToDto = entityToDto(registerEntity);
        return entityToDto;
    }

    //UPDATE
    @Transactional
    public SearchDto update(Long id, SearchDto searchDto ) {
        SearchEntity accountEntity = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        if (accountEntity != null) {
            accountEntity.setSearchValue(searchDto.getSearchValue());
           // accountEntity.setESearch(searchDto.getESearch());
            searchRepository.save(accountEntity);
        }
        return searchDto;
    }


    //DELETE
    @Transactional
    public Map<String, Boolean> delete(Long id) {
        SearchEntity registerEntity = searchRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + " id bulunamadı"));
        searchRepository.delete(registerEntity);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
