package codespring.swLanguage.dataAccess.abstracts;

import java.util.List;

import codespring.swLanguage.entities.concretes.programmingLanguage;

public interface programmingLanguagesRepository {
    
    List<programmingLanguage> getAll();

    programmingLanguage getId(int id);
    void pLanguageAdd(programmingLanguage pLanguage);
    void pLanguageUpdate(programmingLanguage pLanguage);
    void pLanguageDelete(int id);
}
