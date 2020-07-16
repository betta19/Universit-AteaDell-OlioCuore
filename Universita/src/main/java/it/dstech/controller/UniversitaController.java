//package it.dstech.controller;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//
//import it.dstech.models.Esame;
//import it.dstech.models.Libretto;
//import it.dstech.models.User;
//import it.dstech.repository.EsameRepository;
//import it.dstech.repository.UserRepository;
//import it.dstech.service.EsameService;
//import it.dstech.service.UserService;
//
//@Controller
//public class UniversitaController {
//
//	@Autowired
//	private UserRepository userRepo;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Autowired
//	private EsameService esameService;
//	
//	private Logger logger = LoggerFactory.getLogger(UniversitaController.class);
//	
//	@GetMapping(value={"/", "/login"})
//    public ModelAndView login(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("login");
//        return modelAndView;
//    }
//
//
//    @GetMapping(value="/registrazione")
//    public ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        User user = new User();
//        modelAndView.addObject("user", user);
//        modelAndView.setViewName("registrazione");
//        return modelAndView;
//    }
//
//    @PostMapping(value = "/registrazione")
//    public ModelAndView createNewStudente(@Valid User user, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByUsername(user.getUsername());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("username", "error.user",
//                            "Utente già presente");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registrazione");
//        } else {
//            userService.saveUser(user);
//            modelAndView.addObject("messaggio", "Utente registrato con successo!");
//            modelAndView.addObject("studente", new User());
//            modelAndView.setViewName("login");
//
//        }
//        return modelAndView;
//    }
//    
//    @GetMapping(value="/docente/home")
//    public ModelAndView homeD(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User userD = userService.findUserByUsername(auth.getName());
//        modelAndView.addObject("username", "Benvenuto " + userD.getUsername()  + " (" + userD.getEmail() + ")");
//        modelAndView.addObject("messaggio","Contenuto disponibile solo per i docenti");
//        modelAndView.setViewName("/docente/home");
//        return modelAndView;
//    }
//    
//    @PostMapping (value="/docente/aggiungiEsame")
//    public ModelAndView aggiungiEsame() {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	User userD = userService.findUserByUsername(auth.getName());
//    	modelAndView.addObject("listaEsame", userD.getListaEsame());
//    	 modelAndView.addObject("esame", new Esame());
//    	   modelAndView.setViewName("/docente/salvaEsame");
//    	   return modelAndView;
//    }
//    
//    @PostMapping (value="/docente/salvaEsame")
//    	 public ModelAndView salvaEsame(Esame esame, BindingResult result) {
//    		ModelAndView modelAndView = new ModelAndView();
//    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    		User userD = userService.findUserByUsername(auth.getName());
//    		userService.aggiungiEsame(userD, esame);
//    		modelAndView.addObject("listaEsame", userD.getListaEsame());
//    		modelAndView.addObject("esame", new Esame());
//    		modelAndView.setViewName("/docente/home");
//    		return modelAndView;
//    		 }
//    
//    
//    @PostMapping (value="/docente/listaStudenteEsame")
//    public ModelAndView listaStudenti () {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User userD = userService.findUserByUsername(auth.getName());
//		logger.warn(String.format("userD %s", userD.getUsername()));
//    	modelAndView.addObject("listaEsame", userD.getListaEsame());
//    	modelAndView.setViewName("/docente/listaEsame");
//		  return modelAndView;
//    }
//    
//    @GetMapping(value="/studente/home")
//    public ModelAndView homeS(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User userS = userService.findUserByUsername(auth.getName());
//        modelAndView.addObject("username", "Benvenuto "+ userS.getUsername()  + " (" + userS.getEmail() + ")");
//        modelAndView.addObject("messaggio","Contenuto disponibile solo per gli studenti");
//        modelAndView.setViewName("/studente/home");
//        return modelAndView;
//    }
//    
//    @GetMapping(value="/studente/mostraListaEsami")
//    public ModelAndView mostaEsame() {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	User userS = userService.findUserByUsername(auth.getName());
//    	modelAndView.addObject("username", "Benvenuto "+ userS.getUsername()  + " (" + userS.getEmail() + ")");
//    	modelAndView.addObject("listaEsami", esameService.findAllEsame());
//    	modelAndView.setViewName("/studente/iscrizioneEsame");
//    	return modelAndView;
//    }
//    
//    @GetMapping(value="/studente/iscrizioneEsame/{id}")
//    public ModelAndView iscrizioneEsame(@PathVariable("id") Integer id) {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	User userS = userService.findUserByUsername(auth.getName());
//    	Esame esame = esameService.findById(id);
//    	esameService.prenotaEsame(userS, esame);
//    	modelAndView.addObject("username", "Benvenuto "+ userS.getUsername()  + " (" + userS.getEmail() + ")");
//    	modelAndView.addObject("mess","Iscrizione esame effettuata");
//    	modelAndView.addObject("messaggio","Contenuto disponibile solo per gli studenti");
//    	modelAndView.setViewName("/studente/home");
//    	return modelAndView;
//    }
//    
//    @GetMapping(value="/docente/dettagliEsame/{id}")
//    public ModelAndView dettagliEsame(@PathVariable("id") Integer id) {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	User userd = userService.findUserByUsername(auth.getName());
//    	Esame esame = esameService.findById(id);
//    	modelAndView.addObject("username", "Benvenuto "+ userd.getUsername()  + " (" + userd.getEmail() + ")");
//    	modelAndView.addObject("listaStudente", esame.getListaUser());
//    	modelAndView.addObject("esame", esame.getId());
//    	modelAndView.addObject("user", new User());
//    	modelAndView.setViewName("/docente/assegnaVoto");
//    	return modelAndView;
//    }
//    
//    @PostMapping(value="/docente/assegnaVoto")
//    public ModelAndView mettiVoto(@ModelAttribute User studente, @RequestParam ("idEsame") Integer idEsame, @RequestParam ("voto") Integer voto) {
//    	ModelAndView modelAndView = new ModelAndView();
//    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    	User userd = userService.findUserByUsername(auth.getName());
//    	User idStudente = userService.findById(studente.getId()).get();
//    	Esame esame = esameService.findById(idEsame); 
//    	esameService.votazioneStudente(userd, esame, idStudente, voto);
//    	esameService.calcoloMedia(idStudente);
//    	modelAndView.addObject("username", "Benvenuto "+ userd.getUsername()  + " (" + userd.getEmail() + ")");
//    	modelAndView.addObject("mess","Voto assegnato");
//    	modelAndView.addObject("messaggio","Contenuto disponibile solo per gli studenti");
//    	modelAndView.setViewName("/docente/home");
//    	return modelAndView;
//    }
//    
// 
//    
//    
//}
