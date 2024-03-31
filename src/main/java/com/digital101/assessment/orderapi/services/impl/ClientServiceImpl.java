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

import com.digital101.assessment.orderapi.dto.requests.ClientRequestDTO;
import com.digital101.assessment.orderapi.dto.responses.ClientResponseDTO;
import com.digital101.assessment.orderapi.entities.Client;
import com.digital101.assessment.orderapi.exceptions.ClientNotFoundException;
import com.digital101.assessment.orderapi.repositories.ClientRepository;
import com.digital101.assessment.orderapi.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

    public ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ClientResponseDTO> findAll() {
        List<Client> list = repository.findAll();
        return list.stream().map(ClientResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public ClientResponseDTO findById(Long id) throws ClientNotFoundException {
        return new ClientResponseDTO(repository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id)));
    }

    @Override
    public ClientResponseDTO insert(ClientRequestDTO dto) {
        Client clientToSave = repository.save(new Client(dto));
        return new ClientResponseDTO(clientToSave);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }
}
