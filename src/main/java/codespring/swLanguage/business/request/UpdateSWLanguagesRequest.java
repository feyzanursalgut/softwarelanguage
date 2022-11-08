package codespring.swLanguage.business.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSWLanguagesRequest {
    private int id;
    private String name;
}
