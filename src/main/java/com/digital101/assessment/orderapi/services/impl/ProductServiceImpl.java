/* 
* Use and distribution of this code is subject to applicable 
* licenses and the permission of the code owner. This notice 
* does not indicate the actual or intended publication of 
* this source code.
* 
* Portions developed for 101Digital by Software Development team
* LLC and are the property of 101Digital Inc.
* 
* ===== RP Modification ===========================================
* Req/Bug/Task ID#         MMddYYY    Author(s)    Description
* POC                      03282024   Ly Tran      Microservices Engineer Assessment Project v1.0
* ==================================================================
*/
package com.digital101.assessment.orderapi.services.impl;

import com.digital101.assessment.orderapi.dto.ProductDTO;
import com.digital101.assessment.orderapi.entities.Product;
import com.digital101.assessment.orderapi.exceptions.ProductNotFoundException;
import com.digital101.assessment.orderapi.repositories.ProductRepository;
import com.digital101.assessment.orderapi.services.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    public ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductDTO> findAll() {
        List<Product> prod = repository.findAll();
        return prod.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) throws ProductNotFoundException {
        return new ProductDTO(repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public ProductDTO insert(ProductDTO dto) {
        var productSaved = repository.save(new Product(dto));
        return new ProductDTO(productSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
