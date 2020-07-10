package it.dstech.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.repository.EsameRepository;

@Service
public class EsameService implements EsameI{

	@Autowired
	private EsameRepository esameRepository;


		
}
