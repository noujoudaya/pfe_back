package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.*;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;
import sir.zproject.pfe_back.service.facade.DemandeAttestationService;
import sir.zproject.pfe_back.ws.converter.DemandeAttestationConverter;
import sir.zproject.pfe_back.ws.dto.DemandeAttestationDto;

import java.time.LocalDate;
import java.util.List;

@RestController
public class DemandeAttestationWS {

    @Autowired
    private DemandeAttestationService demandeAttestationService;
    @Autowired
    private DemandeAttestationConverter demandeAttestationConverter;

    @PostMapping("employe-secretaire/demandesAttestation/employe")
    public List<DemandeAttestationDto> findByEmploye(@RequestBody Employe employe) {
        List<DemandeAttestation> list = demandeAttestationService.findByEmploye(employe);
        return demandeAttestationConverter.toDto(list);
    }

    @Transactional
    @DeleteMapping("demandesAttestation/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return demandeAttestationService.deleteByEmploye(employe);
    }

    @Transactional
    @DeleteMapping("all/demandesAttestation/deleteAttest/{employeId}/{dateDemande}")
    public int deleteByEmployeIdAndDateDemande(@PathVariable long employeId, @PathVariable LocalDate dateDemande) {
        return demandeAttestationService.deleteByEmployeIdAndDateDemande(employeId, dateDemande);
    }

    @GetMapping("demandesAttestation/dateDemande/{dateDemande}")
    public List<DemandeAttestationDto> findByDateDemande(@PathVariable LocalDate dateDemande) {
        List<DemandeAttestation> list = demandeAttestationService.findByDateDemande(dateDemande);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("demandesAttestation/typeAttestation/{typeAttestation}")
    public List<DemandeAttestationDto> findByTypeAttestation(@PathVariable TypeAttestation typeAttestation) {
        List<DemandeAttestation> list = demandeAttestationService.findByTypeAttestation(typeAttestation);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("demandesAttestation/statutAttestation/{statutAttestation}")
    public List<DemandeAttestationDto> findByStatutAttestation(@PathVariable StatutAttestation statutAttestation) {
        List<DemandeAttestation> list = demandeAttestationService.findByStatutAttestation(statutAttestation);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("admin/demandesAttestation/")
    public List<DemandeAttestationDto> findAll() {
        List<DemandeAttestation> list = demandeAttestationService.findAll();
        return demandeAttestationConverter.toDto(list);
    }

    @PostMapping("employe-secretaire/demandesAttestation/save")
    public int save(@RequestBody DemandeAttestation demandeAttestation) {
        return demandeAttestationService.save(demandeAttestation);
    }

    @PostMapping("admin/demandesAttestation/preparerDemande")
    public String preparerDemande(@RequestBody DemandeAttestation demande) {
        return demandeAttestationService.preparerDemande(demande);
    }

    @PostMapping("admin/demandesAttestation/validerDemande")
    public String validerDemande(@RequestBody DemandeAttestation demande) {
        return demandeAttestationService.validerDemande(demande);
    }

    @PostMapping("demandesAttestation/update")
    public int update(@RequestBody DemandeAttestation demandeAttestation) {
        return demandeAttestationService.update(demandeAttestation);
    }

    @GetMapping("admin/demandesAttestation/search")
    public List<DemandeAttestation> searchByAllAttributs(@RequestParam String search) {
        return demandeAttestationService.searchByAllAttributs(search);
    }

    @GetMapping("admin/demandesAttestation/countByStatutDemande")
    public long countByStatutDemande() {
        return demandeAttestationService.countByStatutDemande();
    }

    @GetMapping("admin/demandesAttestation/paginated")
    public ResponseEntity<Page<DemandeAttestation>> getDemandesAttestation(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        Page<DemandeAttestation> demandesPage = demandeAttestationService.getDemandesAttest(page, size);
        return ResponseEntity.ok().body(demandesPage);
    }

    @PostMapping("employe-secretaire/demandesAttestation/employe/paginated")
    public ResponseEntity<Page<DemandeAttestation>> getDemandesAttestByEmploye(
            @RequestBody Employe employe,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<DemandeAttestation> demandesPage = demandeAttestationService.getDemandesAttestByEmploye(employe, page, size);
        return ResponseEntity.ok().body(demandesPage);
    }

}
