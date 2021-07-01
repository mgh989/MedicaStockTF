package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Stock;

public interface IStockService {

	public boolean insertar(Stock stock);
	public boolean modificar(Stock stock);
	public void eliminar(int idStock);
	public Optional<Stock> buscarId(int idStock);
	public Optional<Stock> listarId(int idStock);
	public List<Stock> listar();
}