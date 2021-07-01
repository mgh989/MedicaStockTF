package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RepartidorxPedido")
public class RepartidorxPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRepartidorxPedido;
	
	@ManyToOne
	@JoinColumn(name="idRepartidor", nullable = false)
	private Repartidor repartidor;
	
	@OneToOne
	@JoinColumn(name="idPedido", nullable = false)
	private Pedido pedido;

	public RepartidorxPedido() {
		super();
	}

	public RepartidorxPedido(int idRepartidorxPedido, Repartidor repartidor, Pedido pedido) {
		super();
		this.idRepartidorxPedido = idRepartidorxPedido;
		this.repartidor = repartidor;
		this.pedido = pedido;
	}

	public int getIdRepartidorxPedido() {
		return idRepartidorxPedido;
	}

	public void setIdRepartidorxPedido(int idRepartidorxPedido) {
		this.idRepartidorxPedido = idRepartidorxPedido;
	}

	public Repartidor getRepartidor() {
		return repartidor;
	}

	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}