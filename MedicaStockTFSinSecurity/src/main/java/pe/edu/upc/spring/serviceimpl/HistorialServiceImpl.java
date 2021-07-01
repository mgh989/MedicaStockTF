package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Historial;
import pe.edu.upc.spring.repository.IHistorialRepository;
import pe.edu.upc.spring.service.IHistorialService;

@Service
public class HistorialServiceImpl implements IHistorialService{

	@Autowired
	private IHistorialRepository hHistorial;
	
	@Override
	@Transactional
	public boolean insertar(Historial historial) {
		Historial objHistorial = hHistorial.save(historial);
		if(objHistorial!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Historial historial) {
		boolean flag = false;
		try {
			hHistorial.save(historial);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idHistorial) {
		hHistorial.deleteById(idHistorial);		
	}

	@Override
	public Optional<Historial> buscarId(int idHistorial) {
		return hHistorial.findById(idHistorial);
	}

	@Override
	public Optional<Historial> listarId(int idHistorial) {
		return hHistorial.findById(idHistorial);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Historial> listar() {
		return hHistorial.findAll();
	}
}