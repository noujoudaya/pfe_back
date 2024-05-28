package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.enumeration.StatutAttestation;
import sir.zproject.pfe_back.enumeration.TypeAttestation;
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
    @Transactional
    public int deleteByEmploye(Employe employe) {
        return demandeAttestationDao.deleteByEmploye(employe);
    }

    @Override
    @Transactional
    public int deleteByEmployeIdAndDateDemande(long employeId, LocalDate dateDemande) {
        return demandeAttestationDao.deleteByEmployeIdAndDateDemande(employeId, dateDemande);
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
    public int save(DemandeAttestation demande) {
        if (demande == null) {
            return 0;
        }
        if (demande.getId() != null && demandeAttestationDao.findById(demande.getId()).isPresent()) {
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
        demande.setStatutAttestation(StatutAttestation.Enregistrée);
        demandeAttestationDao.save(demande);
        return 1;
    }

    @Override
    public String preparerDemande(DemandeAttestation demande) {
        demande.setStatutAttestation(StatutAttestation.En_Cours);
        update(demande);
        return "La demande est en cours de preparation";
    }

    @Override
    public String validerDemande(DemandeAttestation demande) {
        demande.setStatutAttestation(StatutAttestation.Prête);
        update(demande);
        return "La demande est disponible";
    }

    @Override
    public int update(DemandeAttestation demandeAttestation) {
        DemandeAttestation existingDemande = demandeAttestationDao.findById(demandeAttestation.getId()).orElse(null);
        if (existingDemande == null) {
            return 0;
        }
        existingDemande.setEmploye(demandeAttestation.getEmploye());
        existingDemande.setDateDemande(demandeAttestation.getDateDemande());
        existingDemande.setTypeAttestation(demandeAttestation.getTypeAttestation());
        existingDemande.setStatutAttestation(demandeAttestation.getStatutAttestation());
        demandeAttestationDao.save(existingDemande);
        return 1;
    }

    @Override
    public long countByStatutDemande() {
        return demandeAttestationDao.countByStatutAttestation(StatutAttestation.Enregistrée);
    }

    @Override
    public List<DemandeAttestation> searchByAllAttributs(String search) {
        return demandeAttestationDao.searchByAllAttributs(search);
    }

    @Override
    public Page<DemandeAttestation> getDemandesAttest(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return demandeAttestationDao.findAll(pageable);
    }
}

