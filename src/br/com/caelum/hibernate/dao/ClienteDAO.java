package br.com.caelum.hibernate.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.hibernate.model.Cliente;

public class ClienteDAO {
    
	private final Session session;

	public ClienteDAO(Session session) {
		this.session = session;
	}

	public void excluir(Cliente cliente) {
		session.delete(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> ativos() {
		return session.createQuery("from Cliente").list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> inativos() {
		return session.createSQLQuery("select * from Cliente where ativo = false").addEntity(Cliente.class).list();
	}
	
}
