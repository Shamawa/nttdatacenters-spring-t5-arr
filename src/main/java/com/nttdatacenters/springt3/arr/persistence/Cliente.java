package com.nttdatacenters.springt3.arr.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Tabla Clientes
 * 
 * @author Alexandra Rodríguez
 * 
 */
@Entity
@Table(name = "T_CLIENTE")
public class Cliente extends AbstractEntity implements Serializable {
	
	/** Serial Version*/
	private static final long serialVersionUID = 1L;
	
	/** ID Cliente	 */
	private Long id;
	
	/** Nombre */
	private String nombre;
	
	/** Apellidos*/
	private String apellidos;
	
	/** Fecha de Nacimiento */
	private String fechaNacimiento;
	
	/** DNI */
	private String DNI;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "C_PK_CLIENTE_ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "C_NOMBRE", nullable = false)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "C_APELLIDOS", nullable = false)
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "C_FECHA_NACIMIENTO", nullable = false)
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Column(name = "C_DNI", nullable = false)
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	
	
	
	

}
