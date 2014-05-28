package br.com.exemplo.vendas.negocio.ejb.interfaces ;

import javax.ejb.Remote;

import br.com.exemplo.vendas.negocio.interfaces.NotaFiscalServicoInterface;

@Remote
public interface NotaFiscalServicoRemote extends NotaFiscalServicoInterface {
	
}