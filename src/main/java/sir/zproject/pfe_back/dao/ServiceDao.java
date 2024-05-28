package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sir.zproject.pfe_back.bean.Departement;
import sir.zproject.pfe_back.bean.Service;

import java.util.List;


@Repository
public interface ServiceDao extends JpaRepository<Service, Long> {
    List<Service> findByDepartementCode(String code);
    int deleteByDepartementCode(String code);
    Service findByCode(String code);

    Service findByLibelle(String libelle);

    int deleteByCode(String code);

    List<Service> findAll();

    @Override
    Page<Service> findAll(Pageable pageable);




}
