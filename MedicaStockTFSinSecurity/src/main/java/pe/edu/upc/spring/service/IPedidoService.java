package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Pedido;

public interface IPedidoService {
	public boolean insertar(Pedido pedido);
	public boolean modificar(Pedido pedido);
	public void eliminar(int idPedido);
	public Optional<Pedido> buscarId(int idPedido);
	public Optional<Pedido> listarId(int idPedido);
	public List<Pedido> listar();
}