package com.devsuperior.dsClient.dsclient.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsClient.dsclient.dto.ClientDTO;
import com.devsuperior.dsClient.dsclient.entities.Client;
import com.devsuperior.dsClient.dsclient.repositories.ClientRepository;

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
}