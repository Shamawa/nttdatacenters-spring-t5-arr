package com.nttdatacenters.springt3.arr.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nttdatacenters.springt3.arr.persistence.Cliente;
import com.nttdatacenters.springt3.arr.persistence.dao.ClienteDaoI;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
public class GestionClienteImpl implements GestionClienteI {

	@Autowired
	private ClienteDaoI clienteDaoI;

	@Override
	public void insertNewCliente(Cliente newCliente) {
		if (newCliente != null && newCliente.getId() == null) {
			clienteDaoI.insert(newCliente);
		}

	}

	@Override
	public void updateCliente(Cliente updatedCliente) {
		if (updatedCliente != null && updatedCliente.getId() != null) {
			clienteDaoI.update(updatedCliente);
		}

	}

	@Override
	public void deleteCliente(Cliente deletedCliente) {
		if (deletedCliente != null && deletedCliente.getId() != null) {
			clienteDaoI.delete(deletedCliente);
		}

	}

	@Override
	public Cliente searchById(Long clienteId) {
		Cliente cliente = null;

		if (clienteId != null) {
			cliente = clienteDaoI.searchById(clienteId);
		}
		return cliente;
	}

	@Override
	public List<Cliente> searchAll() {
		List<Cliente> clientesList = new ArrayList<>();

		clientesList = clienteDaoI.searchAll();
		
		return clientesList;
	}

	@Override
	public List<Cliente> searchByNameAndSurnames(String nombre, String apellidos) {
		List<Cliente> clientesList = searchAll();

		for (Cliente cliente : clientesList) {
			if (cliente.getNombre().equals(nombre) && cliente.getApellidos().equals(apellidos)) {
				clientesList.add(cliente);
			}
		}
		return clientesList;
	}

}
