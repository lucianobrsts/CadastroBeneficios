package br.com.cadastrobeneficios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cadastrobeneficios.domain.Atividade;
import br.com.cadastrobeneficios.util.HibernateUtil;

public class AtividadeDAO {

	public void salvar(Atividade atividade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(atividade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Atividade> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Atividade> atividades = null;

		try {
			Query consulta = sessao.getNamedQuery("Atividade.listar");
			atividades = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return atividades;
	}

	public Atividade buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Atividade atividade = null;

		try {
			Query consulta = sessao.getNamedQuery("Atividade.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			atividade = (Atividade) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return atividade;
	}

	public void excluir(Atividade atividade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(atividade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Atividade atividade) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(atividade);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

}
