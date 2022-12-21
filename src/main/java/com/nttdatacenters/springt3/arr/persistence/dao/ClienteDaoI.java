package com.nttdatacenters.springt3.arr.persistence.dao;

import java.util.List;

import com.nttdatacenters.springt3.arr.persistence.Cliente;

/**
 * 
 * @author Alexandra Rodríguez
 *
 * Dao Tabla de Cliente
 */
public interface ClienteDaoI extends CommonDaoI<Cliente> {
	
	/**
	 * Obtiene Clientes por nombre y apellidos
	 * @param nombre
	 * @param apellidos
	 * @return
	 */
	public List<Cliente>searchByNameAndSurnames(final String nombre, final String apellidos);

}
