package br.com.locadora.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

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
			FacesContext.getCurrentInstance().addMessage("catego", new FacesMessage("Não foi possive Gravar Insira uma Categoria"));
		else
			new DAO<Dvd>(Dvd.class).adiciona(filme);
		
		this.filme = new Dvd();
	}
	
	public void campoPrecoMaiorQueZero(FacesContext fc, UIComponent componente, 
					Object valor) throws ValidatorException{
		Double preco = (Double) valor;
		System.out.println(preco);
		System.out.println("agora vaiii");
		
		throw new ValidatorException(new FacesMessage("Teste son"));	
	}

}
