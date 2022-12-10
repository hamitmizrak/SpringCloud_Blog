package com.hamitmizrak.searchservice.ui.api;
import com.hamitmizrak.searchservice.business.dto.SearchDto;
import com.hamitmizrak.searchservice.business.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Lombok
@RequiredArgsConstructor

//REST
@RestController
@RequestMapping("search")
public class SearchApi {

    //Injection
    private final SearchService searchService;

    //http://localhost:8502/search
    //CREATE
    @PostMapping
    public ResponseEntity<SearchDto> save(@RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(searchService.save(searchDto));
    }

    //http://localhost:8502/search
    //LIST
    @GetMapping
    public ResponseEntity<List<SearchDto>> getAllList() {
        return ResponseEntity.ok(searchService.getAllList());
    }

    //http://localhost:8502/search/1
    //FIND
    @GetMapping("/{id}")
    public ResponseEntity<SearchDto> getFindId(@PathVariable("id")  Long id) {
        return ResponseEntity.ok(searchService.getFindId(id));
    }

    //http://localhost:8502/search/1
    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<SearchDto> update(@PathVariable("id")  Long id, @RequestBody SearchDto searchDto) {
        return ResponseEntity.ok(searchService.update(id,searchDto));
    }

    //http:localhost:8502/search/1
    //DELETE
    //delete id yeterli obje göndermiyorum ki serveri yormamayayımö
    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")  Long id) {
        searchService.delete(id);
    }
}
