package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.service.facade.RetardService;
import sir.zproject.pfe_back.ws.converter.RetardsConverter;
import sir.zproject.pfe_back.ws.dto.RetardDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("retards")
public class RetardWS {

    @Autowired
    private RetardService retardService;
    @Autowired
    private RetardsConverter retardConverter;

    @GetMapping("/employe")
    public List<RetardDto> findByEmploye(@RequestBody Employe employe) {
        List<Retard> list = retardService.findByEmploye(employe);
        return retardConverter.toDto(list);
    }

    @Transactional
    @DeleteMapping("/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return retardService.deleteByEmploye(employe);
    }

    @Transactional
    @DeleteMapping("/dateRetard/{dateRetard}/employe")
    public int deleteByDateRetardAndEmploye(@PathVariable LocalDate dateRetard, @RequestBody Employe employe) {
        return retardService.deleteByDateRetardAndEmploye(dateRetard, employe);
    }

    @Transactional
    @DeleteMapping("/dateRetard/{dateRetard}")
    public int deleteByDateRetard(@PathVariable LocalDate dateRetard) {
        return retardService.deleteByDateRetard(dateRetard);
    }

    @GetMapping("/dateRetard/{dateRetard}")
    public List<RetardDto> findByDateRetard(@PathVariable LocalDate dateRetard) {
        List<Retard> list = retardService.findByDateRetard(dateRetard);
        return retardConverter.toDto(list);
    }

    @GetMapping("/heureDebutTravail/{heureDebutTravail}")
    public List<RetardDto> findByHeureDebutTravail(@PathVariable LocalTime heureDebutTravail) {
        List<Retard> list = retardService.findByHeureDebutTravail(heureDebutTravail);
        return retardConverter.toDto(list);
    }

    @GetMapping("/")
    public List<RetardDto> findAll() {
        List<Retard> list = retardService.findAll();
        return retardConverter.toDto(list);
    }

    @PostMapping("/save")
    public int save(@RequestBody Retard retard) {
        return retardService.save(retard);
    }

    @PostMapping("/update")
    public int update(@RequestBody Retard retard) {
        return retardService.update(retard);
    }
}
