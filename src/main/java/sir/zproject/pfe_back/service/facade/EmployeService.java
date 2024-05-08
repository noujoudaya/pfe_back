package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;

import java.util.List;

@Service
public interface EmployeService {
    Employe findByCin(String cin);

    Employe findByEmail(String email);

    Employe findByTelephone(String telephone);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByDepartement(Departement departement);

    List<Employe> findByService(sir.zproject.pfe_back.bean.Service service);

    List<Employe> findByFonction(Fonction fonction);

    List<Employe> findByVille(String ville);

    int deleteByNomAndPrenom(String nom, String prenom);

    int deleteByCin(String cin);

    int deleteByEmail(String email);

    int deleteByDepartement(Departement departement);

    int deleteByService(sir.zproject.pfe_back.bean.Service service);

    int deleteByFonction(Fonction fonction);

    int countEmployeByDepartement(Departement departement);

    int countEmployeByService(sir.zproject.pfe_back.bean.Service service);

    int countEmployeByFonction(Fonction fonction);

    int countEmployeByVille(String ville);

    List<Employe> findAll();

    int save(Employe employe);
    int update(Employe employe);
}
