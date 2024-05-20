package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.enumeration.GENRE;
import sir.zproject.pfe_back.service.facade.EmployeService;
import sir.zproject.pfe_back.ws.converter.EmployeConverter;
import sir.zproject.pfe_back.ws.dto.EmployeDto;

import java.util.List;

@RestController
public class EmployeWs {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private EmployeConverter employeConverter;

    @GetMapping("/cin/{cin}")
    public EmployeDto findByCin(@PathVariable String cin) {
        Employe employe = employeService.findByCin(cin);
        return employeConverter.toDto(employe);
    }

    @GetMapping("/numeroCNSS/{numeroCNSS}")
    public EmployeDto findByNumeroCNSS(@PathVariable long numeroCNSS) {
        Employe employe = employeService.findByNumeroCNSS(numeroCNSS);
        return employeConverter.toDto(employe);
    }

    @DeleteMapping("/numeroCNSS/{numeroCNSS}")
    public int deleteByNumeroCNSS(@PathVariable long numeroCNSS) {
        return employeService.deleteByNumeroCNSS(numeroCNSS);
    }

    @GetMapping("/email/{email}")
    public EmployeDto findByEmail(@PathVariable String email) {
        Employe employe = employeService.findByEmail(email);
        return employeConverter.toDto(employe);
    }

    @GetMapping("/telephone/{telephone}")
    public EmployeDto findByTelephone(@PathVariable String telephone) {
        Employe employe = employeService.findByTelephone(telephone);
        return employeConverter.toDto(employe);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public List<EmployeDto> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        List<Employe> employes = employeService.findByNomAndPrenom(nom, prenom);
        return employeConverter.toDto(employes);
    }

    @PostMapping("sup/employes/departement/")
    public List<EmployeDto> findByDepartement(@RequestBody Departement departement) {
        List<Employe> employes = employeService.findByDepartement(departement);
        return employeConverter.toDto(employes);
    }

    @GetMapping("service/{service}")
    public List<EmployeDto> findByService(@RequestBody Service service) {
        List<Employe> employes = employeService.findByService(service);
        return employeConverter.toDto(employes);
    }

    @GetMapping("fonction/{fonction}")
    public List<EmployeDto> findByFonction(@RequestBody Fonction fonction) {
        List<Employe> employes = employeService.findByFonction(fonction);
        return employeConverter.toDto(employes);
    }

    @GetMapping("ville/{ville}")
    public List<EmployeDto> findByVille(@PathVariable String ville) {
        List<Employe> employes = employeService.findByVille(ville);
        return employeConverter.toDto(employes);
    }

    @DeleteMapping("/nom/{nom}/prenom/{prenom}")
    public int deleteByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return employeService.deleteByNomAndPrenom(nom, prenom);
    }

    @DeleteMapping("admin/employes/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return employeService.deleteByCin(cin);
    }

    @DeleteMapping("/email/{email}")
    public int deleteByEmail(@PathVariable String email) {
        return employeService.deleteByEmail(email);
    }

    @DeleteMapping("/departement/{departement}")
    public int deleteByDepartement(@RequestBody Departement departement) {
        return employeService.deleteByDepartement(departement);
    }

    @DeleteMapping("/service/{service}")
    public int deleteByService(@RequestBody Service service) {
        return employeService.deleteByService(service);
    }

    @DeleteMapping("/fonction/{fonction}")
    public int deleteByFonction(@RequestBody Fonction fonction) {
        return employeService.deleteByFonction(fonction);
    }

    @PostMapping("count/departement/")
    public int countEmployeByDepartement(@RequestBody Departement departement) {
        return employeService.countEmployeByDepartement(departement);
    }

    @PostMapping("count/service")
    public int countEmployeByService(@RequestBody Service service) {
        return employeService.countEmployeByService(service);
    }

    @GetMapping("/count/fonction/{fonction}")
    public int countEmployeByFonction(@RequestBody Fonction fonction) {
        return employeService.countEmployeByFonction(fonction);
    }

    @GetMapping("/count/ville/{ville}")
    public int countEmployeByVille(@PathVariable String ville) {
        return employeService.countEmployeByVille(ville);
    }

    @GetMapping("count/genre/{genre}")
    public int countEmployeByGenre(@PathVariable GENRE genre) {
        return employeService.countEmployeByGenre(genre);
    }

    public List<Employe> searchByNomOrPrenomOrEmail(String search) {
        return employeService.searchByNomOrPrenomOrEmail(search);
    }

    @GetMapping("sup/employes/")
    public List<EmployeDto> findAll() {
        List<Employe> employe = employeService.findAll();
        return employeConverter.toDto(employe);
    }

    @PostMapping("admin/employes/save")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }

    @PostMapping("admin/employes/update")
    public int update(@RequestBody Employe employe) {
        return employeService.update(employe);
    }

    @GetMapping("admin/employes/count")
    public long count() {
        return employeService.count();
    }


    @GetMapping("admin/employes/search")
    public List<Employe> searchEmployes(@RequestParam String search) {
        return employeService.searchByNomOrPrenomOrEmail(search);
    }
}
