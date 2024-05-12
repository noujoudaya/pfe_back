package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.TypeConge;
import sir.zproject.pfe_back.service.facade.TypeCongeService;
import sir.zproject.pfe_back.ws.converter.TypeCongeConverter;
import sir.zproject.pfe_back.ws.dto.TypeCongeDto;

import java.util.List;

@RestController
@RequestMapping("typeConge")
public class TypeContrat {

    @Autowired
    private TypeCongeService typeCongeService;
    @Autowired
    private TypeCongeConverter typeCongeConverter;

    @GetMapping("/code/{code}")
    public TypeCongeDto findByCode(@PathVariable String code) {
        TypeConge typeConge = typeCongeService.findByCode(code);
        return typeCongeConverter.toDto(typeConge);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeCongeDto findByLibelle(@PathVariable String libelle) {
        TypeConge typeConge = typeCongeService.findByLibelle(libelle);
        return typeCongeConverter.toDto(typeConge);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeCongeService.deleteByCode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    @Transactional
    public int deleteByLibelle(@PathVariable String libelle) {
        return typeCongeService.deleteByLibelle(libelle);
    }

    @GetMapping("/")
    public List<TypeCongeDto> findAll() {
        List<TypeConge> list = typeCongeService.findAll();
        return typeCongeConverter.toDto(list);
    }

    @PostMapping("/")
    public int save(@RequestBody TypeConge typeConge) {
        return typeCongeService.save(typeConge);
    }
}
