package sir.zproject.pfe_back.service.facade;

import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;

public interface ServiceService {

    List<sir.zproject.pfe_back.bean.Service> findByDepartementCode(String code);
    int deleteByDepartementCode(String code);
    sir.zproject.pfe_back.bean.Service findByCode(String code);

    sir.zproject.pfe_back.bean.Service findByLibelle(String libelle);

    int deleteByCode(String code);

    List<sir.zproject.pfe_back.bean.Service> findAll();


    int save(sir.zproject.pfe_back.bean.Service service);



    int update(Service newService);


}