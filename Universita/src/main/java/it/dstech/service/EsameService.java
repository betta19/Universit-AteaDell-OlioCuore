//package it.dstech.service;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import it.dstech.models.Esame;
//import it.dstech.models.Libretto;
//import it.dstech.models.User;
//import it.dstech.repository.EsameRepository;
//import it.dstech.repository.LibrettoRepository;
//import it.dstech.repository.UserRepository;
//
//@Service
//public class EsameService implements EsameI {
//
//	@Autowired
//	private EsameRepository esameRepository;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Autowired
//	private LibrettoRepository librettoRepo;
//
//	@Override
//	public List<Esame> findAllEsame() {
//
//		List<Esame> listaEsamePreno = new ArrayList<>();
//		for (Esame esame : esameRepository.findAll()) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate data = LocalDate.parse(esame.getData(), formatter);
//			if (!data.isBefore(LocalDate.now())) {
//				listaEsamePreno.add(esame);
//			}
//		}
//		return listaEsamePreno;
//	}
//
//	@Override
//	public Esame findById(int id) {
//		return esameRepository.findById(id);
//	}
//
//	@Override
//	public boolean prenotaEsame(User userS, Esame esame) {
//		esame.setId(esame.getId());
//		userS.setId(userS.getId());
//		esame.getLibretto().add(userS.ge));
//		userRepository.findUserByUsername(esame.getDocente());
//		esame.setIscritto(true);
//		esame.getListaUser().add(userS);
//		userS.getListaEsame().add(esame);
//		userS.getLibretto().add(listaLibretti);
//		Esame save = esameRepository.save(esame);
//		userRepository.save(userS);
//		return save != null;
//
//	}
//
//
//	public void votazioneStudente(User userd, Esame esame, User idStudente, int voto) {
//		List <Libretto> listaLibretti = librettoRepo.findByStudente(idStudente.getUsername());
//		for (Libretto libretto : listaLibretti) {
//			
//			for (Esame cercaEsame : libretto.getEsame()) {
//				if(cercaEsame.getId().equals(esame.getId())) {
//					libretto.setVoto(voto);
//					idStudente.getLibretto().add(libretto);
//					librettoRepo.save(libretto);
//				}
//			}
//		}
//		userRepository.save(idStudente);
//		
//	}
//
//	public void calcoloMedia(User idStudente) {
//		int somma = 0;
//		double media = 0;
//		List<Libretto> libretto = librettoRepo.findByStudente(idStudente.getUsername());
//		for (int i = 0; i < libretto.size(); i++) {
//			somma += libretto.get(i).getVoto();
//			media = somma / libretto.size();
//			idStudente.setMedia(media);
//			librettoRepo.save(libretto.get(i));
//			userRepository.save(idStudente);
//
//		}
//
//	}
//
//}
