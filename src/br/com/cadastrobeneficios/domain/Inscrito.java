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
@Table(name = "inscrito")
@NamedQueries({ @NamedQuery(name = "Inscrito.listar", query = "SELECT inscrito FROM Inscrito inscrito"),
		@NamedQuery(name = "Inscrito.listarPorDataNiver", query = "SELECT inscrito FROM Inscrito inscrito WHERE inscrito.nascimento LIKE ?"),
		@NamedQuery(name = "Inscrito.buscarPorCodigo", query = "SELECT inscrito FROM Inscrito inscrito WHERE inscrito.codigo = :codigo"), })
public class Inscrito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@NotEmpty(message = "Digite o nome de uma crinça que seja inscrita no Projeto.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo Criança Inscrita(5 - 50 dígitos)")
	@Column(name = "crianca_inscrita", length = 50, nullable = false)
	private String criancaInscrita;

	@NotEmpty(message = "O campo Nome Completo é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome (5 - 50 dígitos)")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@NotEmpty(message = "O campo Data de Nascimento é Obrigatório.")
	@Size(min = 10, max = 10, message = "Tamanh inválido para o campo data de nascimento (10 dígitos)")
	@Column(name = "nascimento", nullable = false)
	private String nascimento;

	@NotEmpty(message = "O campo Sexo é obrigatório.")
	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(name = "childnumber")
	private Integer ChildNumber;

	@Column(name = "pf")
	private Integer pf;

	@Column(name = "cs")
	private Integer cs;

	@Column(name = "nis")
	private String nis;

	@NotEmpty(message = "O campo Registro/RG é obrigatório.")
	@Size(min = 3, max = 13, message = "Tamanho inválido para o campo Registro/RG (3 - 13 dígitos.")
	@Column(name = "registrorg", length = 11, nullable = false)
	private String registroRg;

	@NotEmpty(message = "O campo Endereço é obrigatório.")
	@Column(name = "endereco", length = 50, nullable = false)
	private String endereco;

	@Column(name = "fone", length = 15)
	private String fone;

	@Column(name = "celular", length = 15)
	private String celular;

	@Column(name = "celular2", length = 15)
	private String celular2;

	@Column(name = "escola", length = 50)
	private String escola;

	@Column(name = "serie", length = 50)
	private String serie;

	@Column(name = "horario", length = 50)
	private String horario;

	@Column(name = "responsavel", length = 50, nullable = false)
	private String responsavel;

	@NotEmpty(message = "O campo Parentesco é obrigatório.")
	@Column(name = "parentesco", length = 50, nullable = false)
	private String parentesco;

	@Column(name = "docresponsavel", length = 13, nullable = false)
	private String documentoResponsavel;

	@NotEmpty(message = "O campo Responsável Preenchimento é obrigatório.")
	@Column(name = "respreenchimento", length = 50, nullable = false)
	private String responsavelPreenchimento;

	public Inscrito() {

	}

	public Inscrito(String nome) {
		super();
		this.nome = nome;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCriancaInscrita() {
		return criancaInscrita;
	}

	public void setCriancaInscrita(String criancaInscrita) {
		this.criancaInscrita = criancaInscrita.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo.toUpperCase();
	}

	public Integer getChildNumber() {
		return ChildNumber;
	}

	public void setChildNumber(Integer childNumber) {
		ChildNumber = childNumber;
	}

	public Integer getPf() {
		return pf;
	}

	public void setPf(Integer pf) {
		this.pf = pf;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public String getNis() {
		return nis;
	}

	public void setNis(String nis) {
		this.nis = nis;
	}

	public String getRegistroRg() {
		return registroRg;
	}

	public void setRegistroRg(String registroRg) {
		this.registroRg = registroRg;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco.toUpperCase();
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola.toUpperCase();
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel.toUpperCase();
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco.toUpperCase();
	}

	public String getDocumentoResponsavel() {
		return documentoResponsavel;
	}

	public void setDocumentoResponsavel(String documentoResponsavel) {
		this.documentoResponsavel = documentoResponsavel;
	}

	public String getResponsavelPreenchimento() {
		return responsavelPreenchimento;
	}

	public void setResponsavelPreenchimento(String responsavelPreenchimento) {
		this.responsavelPreenchimento = responsavelPreenchimento.toUpperCase();
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	@Override
	public String toString() {
		return "Inscrito [codigo=" + codigo + ", nome=" + nome + ", nascimento=" + nascimento + ", sexo=" + sexo
				+ ", ChildNumber=" + ChildNumber + ", celular=" + celular + ", responsavelPreenchimento="
				+ responsavelPreenchimento + "]";
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
		Inscrito other = (Inscrito) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
