package com.nttdatacenters.springt3.arr.persistence.dao;

import java.util.List;

import com.nttdatacenters.springt3.arr.persistence.Cliente;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
public class ClienteDaoImpl extends CommonDaoImpl<Cliente> implements ClienteDaoI  {

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
