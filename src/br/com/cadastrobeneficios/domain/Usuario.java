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
	@Size(min = 6, max = 8, message = "Tamanho inválido para o campo Senha (6 - 8 dígitos)")
	@Column(name = "senha", length = 8, nullable = false)
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
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

}
