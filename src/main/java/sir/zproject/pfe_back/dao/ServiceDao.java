package sir.zproject.pfe_back.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;


@Repository
public interface ServiceDao extends JpaRepository<Service, Long> {

    Service findByCode(String code);
    Service findByLibelle(String libelle);
    List<Service> findByDepartement(Departement departement);
    int deleteByDepartement(Departement departement);
    int deleteByCode(String code);
    int deleteByLibelle(String libelle);
}
