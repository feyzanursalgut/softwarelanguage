package codespring.swLanguage.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import codespring.swLanguage.dataAccess.abstracts.programmingLanguagesRepository;
import codespring.swLanguage.entities.concretes.programmingLanguage;

@Repository
public class inMemoryProgrammingLanguage implements programmingLanguagesRepository {

    List<programmingLanguage> programmingLanguages;

    public inMemoryProgrammingLanguage(){
        programmingLanguages = new ArrayList<programmingLanguage>() ;

        programmingLanguages.add(new programmingLanguage(0,"c#"));
        programmingLanguages.add(new programmingLanguage(1,"Java"));
        programmingLanguages.add(new programmingLanguage(2,"Python"));
    }
    @Override
    public List<programmingLanguage> getAll() {
        
        return programmingLanguages;
    }

    @Override
    public programmingLanguage getId(int id){
        for (programmingLanguage language:programmingLanguages){
            if(language.getId()==id){
                return language;
            }
        }
        return null;
    }
    @Override
    public void pLanguageAdd(programmingLanguage pLanguage) {
        this.programmingLanguages.add(pLanguage);
        
    }
    @Override
    public void pLanguageUpdate(programmingLanguage pLanguage) {
        for (programmingLanguage pLang : programmingLanguages) {
            if(pLanguage.getId()==pLang.getId()){
                pLang.setName(pLanguage.getName());
            }
            
        }
    }
    
    @Override
    public void pLanguageDelete(int id) {
        this.programmingLanguages.remove(id);
        
    }
    
    

}
