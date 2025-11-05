package com.userbooking.user.booking.service;

import com.userbooking.user.booking.dao.UserRepo;
import com.userbooking.user.booking.dto.UserDetails;
import com.userbooking.user.booking.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    private UserInfo userInfo ;
    public UserInfo convertIntoUserInfo(UserDetails userDetails){
        userInfo = new UserInfo();
        userInfo.setEmail(userDetails.getEmail());
        userInfo.setFullname(userDetails.getFullName());
        userInfo.setPassword(userDetails.getPassword());
        userInfo.setPhoneNumber(userDetails.getPhoneNumber());
        return userInfo;
    }

    public UserInfo saveUserInfo(UserInfo userInfo){
        userRepo.save(userInfo);
        return userInfo;
    }

    public UserInfo findByEmail(String email) throws UserPrincipalNotFoundException {
        Optional<UserInfo> byEmail = userRepo.findByEmail(email);
       return byEmail.orElseThrow(()->new UserPrincipalNotFoundException("User not found"));
    }
}
