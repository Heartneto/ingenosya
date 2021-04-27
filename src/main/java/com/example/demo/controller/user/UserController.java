package com.example.demo.controller.user;

import com.example.demo.controller.BaseController;
import com.example.demo.model.dto.user.UserIdentityAvailability;
import com.example.demo.model.dto.user.UserResponseDTO;
import com.example.demo.security.CurrentUser;
import com.example.demo.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController extends BaseController {

    @GetMapping("me")
    public UserResponseDTO getCurrentUser(@CurrentUser UserPrincipal currentUser){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(currentUser.getUsername());
        dto.setId(currentUser.getId());
        return dto;
    }

    @GetMapping("checkUsernameAvailability")
    public UserIdentityAvailability checkUserNameAvailability(@RequestParam(value = "username") String username){
        Boolean isAvailable = userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

}
