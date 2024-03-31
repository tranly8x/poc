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

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digital101.assessment.orderapi.dto.OrderDTO;
import com.digital101.assessment.orderapi.entities.Order;
import com.digital101.assessment.orderapi.exceptions.OrderNotFoundException;
import com.digital101.assessment.orderapi.repositories.OrderRepository;
import com.digital101.assessment.orderapi.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findAll();
        return list.stream().map(OrderDTO::new).collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        return new OrderDTO(repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id)));
    }

    @Override
    public OrderDTO insert(Order order) {
        var orderSaved = repository.save(order);
        return new OrderDTO(orderSaved);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
