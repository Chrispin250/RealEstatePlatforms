package com.example.realestateplatform.controller;

import com.example.realestateplatform.DTO.UserRegistartionDto;
import com.example.realestateplatform.model.User;
import com.example.realestateplatform.services.UserInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Lazy
@Controller
@RequestMapping("/creation")
public class UserController {
    private final UserInterface userInterface;
     @Autowired
    public UserController(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @GetMapping
    public String showRegistrationForm(){
        return "signup";
    }


    @ModelAttribute("user")
    public UserRegistartionDto userRegistartionDto(){
        return new UserRegistartionDto();
    }
   @PostMapping
    public String addUserAccount(@ModelAttribute("user")UserRegistartionDto dto){
        User foundUser=userInterface.findByEmail(dto.getEmail());
        if (foundUser!=null &&  (foundUser.getEmail().equalsIgnoreCase(dto.getEmail()))) {
               return "redirect:/creation?error";
        }
        userInterface.saveAccount(dto);
        return "redirect:/creation?success";
    }
}
