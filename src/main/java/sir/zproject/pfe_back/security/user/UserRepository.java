package sir.zproject.pfe_back.security.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long>, PagingAndSortingRepository<User,Long> {

    Optional<User> findByLogin(String login);

    int deleteByLogin(String login);

    @Query("SELECT u FROM User u WHERE TYPE(u) = User")
    List<User> findPureUsers();

    @Query("SELECT COUNT(u) FROM User u WHERE TYPE(u) = User")
    long countPureUsers();

    @Query("SELECT u FROM User u WHERE TYPE(u) = User")
    Page<User> findPureUsers(Pageable pageable);
}
