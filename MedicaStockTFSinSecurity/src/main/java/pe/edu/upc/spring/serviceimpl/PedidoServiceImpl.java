package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Pedido;
import pe.edu.upc.spring.repository.IPedidoRepository;
import pe.edu.upc.spring.service.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService{

	@Autowired
	private IPedidoRepository pPedido;
	
	@Override
	@Transactional
	public boolean insertar(Pedido pedido) {
		Pedido objPedido = pPedido.save(pedido);
		if(objPedido!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Pedido pedido) {
		boolean flag = false;
		try {
			pPedido.save(pedido);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPedido) {
		pPedido.deleteById(idPedido);	
	}

	@Override
	public Optional<Pedido> buscarId(int idPedido) {
		return pPedido.findById(idPedido);

	}

	@Override
	public Optional<Pedido> listarId(int idPedido) {
		return pPedido.findById(idPedido);

	}

	@Override
	@Transactional (readOnly = true)
	public List<Pedido> listar() {
		return pPedido.findAll();
	}
}