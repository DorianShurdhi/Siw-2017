package it.uniroma3.siw.progetto.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.progetto.model.Opera;
import it.uniroma3.siw.progetto.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	OperaService operaService;
	
    @GetMapping("/opera")
    public String showForm(Opera opera) {
        return "form";
    }

    @PostMapping("/addOpera")
    public String checkOperaAdd(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "OperazioniAdmin";
        } else {
        	operaService.add(opera); 
        	Iterable <Opera> itopere = operaService.findAll();
    		List<Opera> opere = new LinkedList<>();
    		for(Opera o : itopere){
    			opere.add(o);
    		}
    		model.addAttribute("opere", opere);
        }
        return "OperazioniAdmin";
    }
    //UpdateOpera
    @PostMapping("/updateOpera")
    public String updateOpera(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "OperazioniAdmin";
        } else {
        	//TODO SISTEMARE METODO 
        	operaService.findbyId(opera.getId()); 
        	Iterable <Opera> itopere = operaService.findAll();
    		List<Opera> opere = new LinkedList<>();
    		for(Opera o : itopere){
    			opere.remove(o);
    			if(o.getRestauro().equals("Si"))
    				o.setRestauro("No");
    			else
    				o.setRestauro("Si");
    			opere.add(o);
    		}
    		model.addAttribute("opere", opere);
        }
        return "OperazioniAdmin";
    }
    
    @PostMapping("/removeOpera")
    public String operaRemove(@Valid @ModelAttribute Opera opera, BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "OperazioniAdmin";
        } else {
        	operaService.remove(opera);
        	Iterable <Opera> itopere = operaService.findAll();
    		List<Opera> opere = new LinkedList<>();
    		for(Opera o : itopere){
    			opere.add(o);
    		}
    		model.addAttribute("opere", opere);
        }
        return "OperazioniAdmin";
    }
    
	@ModelAttribute("opere")
	public Iterable<Opera> opere(){
		Iterable <Opera> itopere = operaService.findAll();
		List<Opera> opere = new LinkedList<>();
		for(Opera o : itopere){
			opere.add(o);
		}
		return opere;
	}
}