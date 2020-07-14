package it.dstech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import it.dstech.models.Esame;
import it.dstech.models.User;
import it.dstech.repository.UserRepository;
import it.dstech.service.EsameService;
import it.dstech.service.UserService;

@Controller
public class UniversitaController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EsameService esameService;
	
	@GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value="/registrazione")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("studente", user);
        modelAndView.setViewName("registrazione");
        return modelAndView;
    }

    @PostMapping(value = "/registrazione")
    public ModelAndView createNewStudente(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userService.findUserByUsername(user.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "Utente già presente");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registrazione");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("messaggio", "Utente registrato con successo!");
            modelAndView.addObject("studente", new User());
            modelAndView.setViewName("login");

        }
        return modelAndView;
    }
    
    @GetMapping(value="/docente/home")
    public ModelAndView homeD(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userD = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("username", "Benvenuto " + userD.getUsername()  + " (" + userD.getEmail() + ")");
        modelAndView.addObject("messaggio","Contenuto disponibile solo per i docenti");
        modelAndView.setViewName("/docente/home");
        return modelAndView;
    }
    
    @GetMapping (value="/docente/aggiungiEsame")
    public ModelAndView aggiungiEsame() {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User userD = userService.findUserByUsername(auth.getName());
    	modelAndView.addObject("listaEsame", userD.getListaEsame());
    	 modelAndView.addObject("esame", new Esame());
    	   modelAndView.setViewName("/docente/salvaEsame");
    	   return modelAndView;
    }
    
    @PostMapping (value="/docente/salvaEsame")
    	 public ModelAndView salvaEsame(Esame esame, BindingResult result) {
    		ModelAndView modelAndView = new ModelAndView();
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    		User userD = userService.findUserByUsername(auth.getName());
    		  userService.aggiungiEsame(userD, esame);
    		  modelAndView.addObject("listaEsame", userD.getListaEsame());
    		  modelAndView.addObject("esame", new Esame());
    		   modelAndView.setViewName("/docente/salvaEsame");
    		  return modelAndView;
    		 }
    
    @GetMapping (value="/docente/listaStudenteEsame")
    public ModelAndView listaStudenti (BindingResult result) {
    	ModelAndView modelAndView = new ModelAndView();
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userD = userService.findUserByUsername(auth.getName());
		List<User> listaStudente = new ArrayList<>();
		for (int i = 0; i < userD.getListaEsame().size(); i++) {
			listaStudente.add(userD.getListaEsame().get(i).getListaUser().get(i));
		}
    	modelAndView.addObject("listaStudente", listaStudente);
    	modelAndView.setViewName("/docente/listaStudente");
		  return modelAndView;
    }
    
    @GetMapping(value="/studente/home")
    public ModelAndView homeS(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User userS = userService.findUserByUsername(auth.getName());
        modelAndView.addObject("username", "Benvenuto "+ userS.getUsername()  + " (" + userS.getEmail() + ")");
        modelAndView.addObject("messaggio","Contenuto disponibile solo per gli studenti");
        modelAndView.setViewName("/studente/home");
        return modelAndView;
    }
}
