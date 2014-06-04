package br.com.exemplo.vendas.negocio.ejb ;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ClienteLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.ClienteRemote;
import br.com.exemplo.vendas.negocio.entity.Cliente;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class ClienteBean implements ClienteRemote, ClienteLocal {
	
	@PersistenceContext( unitName = "Vendas" )
	EntityManager em ;

	public ServiceDTO inserirCliente(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) requestDTO.get("ClienteVO");
		if(vo != null){
			Cliente cliente = new Cliente(vo.getNome(), vo.getEndereco(), vo.getCidade(), vo.getEstado(), vo.getCnpj());
			if(DaoFactory.getClienteDAO(em).inserir(cliente)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set( "resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO alterarCliente(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		ClienteVO vo = (ClienteVO) requestDTO.get("ClienteVO");
		if(vo != null){
			Cliente cliente = new Cliente(vo.getNome(), vo.getEndereco(), vo.getCidade(), vo.getEstado(), vo.getCnpj());
			if(DaoFactory.getClienteDAO(em).alterar(cliente)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set( "resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	public ServiceDTO excluirClientePorNome(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		String nome = (String) requestDTO.get("nome");
		if(nome != null){
			if(DaoFactory.getClienteDAO(em).excluir(nome)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}
	
	public ServiceDTO excluirClientePorCodigo(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		Long codigo = (Long) requestDTO.get("codigo");
		if(codigo != null){
			if(DaoFactory.getClienteDAO(em).excluir(codigo)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO localizarClientePorNome(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String nome = (String) requestDTO.get("nome");
		if(nome != null){
			Cliente cliente = DaoFactory.getClienteDAO(em).localizarPorNome(nome);
			ClienteVO vo = Cliente.create(cliente);
			responseDTO.set("resposta", vo);
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO localizarClientePorCodigo(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		Long codigo = (Long) requestDTO.get("codigo");
		if(codigo != null){
			Cliente cliente = DaoFactory.getClienteDAO(em).localizar(codigo);
			ClienteVO vo = Cliente.create(cliente);
			responseDTO.set("resposta", vo);
		}
		return responseDTO;
	}

	public ServiceDTO selecionarTodosClientes(ServiceDTO requestDTO) throws LayerException {
		ServiceDTO responseDTO = new ServiceDTO();
		List<Cliente> clientes = DaoFactory.getClienteDAO(em).listar();
		ClienteVO[] clienteVOs = new ClienteVO[clientes.size()];
		for(int i=0, x=clientes.size(); i<x ; i++){
			Cliente cliente = clientes.get(i);
			ClienteVO vo = Cliente.create(cliente);
			clienteVOs[i] = vo;
		}
		responseDTO.set("resposta", clienteVOs);
		return responseDTO ;
	}
}