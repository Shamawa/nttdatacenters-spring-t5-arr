package com.nttdatacenters.springt3.arr.services;

import java.util.List;

import com.nttdatacenters.springt3.arr.persistence.Cliente;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
public interface GestionClienteI {
	
	/**
	 * Inserta un Cliente.
	 * 
	 * @param newCliente
	 */
	public void insertNewCliente(final Cliente newCliente);

	/**
	 * Actualiza un Cliente existente.
	 * 
	 * @param updatedCliente
	 */
	public void updateCliente(final Cliente updatedCliente);

	/**
	 * Elimina un Cliente existente.
	 * 
	 * @param deletedCliente
	 */
	public void deleteCliente(final Cliente deletedCliente);

	/**
	 * Obtiene un Cliente mediante su ID.
	 * 
	 * @param clienteId
	 */
	public Cliente searchById(final Long clienteId);

	/**
	 * Obtiene todos los Clientes existentes.
	 * 
	 * @return List<Cliente>
	 */
	public List<Cliente> searchAll();

	/**
	 * Obtiene clientes por nombre y apellidos
	 * 
	 * @param name
	 * @param surnames
	 * @return List<EverisPlayer>
	 */
	public List<Cliente> searchByNameAndSurnames(final String nombre, final String apellidos);

}
