package com.nttdatacenters.springt3.arr;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdatacenters.springt3.arr.persistence.Cliente;
import com.nttdatacenters.springt3.arr.services.GestionClienteImpl;

/**
 * 
 * @author Alexandra Rodríguez
 *
 */
@SpringBootApplication
public class SpringT3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringT3Application.class, args);
		
		GestionClienteImpl gestion = new GestionClienteImpl();
		
		// Creamos Cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setId(1L);
		cliente1.setNombre("Mónica");
		cliente1.setApellidos("Rodríguez");
		cliente1.setDNI("1234567F");
		cliente1.setFechaNacimiento("1/1/2000");
		
		// Creamos Cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setId(2L);
		cliente2.setNombre("Marcos");
		cliente2.setApellidos("Rodríguez");
		cliente2.setDNI("2222567F");
		cliente2.setFechaNacimiento("2/2/2000");
		
		gestion.insertNewCliente(cliente1);
		gestion.insertNewCliente(cliente2);
		
		// Buscamos cliente por nombre y apellidos
		List<Cliente> busquedaCliente = gestion.searchByNameAndSurnames("Marcos", "Rodríguez");
		
		for (Cliente cliente : busquedaCliente) {
			System.out.println("Nombre: " + cliente.getNombre());
			System.out.println("Apellido: " + cliente.getApellidos());
		}
		
	}

}
