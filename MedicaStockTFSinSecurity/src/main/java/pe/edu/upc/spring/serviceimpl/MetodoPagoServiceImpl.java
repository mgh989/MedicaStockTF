package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.repository.IMetodoPagoRepository;
import pe.edu.upc.spring.service.IMetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService{

	@Autowired
	private IMetodoPagoRepository mpMetodoPago;
	
	@Override
	@Transactional
	public boolean insertar(MetodoPago metodoPago) {
		MetodoPago objMetodoPago =mpMetodoPago.save(metodoPago);
		if(objMetodoPago == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(MetodoPago metodoPago) {
		boolean flag =  false;
		try {
			mpMetodoPago.save(metodoPago);
			flag = true;			
		}
		catch (Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMetodoPago) {
		mpMetodoPago.deleteById(idMetodoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MetodoPago> buscarId(int idMetodoPago) {
		return mpMetodoPago.findById(idMetodoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MetodoPago> listarId(int idMetodoPago) {
		return mpMetodoPago.findById(idMetodoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MetodoPago> listar() {
		return mpMetodoPago.findAll();
	}
}