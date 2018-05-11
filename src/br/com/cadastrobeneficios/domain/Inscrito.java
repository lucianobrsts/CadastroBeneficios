package br.com.cadastrobeneficios.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "inscrito")
@NamedQueries({ @NamedQuery(name = "Inscrito.listar", query = "SELECT inscrito FROM Inscrito inscrito"),
		@NamedQuery(name = "Inscrito.buscarPorCodigo", query = "SELECT inscrito FROM Inscrito inscrito WHERE inscrito.codigo = :codigos") })
public class Inscrito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Long codigo;

	@NotEmpty(message = "O campo nome é obrigatório.")
	@Size(min = 5, max = 50, message = "Tamanho inválido para o campo nome (5 - 50)")
	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@Column(name = "nascimento", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataNascimento;

	@NotEmpty(message = "O campo sexo é obrigatório.")
	@Column(name = "sexo", nullable = false)
	private String sexo;

	@NotNull(message = "O campo Child Number é obrigatório.")
	@Column(name = "childnumber", nullable = false)
	private Integer ChildNumber;

	@NotNull(message = "O campo PF é obrigatório.")
	@Column(name = "pf", nullable = false)
	private Integer pf;

	@NotNull(message = "O campo CS é obrigatório.")
	@Column(name = "cs", nullable = false)
	private Integer cs;

	@NotEmpty(message = "O campo NIS é obrigatório.")
	@Size(min = 11, max = 11, message = "Tamanho inválido para o campo NIS (11 dígitos).")
	@Column(name = "nis", length = 11, nullable = false)
	private String nis;

	@NotEmpty(message = "O campo RG é obrigatório.")
	@Size(min = 1, max = 11, message = "Tamanho inválido para o campo RG(9 dígitos.")
	@Column(name = "rg", length = 9, nullable = false)
	private String rg;

	@NotEmpty(message = "O campo endereço é obrigatório.")
	@Column(name = "endereco", length = 50, nullable = false)
	private String endereco;

	@Column(name = "fone", length = 10)
	private String fone;

	@Column(name = "celular", length = 11, nullable = false)
	private String celular;

	@Column(name = "escola", length = 50)
	private String escola;

	@Column(name = "horario", length = 50)
	private String horario;

	@Column(name = "responsavel", length = 50, nullable = false)
	private String responsavel;

	@Column(name = "parentesco", length = 50)
	private String parentesco;

	@Column(name = "docresponsavel", length = 11)
	private String documentoResponsavel;

	@Column(name = "respreenchimento", length = 50, nullable = false)
	private String responsavelPreenchimento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "beneficio_codigo", referencedColumnName = "codigo", nullable = false)
	private Beneficio beneficio;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		this.escola = escola;
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
		this.responsavel = responsavel;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
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
		this.responsavelPreenchimento = responsavelPreenchimento;
	}

	public Beneficio getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(Beneficio beneficio) {
		this.beneficio = beneficio;
	}

	@Override
	public String toString() {
		return "Inscrito [codigo=" + codigo + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo
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
