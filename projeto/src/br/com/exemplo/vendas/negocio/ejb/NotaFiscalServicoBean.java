package br.com.exemplo.vendas.negocio.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.NotaFiscalServicoLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.NotaFiscalServicoRemote;
import br.com.exemplo.vendas.negocio.entity.NotaFiscalServico;
import br.com.exemplo.vendas.negocio.model.vo.NotaFiscalServicoVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class NotaFiscalServicoBean implements NotaFiscalServicoRemote, NotaFiscalServicoLocal {
	
	@PersistenceContext( unitName = "Vendas" )
	EntityManager em ;

	@Override
	public ServiceDTO inserirNfs(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		NotaFiscalServicoVO vo = (NotaFiscalServicoVO)requestDTO.get("NotaFiscalServicoVO");
		if(vo != null){
			NotaFiscalServico notaFiscalServico = new NotaFiscalServico(vo.getNumero(), vo.getDiscriminacaoGeral(), vo.getData(), vo.getValor());
			if(DaoFactory.getNotaFiscalServicoDAO(em).inserir(notaFiscalServico)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}
	
	@Override
	public ServiceDTO alterarNfs(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		NotaFiscalServicoVO vo = (NotaFiscalServicoVO)requestDTO.get("NotaFiscalServicoVO");
		if(vo != null){
			NotaFiscalServico notaFiscalServico = new NotaFiscalServico(vo.getNumero(), vo.getDiscriminacaoGeral(), vo.getData(), vo.getValor());
			if(DaoFactory.getNotaFiscalServicoDAO(em).alterar(notaFiscalServico)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}
	
	@Override
	public ServiceDTO excluirNfs(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String numero = (String)requestDTO.get("numero");
		if(numero != null){
			if(DaoFactory.getNotaFiscalServicoDAO(em).excluir(numero)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO localizarPorNumero(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String numero = (String)requestDTO.get("numero");
		if(numero != null){
			NotaFiscalServico nfs = DaoFactory.getNotaFiscalServicoDAO(em).localizarPorNumero(numero);
			NotaFiscalServicoVO vo = NotaFiscalServico.create(nfs);
			responseDTO.set("NotaFiscalServicoVO", vo);
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO selecionarTodosNfe(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		List<NotaFiscalServico> nfss = DaoFactory.getNotaFiscalServicoDAO(em).listar();
		NotaFiscalServicoVO[] nfssVO = new NotaFiscalServicoVO[nfss.size()];
		for(int i=0, x=nfss.size(); i<x ; i++){
			NotaFiscalServico nfs = nfss.get(i);
			NotaFiscalServicoVO vo = NotaFiscalServico.create(nfs);
			nfssVO[i] = vo;
		}
		responseDTO.set("listaNotaFiscalServicoVO", nfssVO);
		return responseDTO;
	}
}