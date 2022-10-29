package codespring.swLanguage.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codespring.swLanguage.business.abstracts.programmingLanguageService;
import codespring.swLanguage.entities.concretes.programmingLanguage;

@RestController
@RequestMapping("/api/PLanguages")
public class programmingLanguageController {
    private programmingLanguageService pLanguageService;

   @Autowired
    public programmingLanguageController(programmingLanguageService pLanguageService) {
        this.pLanguageService = pLanguageService;
    }

    @GetMapping("/getAll")
    
    public List<programmingLanguage> getAll() {
        return pLanguageService.getAll();
    }

    @GetMapping("/getId")
    public programmingLanguage getId(@RequestParam int id) throws Exception{
        return this.pLanguageService.getId(id);
    }

    @PostMapping("/setName")
    public void pLanguageAdd(@RequestBody programmingLanguage pLanguage)throws Exception{
        this.pLanguageService.pLanguageAdd(pLanguage);
    }
     
    @PutMapping("/updateName")
    public void pLanguageUpdate(@RequestBody programmingLanguage pLanguage) {
        this.pLanguageService.pLanguageUpdate(pLanguage);
    }

    @DeleteMapping("/delete")
        public void pLanguageDelete(@RequestParam int id){
            this.pLanguageService.pLanguageDelete(id);
    }
}
