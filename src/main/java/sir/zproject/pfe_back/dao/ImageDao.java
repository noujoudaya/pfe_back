package sir.zproject.pfe_back.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sir.zproject.pfe_back.bean.Image;

import java.util.Optional;

@Repository
public interface ImageDao extends JpaRepository<Image, Long> {
    Optional<Image> findByName(String name);
    Optional<Image> findById (Long id);
}

