package com.alam.Airbnb.Service.Interfaces;

import com.alam.Airbnb.DTO.ProfileUpdateDTO;
import com.alam.Airbnb.DTO.UserDTO;
import com.alam.Airbnb.Entity.User;

public interface UserService {
    User getUserById(Long id);
    void updateProfile(ProfileUpdateDTO profileUpdateDTO);
    UserDTO getMyProfile();
}
