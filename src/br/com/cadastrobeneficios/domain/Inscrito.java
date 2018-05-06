package br.com.cadastrobeneficios.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "inscrito")
public class Inscrito {

	private Long codigo;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private Integer ChildNumber;
	private Integer pf;
	private Integer cs;
	private String nis;
	private String rg;
	private String endereco;
	private String fone;
	private String celular;
	private String escola;
	private String horario;
	private String responsavel;
	private String parentesco;
	private String documentoResponsavel;
	private String responsavelPreenchimento;

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
