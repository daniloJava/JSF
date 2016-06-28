package br.com.locadora.bean;

import javax.faces.bean.ManagedBean;

import br.com.locadora.dao.DAO;
import br.com.locadora.modelo.Dvd;

@ManagedBean
public class DvdBean {

	private Dvd filme = new Dvd();

	public Dvd getFilme() {
		return filme;
	}

	public void gravarDVD() {
		System.out.println("Gravando" + this.filme.getTitulo());
		new DAO<Dvd>(Dvd.class).adiciona(this.filme);
		
	}

}
