package com.userbooking.user.booking.controller;


import com.userbooking.user.booking.entity.Booking;
import com.userbooking.user.booking.dto.UserDetails;
import com.userbooking.user.booking.entity.UserInfo;
import com.userbooking.user.booking.service.BookingService;
import com.userbooking.user.booking.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller

public class PublicController {
    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;

    @GetMapping(value = {"/","/home"})
    public String home(){
        return "index";
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }

    @PostMapping("book")
    public String book(@Valid @ModelAttribute Booking booking,BindingResult result,Model m,HttpSession session,RedirectAttributes redirectAttributes){
        booking.setUserInfo((UserInfo) session.getAttribute("user"));
        if(result.hasErrors()){
            m.addAttribute("issue","Please fill correct details");
            return "reservation";
        }
         String s=  bookingService.saveBooking(booking);
         redirectAttributes.addFlashAttribute("issue",s);
        return "redirect:/reservation";
    }

    @GetMapping("reservation")
    public String reservation(){
        return "reservation";
    }

    @PostMapping("/cancelBooking/{id}")
    public String deleteBooking(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return "redirect:/cancellation";
    }


    @GetMapping("cancellation")
    public String cancellation(HttpSession session,Model m)
    {
       UserInfo userinfo= (UserInfo) session.getAttribute("user");
        List<Booking> books = bookingService.getAllBookingByUserId(userinfo.getId());
        m.addAttribute("book",books);
        System.out.println(books);
        return "cancellation";
    }


    @GetMapping("signin")
    public String userSignin(Model m){
        m.addAttribute("userDetails",new UserDetails());
        return "userregistration";
    }

   @PostMapping("register")
    public String register(@Valid @ModelAttribute("userDetails") UserDetails userDetails, BindingResult result, Model m , RedirectAttributes redirectAttributes,HttpServletRequest r){
        if(result.hasErrors()){
            m.addAttribute("issue","Please fill correct details");
            m.addAttribute("userDetails",userDetails);
            return "userregistration";
        }
       UserInfo userInfo = userService.saveUserInfo(userService.convertIntoUserInfo(userDetails));
        HttpSession session = r.getSession();
        session.setAttribute("user",userInfo);
       return "redirect:/home";
    }

    @PostMapping("verifylogin")
    public String verifylogin(@RequestParam String username, @RequestParam String password, Model m , HttpServletRequest r, HttpServletResponse rs){
        try {
            UserInfo info =userService.findByEmail(username);
            if(!info.getPassword().equals(password)){
                m.addAttribute("invalid","Password is invalid");

                return "login";
            }
            HttpSession session = r.getSession();
            session.setAttribute("user",info);
            } catch (UserPrincipalNotFoundException ex) {
            m.addAttribute("invalid","User not found");
            return "login";
        }

        return "redirect:/home";
    }

    }


