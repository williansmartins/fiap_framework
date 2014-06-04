package br.com.exemplo.vendas.apresentacao.delegate ;

import java.rmi.RemoteException;

import br.com.exemplo.vendas.negocio.interfaces.BoletoInterface;
import br.com.exemplo.vendas.negocio.interfaces.ClienteInterface;
import br.com.exemplo.vendas.negocio.interfaces.NotaFiscalServicoInterface;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;
import br.com.exemplo.vendas.util.exception.SysExceptionFactory;
import br.com.exemplo.vendas.util.locator.ServiceLocator;
import br.com.exemplo.vendas.util.locator.ServiceLocatorException;
import br.com.exemplo.vendas.util.locator.ServiceLocatorFactory;

public class BusinessDelegate {

	private static BusinessDelegate instance = null;
	private ServiceLocator serviceLocator;

	private BusinessDelegate() throws Exception {
		setServiceLocator();
	}

	public synchronized static BusinessDelegate getInstance() throws LayerException {
		if(instance == null){
			try{
				instance = new BusinessDelegate();
			}catch(Exception exception){
				throw SysExceptionFactory.getException(exception);
			}
		}
		return instance;
	}

	/*
	 * Inserir --------------------------------------------------------------------------------
	 */
	public ServiceDTO inserirCliente(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).inserirCliente(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException( serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO inserirBoleto(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((BoletoInterface)serviceLocator.getService("BoletoBean/remote")).inserirBoleto(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException( serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO inserirNfs(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((NotaFiscalServicoInterface)serviceLocator.getService("NotaFiscalServicoBean/remote")).inserirNfs(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException( serviceLocatorException);
		}
		return responseDTO;
	}
	
	/*
	 * Alterar --------------------------------------------------------------------------------
	 */
	public ServiceDTO alterarCliente(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).alterarCliente(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO ;
	}
	
	public ServiceDTO alterarBoleto(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((BoletoInterface)serviceLocator.getService("BoletoBean/remote")).alterarBoleto(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO ;
	}
	
	public ServiceDTO alterarNfs(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((NotaFiscalServicoInterface)serviceLocator.getService("NotaFiscalServicoBean/remote")).alterarNfs(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException( serviceLocatorException);
		}
		return responseDTO;
	}

	/*
	 * Alterar --------------------------------------------------------------------------------
	 */
	public ServiceDTO excluirClientePorCodigo(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).excluirClientePorCodigo(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO excluirClientePorNome(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).excluirClientePorNome(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO excluirBoleto(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((BoletoInterface)serviceLocator.getService("BoletoBean/remote")).excluirBoleto(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO excluirNfs(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((NotaFiscalServicoInterface)serviceLocator.getService("NotaFiscalServicoBean/remote")).excluirNfs(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException( serviceLocatorException);
		}
		return responseDTO;
	}

	/*
	 * Selecionar Todos --------------------------------------------------------------------------------
	 */
	public ServiceDTO selecionarTodosClientes(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).selecionarTodosClientes(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO selecionarTodosBoletos(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((BoletoInterface)serviceLocator.getService("BoletoBean/remote")).selecionarTodosBoletos(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO selecionarTodosNfs(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((NotaFiscalServicoInterface)serviceLocator.getService("NotaFiscalServicoBean/remote")).selecionarTodosNfs(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}

	/*
	 * Buscas Especificas --------------------------------------------------------------------------------
	 */
	public ServiceDTO localizarClientePorNome(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).localizarClientePorNome(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO localizarClientePorCodigo(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((ClienteInterface)serviceLocator.getService("ClienteBean/remote")).localizarClientePorCodigo(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO localizarBoletoPorCodigoBarra(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((BoletoInterface)serviceLocator.getService("BoletoBean/remote")).localizarPorCodigoBarra(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}
	
	public ServiceDTO localizarNfsPorNumero(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		try{
			responseDTO = ((NotaFiscalServicoInterface)serviceLocator.getService("NotaFiscalServicoBean/remote")).localizarNfsPorNumero(requestDTO);
		}catch(RemoteException remoteException){
			throw SysExceptionFactory.getException(remoteException);
		}catch(ServiceLocatorException serviceLocatorException){
			throw SysExceptionFactory.getException(serviceLocatorException);
		}
		return responseDTO;
	}

	private void setServiceLocator() throws Exception {
		this.serviceLocator = ServiceLocatorFactory.getServiceLocator("serviceLocator");
	}
}