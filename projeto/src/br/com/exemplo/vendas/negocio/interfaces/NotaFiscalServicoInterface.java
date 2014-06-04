package br.com.exemplo.vendas.negocio.interfaces ;

import java.rmi.RemoteException;

import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public interface NotaFiscalServicoInterface {
	
	public ServiceDTO inserirNfs(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO alterarNfs(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO excluirNfs(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO selecionarTodosNfs(ServiceDTO requestDTO) throws LayerException, RemoteException;
	public ServiceDTO localizarNfsPorNumero(ServiceDTO requestDTO) throws LayerException, RemoteException;
}