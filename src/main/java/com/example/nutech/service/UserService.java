package com.example.nutech.service;

import com.example.nutech.dto.request.LoginUserRequest;
import com.example.nutech.dto.request.ProfileUpdateRequest;
import com.example.nutech.dto.response.ProfileResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.dto.response.TokenDTO;
import com.example.nutech.entity.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    ResponseDTO<Void> registration(User user);
    ResponseDTO<TokenDTO> login(LoginUserRequest request);
    ResponseDTO<ProfileResponse> getProfile(String token);
    ResponseDTO<ProfileResponse> updateProfile(String token, ProfileUpdateRequest updateRequestDTO);
    ResponseDTO<ProfileResponse> uploadProfileImage(String token, MultipartFile file);
}
