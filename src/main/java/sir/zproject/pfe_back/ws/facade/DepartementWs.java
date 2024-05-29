package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.service.facade.DepartementService;
import sir.zproject.pfe_back.ws.converter.DepartementConverter;
import sir.zproject.pfe_back.ws.dto.DepartementDto;

import java.util.List;

@RestController
public class DepartementWs {

    private final DepartementService departementService;
    @Autowired
    private DepartementConverter departementConverter;

    public DepartementWs(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("departement/code/{code}")
    public DepartementDto findByCode(@PathVariable String code) {
        Departement departement = departementService.findByCode(code);
        return departementConverter.toDto(departement);
    }

    @GetMapping("departement/libelle/{libelle}")
    public DepartementDto findByLibelle(@PathVariable String libelle) {
        Departement departement = departementService.findByCode(libelle);
        return departementConverter.toDto(departement);
    }

    @DeleteMapping("admin/departement/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return departementService.deleteByCode(code);
    }

    @GetMapping("all/departement/")
    public List<Departement> findAll() {
        return departementService.findAll();
    }

    @PostMapping("admin/departement/")
    public int save(@RequestBody Departement departement) {
        return departementService.save(departement);
    }

    @PutMapping("admin/departement/")
    public int update(@RequestBody Departement newDepartement) {
        return departementService.update(newDepartement);
    }

    @GetMapping("admin/departement/paginated")
    public ResponseEntity<Page<Departement>> getDepartements(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Departement> demandesPage = departementService.getDepartements(page, size);
        return ResponseEntity.ok().body(demandesPage);
    }
}
