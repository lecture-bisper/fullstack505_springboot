package com.bitc.security.controller;

import com.bitc.security.data.dto.AddUserRequest;
import com.bitc.security.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequiredArgsConstructor
@Controller
public class UserController {

  private final UserService userService;

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public String signup(AddUserRequest user) throws Exception {
    userService.save(user);
    return "redirect:/login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String login() throws Exception {
    return "login";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public String signup() throws Exception {
    return "signup";
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest req, HttpServletResponse resp) throws Exception {
    new SecurityContextLogoutHandler().logout(req, resp, SecurityContextHolder.getContext().getAuthentication());
    return "redirect:/logout";
  }
}









