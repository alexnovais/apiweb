package br.com.versalli.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.versalli.ws.model.Cliente;

@RestController
public class ClienteController {

	Map<Integer, Cliente> clientes = new HashMap<>();
	Integer proximoId = 1;

	// Métodos de Negócio
	private Cliente cadastrar(Cliente cliente) {

		cliente.setId(proximoId);
		proximoId++;

		clientes.put(cliente.getId(), cliente);

		return cliente;
	}

	private Collection<Cliente> buscarTodos() {
		return clientes.values();
	}
	// End points para comunicação Web/Servidor

	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = cadastrar(cliente);
		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesEncontrados = buscarTodos();
		return new ResponseEntity<>(clientesEncontrados, HttpStatus.OK);
	}
}
