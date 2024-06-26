package sir.zproject.pfe_back.service.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.enumeration.GENRE;

import java.util.List;

@Service
public interface EmployeService {
    Employe findByMatricule(Long matricule);

    Employe findByCin(String cin);

    Employe findByNumeroCNSS(long numeroCNSS);

    int deleteByNumeroCNSS(long numeroCNSS);

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

    int countEmployeByGenre(GENRE genre);

    List<Employe> findAll();

    long count();

    int save(Employe employe);

    int update(Employe employe);
    List<Employe> searchByNomOrPrenomOrEmail(@Param("search") String search);

    Page<Employe> getEmployes(int page, int size);

    Page<Employe> getEmployesByDepartement(Departement departement, int page, int size);

}
