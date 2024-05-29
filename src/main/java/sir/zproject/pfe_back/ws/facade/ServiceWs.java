package sir.zproject.pfe_back.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;
import sir.zproject.pfe_back.service.facade.ServiceService;
import sir.zproject.pfe_back.ws.converter.ServiceConverter;
import sir.zproject.pfe_back.ws.dto.ServiceDto;

import java.util.List;

@RestController
public class ServiceWs {
    private final ServiceService serviceService;
    private final ServiceConverter serviceConverter;

    public ServiceWs(ServiceService service, ServiceConverter serviceConverter) {
        this.serviceService = service;
        this.serviceConverter = serviceConverter;
    }
    @GetMapping("service/departement/code/{code}")
    public List<ServiceDto> findByDepartementCode(@PathVariable String code) {
        List<Service> services = serviceService.findByDepartementCode(code);
        return serviceConverter.toDto(services);
    }
    @DeleteMapping("service/departement/code/{code}")
    public int deleteByDepartementCode(@PathVariable String code) {
        return serviceService.deleteByDepartementCode(code);
    }
    @GetMapping("service/code/{code}")
    public ServiceDto findByCode(@PathVariable String code) {
        Service service = serviceService.findByCode(code);
        return serviceConverter.toDto(service);
    }
    @DeleteMapping("admin/service/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return serviceService.deleteByCode(code);
    }
    @GetMapping("all/service/")
    public List<ServiceDto> findAll() {
        List<Service> services = serviceService.findAll();
        return serviceConverter.toDto(services);
    }
    @GetMapping("service/libelle/{libelle}")
    public Service findByLibelle(@PathVariable String libelle) {
        return serviceService.findByLibelle(libelle);
    }

    @PostMapping("admin/service/")
    public int save(@RequestBody Service service) {
        return this.serviceService.save(service);
    }
    @PutMapping("admin/service/")
    public int update(@RequestBody Service newService) {
        return serviceService.update(newService);
    }

    @GetMapping("admin/service/paginated")
    public ResponseEntity<Page<Service>> getServices(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        Page<Service> demandesPage = serviceService.getServices(page, size);
        return ResponseEntity.ok().body(demandesPage);
    }
}
