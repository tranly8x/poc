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

import com.digital101.assessment.orderapi.dto.requests.ClientRequestDTO;
import com.digital101.assessment.orderapi.dto.responses.ClientResponseDTO;

import java.util.List;

public interface ClientService {

    List<ClientResponseDTO> findAll();

    ClientResponseDTO findById(Long id);

    ClientResponseDTO insert(ClientRequestDTO dto);

     void delete(Long id);
}