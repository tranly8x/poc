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
package com.digital101.assessment.orderapi.services;

import com.digital101.assessment.orderapi.dto.OrderDTO;
import com.digital101.assessment.orderapi.entities.Order;

import java.util.List;


public interface OrderService {

    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    OrderDTO insert(Order order);

    void delete(Long id);
}