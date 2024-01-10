package internship.AI_task_1.controller;

import internship.AI_task_1.entity.User;
import internship.AI_task_1.repository.UserRepository;
import internship.AI_task_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/follow")
    public ResponseEntity<User> followUser(@PathVariable Long userId,
                                           @RequestParam Long followerId) {
        User userToFollow = userService.getUserById(userId);
        User follower = userService.getUserById(followerId);

        if (userToFollow != null && followerId != null) {
            List<Long> followedBy = userToFollow.getFollowedBy();

            if (!followedBy.contains(followerId)) {
                followedBy.add(followerId);
                userService.updateUser(userToFollow);
                return new ResponseEntity<>(userToFollow, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
