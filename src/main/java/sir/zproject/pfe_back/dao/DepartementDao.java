package sir.zproject.pfe_back.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.DemandeAttestation;
import sir.zproject.pfe_back.bean.Departement;
@Repository
public interface DepartementDao extends JpaRepository<Departement, Long> {
    int deleteByCode (String code);
    Departement findByCode (String code);
    Departement findByLibelle (String libelle);

    @Override
    Page<Departement> findAll(Pageable pageable);

}
