package com.devsuperior.dsClient.dsclient.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsClient.dsclient.dto.ClientDTO;
import com.devsuperior.dsClient.dsclient.entities.Client;
import com.devsuperior.dsClient.dsclient.repositories.ClientRepository;
import com.devsuperior.dsClient.dsclient.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		List<ClientDTO> listDto = new ArrayList<>();
		for(Client cli : list){
			listDto.add(new ClientDTO(cli));
		}
		return listDto;
	}

	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}
}