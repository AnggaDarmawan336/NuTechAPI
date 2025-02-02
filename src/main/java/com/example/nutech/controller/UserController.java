package com.example.nutech.controller;

import com.example.nutech.dto.request.LoginUserRequest;
import com.example.nutech.dto.request.ProfileUpdateRequest;
import com.example.nutech.dto.response.ProfileResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.dto.response.TokenDTO;
import com.example.nutech.entity.User;
import com.example.nutech.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping
@Tag(name = "1. Membership Module")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "register", security = {})
    @PostMapping("/registration")
    public ResponseEntity<ResponseDTO<Void>> registerUser(@RequestBody User user){
        ResponseDTO<Void> result = userService.registration(user);
        return ResponseEntity.status(result.getStatus() == 0 ? 200 : 400).body(result);
    }

    @Operation(summary = "login", security = {})
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<TokenDTO>> login(@RequestBody LoginUserRequest request){
        ResponseDTO<TokenDTO> result = userService.login(request);
        return ResponseEntity.status(result.getStatus() == 0 ? 200 : 400).body(result);
    }

    @GetMapping("/profile")
    public ResponseEntity<ResponseDTO<ProfileResponse>> getProfile(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ResponseDTO<>(108, "Token tidak valid atau kadaluwarsa", null));
        }

        String token = authHeader.replace("Bearer ", "");
        ResponseDTO<ProfileResponse> result = userService.getProfile(token);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/profile/update")
    public ResponseEntity<ResponseDTO<ProfileResponse>> updateProfile(
            HttpServletRequest request,
            @RequestBody ProfileUpdateRequest updateRequestDTO)
    {        String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ResponseDTO<>(108, "Token tidak valid atau kadaluwarsa", null));
        }

        String token = authHeader.replace("Bearer ", "");
        ResponseDTO<ProfileResponse> result = userService.updateProfile(token, updateRequestDTO);
        return ResponseEntity.ok(result);
    }


    @PutMapping(value = "/profile/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseDTO<ProfileResponse>> updateProfileImage(
            HttpServletRequest request,
            @RequestParam("file") MultipartFile file)
    {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
            return ResponseEntity.ok(new ResponseDTO<>(108, "Token tidak valid atau kadaluwarsa", null));
        }

        String token = authHeader.replace("Bearer ", "");
        ResponseDTO<ProfileResponse> result = userService.uploadProfileImage(token, file);
        return ResponseEntity.ok(result);
    }
}
