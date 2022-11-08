package codespring.swLanguage.business.abstracts;

import java.util.List;

import codespring.swLanguage.business.request.CreateSWLanguageRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesRequest;
import codespring.swLanguage.business.response.GetAllSWLanguageResponse;
import codespring.swLanguage.business.response.GetIdSWLanguageResponse;

public interface programmingLanguageService {
    List<GetAllSWLanguageResponse> getAll();
    GetIdSWLanguageResponse getId(int id);
    void add(CreateSWLanguageRequest createSWLanguageRequest) throws Exception;
    void update(UpdateSWLanguagesRequest updateSWLanguagesRequest) throws Exception;
    void delete(DeleteSWLanguagesRequest deleteSWLanguagesRequest);
   
    
}
