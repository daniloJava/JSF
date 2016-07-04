package br.com.locadora.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Dvd {
	
	@Id @GeneratedValue
	private Integer id;
	private String titulo;
	private double preço;
	@Temporal(TemporalType.DATE)
	private Calendar datalancamento = Calendar.getInstance();
	
	@ManyToMany
	private List<Categoria> todosClientes = new ArrayList<Categoria>();
	
	public List<Categoria> getCategoria() {
		return todosClientes;
	}

	public void adicionaCategoria(Categoria categoria){
		this.todosClientes.add(categoria);
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
	
	public double getPreço() {
		return preço;
	}
	public void setPreço(double preço) {
		this.preço = preço;
	}

	public Calendar getDatalancamento() {
		return datalancamento;
	}

	public void setDatalancamento(Calendar datalancamento) {
		this.datalancamento = datalancamento;
	}

	public List<Categoria> getTodosClientes() {
		return todosClientes;
	}

	public void setTodosClientes(List<Categoria> todosClientes) {
		this.todosClientes = todosClientes;
	}
	

	

	
	
	
}