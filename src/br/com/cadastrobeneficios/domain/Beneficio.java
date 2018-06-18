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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "beneficio")
@NamedQueries({ @NamedQuery(name = "Beneficio.listar", query = "SELECT beneficio FROM Beneficio beneficio"),
		@NamedQuery(name = "Beneficio.buscarPorCodigo", query = "SELECT beneficio FROM Beneficio beneficio WHERE beneficio.codigo = :codigo") })
public class Beneficio {

	@Id
	@Column(name = "codigo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;

	@Column(name = "data_inicio", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataInicio;

	@Column(name = "data_fim", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dataFim;

	@Column(name = "dia_semana", nullable = false)
	private String diaDaSemana;

	@Column(name = "horario_inicio", length = 50, nullable = false)
	private String horarioInicio;

	@Column(name = "horario_fim", length = 50, nullable = false)
	private String horarioFim;

	@NotNull(message = "O campo Atividade é obrigatório.")
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "atividade_codigo", referencedColumnName = "codigo", nullable = false)
	private Atividade atividade;

	@NotNull(message = "O campo Nome é obrigatório.")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inscrito_codigo", referencedColumnName = "codigo", nullable = false)
	private Inscrito inscrito;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(String diaDaSemana) {
		this.diaDaSemana = diaDaSemana.toUpperCase();
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Inscrito getInscrito() {
		return inscrito;
	}

	public void setInscrito(Inscrito inscrito) {
		this.inscrito = inscrito;
	}

	@Override
	public String toString() {
		return "Beneficio [codigo=" + codigo + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", diaDaSemana="
				+ diaDaSemana + ", horarioInicio=" + horarioInicio + ", horarioFim=" + horarioFim + ", atividade="
				+ atividade + ", inscrito=" + inscrito + "]";
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
		Beneficio other = (Beneficio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
