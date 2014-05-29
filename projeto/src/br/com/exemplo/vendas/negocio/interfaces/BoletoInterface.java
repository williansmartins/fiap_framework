package br.com.exemplo.vendas.negocio.interfaces ;

import java.rmi.RemoteException;

import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public interface BoletoInterface {
	
	public ServiceDTO inserirBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO alterarBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO excluirBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO selecionarTodosBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO localizarPorCodigoBarra(ServiceDTO requestDTO) throws LayerException, RemoteException;
}