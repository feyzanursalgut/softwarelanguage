package codespring.swLanguage.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import codespring.swLanguage.entities.concretes.programmingLanguage;

public interface SWLanguagesRepository extends JpaRepository<programmingLanguage, Integer>{

    // void add(CreateSWLanguageRequest createSWLanguageRequest);

}
