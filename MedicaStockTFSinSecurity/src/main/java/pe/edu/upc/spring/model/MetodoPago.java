package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MetodoPago")
public class MetodoPago implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMetodoPago;
	
	@Column(name="nombreMetodoPago", length = 60, nullable = false)
	private String nombreMetodoPago;

	public MetodoPago() {
		super();
	}

	public MetodoPago(int idMetodoPago, String nombreMetodoPago) {
		super();
		this.idMetodoPago = idMetodoPago;
		this.nombreMetodoPago = nombreMetodoPago;
	}

	public int getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getNombreMetodoPago() {
		return nombreMetodoPago;
	}

	public void setNombreMetodoPago(String nombreMetodoPago) {
		this.nombreMetodoPago = nombreMetodoPago;
	}
}