package it.dstech.service;



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
		
		List<Esame> listaEsamePreno = new ArrayList<>();
		for (Esame esame : esameRepository.findAll()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			LocalDateTime data = LocalDateTime.parse(esame.getData(), formatter);
			if (!data.isBefore(LocalDateTime.now())) {
				listaEsamePreno.add(esame);
			}
		}
		return listaEsamePreno;
	}

	public Esame findById(Integer id) {
		return esameRepository.findById(id).get();
	}
	
		
}
