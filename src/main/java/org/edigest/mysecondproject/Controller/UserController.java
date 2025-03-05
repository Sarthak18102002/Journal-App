package org.edigest.mysecondproject.Controller;

import org.edigest.mysecondproject.Entity.JournalEntry;
import org.edigest.mysecondproject.Entity.User;
import org.edigest.mysecondproject.Service.JournalEntryService;
import org.edigest.mysecondproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllusers()
    {
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user)
    {
        userService.saveEntry(user);
    }

    @PutMapping("/{username}")
        public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String username)
    {
        User userInDb = userService.findByUserName(user.getUserName());
        if(userInDb != null)
        {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

