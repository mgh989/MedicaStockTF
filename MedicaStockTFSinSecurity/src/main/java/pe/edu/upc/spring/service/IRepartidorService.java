package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Repartidor;

public interface IRepartidorService {
	public boolean insertar(Repartidor repartidor);
	public boolean modificar(Repartidor repartidor);
	public void eliminar(int idRepartidor);
	public Optional<Repartidor> buscarId(int idRepartidor);
	public Optional<Repartidor> listarId(int idRepartidor);
	public List<Repartidor> listar();
}