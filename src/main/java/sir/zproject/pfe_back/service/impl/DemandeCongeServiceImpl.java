package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.*;
import sir.zproject.pfe_back.dao.DemandeCongeDao;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.enumeration.StatutConge;
import sir.zproject.pfe_back.service.facade.DemandeCongeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeCongeServiceImpl implements DemandeCongeService {

    @Autowired
    private DemandeCongeDao demandeCongeDao;
    @Autowired
    private EmployeDao employeDao;
    @Override
    public List<DemandeConge> findByEmploye(Employe employe) {
        return demandeCongeDao.findByEmploye(employe);
    }

    @Override
    @Transactional
    public int deleteByEmploye(Employe employe) {
        return demandeCongeDao.deleteByEmploye(employe);
    }

    @Override
    @Transactional
    public int deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(LocalDate dateDemande, long employeId, String typeCongeLibelle) {
        return demandeCongeDao.deleteByDateDemandeAndEmployeIdAndTypeCongeLibelle(dateDemande, employeId, typeCongeLibelle);
    }

    @Override
    @Transactional
    public int deleteByStatutConge(StatutConge statutConge) {
        return demandeCongeDao.deleteByStatutConge(statutConge);
    }

    @Override
    @Transactional
    public int deleteByTypeConge(TypeConge typeConge) {
        return demandeCongeDao.deleteByTypeConge(typeConge);
    }

    @Override
    @Transactional
    public int deleteByDateDebut(LocalDate dateDebut) {
        return demandeCongeDao.deleteByDateDebut(dateDebut);
    }

    @Override
    @Transactional
    public int deleteByDateFin(LocalDate dateFin) {
        return demandeCongeDao.deleteByDateFin(dateFin);
    }

    @Override
    public List<DemandeConge> findByDateDemande(LocalDate dateDemande) {
        return demandeCongeDao.findByDateDemande(dateDemande);
    }

    @Override
    public List<DemandeConge> findByDateDebut(LocalDate dateDebut) {
        return demandeCongeDao.findByDateDebut(dateDebut);
    }

    @Override
    public List<DemandeConge> findByDateFin(LocalDate dateFin) {
        return demandeCongeDao.findByDateFin(dateFin);
    }

    @Override
    public List<DemandeConge> findByTypeConge(TypeConge typeConge) {
        return demandeCongeDao.findByTypeConge(typeConge);
    }

    @Override
    public List<DemandeConge> findByStatutConge(StatutConge statutConge) {
        return demandeCongeDao.findByStatutConge(statutConge);
    }

    @Override
    public List<DemandeConge> findAll() {
        return demandeCongeDao.findAll();
    }

    @Override
    public int save(DemandeConge demande) {
        if (demande == null) {
            return 0;
        }
        if (demande.getId() != null && demandeCongeDao.findById(demande.getId()).isPresent()) {
            return -1;
        }
        if (demande.getEmploye() == null) {
            return -2;
        }
        Optional<Employe> employeOptional = employeDao.findById(demande.getEmploye().getId());
        if (employeOptional.isEmpty()) {
            return -3;
        }

        demande.setEmploye(employeOptional.get());
        demande.setStatutConge(StatutConge.En_Attente);
        demandeCongeDao.save(demande);
        return 1;
    }

    @Override
    public String accepterDemande(DemandeConge demande) {
      demande.setStatutConge(StatutConge.Acceptée);
      update(demande);
      return "Demande acceptée";
    }

    @Override
    public String refuserDemande(DemandeConge demande) {
        demande.setStatutConge(StatutConge.Refusée);
        update(demande);
        return "Demande refusée";
    }

    @Override
    public int update(DemandeConge demandeConge) {
        DemandeConge existingDemande = demandeCongeDao.findById(demandeConge.getId()).orElse(null);
        if (existingDemande == null) {
            return 0;
        }
        existingDemande.setEmploye(demandeConge.getEmploye());
        existingDemande.setDateDemande(demandeConge.getDateDemande());
        existingDemande.setDateDebut(demandeConge.getDateDebut());
        existingDemande.setDateFin(demandeConge.getDateFin());
        existingDemande.setTypeConge(demandeConge.getTypeConge());
        existingDemande.setStatutConge(demandeConge.getStatutConge());
        existingDemande.setMotifRefus(demandeConge.getMotifRefus());
        demandeCongeDao.save(existingDemande);
        return 1;
    }

    @Override
    public long countByStatutConge() {
        return demandeCongeDao.countByStatutConge(StatutConge.En_Attente);
    }

    @Override
    public List<DemandeConge> searchByAllAttributs(String search) {
        return demandeCongeDao.searchByAllAttributs(search);
    }
}
