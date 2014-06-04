package br.com.exemplo.vendas.negocio.dao ;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Cliente;

public class ClienteDAO extends GenericDAO<Cliente> {
	
	public ClienteDAO(EntityManager em){
		super(em);
	}

	public ClienteDAO(){
		super(Persistence.createEntityManagerFactory("Vendas").createEntityManager());
	}

	public boolean inserir(Cliente cliente){
		boolean result = false;
		Cliente existenteCliente = localizarPorNome(cliente.getNome());

		try{
			if(existenteCliente == null){
				em.persist(cliente);
				result = true;
			}
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Cliente cliente) {
		boolean result = false ;
		try{
			Cliente existenteCliente = em.find(Cliente.class, cliente.getCodigo());
			if(existenteCliente != null){
				em.merge(cliente);
				result = true;
			}else{
				result = false;
			}
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			result = false;
		}
		return result;
	}

	public boolean excluir(Long codigo){
		Cliente cliente = em.find(Cliente.class, codigo);
		return excluir(cliente);
	}
	
	public boolean excluir(String nome){
		Cliente cliente = localizarPorNome(nome);
		return excluir(cliente);
	}
	
	public boolean excluir(Cliente cliente) {
		try{
			em.remove(cliente);
			return true;
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			return false;
		}
	}

	public Cliente localizarPorCodigo(Long codigo){
		try{
			return em.find(Cliente.class, codigo);
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			return null;
		}
	}
	
	public Cliente localizarPorNome(String nome){
		try{
			Query query = em.createQuery("from Cliente where nome = :nome");
			query.setParameter( "nome", nome);
			return (Cliente) query.getSingleResult();
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			return null;
		}
	}
}