package sir.zproject.pfe_back.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserWS {

    @Autowired
    private UserService userService;

    @GetMapping("/count")
    public long count() {
        return userService.count();
    }

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request, Principal connectedUser) {
        userService.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/pureUsers")
    public List<User> findPureUsers() {
        return this.userService.findPureUsers();
    }

    @GetMapping("/countPureUsers")
    public long countPureUsers() {
        return this.userService.countPureUsers();
    }

    @DeleteMapping("/delete/login/{login}")
    public int deleteByLogin(@PathVariable String login) {
        return userService.deleteByLogin(login);
    }

    @GetMapping("/pure-users")
    public Page<User> getPureUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return userService.getPureUsers(page, size);
    }

}
