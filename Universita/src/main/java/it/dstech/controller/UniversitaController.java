package it.dstech.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import it.dstech.models.Docente;
import it.dstech.models.Studente;
import it.dstech.repository.DocenteRepository;
import it.dstech.repository.StudenteRepository;
import it.dstech.service.DocenteService;
import it.dstech.service.StudenteService;

@Controller
public class UniversitaController {

	@Autowired
	private DocenteRepository docenteRepo;
	
	@Autowired
	private StudenteRepository studenteRepo;
	
	@Autowired
	private StudenteService studenteService;
	
	@Autowired
	private DocenteService docenteService;
	
	@GetMapping(value={"/", "/login"})
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @GetMapping(value="/registration")
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Studente user = new Studente();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping(value = "/registration")
    public ModelAndView createNewStudente(@Valid Studente studente, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Studente userExists = studenteService.findUserByUserName(studente.getUsername());
        if (userExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the user name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            studenteService.saveUser(studente);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new Studente());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }
    
    @GetMapping(value="/docente/home")
    public ModelAndView homeD(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Docente user = docenteService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getUsername()  + " (" + user.getEmail() + ")");
        modelAndView.addObject("ProfMessage","Content Available Only for Users with Prof Role");
        modelAndView.setViewName("/docente/home");
        return modelAndView;
    }
    
    @GetMapping(value="/studente/home")
    public ModelAndView homeS(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Studente user = studenteService.findUserByUserName(auth.getName());
        modelAndView.addObject("userName", "Welcome " + user.getMatricola() + user.getUsername()  + " (" + user.getEmail() + ")");
        modelAndView.addObject("StudMessage","Content Available Only for Users with student Role");
        modelAndView.setViewName("/studente/home");
        return modelAndView;
    }
}
