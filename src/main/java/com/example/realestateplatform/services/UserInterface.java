package com.example.realestateplatform.services;
import com.example.realestateplatform.DTO.UserRegistartionDto;
import com.example.realestateplatform.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserInterface extends UserDetailsService {
    public User saveAccount(UserRegistartionDto userRegistartionDto);
    public User findByEmail(String email);
}
