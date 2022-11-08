package codespring.swLanguage.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codespring.swLanguage.business.abstracts.programmingLanguagesDetailService;
import codespring.swLanguage.business.request.DeleteSWLanguagesDetailRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesDetailRequest;
import codespring.swLanguage.business.response.GetAllSWLanguagesDetailResponse;
import codespring.swLanguage.business.response.GetIdSWLanguagesDetailResponse;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/details")
public class SWLanguagesDetailController {



    private programmingLanguagesDetailService pLanguagesDetailService;

    @Autowired
    public SWLanguagesDetailController(programmingLanguagesDetailService pLanguagesDetailServices){
        this.pLanguagesDetailService=pLanguagesDetailServices;
    }

    @Operation(summary = "{Kayıtlı programlama dillerini detayları ile birlikte getirir}", tags = "Software Languages Service")
    @GetMapping("/getAll")
    public List<GetAllSWLanguagesDetailResponse> getAll(){
        return pLanguagesDetailService.getAll();
    }
    @PostMapping("/add")
    public GetIdSWLanguagesDetailResponse getId(int id){
        return pLanguagesDetailService.getId(id);
    }

    @Operation(summary = "{Listedeki Kaydı Günceller", tags = "Software Technologies Services")
    @PutMapping("/update")
	public void update(UpdateSWLanguagesDetailRequest updateSWLanguagesDetailRequest) throws Exception{
		pLanguagesDetailService.update(updateSWLanguagesDetailRequest);
	}

    @Operation(summary = "{Listeden Kayıt Siler}", tags = "Software Technologies Services")
    @DeleteMapping("/delete")
	public void delete(DeleteSWLanguagesDetailRequest DeleteSWLanguagesDetailRequest) {
		pLanguagesDetailService.delete(DeleteSWLanguagesDetailRequest);
	}
}
