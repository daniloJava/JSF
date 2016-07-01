package br.com.locadora.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Dvd {
	
	@Id @GeneratedValue
	private Integer id;
	private String titulo;
	private String categoria;
	private double preço;
	private String datalancamento;
	
	@ManyToMany
	private List<Cliente> todosClientes = new ArrayList<Cliente>();
	
	public List<Cliente> getClientes() {
		return todosClientes;
	}

	public void adicionaCliente(Cliente cliente){
		this.todosClientes.add(cliente);
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}
	public String getDatalancamento() {
		return datalancamento;
	}
	public void setDatalancamento(String datalancamento) {
		this.datalancamento = datalancamento;
	}

	
	
	
}