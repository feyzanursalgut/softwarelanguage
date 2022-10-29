package codespring.swLanguage.business.abstracts;

import java.util.List;

import codespring.swLanguage.entities.concretes.programmingLanguage;

public interface programmingLanguageService {
    List <programmingLanguage> getAll();
    programmingLanguage getId(int id) throws Exception;
    void pLanguageAdd(programmingLanguage pLanguage) throws Exception;
    void pLanguageUpdate(programmingLanguage pLanguage) ;
    void pLanguageDelete(int id);

   
    
}
