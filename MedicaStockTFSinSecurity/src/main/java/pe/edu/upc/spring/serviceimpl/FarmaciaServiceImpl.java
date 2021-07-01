package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Farmacia;
import pe.edu.upc.spring.repository.IFarmaciaRepository;
import pe.edu.upc.spring.service.IFarmaciaService;

@Service
public class FarmaciaServiceImpl implements IFarmaciaService{
	
	@Autowired
	private IFarmaciaRepository fFarmacia; 

	@Override
	@Transactional
	public boolean insertar(Farmacia farmacia) {
		Farmacia objFarmacia = fFarmacia.save(farmacia);
		if(objFarmacia==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Farmacia farmacia) {
		boolean flag =  false;
		try {
			fFarmacia.save(farmacia);
			flag = true;			
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idFarmacia) {
		fFarmacia.deleteById(idFarmacia);		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Farmacia> listarId(int idFarmacia) {
		return fFarmacia.findById(idFarmacia);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Farmacia> listar() {
		return fFarmacia.findAll();
	}
}