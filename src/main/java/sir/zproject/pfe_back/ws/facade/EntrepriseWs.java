package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Entreprise;
import sir.zproject.pfe_back.service.facade.EntrepriseService;
import sir.zproject.pfe_back.ws.converter.EntrepriseConverter;
import sir.zproject.pfe_back.ws.dto.EntrepriseDto;

import java.util.List;

@RestController
@RequestMapping("entreprise")
public class EntrepriseWs {
    @Autowired
    private EntrepriseService entrepriseService;
    @Autowired
    private EntrepriseConverter entrepriseConverter;
    @GetMapping("/rS/{rS}")
    public EntrepriseDto findByRaisonSociale(@PathVariable String rS) {
        Entreprise entreprise = entrepriseService.findByRaisonSociale(rS);
        return entrepriseConverter.toDto(entreprise);
    }
    @GetMapping("/idtFsc/{idtFsc}")
    public EntrepriseDto findByIdentifiantFiscale(@PathVariable String idtFsc) {
        Entreprise entreprise = entrepriseService.findByIdentifiantFiscale(idtFsc);
        return entrepriseConverter.toDto(entreprise);
    }
    @GetMapping("/cnss/{cnss}")
    public EntrepriseDto findByNumeroCNSS(@PathVariable Long cnss) {
        Entreprise entreprise = entrepriseService.findByNumeroCNSS(cnss);
        return entrepriseConverter.toDto(entreprise);
    }
    @GetMapping("/mut/{mut}")
    public EntrepriseDto findByNumeromutuelle(@PathVariable Long mut) {
        Entreprise entreprise = entrepriseService.findByNumeromutuelle(mut);
        return entrepriseConverter.toDto(entreprise);
    }
    @GetMapping("/ice/{ice}")
    public EntrepriseDto findByIce(@PathVariable String ice) {
        Entreprise entreprise = entrepriseService.findByIce(ice);
        return entrepriseConverter.toDto(entreprise);
    }

    @GetMapping("/")
    public List<EntrepriseDto> findAll() {
        List<Entreprise> entreprises = entrepriseService.findAll();
        return entrepriseConverter.toDto(entreprises);
    }
    @DeleteMapping("/ice/{ice}")
    public int deleteByIce(@PathVariable String ice) {
        return entrepriseService.deleteByIce(ice);
    }
@PostMapping("/")
    public int save(@RequestBody Entreprise entreprise) {
        return entrepriseService.save(entreprise);
    }
@PutMapping("/")
    public int update(@RequestBody Entreprise entreprise) {
        return entrepriseService.update(entreprise);
    }
}
