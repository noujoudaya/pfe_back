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
@RequestMapping("service")
public class ServiceWs {
    private final ServiceService serviceService;
    private final ServiceConverter serviceConverter;

    public ServiceWs(ServiceService service, ServiceConverter serviceConverter) {
        this.serviceService = service;
        this.serviceConverter = serviceConverter;
    }
    @GetMapping("departement/code/{code}")
    public List<ServiceDto> findByDepartementCode(@PathVariable String code) {
        List<Service> services = serviceService.findByDepartementCode(code);
        return serviceConverter.toDto(services);
    }
    @DeleteMapping("departement/code/{code}")
    public int deleteByDepartementCode(@PathVariable String code) {
        return serviceService.deleteByDepartementCode(code);
    }
    @GetMapping("/code/{code}")
    public ServiceDto findByCode(@PathVariable String code) {
        Service service = serviceService.findByCode(code);
        return serviceConverter.toDto(service);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return serviceService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<ServiceDto> findAll() {
        List<Service> services = serviceService.findAll();
        return serviceConverter.toDto(services);
    }
    @GetMapping("/libelle/{libelle}")
    public Service findByLibelle(@PathVariable String libelle) {
        return serviceService.findByLibelle(libelle);
    }

    @PostMapping("/")
    public int save(@RequestBody Service service) {
        return this.serviceService.save(service);
    }
    @PutMapping("/")
    public int update(@RequestBody Service newService) {
        return serviceService.update(newService);
    }
}
