package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;

@Repository
public interface EmployeDao extends JpaRepository<Employe, Long> {

    Employe findByCin(String cin);

    Employe findByNumeroCNSS(long numeroCNSS);

    int deleteByNumeroCNSS(long numeroCNSS);

    Employe findByEmail(String email);

    Employe findByTelephone(String telephone);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByDepartement(Departement departement);

    List<Employe> findByService(Service service);

    List<Employe> findByFonction(Fonction fonction);

    List<Employe> findByVille(String ville);

    int deleteByNomAndPrenom(String nom, String prenom);

    int deleteByCin(String cin);

    int deleteByEmail(String email);

    int deleteByDepartement(Departement departement);

    int deleteByService(Service service);

    int deleteByFonction(Fonction fonction);

    int countEmployeByDepartement(Departement departement);

    int countEmployeByService(Service service);

    int countEmployeByFonction(Fonction fonction);

    int countEmployeByVille(String ville);


    @Query("SELECT e FROM Employe e WHERE " +
            "LOWER(e.nom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(e.prenom) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(e.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(e.departement.libelle) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(e.fonction.libelle) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Employe> searchByNomOrPrenomOrEmailOrDepartementLibelleOrFonctionLibelle(@Param("search") String search);

}
