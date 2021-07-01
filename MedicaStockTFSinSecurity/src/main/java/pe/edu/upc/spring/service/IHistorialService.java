package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Historial;

public interface IHistorialService {
	public boolean insertar(Historial historial);
	public boolean modificar(Historial historial);
	public void eliminar(int idHistorial);
	public Optional<Historial> buscarId(int idHistorial);
	public Optional<Historial> listarId(int idHistorial);
	public List<Historial> listar();
}