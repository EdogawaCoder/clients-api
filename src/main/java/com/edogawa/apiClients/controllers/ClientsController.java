package com.edogawa.apiClients.controllers;

import com.edogawa.apiClients.entities.Client;
import com.edogawa.apiClients.repositories.ClientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientsController {

    @GetMapping
    public List<Client> getAll(@RequestParam String name) throws Exception {


        var clientRepository = new ClientRepository();

        return clientRepository.searchClients(name);
    }

}
