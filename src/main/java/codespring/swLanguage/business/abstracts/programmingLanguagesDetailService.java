package codespring.swLanguage.business.abstracts;

import java.util.List;
import codespring.swLanguage.business.request.CreateSWLanguagesDetailRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesDetailRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesDetailRequest;
import codespring.swLanguage.business.response.GetAllSWLanguagesDetailResponse;
import codespring.swLanguage.business.response.GetIdSWLanguagesDetailResponse;

public interface programmingLanguagesDetailService {
    List<GetAllSWLanguagesDetailResponse>getAll();
    GetIdSWLanguagesDetailResponse getId(int id);
    void add(CreateSWLanguagesDetailRequest createSWLanguagesDetailRequest) throws Exception;
    void update(UpdateSWLanguagesDetailRequest updateSWLanguagesDetailRequest);
    void delete(DeleteSWLanguagesDetailRequest deleteSWLanguagesDetailRequest);

}
