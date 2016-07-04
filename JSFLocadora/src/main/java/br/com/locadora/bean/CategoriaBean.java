package br.com.locadora.bean;

import javax.faces.bean.ManagedBean;

import br.com.locadora.dao.DAO;
import br.com.locadora.modelo.Categoria;

@ManagedBean(name="categBen")
public class CategoriaBean {

	private Categoria categoria = new Categoria();

	public Categoria getCategoria() {
		return categoria;
	}

	public String gravar(){
		System.out.println("Gravando categoria "+ this.categoria.getNomeCategoria());
		new DAO<Categoria>(Categoria.class).adiciona(categoria);
		
		this.categoria = new Categoria();
		return "dvd-cadastro?redirect=true";
	}
	
	
	
	
}
