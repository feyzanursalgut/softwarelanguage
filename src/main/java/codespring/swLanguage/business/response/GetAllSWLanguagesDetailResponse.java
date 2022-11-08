package codespring.swLanguage.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSWLanguagesDetailResponse {
    private int id;
    private String name;
    private String programmingLanguage;
}
