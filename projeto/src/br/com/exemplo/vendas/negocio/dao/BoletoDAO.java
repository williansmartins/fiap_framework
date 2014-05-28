package br.com.exemplo.vendas.negocio.dao ;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.Boleto;

public class BoletoDAO extends GenericDAO<Boleto> {
	
	public BoletoDAO(EntityManager em){
		super(em);
	}

	public BoletoDAO(){
		super(Persistence.createEntityManagerFactory("Vendas").createEntityManager());
	}

	public boolean inserir(Boleto boleto){
		boolean result = false ;
		Boleto existenteBoleto = localizarPorCodigoBarra(boleto.getCodigoBarra());

		try{
			if(existenteBoleto == null){
				em.persist(boleto);
				result = true;
			}
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(Boleto boleto){
		boolean result = false ;
		Boleto existenteBoleto = null ;

		try{
			existenteBoleto = em.find(Boleto.class, boleto.getCodigoBarra());
			if(existenteBoleto != null){
				em.merge(boleto);
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
		return result ;
	}

	public boolean excluir(String codigoBarra){
		boolean result = false ;
		try{
			Query q = em.createQuery("from Boleto where codigoBarra = :codigoBarra");
			q.setParameter("codigoBarra", codigoBarra);
			Boleto obj = (Boleto) q.getSingleResult();
			em.remove(obj);
			result = true ;
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
		}
		return result;
	}

	public Boleto localizarPorCodigoBarra(String codigoBarra) {
		try{
			Query q = em.createQuery("from Boleto where codigoBarra = :codigoBarra");
			q.setParameter("codigoBarra", codigoBarra);
			return (Boleto) q.getSingleResult();
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			return null;
		}
	}
}