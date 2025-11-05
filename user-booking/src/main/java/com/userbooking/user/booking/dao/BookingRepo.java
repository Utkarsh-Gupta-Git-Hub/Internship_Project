package com.userbooking.user.booking.dao;

import com.userbooking.user.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
    @Query(value = "from Booking where userInfo.id=:id")
public List<Booking> findByUserInfo(@Param("id") Long id);
}
