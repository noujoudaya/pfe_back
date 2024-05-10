package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAbsence;
import sir.zproject.pfe_back.service.facade.AbsenceService;
import sir.zproject.pfe_back.ws.converter.AbsenceConverter;
import sir.zproject.pfe_back.ws.dto.AbsenceDto;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("absences")
public class AbsenceWS {

    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private AbsenceConverter absenceConverter;

    @GetMapping("/employe")
    public List<AbsenceDto> findByEmploye(@RequestBody Employe employe) {
        List<Absence> list = absenceService.findByEmploye(employe);
        return absenceConverter.toDto(list);
    }

    @Transactional
    @DeleteMapping("/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return absenceService.deleteByEmploye(employe);
    }

    @Transactional
    @DeleteMapping("/dateAbsence/{dateAbsence}/employe")
    public int deleteByDateAbsenceAndEmploye(@PathVariable LocalDate dateAbsence, @RequestBody Employe employe) {
        return absenceService.deleteByDateAbsenceAndEmploye(dateAbsence, employe);
    }

    @GetMapping("/dateAbsence/{dateAbsence}")
    public List<AbsenceDto> findByDateAbsence(@PathVariable LocalDate dateAbsence) {
        List<Absence> list = absenceService.findByDateAbsence(dateAbsence);
        return absenceConverter.toDto(list);
    }

    @GetMapping("/statutAbsence/{statutAbsence}")
    public List<AbsenceDto> findByStatutAbsence(@PathVariable StatutAbsence statutAbsence) {
        List<Absence> list = absenceService.findByStatutAbsence(statutAbsence);
        return absenceConverter.toDto(list);
    }

    @GetMapping("/")
    public List<AbsenceDto> findAll() {
        List<Absence> list = absenceService.findAll();
        return absenceConverter.toDto(list);
    }

    @PostMapping("/save")
    public int save(@RequestBody Absence absence) {
        return absenceService.save(absence);
    }

    @PostMapping("/update")
    public int update(@RequestBody Absence absence) {
        return absenceService.update(absence);
    }

    @PostMapping("/justifier")
    public String justifier(@RequestBody Absence absence) {
        return absenceService.justifier(absence);
    }

    @GetMapping("/search")
    public List<Absence> searchByAllAttributs(@RequestParam String search) {
        return absenceService.searchByAllAttributs(search);
    }
}
