package xtracap.users.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import xtracap.users.entity.User;
import xtracap.users.exception.NoUsersFoundException;
import xtracap.users.service.UserService;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;



@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showUsers(Model model, @RequestParam(defaultValue = "0") int page,
                            @RequestParam(defaultValue = "5") int size) {

        try {
            model.addAttribute("user", new User());
            model.addAttribute("users", userService.findAllUsers(page * size, size));
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", userService.getTotalPages(size));
        } catch (NoUsersFoundException e) {
            model.addAttribute("errorMessage", "No users found.");
            return "users";
        } catch (Exception e) {
            log.error("Error fetching users: {}", e.getMessage());
            model.addAttribute("errorMessage", "An error occurred while fetching users.");
        }

        return "users";
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = result.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            userService.saveUser(user);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("Error adding user: {}", e.getMessage());
            // Consider adding a user-friendly message for the UI
            return ResponseEntity.status(500).build();
        }
    }
}

