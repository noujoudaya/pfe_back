package sir.zproject.pfe_back.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserWS {

    @Autowired
    private UserService userService;

    @GetMapping("/count")
    public long count() {
        return userService.count();
    }
}
