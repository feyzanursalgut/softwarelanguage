package codespring.swLanguage.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.swLanguage.business.abstracts.programmingLanguageService;
import codespring.swLanguage.business.request.CreateSWLanguageRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesRequest;
import codespring.swLanguage.business.response.GetAllSWLanguageResponse;
import codespring.swLanguage.business.response.GetIdSWLanguageResponse;
import codespring.swLanguage.dataAccess.abstracts.SWLanguagesRepository;
import codespring.swLanguage.entities.concretes.programmingLanguage;

@Service
public class programmingManager implements programmingLanguageService{

    public SWLanguagesRepository swLanguagesRepository;

    @Autowired
    public programmingManager(SWLanguagesRepository swLanguagesRepository) {
        this.swLanguagesRepository=swLanguagesRepository;
    }

    @Override
    public List<GetAllSWLanguageResponse> getAll() {
        
        List<programmingLanguage> languages=swLanguagesRepository.findAll();
		List<GetAllSWLanguageResponse>SWLanguageResponses=new ArrayList<>();

		for (programmingLanguage language :languages) {
			GetAllSWLanguageResponse responseItem = new GetAllSWLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());

			SWLanguageResponses.add(responseItem);
		}
		return SWLanguageResponses;
    }

    @Override
    public GetIdSWLanguageResponse getId(int id){
        programmingLanguage pLanguage = swLanguagesRepository.getReferenceById(id);
        GetIdSWLanguageResponse gIdSWLanguagesResponse = new GetIdSWLanguageResponse();
        gIdSWLanguagesResponse.setId(pLanguage.getId());
        gIdSWLanguagesResponse.setName(pLanguage.getName());

        return gIdSWLanguagesResponse;
    }



    @Override
    public void add(CreateSWLanguageRequest createSWLanguageRequest) throws Exception {
        
        programmingLanguage programmingLanguage=new programmingLanguage();
        programmingLanguage.setName(createSWLanguageRequest.getName());
        if(pLangControl(createSWLanguageRequest)){
            throw new Exception("programlama dili hatası");
        }
        this.swLanguagesRepository.save(programmingLanguage);
    }

    
    

    @Override
    public void update(UpdateSWLanguagesRequest updateSWLanguagesRequest) throws Exception{

        programmingLanguage pLanguage = new programmingLanguage();
        pLanguage.setName(updateSWLanguagesRequest.getName());
        pLanguage.setId(updateSWLanguagesRequest.getId());
         if (pLangControl(updateSWLanguagesRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.swLanguagesRepository.save(pLanguage);
        
    }

    public boolean pLangControl(UpdateSWLanguagesRequest updateSWLanguagesRequest){
        List<programmingLanguage> pLanguage=swLanguagesRepository.findAll();
        for (programmingLanguage programmingLanguage : pLanguage) {
            if(programmingLanguage.getName().equalsIgnoreCase(updateSWLanguagesRequest.getName())
            || updateSWLanguagesRequest.getName().equals("")){
                return true;
            }
            
        }
        return false;
    }

    public boolean pLangControl(CreateSWLanguageRequest createSWLanguageRequest){
        List<programmingLanguage> pLanguages = swLanguagesRepository.findAll();
        for (programmingLanguage pLanguage : pLanguages) {
            if (pLanguage.getName().equalsIgnoreCase(createSWLanguageRequest.getName()) 
            || createSWLanguageRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(DeleteSWLanguagesRequest deleteSWLanguagesRequest) {
        programmingLanguage pLanguages = new programmingLanguage();
        pLanguages.setId(deleteSWLanguagesRequest.getId());
        swLanguagesRepository.delete(pLanguages);
    }
}
