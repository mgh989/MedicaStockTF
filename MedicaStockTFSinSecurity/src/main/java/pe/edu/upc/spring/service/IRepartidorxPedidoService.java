package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.RepartidorxPedido;

public interface IRepartidorxPedidoService {
	public boolean insertar(RepartidorxPedido repartidorxPedido);
	public boolean modificar(RepartidorxPedido repartidorxPedido);
	public void eliminar(int idRepartidorxPedido);
	public Optional<RepartidorxPedido> buscarId(int idRepartidorxPedido);
	public Optional<RepartidorxPedido> listarId(int idRepartidorxPedido);
	public List<RepartidorxPedido> listar();
}