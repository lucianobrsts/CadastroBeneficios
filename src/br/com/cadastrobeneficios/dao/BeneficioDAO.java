package br.com.cadastrobeneficios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cadastrobeneficios.domain.Beneficio;
import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.util.HibernateUtil;

public class BeneficioDAO {

	public void salvar(Beneficio beneficio) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(beneficio);
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
	public List<Beneficio> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Beneficio> beneficios = null;

		try {
			Query consulta = sessao.getNamedQuery("Beneficio.listar");
			beneficios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return beneficios;
	}

	public Beneficio buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Beneficio beneficio = null;

		try {
			Query consulta = sessao.getNamedQuery("Beneficio.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			beneficio = (Beneficio) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return beneficio;
	}

	public void excluir(Beneficio beneficio) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(beneficio);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Beneficio beneficio) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.update(beneficio);
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
