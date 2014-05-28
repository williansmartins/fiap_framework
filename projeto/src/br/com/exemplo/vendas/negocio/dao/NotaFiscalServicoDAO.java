package br.com.exemplo.vendas.negocio.dao ;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.exemplo.vendas.negocio.entity.NotaFiscalServico;

public class NotaFiscalServicoDAO extends GenericDAO<NotaFiscalServico> {
	
	public NotaFiscalServicoDAO(EntityManager em){
		super(em);
	}

	public NotaFiscalServicoDAO(){
		super(Persistence.createEntityManagerFactory("Vendas").createEntityManager());
	}

	public boolean inserir(NotaFiscalServico nfs){
		boolean result = false ;
		NotaFiscalServico existenteNfs = localizarPorNumero(nfs.getNumero());

		try{
			if(existenteNfs == null){
				em.persist(nfs);
				result = true;
			}
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean alterar(NotaFiscalServico nfs){
		boolean result = false ;
		try{
			NotaFiscalServico existenteNfs = em.find(NotaFiscalServico.class, nfs.getNumero());
			if(existenteNfs != null){
				em.merge(nfs);
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

	public boolean excluir(String numero){
		boolean result = false ;
		try{
			Query q = em.createQuery("from NotaFiscalServico where numero = :numero");
			q.setParameter("numero", numero);
			NotaFiscalServico obj = (NotaFiscalServico) q.getSingleResult();
			em.remove(obj);
			result = true ;
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
		}
		return result;
	}

	public NotaFiscalServico localizarPorNumero(String numero) {
		try{
			Query q = em.createQuery("from NotaFiscalServico where numero = :numero");
			q.setParameter("numero", numero);
			return (NotaFiscalServico) q.getSingleResult();
		}catch(Exception e){
			if(debugInfo){
				e.printStackTrace();
			}
			return null;
		}
	}
}