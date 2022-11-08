package codespring.swLanguage.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.swLanguage.business.abstracts.programmingLanguagesDetailService;
import codespring.swLanguage.business.request.CreateSWLanguagesDetailRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesDetailRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesDetailRequest;
import codespring.swLanguage.business.response.GetAllSWLanguagesDetailResponse;
import codespring.swLanguage.business.response.GetIdSWLanguagesDetailResponse;
import codespring.swLanguage.dataAccess.abstracts.SWLanguagesDetailRepository;
import codespring.swLanguage.dataAccess.abstracts.SWLanguagesRepository;
import codespring.swLanguage.entities.concretes.programmingLanguage;
import codespring.swLanguage.entities.concretes.programminglanguagesdetail;

@Service
public class programmingLanguagesDetailManager implements programmingLanguagesDetailService{

    private SWLanguagesDetailRepository swlDetailRepository;
    private SWLanguagesRepository swLanguagesRepository;

    @Autowired
    public programmingLanguagesDetailManager(SWLanguagesDetailRepository pLanguagesDetailRepository, SWLanguagesRepository swLanguagesRepository){
        this.swlDetailRepository=pLanguagesDetailRepository;
        this.swLanguagesRepository=swLanguagesRepository;
    }


    @Override
    public List<GetAllSWLanguagesDetailResponse> getAll() {
        
        List<programminglanguagesdetail> rProggramingTechnologies = swlDetailRepository.findAll();
        List<GetAllSWLanguagesDetailResponse> pTechnologiesResponses = new ArrayList<>();
        for (programminglanguagesdetail pTechnology : rProggramingTechnologies) {
            GetAllSWLanguagesDetailResponse rTechnologies = new GetAllSWLanguagesDetailResponse();
            programmingLanguage pLanguages = swLanguagesRepository.getReferenceById(pTechnology.getProgrammingLanguage().getId());
            rTechnologies.setId(pTechnology.getId());
            rTechnologies.setName(pTechnology.getName());
            rTechnologies.setProgrammingLanguage(pLanguages.getName());
            pTechnologiesResponses.add(rTechnologies);            
        }
        return pTechnologiesResponses;
    }

    @Override
    public void add(CreateSWLanguagesDetailRequest createSWLanguagesDetailRequest) throws Exception {
        programminglanguagesdetail plDetail = new programminglanguagesdetail();
        programmingLanguage pLanguages = swLanguagesRepository.getReferenceById(createSWLanguagesDetailRequest.getProgrammingLanguageId());
        plDetail.setName(createSWLanguagesDetailRequest.getName());
        plDetail.setProgrammingLanguage(pLanguages);

         if (pTechControl(createSWLanguagesDetailRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.swlDetailRepository.save(plDetail);
        
    }

    public boolean pTechControl(CreateSWLanguagesDetailRequest createSWLanguagesDetailRequest){
        List<programminglanguagesdetail> pTechnologies = swlDetailRepository.findAll();
        for (programminglanguagesdetail pTechnology : pTechnologies) {
            if (pTechnology.getName().equalsIgnoreCase(createSWLanguagesDetailRequest.getName()) 
            || createSWLanguagesDetailRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public GetIdSWLanguagesDetailResponse getId(int id) {
        programminglanguagesdetail plDetail = swlDetailRepository.getReferenceById(id);
        GetIdSWLanguagesDetailResponse getIdPTechnologiesResponse = new GetIdSWLanguagesDetailResponse();
        getIdPTechnologiesResponse.setId(plDetail.getId());
        getIdPTechnologiesResponse.setName(plDetail.getName());

        return getIdPTechnologiesResponse;
    }


    @Override
    public void update(UpdateSWLanguagesDetailRequest updateSWLanguagesDetailRequest) {
        programmingLanguage pLanguages = swLanguagesRepository.getReferenceById(updateSWLanguagesDetailRequest.getProgrammingLanguageId());

        programminglanguagesdetail plDetail = new programminglanguagesdetail();
        plDetail.setId(updateSWLanguagesDetailRequest.getId());
        plDetail.setName(updateSWLanguagesDetailRequest.getName());
        plDetail.setProgrammingLanguage(pLanguages);

         if (pLangControl(updateSWLanguagesDetailRequest)) {
            
        }

        programminglanguagesdetail programminglanguagesdetail = swlDetailRepository.getReferenceById(plDetail.getId());
		programminglanguagesdetail.setName(plDetail.getName());
		programminglanguagesdetail.setProgrammingLanguage(pLanguages);
		swlDetailRepository.save(programminglanguagesdetail);
        
    }

    private boolean pLangControl(UpdateSWLanguagesDetailRequest updateSWLDetailsRequest) {
        List<programminglanguagesdetail> plDetails = swlDetailRepository.findAll();
        for (programminglanguagesdetail plDetail : plDetails) {
            if (plDetail.getName().equalsIgnoreCase(updateSWLDetailsRequest.getName()) 
            || updateSWLDetailsRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void delete(DeleteSWLanguagesDetailRequest deleteSWLanguagesDetailRequest) {
        programminglanguagesdetail plDetails = new programminglanguagesdetail();
        plDetails.setId(deleteSWLanguagesDetailRequest.getId());
        swlDetailRepository.delete(plDetails);
        
    }
    
}
