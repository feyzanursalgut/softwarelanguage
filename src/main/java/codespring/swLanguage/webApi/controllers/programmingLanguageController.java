package codespring.swLanguage.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import codespring.swLanguage.business.abstracts.programmingLanguageService;
import codespring.swLanguage.business.request.CreateSWLanguageRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesRequest;
import codespring.swLanguage.business.response.GetAllSWLanguageResponse;
import codespring.swLanguage.business.response.GetIdSWLanguageResponse;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/api/PLanguages")

public class programmingLanguageController {
    
    private programmingLanguageService pLanguageService;

   @Autowired
    public programmingLanguageController(programmingLanguageService pLanguageService) {
        this.pLanguageService = pLanguageService;
    }

    
    @Operation(summary = "**Kayıtlı datayı getirir.**" , tags = "Software Languages Application")
    @GetMapping("/getAll")
    public List<GetAllSWLanguageResponse> getAll() {
        return pLanguageService.getAll();
    }

    @GetMapping("/getId")
    @Operation(summary = "**Kayıtlı datayı Id'sine göre arattığınızda getirir.**",tags = "Software Languages Application")
    public GetIdSWLanguageResponse getId( int id) throws Exception{
        return this.pLanguageService.getId(id);
    }

    
    @Operation(summary = "**Yeni bir kayıt ekler.Değerler boş gönderilemez.**", tags = "Software Languages Application")
    @PostMapping("/add")
    public void add(@RequestBody CreateSWLanguageRequest createSWLanguageRequest) throws Exception{
        this.pLanguageService.add(createSWLanguageRequest);
    }
     
    @PutMapping("/updateName")
    @Operation(summary = "**Kayıtlı datayı günceller. Aynı değer birden fazla eklenemez.**", tags = "Software Languages Application")
    public void update(@RequestBody UpdateSWLanguagesRequest updateSWLanguagesRequest) throws Exception {
        this.pLanguageService.update(updateSWLanguagesRequest);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "**Kayıtlı datayı siler.**", tags = "Software Languages Application")
        public void delete(DeleteSWLanguagesRequest deleteSWLanguagesRequest){
            pLanguageService.delete(deleteSWLanguagesRequest);
}
}
