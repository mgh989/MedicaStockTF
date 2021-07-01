package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Farmacia;

public interface IFarmaciaService {
	
	public boolean insertar(Farmacia farmacia);
	public boolean modificar(Farmacia farmacia);
	public void eliminar(int idFarmacia);
	public Optional<Farmacia> listarId(int idFarmacia);
	List<Farmacia> listar();	
}