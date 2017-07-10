package com.antivirus.controller;

import com.antivirus.entity.Orders;
import com.antivirus.entity.User;
import com.antivirus.service.MailSenderService;
import com.antivirus.service.UserService;
import com.antivirus.validator.UserLoginValidation.UserLoginValidationMessages;
import com.antivirus.validator.Validator;
import com.antivirus.validator.userValidator.UserValidationMessages;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

/**
 * Created by Study on 26.05.2017.
 */
@Controller
@Transactional
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;



    @GetMapping("/registration")

    public String registration(Model model){
        model.addAttribute("users", userService);
        model.addAttribute("user", new User());
        return "views-user-registration";
    }


    @PostMapping("/registration")

    public String registration(@ModelAttribute("user") User user, Model model){

        System.out.println("user = " + user);

        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        try {
            userService.save(user);
            System.out.println("user = [" + user + "], model = [" + model + "]");
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXIST)){
                    model.addAttribute("usernameException", e.getMessage());
            }
            else if(e.getMessage().equals(UserValidationMessages.WRONG_EMAIL) ||
                    e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)){
                model.addAttribute("useremailException", e.getMessage());
            }

            return "views-user-registration";
        }
        String theme = "thanks for registration";
        String mailBody = "gl & hf http://localhost:8080/confirm/" + uuid;
        mailSenderService.sendMail(theme, mailBody, user.getEmail());
        return "redirect:/registration";
    }

    @GetMapping ("/deleteUser/{id}")
    public  String deleteUser(@PathVariable int id){

        userService.delete(id);

        return "views-admin-userList";
    }

    @GetMapping ("/updateUser/{id}")
    public  String updateUser(Model model, @PathVariable int id) {
        model.addAttribute("userAttribute", userService.findOne(id));
        return "views-user-updateUser";
    }

    @GetMapping ("/userList")
    public String userList(Model model, @PageableDefault Pageable pageable){
        model.addAttribute("usersList", userService.findAllPages(pageable));

        return "views-admin-userList";
    }


    @PostMapping("/updateUser/{id}")
    public  String updateUser(@ModelAttribute ("userAttribute") User user, @PathVariable int id, @RequestParam String newPassword){
        user.setId(id);
        userService.update(user, newPassword);

        return "redirect:/";
    }


    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid){
        User user = userService.findByUuid(uuid);
        user.setEnable(true);
        userService.update(user);
        return "redirect:/";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username,
                               @RequestParam String password){

        try {
            validator.validate(new User(username,password));
        } catch (Exception e) {
            if(e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_FIELD)||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD)||
                    e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)){
                model.addAttribute("exception", e.getMessage());
            }
        }
        model.addAttribute("user", new User());

        return "views-user-registration";
    }

    @GetMapping("/profile")
    public String showProfile(Principal principal, Model model){
        User user = userService.findUserWithOrders(Integer.parseInt(principal.getName()));

        for (Orders order : user.getOrders()) {
            Hibernate.initialize(order.getProducts());
        }
        model.addAttribute("user", user);
        return "views-user-profile";
    }

}
