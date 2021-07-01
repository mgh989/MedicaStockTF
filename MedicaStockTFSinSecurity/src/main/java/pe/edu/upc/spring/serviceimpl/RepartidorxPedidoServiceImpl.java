package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.RepartidorxPedido;
import pe.edu.upc.spring.repository.IRepartidorxPedidoRepository;
import pe.edu.upc.spring.service.IRepartidorxPedidoService;

@Service
public class RepartidorxPedidoServiceImpl implements IRepartidorxPedidoService{

	@Autowired
	private IRepartidorxPedidoRepository rpRepartidorxPedido;
	
	@Override
	@Transactional
	public boolean insertar(RepartidorxPedido repartidorxPedido) {
		RepartidorxPedido objRepartidorxPedido = rpRepartidorxPedido.save(repartidorxPedido);
		if(objRepartidorxPedido!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(RepartidorxPedido repartidorxPedido) {
		boolean flag = false;
		try {
			rpRepartidorxPedido.save(repartidorxPedido);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRepartidorxPedido) {
		rpRepartidorxPedido.deleteById(idRepartidorxPedido);		
	}

	@Override
	public Optional<RepartidorxPedido> buscarId(int idRepartidorxPedido) {
		return rpRepartidorxPedido.findById(idRepartidorxPedido);
	}

	@Override
	public Optional<RepartidorxPedido> listarId(int idRepartidorxPedido) {
		return rpRepartidorxPedido.findById(idRepartidorxPedido);
	}

	@Override
	@Transactional (readOnly = true)
	public List<RepartidorxPedido> listar() {
		return rpRepartidorxPedido.findAll();
	}
}
