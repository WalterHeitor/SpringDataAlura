package br.com.alura.spring.data.orm;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cargo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descricao;
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Cargo{" +" id= " + id +	" , descricao=' " + descricao + '\'' + '}';
	}
}
