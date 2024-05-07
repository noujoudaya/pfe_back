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
@RequestMapping("fonctions")
public class Fonctionws {

    @Autowired
    private FonctionService fonctionService;
    @Autowired
    private FonctionConverter fonctionConverter;

    @GetMapping("/code/{code}")
    public FonctionDto findByCode(@PathVariable String code) {
        Fonction fonction = fonctionService.findByCode(code);
        return fonctionConverter.toDto(fonction);
    }

    @GetMapping("/libelle/{libelle}")
    public FonctionDto findByLibelle(@PathVariable String libelle) {
        Fonction fonction = fonctionService.findByLibelle(libelle);
        return fonctionConverter.toDto(fonction);
    }

    @GetMapping("/service/{service}")
    public List<FonctionDto> findByService(@RequestBody Service service) {
        List<Fonction> fonctions = fonctionService.findByService(service);
        return fonctionConverter.toDto(fonctions);
    }

    @DeleteMapping("/service/{service}")
    public int deleteByService(@RequestBody Service service) {
        return fonctionService.deleteByService(service);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return fonctionService.deleteByCode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return fonctionService.deleteByLibelle(libelle);
    }

    @GetMapping("/")
    public List<FonctionDto> findAll() {
        List<Fonction> fonctions = fonctionService.findAll();
        return fonctionConverter.toDto(fonctions);
    }

    @PostMapping("/")
    public int save(Fonction fonction) {
        return fonctionService.save(fonction);
    }
}
