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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "beneficio")
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

	@Column(name = "horario", length = 50, nullable = false)
	private String horario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "atividade_codigo", referencedColumnName = "codigo", nullable = false)
	private Atividade atividade;

}
