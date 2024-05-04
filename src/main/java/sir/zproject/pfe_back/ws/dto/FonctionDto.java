package sir.zproject.pfe_back.ws.dto;


import lombok.Getter;
import lombok.Setter;
import sir.zproject.pfe_back.bean.Service;

@Getter
@Setter
public class FonctionDto {
    private Long id;
    private String libelle;
    private String code;
    private Service service;
}
