package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;
import sir.zproject.pfe_back.service.facade.DemandeAttestationService;
import sir.zproject.pfe_back.ws.converter.DemandeAttestationConverter;
import sir.zproject.pfe_back.ws.dto.DemandeAttestationDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/demandesAttestation")
public class DemandeAttestationWS {

    @Autowired
    private DemandeAttestationService demandeAttestationService;
    @Autowired
    private DemandeAttestationConverter demandeAttestationConverter;

    @GetMapping("/employe")
    public List<DemandeAttestationDto> findByEmploye(@RequestBody Employe employe) {
        List<DemandeAttestation> list = demandeAttestationService.findByEmploye(employe);
        return demandeAttestationConverter.toDto(list);
    }

    @Transactional
    @DeleteMapping("/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return demandeAttestationService.deleteByEmploye(employe);
    }

    @Transactional
    @DeleteMapping("/employe/dateDemande/{dateDemande}")
    public int deleteByEmployeAndDateDemande(@RequestBody Employe employe, @PathVariable LocalDate dateDemande) {
        return demandeAttestationService.deleteByEmployeAndDateDemande(employe, dateDemande);
    }

    @GetMapping("/dateDemande/{dateDemande}")
    public List<DemandeAttestationDto> findByDateDemande(@PathVariable LocalDate dateDemande) {
        List<DemandeAttestation> list = demandeAttestationService.findByDateDemande(dateDemande);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("/typeAttestation/{typeAttestation}")
    public List<DemandeAttestationDto> findByTypeAttestation(@PathVariable TypeAttestation typeAttestation) {
        List<DemandeAttestation> list = demandeAttestationService.findByTypeAttestation(typeAttestation);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("/statutAttestation/{statutAttestation}")
    public List<DemandeAttestationDto> findByStatutAttestation(@PathVariable StatutAttestation statutAttestation) {
        List<DemandeAttestation> list = demandeAttestationService.findByStatutAttestation(statutAttestation);
        return demandeAttestationConverter.toDto(list);
    }

    @GetMapping("/")
    public List<DemandeAttestationDto> findAll() {
        List<DemandeAttestation> list = demandeAttestationService.findAll();
        return demandeAttestationConverter.toDto(list);
    }

    @PostMapping("/save")
    public int save(@RequestBody DemandeAttestation demandeAttestation) {
        return demandeAttestationService.save(demandeAttestation);
    }

    @PostMapping("/preparerDemande")
    public String preparerDemande(@RequestBody DemandeAttestation demande) {
        return demandeAttestationService.preparerDemande(demande);
    }

    @PostMapping("/validerDemande")
    public String validerDemande(@RequestBody DemandeAttestation demande) {
        return demandeAttestationService.validerDemande(demande);
    }

    @PostMapping("/update")
    public int update(@RequestBody DemandeAttestation demandeAttestation) {
        return demandeAttestationService.update(demandeAttestation);
    }
}
