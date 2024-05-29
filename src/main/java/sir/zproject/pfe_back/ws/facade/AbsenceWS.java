package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Absence;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.enumeration.StatutAbsence;
import sir.zproject.pfe_back.service.facade.AbsenceService;
import sir.zproject.pfe_back.ws.converter.AbsenceConverter;
import sir.zproject.pfe_back.ws.dto.AbsenceDto;

import java.time.LocalDate;
import java.util.List;

@RestController
public class AbsenceWS {

    @Autowired
    private AbsenceService absenceService;
    @Autowired
    private AbsenceConverter absenceConverter;

    @GetMapping("employe/absences/employe")
    public List<AbsenceDto> findByEmploye(@RequestBody Employe employe) {
        List<Absence> list = absenceService.findByEmploye(employe);
        return absenceConverter.toDto(list);
    }

    @Transactional
    @DeleteMapping("secretaire/absences/employe")
    public int deleteByEmploye(@RequestBody Employe employe) {
        return absenceService.deleteByEmploye(employe);
    }

    @Transactional
    @DeleteMapping("secretaire/absences/dateAbsence/{dateAbsence}/employe")
    public int deleteByDateAbsenceAndEmploye(@PathVariable LocalDate dateAbsence, @RequestBody Employe employe) {
        return absenceService.deleteByDateAbsenceAndEmploye(dateAbsence, employe);
    }

    @GetMapping("sup/absences/dateAbsence/{dateAbsence}")
    public List<AbsenceDto> findByDateAbsence(@PathVariable LocalDate dateAbsence) {
        List<Absence> list = absenceService.findByDateAbsence(dateAbsence);
        return absenceConverter.toDto(list);
    }

    @GetMapping("sup/absences/statutAbsence/{statutAbsence}")
    public List<AbsenceDto> findByStatutAbsence(@PathVariable StatutAbsence statutAbsence) {
        List<Absence> list = absenceService.findByStatutAbsence(statutAbsence);
        return absenceConverter.toDto(list);
    }

    @GetMapping("sup/absences/")
    public List<AbsenceDto> findAll() {
        List<Absence> list = absenceService.findAll();
        return absenceConverter.toDto(list);
    }

    @PostMapping("secretaire/absences/save")
    public int save(@RequestBody Absence absence) {
        return absenceService.save(absence);
    }

    @PostMapping("secretaire/absences/update")
    public int update(@RequestBody Absence absence) {
        return absenceService.update(absence);
    }

    @PostMapping("admin/absences/justifier")
    public String justifier(@RequestBody Absence absence) {
        return absenceService.justifier(absence);
    }

    @GetMapping("sup/absences/search")
    public List<Absence> searchByAllAttributs(@RequestParam String search) {
        return absenceService.searchByAllAttributs(search);
    }

    @PostMapping("sup/absences/departement")
    public List<AbsenceDto> findByEmployeDepartement(@RequestBody Departement departement) {
        List<Absence> list = absenceService.findByEmployeDepartement(departement);
        return absenceConverter.toDto(list);
    }

    @PostMapping("sup/absences/paginated")
    public ResponseEntity<Page<Absence>> getAbsences(
            @RequestBody Departement departement,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        Page<Absence> demandesPage = absenceService.getAbsences(departement,page, size);
        return ResponseEntity.ok().body(demandesPage);
    }
}
