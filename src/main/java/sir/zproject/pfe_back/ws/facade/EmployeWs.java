package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.service.facade.EmployeService;

import java.util.List;

@RestController
@RequestMapping("employes")
public class EmployeWs {

    @Autowired
    private EmployeService employeService;

    @GetMapping("/cin/{cin}")
    public Employe findByCin(@PathVariable String cin) {
        return employeService.findByCin(cin);
    }

    @GetMapping("/email/{email}")
    public Employe findByEmail(@PathVariable String email) {
        return employeService.findByEmail(email);
    }

    @GetMapping("/telephone/{telephone}")
    public Employe findByTelephone(@PathVariable String telephone) {
        return employeService.findByTelephone(telephone);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public List<Employe> findByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return employeService.findByNomAndPrenom(nom, prenom);
    }

    @GetMapping("departement/{departement}")
    public List<Employe> findByDepartement(@RequestBody Departement departement) {
        return employeService.findByDepartement(departement);
    }

    @GetMapping("service/{service}")
    public List<Employe> findByService(@RequestBody Service service) {
        return employeService.findByService(service);
    }

    @GetMapping("fonction/{fonction}")
    public List<Employe> findByFonction(@RequestBody Fonction fonction) {
        return employeService.findByFonction(fonction);
    }

    @GetMapping("ville/{ville}")
    public List<Employe> findByVille(@PathVariable String ville) {
        return employeService.findByVille(ville);
    }

    @DeleteMapping("/nom/{nom}/prenom/{prenom}")
    public int deleteByNomAndPrenom(@PathVariable String nom, @PathVariable String prenom) {
        return employeService.deleteByNomAndPrenom(nom, prenom);
    }

    @DeleteMapping("/cin/{cin}")
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

    @GetMapping("/count/departement/{departement}")
    public int countEmployeByDepartement(@RequestBody Departement departement) {
        return employeService.countEmployeByDepartement(departement);
    }

    @GetMapping("/count/service/{service}")
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

    @GetMapping("/")
    public List<Employe> findAll() {
        return employeService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody Employe employe) {
        return employeService.save(employe);
    }
}
