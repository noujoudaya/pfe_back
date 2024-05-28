package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutConge;
import sir.zproject.pfe_back.bean.TypeConge;
import sir.zproject.pfe_back.service.facade.DemandeCongeService;
import sir.zproject.pfe_back.ws.converter.DemandeCongeConverter;
import sir.zproject.pfe_back.ws.dto.DemandeCongeDto;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DemandeCongeWS {

    @Autowired
    private DemandeCongeService demandeCongeService;
    @Autowired
    private DemandeCongeConverter demandeCongeConverter;


    @PostMapping("employe-secretaire/demandesConge/employe")
    public List<DemandeCongeDto> findByEmploye(@RequestBody Employe employe) {
        List<DemandeConge> list = demandeCongeService.findByEmploye(employe);
        return demandeCongeConverter.toDto(list);
    }

    @DeleteMapping("demandesConge/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return demandeCongeService.deleteByEmploye(employe);
    }

    @DeleteMapping("/statutConge/{statutConge}")
    public int deleteByStatutConge(@PathVariable StatutConge statutConge) {
        return demandeCongeService.deleteByStatutConge(statutConge);
    }

    @DeleteMapping("/typeConge")
    public int deleteByTypeConge(@RequestBody TypeConge typeConge) {
        return demandeCongeService.deleteByTypeConge(typeConge);
    }

    @DeleteMapping("/dateDebut/{dateDebut}")
    public int deleteByDateDebut(@PathVariable LocalDate dateDebut) {
        return demandeCongeService.deleteByDateDebut(dateDebut);
    }

    @DeleteMapping("/dateFin/{dateFin}")
    public int deleteByDateFin(@PathVariable LocalDate dateFin) {
        return demandeCongeService.deleteByDateFin(dateFin);
    }

    @GetMapping("demandesConge/dateDemande/{dateDemande}")
    public List<DemandeCongeDto> findByDateDemande(@PathVariable LocalDate dateDemande) {
        List<DemandeConge> list = demandeCongeService.findByDateDemande(dateDemande);
        return demandeCongeConverter.toDto(list);
    }

    @GetMapping("/dateDebut/{dateDebut}")
    public List<DemandeCongeDto> findByDateDebut(@PathVariable LocalDate dateDebut) {
        List<DemandeConge> list = demandeCongeService.findByDateDebut(dateDebut);
        return demandeCongeConverter.toDto(list);
    }

    @GetMapping("/dateFin/{dateFin}")
    public List<DemandeCongeDto> findByDateFin(@PathVariable LocalDate dateFin) {
        List<DemandeConge> list = demandeCongeService.findByDateFin(dateFin);
        return demandeCongeConverter.toDto(list);
    }

    @GetMapping("/typeConge")
    public List<DemandeCongeDto> findByTypeConge(@RequestBody TypeConge typeConge) {
        List<DemandeConge> list = demandeCongeService.findByTypeConge(typeConge);
        return demandeCongeConverter.toDto(list);
    }

    @GetMapping("/statutConge/{statutConge}")
    public List<DemandeCongeDto> findByStatutConge(@PathVariable StatutConge statutConge) {
        List<DemandeConge> list = demandeCongeService.findByStatutConge(statutConge);
        return demandeCongeConverter.toDto(list);
    }

    @GetMapping("admin/demandesConge/")
    public List<DemandeCongeDto> findAll() {
        List<DemandeConge> list = demandeCongeService.findAll();
        return demandeCongeConverter.toDto(list);
    }

    @PostMapping("employe-secretaire/demandesConge/save")
    public int save(@RequestBody DemandeConge demandeConge) {
        return demandeCongeService.save(demandeConge);
    }

    @PostMapping("admin/demandesConge/accepterDemande")
    public String accepterDemande(@RequestBody DemandeConge demande) {
        return demandeCongeService.accepterDemande(demande);
    }

    @PostMapping("admin/demandesConge/refuserDemande")
    public String refuserDemande(@RequestBody DemandeConge demande) {
        return demandeCongeService.refuserDemande(demande);
    }

    @PostMapping("demandesConge/update")
    public int update(@RequestBody DemandeConge demandeConge) {
        return demandeCongeService.update(demandeConge);
    }

    @GetMapping("admin/demandesConge/search")
    public List<DemandeConge> searchByAllAttributs(@RequestParam String search) {
        return demandeCongeService.searchByAllAttributs(search);
    }

    @GetMapping("admin/demandesConge/countByStatutConge")
    public long countByStatutConge() {
        return demandeCongeService.countByStatutConge();
    }

    @PostMapping("all/demandesConge/deleteConge/{dateDemande}/{employeId}/{typeCongeLibelle}")
    public int deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(@PathVariable LocalDate dateDemande, @PathVariable long employeId, @PathVariable String typeCongeLibelle) {
        return demandeCongeService.deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(dateDemande, employeId, typeCongeLibelle);
    }

    @GetMapping("admin/demandesConge/paginated")
    public ResponseEntity<Page<DemandeConge>> getDemandesConge(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        Page<DemandeConge> demandesPage = demandeCongeService.getDemandesConge(page, size);
        return ResponseEntity.ok().body(demandesPage);
    }
}
