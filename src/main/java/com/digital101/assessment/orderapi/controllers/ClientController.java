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
package com.digital101.assessment.orderapi.controllers;

import com.digital101.assessment.orderapi.dto.requests.ClientRequestDTO;
import com.digital101.assessment.orderapi.dto.responses.ClientResponseDTO;
import com.digital101.assessment.orderapi.services.ClientService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@Tag(name = "Clients")
@RequestMapping(value = "/clients", produces = "application/json")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @Operation(summary = "Returns all clients in database.")
    @ApiResponse(responseCode =  "200", description = "OK")
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Returns client by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode =  "200", description = "OK."),
            @ApiResponse(responseCode =  "404", description = "Client not found.")
    })
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create a new client in database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode =  "201", description = "Client created with success."),
            @ApiResponse(responseCode =  "400", description = "Problem with request.")
    })
    public ResponseEntity<ClientResponseDTO> insert(@RequestBody @Valid ClientRequestDTO client) {
        var createdClient = service.insert(client);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(createdClient.getId())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(createdClient);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Delete client by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode =  "204", description = "Deleted with success."),
            @ApiResponse(responseCode =  "404", description = "Client not found."),
            @ApiResponse(responseCode =  "400", description = "Problem with request.")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
