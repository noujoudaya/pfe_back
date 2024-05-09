package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Departement;

import java.util.List;

@Service
public interface ServiceService {

    sir.zproject.pfe_back.bean.Service findByCode(String code);
    sir.zproject.pfe_back.bean.Service findByLibelle(String libelle);
    List<sir.zproject.pfe_back.bean.Service> findByDepartement(Departement departement);
    int deleteByDepartement(Departement departement);
    int deleteByCode(String code);
    int deleteByLibelle(String libelle);
    List<sir.zproject.pfe_back.bean.Service> findAll();
    int save(sir.zproject.pfe_back.bean.Service service);
}
