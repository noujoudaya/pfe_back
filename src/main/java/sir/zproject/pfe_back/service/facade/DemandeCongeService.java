package sir.zproject.pfe_back.service.facade;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutConge;
import sir.zproject.pfe_back.bean.TypeConge;

import java.time.LocalDate;
import java.util.List;

@Service
public interface DemandeCongeService {

    List<DemandeConge> findByEmploye(Employe employe);

    @Transactional
    int deleteByEmploye(Employe employe);

    @Transactional
    int deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(LocalDate dateDemande, long employeId, String typeCongeLibelle);


    @Transactional
    int deleteByStatutConge(StatutConge statutConge);

    @Transactional
    int deleteByTypeConge(TypeConge typeConge);

    @Transactional
    int deleteByDateDebut(LocalDate dateDebut);

    @Transactional
    int deleteByDateFin(LocalDate dateFin);

    List<DemandeConge> findByDateDemande(LocalDate dateDemande);

    List<DemandeConge> findByDateDebut(LocalDate dateDebut);

    List<DemandeConge> findByDateFin(LocalDate dateFin);

    List<DemandeConge> findByTypeConge(TypeConge typeConge);

    List<DemandeConge> findByStatutConge(StatutConge statutConge);

    List<DemandeConge> findAll();

    int save(DemandeConge demandeConge);

    public String accepterDemande(DemandeConge demande);

    public String refuserDemande(DemandeConge demande);

    int update(DemandeConge demandeConge);

    long countByStatutConge();

    List<DemandeConge> searchByAllAttributs(@Param("search") String search);


}
