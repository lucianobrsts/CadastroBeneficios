package br.com.cadastrobeneficios.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.cadastrobeneficios.domain.Usuario;
import br.com.cadastrobeneficios.util.HibernateUtil;

public class UsuarioDAO {

	public void salvar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(usuario);
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
	public List<Usuario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Usuario> usuarios = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.listar");
			usuarios = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuarios;
	}

	public Usuario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}

	public void excluir(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Usuario usuario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(usuario);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public Usuario autenticar(String login, String senha) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Usuario usuario = null;

		try {
			Query consulta = sessao.getNamedQuery("Usuario.autenticar");
			consulta.setString("login", login);
			consulta.setString("senha", senha);

			usuario = (Usuario) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return usuario;
	}

}