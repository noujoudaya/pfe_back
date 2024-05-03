package sir.zproject.pfe_back.service.facade;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Retard;

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

    List<Retard> findAll();

    String save(Retard retard);
}
