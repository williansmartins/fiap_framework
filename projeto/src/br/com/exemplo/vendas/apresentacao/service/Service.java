package br.com.exemplo.vendas.apresentacao.service ;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import br.com.exemplo.vendas.apresentacao.delegate.BusinessDelegate;
import br.com.exemplo.vendas.negocio.model.vo.BoletoVO;
import br.com.exemplo.vendas.negocio.model.vo.ClienteVO;
import br.com.exemplo.vendas.negocio.model.vo.NotaFiscalServicoVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

public class Service implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/*
	 * Cliente
	 */
	public Boolean inserirCliente(ClienteVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("ClienteVO", vo);
		responseDTO = BusinessDelegate.getInstance().inserirCliente(requestDTO);
		return (Boolean) responseDTO.get("resposta");
	}
	
	public Boolean alterarCliente( ClienteVO vo ) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("ClienteVO", vo);
		responseDTO = BusinessDelegate.getInstance().alterarCliente(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public Boolean excluirClientePorCodigo(ClienteVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("codigo", vo.getNome());
		responseDTO = BusinessDelegate.getInstance().excluirClientePorCodigo(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public Boolean excluirClientePorNome(ClienteVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("nome", vo.getNome());
		responseDTO = BusinessDelegate.getInstance().excluirClientePorNome(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}

	public List<ClienteVO> listarClientes() throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		responseDTO = BusinessDelegate.getInstance().selecionarTodosClientes(requestDTO);
		ClienteVO[] Clientes = (ClienteVO[])responseDTO.get("resposta");
		return Arrays.asList(Clientes);
	}

	public ClienteVO buscarClientePorCodigo(ClienteVO vo) throws LayerException {
	    ServiceDTO requestDTO = new ServiceDTO();
	    ServiceDTO responseDTO = new ServiceDTO();
	    requestDTO.set("codigo", vo.getCodigo());
	    responseDTO = BusinessDelegate.getInstance().localizarClientePorCodigo(requestDTO);
	    return (ClienteVO)responseDTO.get("resposta");
	}
	
	public ClienteVO buscarClientePorNome(ClienteVO vo) throws LayerException {
	    ServiceDTO requestDTO = new ServiceDTO();
	    ServiceDTO responseDTO = new ServiceDTO();
	    requestDTO.set("nome", vo.getNome());
	    responseDTO = BusinessDelegate.getInstance().localizarClientePorNome(requestDTO);
	    return (ClienteVO)responseDTO.get("resposta");
	}

	/*
	 * Boleto
	 */
	public Boolean inserirBoleto(BoletoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("BoletoVO", vo);
		responseDTO = BusinessDelegate.getInstance().inserirBoleto(requestDTO);
		return (Boolean) responseDTO.get("resposta");
	}
	
	public Boolean alterarBoleto(BoletoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("BoletoVO", vo);
		responseDTO = BusinessDelegate.getInstance().alterarBoleto(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public Boolean excluirBoleto(BoletoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("codigoBarra", vo.getCodigoBarra());
		responseDTO = BusinessDelegate.getInstance().excluirBoleto(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public List<BoletoVO> listarBoletos() throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		responseDTO = BusinessDelegate.getInstance().selecionarTodosBoletos(requestDTO);
		BoletoVO[] Boletos = (BoletoVO[])responseDTO.get("resposta");
		return Arrays.asList(Boletos);
	}

	public BoletoVO localizarBoletoPorCodigoBarra(BoletoVO vo) throws LayerException {
	    ServiceDTO requestDTO = new ServiceDTO();
	    ServiceDTO responseDTO = new ServiceDTO();
	    requestDTO.set("codigoBarra", vo.getCodigoBarra());
	    responseDTO = BusinessDelegate.getInstance().localizarBoletoPorCodigoBarra(requestDTO);
	    return (BoletoVO)responseDTO.get("resposta");
	}
	
	/*
	 * Nota Fiscal de Servico
	 */
	public Boolean inserirNfs(NotaFiscalServicoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("NotaFiscalServicoVO", vo);
		responseDTO = BusinessDelegate.getInstance().inserirNfs(requestDTO);
		return (Boolean) responseDTO.get("resposta");
	}
	
	public Boolean alterarNfs(NotaFiscalServicoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("NotaFiscalServicoVO", vo);
		responseDTO = BusinessDelegate.getInstance().alterarBoleto(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public Boolean excluirNfs(NotaFiscalServicoVO vo) throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		requestDTO.set("numero", vo.getNumero());
		responseDTO = BusinessDelegate.getInstance().excluirNfs(requestDTO);
		return (Boolean)responseDTO.get("resposta");
	}
	
	public List<NotaFiscalServicoVO> listarNfss() throws LayerException {
		ServiceDTO requestDTO = new ServiceDTO();
		ServiceDTO responseDTO = new ServiceDTO();
		responseDTO = BusinessDelegate.getInstance().selecionarTodosNfs(requestDTO);
		NotaFiscalServicoVO[] nfss = (NotaFiscalServicoVO[])responseDTO.get("resposta");
		return Arrays.asList(nfss);
	}

	public NotaFiscalServicoVO localizarNfsPorNumero(NotaFiscalServicoVO vo) throws LayerException {
	    ServiceDTO requestDTO = new ServiceDTO();
	    ServiceDTO responseDTO = new ServiceDTO();
	    requestDTO.set("nuemro", vo.getNumero());
	    responseDTO = BusinessDelegate.getInstance().localizarNfsPorNumero(requestDTO);
	    return (NotaFiscalServicoVO)responseDTO.get("resposta");
	}
}