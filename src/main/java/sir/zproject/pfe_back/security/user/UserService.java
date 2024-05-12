package sir.zproject.pfe_back.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    long count() {
        return userRepository.count();
    }
}
