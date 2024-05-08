package sir.zproject.pfe_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Employe;
import sir.zproject.pfe_back.bean.Fonction;
import sir.zproject.pfe_back.dao.EmployeDao;
import sir.zproject.pfe_back.service.facade.EmployeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeDao employeDao;

    @Override
    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }

    @Override
    public Employe findByEmail(String email) {
        return employeDao.findByEmail(email);
    }

    @Override
    public Employe findByTelephone(String telephone) {
        return employeDao.findByTelephone(telephone);
    }

    @Override
    public List<Employe> findByNomAndPrenom(String nom, String prenom) {
        return employeDao.findByNomAndPrenom(nom, prenom);
    }

    @Override
    public List<Employe> findByDepartement(Departement departement) {
        return employeDao.findByDepartement(departement);
    }

    @Override
    public List<Employe> findByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.findByService(service);
    }

    @Override
    public List<Employe> findByFonction(Fonction fonction) {
        return employeDao.findByFonction(fonction);
    }

    @Override
    public List<Employe> findByVille(String ville) {
        return employeDao.findByVille(ville);
    }

    @Override
    @Transactional
    public int deleteByNomAndPrenom(String nom, String prenom) {
        return employeDao.deleteByNomAndPrenom(nom, prenom);
    }

    @Override
    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    @Override
    @Transactional
    public int deleteByEmail(String email) {
        return employeDao.deleteByEmail(email);
    }

    @Override
    public int deleteByDepartement(Departement departement) {
        return employeDao.deleteByDepartement(departement);
    }

    @Override
    @Transactional
    public int deleteByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.deleteByService(service);
    }

    @Override
    @Transactional
    public int deleteByFonction(Fonction fonction) {
        return employeDao.deleteByFonction(fonction);
    }

    @Override
    public int countEmployeByDepartement(Departement departement) {
        return employeDao.countEmployeByDepartement(departement);
    }

    @Override
    public int countEmployeByService(sir.zproject.pfe_back.bean.Service service) {
        return employeDao.countEmployeByService(service);
    }

    @Override
    public int countEmployeByFonction(Fonction fonction) {
        return employeDao.countEmployeByFonction(fonction);
    }

    @Override
    public int countEmployeByVille(String ville) {
        return employeDao.countEmployeByVille(ville);
    }

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override
    public int save(Employe employe) {
        if (employe == null) {
            return 0; // Retourne 0 si l'employé est null
        }

        // Vérifie si l'employé existe déjà (supposant que getId() est la méthode pour obtenir l'ID)
        if (employe.getId() != null && employeDao.existsById(employe.getId())) {
            // Mise à jour
            System.out.println("Mise à jour de l'employé existant.");
        } else {
            // Insertion
            System.out.println("Insertion d'un nouvel employé.");
        }

        employeDao.save(employe);
        return 1; // Retourne 1 pour indiquer que l'opération a réussi
    }

    @Override
    public int update(Employe employe) {
        Employe existingEmp = employeDao.findById(employe.getId()).orElse(null);
        assert existingEmp != null;
        existingEmp.setNom(employe.getNom());
        existingEmp.setPrenom(employe.getPrenom());
        existingEmp.setCin(employe.getCin());
        existingEmp.setEmail(employe.getEmail());
        existingEmp.setTelephone(employe.getTelephone());
        existingEmp.setVille(employe.getVille());
        existingEmp.setDepartement(employe.getDepartement());
        existingEmp.setService(employe.getService());
        existingEmp.setFonction(employe.getFonction());
        existingEmp.setTypeSalaire(employe.getTypeSalaire());
        existingEmp.setSalaire(employe.getSalaire());
        existingEmp.setService(employe.getService());
        existingEmp.setFonction(employe.getFonction());
        existingEmp.setAdresse(employe.getAdresse());
        existingEmp.setDateEmbauche(employe.getDateEmbauche());
        existingEmp.setDateEntree(employe.getDateEntree());
        existingEmp.setDateFinContrat(employe.getDateFinContrat());
        existingEmp.setDateNaissance(employe.getDateNaissance());
        existingEmp.setDesignation(employe.getDesignation());
        existingEmp.setGenre(employe.getGenre());
        existingEmp.setNumeroCompteBancaire(employe.getNumeroCompteBancaire());
        existingEmp.setSoldeConge(employe.getSoldeConge());
        existingEmp.setTypeContrat(employe.getTypeContrat());
        employeDao.save(existingEmp);
        return 1;
    }
}

