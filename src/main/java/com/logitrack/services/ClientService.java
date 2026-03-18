package com.logitrack.services;

import com.logitrack.entities.Client;
import com.logitrack.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + id));
    }

    public void deleteClient(int id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client non trouvé");
        }
        clientRepository.deleteById(id);
    }
}