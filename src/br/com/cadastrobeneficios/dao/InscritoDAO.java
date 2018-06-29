package br.com.cadastrobeneficios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.util.HibernateUtil;

public class InscritoDAO {

	public void salvar(Inscrito inscrito) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(inscrito);
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
	public List<Inscrito> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Inscrito> inscritos = null;

		try {
			Query consulta = sessao.getNamedQuery("Inscrito.listar");
			inscritos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return inscritos;
	}

	public Inscrito buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Inscrito inscrito = null;

		try {
			Query consulta = sessao.getNamedQuery("Inscrito.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			inscrito = (Inscrito) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return inscrito;
	}

	public String buscarPorDataNascimento(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Inscrito inscrito = null;

		try {
			Query consulta = sessao.getNamedQuery("Inscrito.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			inscrito = (Inscrito) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return inscrito.getDataNascimento();
	}

	public void excluir(Inscrito inscrito) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(inscrito);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Inscrito inscrito) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();

			sessao.update(inscrito);
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
