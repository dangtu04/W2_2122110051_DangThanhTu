package com.dangthanhtu.backend.service;

import org.springframework.web.multipart.MultipartFile;

import com.dangthanhtu.backend.payloads.BrandDTO;

import java.io.InputStream;
import java.util.List;

public interface BrandService {
    BrandDTO createBrand(BrandDTO brandDTO);

    BrandDTO updateBrand(Long brandId, BrandDTO brandDTO);

    String uploadBrandImage(Long brandId, MultipartFile file);

    List<BrandDTO> getBrands();

    BrandDTO getBrandById(Long brandId);

    InputStream getBrandImage(String fileName);

    void deleteBrand(Long brandId);
}
