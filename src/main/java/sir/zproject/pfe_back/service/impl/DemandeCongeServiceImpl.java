package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sir.zproject.pfe_back.bean.DemandeConge;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.StatutConge;
import sir.zproject.pfe_back.bean.TypeConge;
import sir.zproject.pfe_back.dao.DemandeCongeDao;
import sir.zproject.pfe_back.service.facade.DemandeCongeService;

import java.time.LocalDate;
import java.util.List;

@Service
public class DemandeCongeServiceImpl implements DemandeCongeService {

    @Autowired
    private DemandeCongeDao demandeCongeDao;
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
    public String save(DemandeConge demandeConge) {
        return "bonjour";
    }
}
