package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Rubrique;
import sir.zproject.pfe_back.dao.RubriqueDao;
import sir.zproject.pfe_back.ws.converter.RubriqueConverter;
import sir.zproject.pfe_back.ws.dto.EmployeDto;
import sir.zproject.pfe_back.ws.dto.RubriqueDto;

import java.util.List;

@RestController
public class RubriqueWs {
    @Autowired
    private RubriqueDao rubriqueDao;
    @Autowired
    private RubriqueConverter rubriqueConverter;
@GetMapping("rubrique/code/{code}")
    public RubriqueDto findByCode(@PathVariable Long code) {
    Rubrique rubrique = rubriqueDao.findByCode(code);
    return rubriqueConverter.toDto(rubrique);
}
@GetMapping("rubrique/")
    public List<RubriqueDto> findAll() {
    List<Rubrique> rubriques = rubriqueDao.findAll();
    return rubriqueConverter.toDto(rubriques);
}

}
