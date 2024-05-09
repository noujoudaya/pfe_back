package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.service.facade.FonctionService;
import sir.zproject.pfe_back.ws.converter.FonctionConverter;
import sir.zproject.pfe_back.ws.dto.FonctionDto;

import java.util.List;

@RestController
@RequestMapping("fonction")
public class Fonctionws {

    @Autowired
    private FonctionService fonctionService;
    @Autowired
    private FonctionConverter fonctionConverter;
    @GetMapping("service/code/{code}")
    public List<FonctionDto> findByServiceCode(@PathVariable String code) {
        List<Fonction> fonctions = fonctionService.findByServiceCode(code);
        return fonctionConverter.toDto(fonctions);

    }
    @DeleteMapping("service/code/{code}")
    public int deleteByServiceCode(@PathVariable String code) {
        return fonctionService.deleteByServiceCode(code);
    }
    @GetMapping("/code/{code}")
    public Fonction findByCode(@PathVariable String code) {
        return fonctionService.findByCode(code);
    }
    @GetMapping("/libelle/{libelle}")
    public Fonction findByLibelle(@PathVariable String libelle) {
        return fonctionService.findByLibelle(libelle);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return fonctionService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<Fonction> findAll() {
        return fonctionService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Fonction fonction) {
        return fonctionService.save(fonction);
    }
    @PutMapping("/")
    public int update(@RequestBody Fonction newFonction) {
        return fonctionService.update(newFonction);
    }
}
