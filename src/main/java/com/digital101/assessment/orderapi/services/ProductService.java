package com.digital101.assessment.orderapi.services;


import java.util.List;

import com.digital101.assessment.orderapi.dto.ProductDTO;

public interface ProductService {
     List<ProductDTO> findAll();

    ProductDTO findById(Long id);
    
    ProductDTO insert(ProductDTO dto);

    void delete(Long id);
}