package br.com.locadora.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.locadora.dao.DAO;
import br.com.locadora.modelo.Categoria;
import br.com.locadora.modelo.Dvd;

@ManagedBean(name="dvd")
@ViewScoped
public class DvdBean {

	private Dvd filme = new Dvd();
	private Integer categoriaId;
	
	

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Dvd getFilme() {
		return filme;
	}
	
	public List<Categoria> getCategoria(){
		return new DAO<Categoria>(Categoria.class).listaTodos();
	}

	public List<Categoria> getCategoriasDoDvd(){
		return this.filme.getCategoria();
	}
	public void gravarCategoria(){
		Categoria categoria = new DAO<Categoria>(Categoria.class).buscaPorId(this.categoriaId);
		this.filme.adicionaCategoria(categoria);
	}
	
	public void gravarDVD() {
		System.out.println("Gravando" + this.filme.getTitulo());
		if(filme.getCategoria().isEmpty())
			throw new RuntimeException("o Dvd precisa ter uma categoria");
		
		new DAO<Dvd>(Dvd.class).adiciona(filme);
		
	}

}
