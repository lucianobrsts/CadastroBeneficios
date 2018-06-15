package br.com.cadastrobeneficios.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "atividade")
@NamedQueries({ @NamedQuery(name = "Atividade.listar", query = "SELECT atividade FROM Atividade atividade"),
		@NamedQuery(name = "Atividade.buscarPorCodigo", query = "SELECT atividade FROM Atividade atividade WHERE atividade.codigo = :codigo") })
public class Atividade {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Atividade [codigo=" + codigo + ", nome=" + nome + "]";
	}

}
