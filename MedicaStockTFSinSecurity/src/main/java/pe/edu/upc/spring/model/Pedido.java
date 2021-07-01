package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pedido")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	
	@Column(name="cantCompra", nullable = false)
	private int cantCompra;	
	
	@Column(name="direccionPedido", length = 500, nullable = false)
	private String direccionPedido;
	
	@ManyToOne
	@JoinColumn(name="idCliente", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="idStock", nullable = false)
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name="idMetodoPago", nullable = false)
	private MetodoPago metodoPago;

	public Pedido() {
		super();
	}

	public Pedido(int idPedido, int cantCompra, String direccionPedido, Cliente cliente, Stock stock,
			MetodoPago metodoPago) {
		super();
		this.idPedido = idPedido;
		this.cantCompra = cantCompra;
		this.direccionPedido = direccionPedido;
		this.cliente = cliente;
		this.stock = stock;
		this.metodoPago = metodoPago;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getCantCompra() {
		return cantCompra;
	}

	public void setCantCompra(int cantCompra) {
		this.cantCompra = cantCompra;
	}

	public String getDireccionPedido() {
		return direccionPedido;
	}

	public void setDireccionPedido(String direccionPedido) {
		this.direccionPedido = direccionPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
}