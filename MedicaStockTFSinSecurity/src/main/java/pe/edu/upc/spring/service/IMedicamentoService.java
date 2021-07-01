package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Medicamento;

public interface IMedicamentoService {
	
	public boolean insertar(Medicamento medicamento);
	public boolean modificar (Medicamento medicamento);
	public void eliminar (int idMedicamento);
	public Optional<Medicamento> listarId(int idMedicamento);
	List<Medicamento> listar();
	List<Medicamento> buscarNombre(String nombreMedicamento);
}