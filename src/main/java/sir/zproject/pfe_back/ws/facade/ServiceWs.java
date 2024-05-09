package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.service.facade.ServiceService;
import sir.zproject.pfe_back.ws.converter.ServiceConverter;
import sir.zproject.pfe_back.ws.dto.ServiceDto;

import java.util.List;

@RestController
@RequestMapping("services")
public class ServiceWs {

    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceConverter serviceConverter;

    @GetMapping("/code/{code}")
    public ServiceDto findByCode(@PathVariable String code) {
        Service service = serviceService.findByCode(code);
        return serviceConverter.toDto(service);
    }

    @GetMapping("/libelle/{libelle}")
    public ServiceDto findByLibelle(@PathVariable String libelle) {
        Service service = serviceService.findByLibelle(libelle);
        return serviceConverter.toDto(service);
    }

    @PostMapping("/departement")
    public List<ServiceDto> findByDepartement(@RequestBody Departement departement) {
        List<Service> services = serviceService.findByDepartement(departement);
        return serviceConverter.toDto(services);
    }

    @DeleteMapping("/departement/{departement}")
    public int deleteByDepartement(@RequestBody Departement departement) {
        return serviceService.deleteByDepartement(departement);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return serviceService.deleteByCode(code);
    }

    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return serviceService.deleteByLibelle(libelle);
    }

    @GetMapping("/")
    public List<ServiceDto> findAll() {
        List<Service> services = serviceService.findAll();
        return serviceConverter.toDto(services);
    }

    @PostMapping("/")
    public int save(@RequestBody Service service) {
        return serviceService.save(service);
    }
}
