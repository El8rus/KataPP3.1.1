package SpringBoot.CRUDProject.controller;

import SpringBoot.CRUDProject.model.User;
import SpringBoot.CRUDProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/new_user")
    public String newUser(Model model) {
        model.addAttribute("userForm", new User());
        return "new_user";
    }

    @PostMapping("/users")
    public String addUser(@ModelAttribute("userForm") User newUser) {
        userService.save(newUser);
        return "redirect:/users";
    }

    @GetMapping("users/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User editUser = userService.findUserById(id);
        model.addAttribute("editUser", editUser);
        return "edit_user";
    }

    @PatchMapping("users/{id}")
    public String saveUser(@PathVariable("id") Long id, User editUser) {
        userService.save(editUser);
        return "redirect:/users";
    }

    @DeleteMapping("users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}
