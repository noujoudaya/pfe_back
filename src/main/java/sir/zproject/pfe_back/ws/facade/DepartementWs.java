package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.service.facade.DepartementService;
import sir.zproject.pfe_back.ws.converter.DepartementConverter;
import sir.zproject.pfe_back.ws.dto.DepartementDto;

import java.util.List;

@RestController
@RequestMapping("departements")
public class DepartementWs {

    @Autowired
    private DepartementService departementService;
    @Autowired
    private DepartementConverter departementConverter;

    @GetMapping("/code/{code}")
    public DepartementDto findByCode(@PathVariable String code) {
        Departement departement = departementService.findByCode(code);
        return departementConverter.toDto(departement);
    }

    @GetMapping("/libelle/{libelle}")
    public DepartementDto findByLibelle(@PathVariable String libelle) {
        Departement departement = departementService.findByLibelle(libelle);
        return departementConverter.toDto(departement);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return departementService.deleteByCode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return departementService.deleteByLibelle(libelle);
    }

    @GetMapping("/")
    public List<DepartementDto> findAll() {
        List<Departement> departements = departementService.findAll();
        return departementConverter.toDto(departements);
    }

    @PostMapping("/")
    public int save(@RequestBody Departement departement) {
        return departementService.save(departement);
    }
}
