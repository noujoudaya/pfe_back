package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Departement;

import java.util.List;

public interface DepartementService {
    Departement findByCode(String code);

    Departement findByLibelle(String libelle);

    int deleteByCode(String code);

    List<Departement> findAll();


    int save(Departement departement);

    int update(Departement newDepartement);
}