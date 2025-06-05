package com.alam.Airbnb.Service;

import com.alam.Airbnb.DTO.LoginDTO;
import com.alam.Airbnb.DTO.SignUpDTO;
import com.alam.Airbnb.DTO.UserDTO;
import com.alam.Airbnb.Entity.User;
import com.alam.Airbnb.Enums.Role;
import com.alam.Airbnb.Exception.ResourceNotFoundException;
import com.alam.Airbnb.Repository.UserRepository;
import com.alam.Airbnb.Security.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public UserDTO userSignUp(SignUpDTO signUpDTO){
        User user = userRepository.findByEmail(signUpDTO.getEmail()).orElse(null);
        if(user != null){
            throw new RuntimeException("User with the Email Already Exists");
        }
        User newUser = modelMapper.map(signUpDTO,User.class);
        newUser.setRoles(Set.of(Role.GUEST));
        newUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        newUser = userRepository.save(newUser);
        return modelMapper.map(newUser, UserDTO.class);
    }

    public String[] login(LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken
                (loginDTO.getEmail(), loginDTO.getPassword()));
        User user = (User) authentication.getPrincipal();

        String[] arr = new String[2];
        arr[0] = jwtService.generateAccessToken(user);
        arr[1] = jwtService.generateRefreshToken(user);
        return arr;
    }

    public String refreshToken(String refreshToken) {
        Long id = jwtService.getUserIdFromToken(refreshToken);

        User user = userRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id: "+id));
        return jwtService.generateAccessToken(user);
    }
}
