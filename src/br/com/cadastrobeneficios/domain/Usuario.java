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
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuario")
@NamedQueries({ @NamedQuery(name = "Usuario.listar", query = "SELECT usuario FROM Usuario usuario"),
		@NamedQuery(name = "Usuario.buscarPorCodigo", query = "SELECT usuario FROM Usuario usuario WHERE usuario.codigo = :codigo"),
		@NamedQuery(name = "Usuario.autenticar", query = "SELECT usuario FROM Usuario usuario WHERE usuario.login = :login AND usuario.senha = :senha") })
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@NotEmpty(message = "O campo Nome é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo Nome (5 - 50)")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@NotEmpty(message = "O campo Login é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo Login (5 - 50)")
	@Column(name = "login", length = 50, nullable = false)
	private String login;

	@NotEmpty(message = "O campo Tipo é obrigatório.")
	@Column(name = "tipo", length = 50, nullable = false)
	private String tipo;

	@NotEmpty(message = "O campo Senha é obrigatório.")
	@Size(min = 6, max = 10, message = "Tamanho inválido para o campo Senha (6 - 10 dígitos)")
	@Column(name = "senha", length = 10, nullable = false)
	private String senha;

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
		this.nome = nome.toUpperCase();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login.toUpperCase();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo.toUpperCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nome=" + nome + ", login=" + login + ", tipo=" + tipo + ", senha="
				+ senha + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
