package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.service.facade.TypeCongeService;
import sir.zproject.pfe_back.ws.converter.TypeCongeConverter;
import sir.zproject.pfe_back.ws.dto.TypeCongeDto;

import java.util.List;

@RestController
public class TypeCongeWS {

    @Autowired
    private TypeCongeService typeCongeService;
    @Autowired
    private TypeCongeConverter typeCongeConverter;

    @GetMapping("/code/{code}")
    public TypeCongeDto findByCode(@PathVariable String code) {
        sir.zproject.pfe_back.bean.TypeConge typeConge = typeCongeService.findByCode(code);
        return typeCongeConverter.toDto(typeConge);
    }

    @GetMapping("/libelle/{libelle}")
    public TypeCongeDto findByLibelle(@PathVariable String libelle) {
        sir.zproject.pfe_back.bean.TypeConge typeConge = typeCongeService.findByLibelle(libelle);
        return typeCongeConverter.toDto(typeConge);
    }

    @DeleteMapping("typeConge/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeCongeService.deleteByCode(code);
    }

    @DeleteMapping("typeConge/libelle/{libelle}")
    @Transactional
    public int deleteByLibelle(@PathVariable String libelle) {
        return typeCongeService.deleteByLibelle(libelle);
    }

    @GetMapping("all/typeConge/")
    public List<TypeCongeDto> findAll() {
        List<sir.zproject.pfe_back.bean.TypeConge> list = typeCongeService.findAll();
        return typeCongeConverter.toDto(list);
    }

    @PostMapping("typeConge/save")
    public int save(@RequestBody sir.zproject.pfe_back.bean.TypeConge typeConge) {
        return typeCongeService.save(typeConge);
    }
}
