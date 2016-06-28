package br.com.locadora.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class DvdBean {

	private Dvd livro = new Dvd();

	public Dvd getLivro() {
		return livro;
	}

	public void gravarDVD() {
		System.out.println("Gravando");
	}

}
