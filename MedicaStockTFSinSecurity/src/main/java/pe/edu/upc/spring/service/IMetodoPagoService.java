package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.MetodoPago;

public interface IMetodoPagoService {
	public boolean insertar(MetodoPago metodoPago);
	public boolean modificar(MetodoPago metodoPago);
	public void eliminar(int idMetodoPago);
	public Optional<MetodoPago> buscarId(int idMetodoPago);
	public Optional<MetodoPago> listarId(int idMetodoPago);
	public List<MetodoPago> listar();
}