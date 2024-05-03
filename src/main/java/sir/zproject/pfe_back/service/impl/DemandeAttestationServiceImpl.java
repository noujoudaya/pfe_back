package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.StatutAttestation;
import sir.zproject.pfe_back.bean.TypeAttestation;
import sir.zproject.pfe_back.dao.DemandeAttestationDao;
import sir.zproject.pfe_back.service.facade.DemandeAttestationService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DemandeAttestationServiceImpl implements DemandeAttestationService {

    @Autowired
    private DemandeAttestationDao demandeAttestationDao;
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
        return demandeAttestationDao.deleteByEmployeAndDateDemande(employe,dateDemande);
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
    public int save(DemandeAttestation demandeAttestation) {
        return 0;
    }
}
