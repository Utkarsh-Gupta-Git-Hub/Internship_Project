package com.userbooking.user.booking.dao;

import com.userbooking.user.booking.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Long> {
    public Optional<UserInfo> findByEmail(String email);
}
