package br.com.exemplo.vendas.negocio.ejb.interfaces ;

import javax.ejb.Remote;

import br.com.exemplo.vendas.negocio.interfaces.BoletoInterface;

@Remote
public interface BoletoRemote extends BoletoInterface {
	
}