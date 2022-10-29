package codespring.swLanguage.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.swLanguage.business.abstracts.programmingLanguageService;
import codespring.swLanguage.dataAccess.abstracts.programmingLanguagesRepository;
import codespring.swLanguage.entities.concretes.programmingLanguage;

@Service
public class programmingManager implements programmingLanguageService{

    
    private programmingLanguagesRepository pLanguagesRepository;

    @Autowired
    public programmingManager(programmingLanguagesRepository pLanguagesRepository) {
        this.pLanguagesRepository=pLanguagesRepository;
    }

    @Override
    public List<programmingLanguage> getAll() {
        
        return pLanguagesRepository.getAll();
    }

    @Override
    public programmingLanguage getId(int id) throws Exception{
        return this.pLanguagesRepository.getId(id);
    }

    @Override
    public void pLanguageAdd(programmingLanguage pLanguage ) throws Exception{
        if(pLangControl(pLanguage)){
            throw new Exception("aynı veya Boş Olamaz");
        }

        this.pLanguagesRepository.pLanguageAdd(pLanguage);
    }


    @Override
    public void pLanguageUpdate(programmingLanguage pLanguage){
        this.pLanguagesRepository.pLanguageUpdate(pLanguage);
        
    }

    @Override
    public void pLanguageDelete(int id) {
        this.pLanguagesRepository.pLanguageDelete(id);
        
    }
    
    public boolean pLangControl(programmingLanguage pLanguage){
        List<programmingLanguage> pLanguages=pLanguagesRepository.getAll();
        for (programmingLanguage programmingLanguage : pLanguages) {
            if(programmingLanguage.getName().equalsIgnoreCase(pLanguage.getName())
            || pLanguage.getName().equals("")
            ||programmingLanguage.getId()==(pLanguage.getId())){
                return true;
            }
            
        }
        return false;
    }
}
