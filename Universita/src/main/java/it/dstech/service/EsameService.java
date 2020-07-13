package it.dstech.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Esame;
import it.dstech.repository.EsameRepository;

@Service
public class EsameService implements EsameI{

	@Autowired
	private EsameRepository esameRepository;

	@Override
	public List<Esame> findAllEsame() {
		return esameRepository.findAll();
	}

	
		
}
