package br.com.versalli.ws.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class ClienteController {
	
	@RequestMapping(method=RequestMethod.GET, value="/clientes")
	public void buscar(){
		System.out.println("Chamou /clientes!");
	}
}
