package br.com.exemplo.vendas.negocio.interfaces ;

import br.com.exemplo.vendas.util.dto.ServiceDTO;

public interface ClienteInterface {
	
	public ServiceDTO inserirCliente(ServiceDTO requestDTO) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
	public ServiceDTO alterarCliente(ServiceDTO requestDTO) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
	public ServiceDTO excluirClientePorNome(ServiceDTO requestDTO) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
	public ServiceDTO excluirClientePorCodigo(ServiceDTO requestDTO) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
	public ServiceDTO selecionarTodosCliente(ServiceDTO requestDTO) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
	public ServiceDTO localizarPorNome(ServiceDTO requestDTO, String login) throws br.com.exemplo.vendas.util.exception.LayerException, java.rmi.RemoteException;
}