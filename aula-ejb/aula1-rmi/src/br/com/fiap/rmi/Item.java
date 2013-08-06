package br.com.fiap.rmi;

import java.io.Serializable;

public class Item  implements Serializable{
	
	private static final long serialVersionUID = -5483285013077193433L;


	private String nome;
	
	private transient double preco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
