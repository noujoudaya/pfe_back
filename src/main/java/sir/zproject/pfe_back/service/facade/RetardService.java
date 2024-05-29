package sir.zproject.pfe_back.service.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.bean.Retard;
import sir.zproject.pfe_back.enumeration.StatutAbsence;
import sir.zproject.pfe_back.enumeration.StatutConge;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public interface RetardService {

    List<Retard> findByEmploye(Employe employe);

    @Transactional
    int deleteByEmploye(Employe employe);

    @Transactional
    int deleteByDateRetardAndEmploye(LocalDate dateRetard, Employe employe);

    @Transactional
    int deleteByDateRetard(LocalDate dateRetard);

    List<Retard> findByDateRetard(LocalDate dateRetard);

    List<Retard> findByHeureDebutTravail(LocalTime heureDebutTravail);
    List<Retard> findByStatutRetard(StatutAbsence statutRetard);

    List<Retard> findAll();

    int save(Retard retard);
    int update(Retard retard);
    List<Retard> searchByAllAttributs(@Param("search") String search);

    String justifier(Retard retard);
    List<Retard> findByEmployeDepartement(Departement departement);

    Page<Retard> getRetards(Departement departement, int page, int size);

}
