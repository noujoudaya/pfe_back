package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.*;
import sir.zproject.pfe_back.dao.DemandeCongeDao;
import sir.zproject.pfe_back.dao.EmployeDao;
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
    public int deleteByEmploye(Employe employe) {
        return demandeCongeDao.deleteByEmploye(employe);
    }

    @Override
    public int deleteByStatutConge(StatutConge statutConge) {
        return demandeCongeDao.deleteByStatutConge(statutConge);
    }

    @Override
    public int deleteByTypeConge(TypeConge typeConge) {
        return demandeCongeDao.deleteByTypeConge(typeConge);
    }

    @Override
    public int deleteByDateDebut(LocalDate dateDebut) {
        return demandeCongeDao.deleteByDateDebut(dateDebut);
    }

    @Override
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
    public String save(DemandeConge demande) {
        if (demande == null) {
            return "L'objet demande ne doit pas être null";
        }
        if (demande.getId() != null && demandeCongeDao.findById(demande.getId()).isPresent()) {
            return "Cette demande existe déjà";
        }
        if (demande.getEmploye() == null) {
            return "L'employé est obligatoire";
        }
        Optional<Employe> employeOptional = employeDao.findById(demande.getEmploye().getId());
        if (employeOptional.isEmpty()) {
            return "Aucun employé trouvé avec cet ID";
        }

        demande.setEmploye(employeOptional.get());
        demande.setStatutConge(StatutConge.EnAttente);
        demandeCongeDao.save(demande);
        return "Demande ajoutée avec succès";
    }

    public String accepterDemande(DemandeConge demande) {
        demande.setStatutConge(StatutConge.Acceptee);
        demandeCongeDao.save(demande);
        return "Demande acceptée";
    }

    public String refuserDemande(DemandeConge demande) {
        demande.setStatutConge(StatutConge.Refusee);
        demandeCongeDao.save(demande);
        return "Demande refusée";
    }
}
