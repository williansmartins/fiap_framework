package br.com.exemplo.vendas.negocio.dao ;

import javax.persistence.EntityManager ;

import br.com.exemplo.vendas.util.exception.SysException ;

public final class DaoFactory {

	private static DaoFactory myInstance = null;
	private static ClienteDAO clienteDAO_instance;
	private static BoletoDAO boletoDAO_instance;
	private static NotaFiscalServicoDAO notaFiscalServicoDAO_instance;

	private DaoFactory() throws SysException {}
	private synchronized static void initialize() throws SysException {
		if(myInstance == null) {
			myInstance = new DaoFactory();
		}
	}

	public static ClienteDAO getClienteDAO(EntityManager em) throws SysException {
		initialize();
		if(clienteDAO_instance == null) {
			clienteDAO_instance = new ClienteDAO(em);
		}
		return clienteDAO_instance;
	}

	public static BoletoDAO getBoletoDAO(EntityManager em) throws SysException {
		initialize();
		if(boletoDAO_instance == null) {
			boletoDAO_instance = new BoletoDAO(em);
		}
		return boletoDAO_instance;
	}

	public static NotaFiscalServicoDAO getNotaFiscalServicoDAO(EntityManager em) throws SysException {
		initialize();
		if(notaFiscalServicoDAO_instance == null) {
			notaFiscalServicoDAO_instance = new NotaFiscalServicoDAO(em);
		}
		return notaFiscalServicoDAO_instance;
	}
}