package br.com.locadora.bean;

import javax.faces.bean.ManagedBean;

import br.com.locadora.modelo.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente();

	public Cliente getCliente() {
		return cliente;
	}

	public void gravar(){
		System.out.println("Gravando cliente "+ this.cliente.getNomeCliente());
		
	}
	
	
	
	
}
