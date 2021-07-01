package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Medicamento;
import pe.edu.upc.spring.repository.IMedicamentoRepository;
import pe.edu.upc.spring.service.IMedicamentoService;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService{

	@Autowired
	private IMedicamentoRepository mMedicamento;
	
	@Override
	@Transactional
	public boolean insertar(Medicamento medicamento) {
		Medicamento objMedicamento =mMedicamento.save(medicamento);
		if(objMedicamento == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Medicamento medicamento) {
		boolean flag =  false;
		try {
			mMedicamento.save(medicamento);
			flag = true;			
		}
		catch (Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMedicamento) {
		mMedicamento.deleteById(idMedicamento);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Medicamento> listarId(int idMedicamento) {
		return mMedicamento.findById(idMedicamento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Medicamento> listar() {
		return mMedicamento.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Medicamento> buscarNombre(String nombreMedicamento) {
		return mMedicamento.buscarNombre(nombreMedicamento);
	}
}