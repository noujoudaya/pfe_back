package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.StatutAttestation;
import sir.zproject.pfe_back.bean.TypeAttestation;
import sir.zproject.pfe_back.dao.DemandeAttestationDao;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.service.facade.DemandeAttestationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeAttestationServiceImpl implements DemandeAttestationService {

    @Autowired
    private DemandeAttestationDao demandeAttestationDao;
    @Autowired
    private EmployeDao employeDao;

    @Override
    public List<DemandeAttestation> findByEmploye(Employe employe) {
        return demandeAttestationDao.findByEmploye(employe);
    }

    @Override
    public int deleteByEmploye(Employe employe) {
        return demandeAttestationDao.deleteByEmploye(employe);
    }

    @Override
    public int deleteByEmployeAndDateDemande(Employe employe, LocalDate dateDemande) {
        return demandeAttestationDao.deleteByEmployeAndDateDemande(employe, dateDemande);
    }

    @Override
    public List<DemandeAttestation> findByDateDemande(LocalDate dateDemande) {
        return demandeAttestationDao.findByDateDemande(dateDemande);
    }

    @Override
    public List<DemandeAttestation> findByTypeAttestation(TypeAttestation typeAttestation) {
        return demandeAttestationDao.findByTypeAttestation(typeAttestation);
    }

    @Override
    public List<DemandeAttestation> findByStatutAttestation(StatutAttestation statutAttestation) {
        return demandeAttestationDao.findByStatutAttestation(statutAttestation);
    }

    @Override
    public List<DemandeAttestation> findAll() {
        return demandeAttestationDao.findAll();
    }

    @Override
    public String save(DemandeAttestation demande) {
        if (demande == null) {
            return "L'objet demande ne doit pas être null";
        }
        if (demande.getId() != null && demandeAttestationDao.findById(demande.getId()).isPresent()) {
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
        demande.setStatutAttestation(StatutAttestation.Enregistre);
        demandeAttestationDao.save(demande);
        return "Demande ajoutée avec succès";
    }

    public String preparerDemande(DemandeAttestation demande) {
        demande.setStatutAttestation(StatutAttestation.EnCours);
        demandeAttestationDao.save(demande);
        return "La demande est en cours de preparation";
    }

    public String validerDemande(DemandeAttestation demande) {
        demande.setStatutAttestation(StatutAttestation.Prete);
        demandeAttestationDao.save(demande);
        return "La demande est disponible";
    }

}
