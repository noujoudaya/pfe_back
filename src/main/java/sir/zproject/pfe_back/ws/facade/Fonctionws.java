package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.service.facade.FonctionService;
import sir.zproject.pfe_back.ws.converter.FonctionConverter;
import sir.zproject.pfe_back.ws.dto.FonctionDto;

import java.util.List;

@RestController
public class Fonctionws {

    @Autowired
    private FonctionService fonctionService;
    @Autowired
    private FonctionConverter fonctionConverter;
    @GetMapping("fonction/service/code/{code}")
    public List<FonctionDto> findByServiceCode(@PathVariable String code) {
        List<Fonction> fonctions = fonctionService.findByServiceCode(code);
        return fonctionConverter.toDto(fonctions);

    }
    @DeleteMapping("fonction/service/code/{code}")
    public int deleteByServiceCode(@PathVariable String code) {
        return fonctionService.deleteByServiceCode(code);
    }
    @GetMapping("fonction/code/{code}")
    public Fonction findByCode(@PathVariable String code) {
        return fonctionService.findByCode(code);
    }
    @GetMapping("fonction/libelle/{libelle}")
    public Fonction findByLibelle(@PathVariable String libelle) {
        return fonctionService.findByLibelle(libelle);
    }
    @DeleteMapping("admin/fonction/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return fonctionService.deleteByCode(code);
    }
    @GetMapping("all/fonction/")
    public List<Fonction> findAll() {
        return fonctionService.findAll();
    }
    @PostMapping("admin/fonction/")
    public int save(@RequestBody Fonction fonction) {
        return fonctionService.save(fonction);
    }
    @PutMapping("admin/fonction/")
    public int update(@RequestBody Fonction newFonction) {
        return fonctionService.update(newFonction);
    }

    @GetMapping("admin/fonction/paginated")
    public ResponseEntity<Page<Fonction>> getFonctions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        Page<Fonction> demandesPage = fonctionService.getFonctions(page, size);
        return ResponseEntity.ok().body(demandesPage);
    }
}
