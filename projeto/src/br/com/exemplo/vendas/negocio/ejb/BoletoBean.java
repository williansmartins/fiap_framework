package br.com.exemplo.vendas.negocio.ejb;

import java.rmi.RemoteException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.exemplo.vendas.negocio.dao.DaoFactory;
import br.com.exemplo.vendas.negocio.ejb.interfaces.BoletoLocal;
import br.com.exemplo.vendas.negocio.ejb.interfaces.BoletoRemote;
import br.com.exemplo.vendas.negocio.entity.Boleto;
import br.com.exemplo.vendas.negocio.model.vo.BoletoVO;
import br.com.exemplo.vendas.util.dto.ServiceDTO;
import br.com.exemplo.vendas.util.exception.LayerException;

@Stateless
public class BoletoBean implements BoletoRemote, BoletoLocal {
	
	@PersistenceContext( unitName = "Vendas" )
	EntityManager em ;

	@Override
	public ServiceDTO inserirBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		BoletoVO vo = (BoletoVO)requestDTO.get("BoletoVO");
		if(vo != null){
			Boleto boleto = new Boleto(vo.getCodigoBarra(), vo.getNomeBanco(), vo.getObservacao(), vo.getDataDocumento(), vo.getDataVencimento(), vo.getValorDocumento(), vo.getMulta(), vo.getValorCobrado());
			if(DaoFactory.getBoletoDAO(em).inserir(boleto)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}
	
	@Override
	public ServiceDTO alterarBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		BoletoVO vo = (BoletoVO)requestDTO.get("BoletoVO");
		if(vo != null){
			Boleto boleto = new Boleto(vo.getCodigoBarra(), vo.getNomeBanco(), vo.getObservacao(), vo.getDataDocumento(), vo.getDataVencimento(), vo.getValorDocumento(), vo.getMulta(), vo.getValorCobrado());
			if(DaoFactory.getBoletoDAO(em).alterar(boleto)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}
	
	@Override
	public ServiceDTO excluirBoleto(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String numero = (String)requestDTO.get("numero");
		if(numero != null){
			if(DaoFactory.getBoletoDAO(em).excluir(numero)){
				responseDTO.set("resposta", new Boolean(true));
			}else{
				responseDTO.set("resposta", new Boolean(false));
			}
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO localizarPorCodigoBarra(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String numero = (String)requestDTO.get("numero");
		if(numero != null){
			Boleto boleto = DaoFactory.getBoletoDAO(em).localizarPorCodigoBarra(numero);
			BoletoVO vo = Boleto.create(boleto);
			responseDTO.set("BoletoVO", vo);
		}
		return responseDTO;
	}

	@Override
	public ServiceDTO selecionarTodosBoletos(ServiceDTO requestDTO) throws LayerException, RemoteException {
		ServiceDTO responseDTO = new ServiceDTO();
		String numero = (String)requestDTO.get("numero");
		if(numero != null){
			List<Boleto> nfss = DaoFactory.getBoletoDAO(em).listar();
			BoletoVO[] nfssVO = new BoletoVO[nfss.size()];
			for(int i=0, x=nfss.size(); i<x ; i++){
				Boleto nfs = nfss.get(i);
				BoletoVO vo = Boleto.create(nfs);
				nfssVO[i] = vo;
			}
			responseDTO.set("listaBoletoVO", nfssVO);
		}
		return responseDTO;
	}
}