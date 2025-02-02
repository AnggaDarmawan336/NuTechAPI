package com.example.nutech.service;

import com.example.nutech.dto.response.BannerResponse;
import com.example.nutech.dto.response.ResponseDTO;
import com.example.nutech.dto.response.LayananResponse;

import java.util.List;

public interface InformationService {
    ResponseDTO<List<BannerResponse>> bannerAll();
    ResponseDTO<List<LayananResponse>> serviceAll(String token);
}
