package it.dstech.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Esame;
import it.dstech.models.Libretto;
import it.dstech.models.User;
import it.dstech.repository.EsameRepository;
import it.dstech.repository.LibrettoRepository;
import it.dstech.repository.UserRepository;

@Service
public class EsameService implements EsameI {

	@Autowired
	private EsameRepository esameRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LibrettoRepository librettoRepo;

	@Override
	public List<Esame> findAllEsame() {

		List<Esame> listaEsamePreno = new ArrayList<>();
		for (Esame esame : esameRepository.findAll()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate data = LocalDate.parse(esame.getData(), formatter);
			if (!data.isBefore(LocalDate.now())) {
				listaEsamePreno.add(esame);
			}
		}
		return listaEsamePreno;
	}

	@Override
	public Esame findById(int id) {
		return esameRepository.findById(id);
	}

	@Override
	public boolean prenotaEsame(User userS, Esame esame) {
		esame.setId(esame.getId());
		userS.setId(userS.getId());
		esame.setIscritto(true);
		userS.getListaEsame().add(esame);
		Esame save = esameRepository.save(esame);
		userRepository.save(userS);
		return save != null;

	}

	public void votazioneEsame(User userd, Esame esame, User idStudente, int voto) {

		Libretto libretto = new Libretto();
		for (int i = 0; i < idStudente.getLibretto().size(); i++) {
			idStudente.getLibretto().get(i).getUser().add(userd);
			idStudente.getLibretto().get(i).getEsame().add(esame);
			idStudente.getLibretto().get(i).getVoto().add(voto);
		}
		libretto.getUser().add(userd);
		libretto.getEsame().add(esame);
		libretto.getVoto().add(voto);
		libretto.setStudente(idStudente);
		librettoRepo.save(libretto);
		userRepository.save(idStudente);

	}

	public void calcoloMedia(User idStudente, Libretto libretto) {
		int somma = 0;
		double media = 0;
		for (int i = 0; i < librettoRepo.findByStudente(idStudente.getUsername()).getVoto().size(); i++) {
			somma+= librettoRepo.findByStudente(idStudente.getUsername()).getVoto().get(i);
		}
		media = somma / librettoRepo.findByStudente(idStudente.getUsername()).getVoto().size();
		libretto.setMedia(media);
		librettoRepo.save(libretto);
	}

}
