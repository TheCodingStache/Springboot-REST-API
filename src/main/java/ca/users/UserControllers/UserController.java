package ca.users.UserControllers;

import ca.users.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class UserController {
    private List<User> users = new ArrayList<>();
    private AtomicLong nextID = new AtomicLong();

    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Springboot Java";
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createNewUser(@RequestBody User user) {
        //Set user to have next ID
        user.setId(nextID.incrementAndGet());
        users.add(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/users/{id}")
    public User getOneUser(@PathVariable("id") long userID,
                             @RequestBody User newUsers
                               ) {
        for (User user : users) {
            if (user.getId() == userID) {
                users.remove(user);
                user.setId(userID);
                users.add(newUsers);
                return user;
            }
        }
        throw new IllegalArgumentException();
    }
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }

}
