package codespring.swLanguage.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;

import codespring.swLanguage.entities.concretes.programminglanguagesdetail;

public interface SWLanguagesDetailRepository extends JpaRepository<programminglanguagesdetail,Integer>{
 
    
}
