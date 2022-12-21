package com.nttdatacenters.springt3.arr.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
public interface ClienteRepositoryI extends JpaRepository <Cliente, Long>{

	/**
	 * Búsqueda de personas por nombre
	 * 
	 * @param name
	 * @return List<Cliente>
	 */
	
	public List<Cliente> searchByNombreApellidos (final String name, final String apellidos);

}
