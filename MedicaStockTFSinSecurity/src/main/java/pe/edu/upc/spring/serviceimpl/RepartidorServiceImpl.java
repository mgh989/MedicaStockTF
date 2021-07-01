package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Repartidor;
import pe.edu.upc.spring.repository.IRepartidorRepository;
import pe.edu.upc.spring.service.IRepartidorService;

@Service
public class RepartidorServiceImpl implements IRepartidorService{

	@Autowired
	private IRepartidorRepository rRepartidor;
	
	@Override
	@Transactional
	public boolean insertar(Repartidor repartidor) {
		Repartidor objRepartidor = rRepartidor.save(repartidor);
		if(objRepartidor!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Repartidor repartidor) {
		boolean flag = false;
		try {
			rRepartidor.save(repartidor);
			flag=true;
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRepartidor) {
		rRepartidor.deleteById(idRepartidor);		
	}

	@Override
	public Optional<Repartidor> buscarId(int idRepartidor) {
		return rRepartidor.findById(idRepartidor);
	}

	@Override
	public Optional<Repartidor> listarId(int idRepartidor) {
		return rRepartidor.findById(idRepartidor);
	}

	@Override
	@Transactional (readOnly = true)
	public List<Repartidor> listar() {
		return rRepartidor.findAll();
	}
}