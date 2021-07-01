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
@Table(name="Stock")
public class Stock implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStock;
	
	@Column(name="cantStock", nullable = false)
	private int cantStock;
	
	@Column(name="precioStock", nullable=false)
	private int precioStock;
	
	@ManyToOne
	@JoinColumn(name="idFarmacia", nullable = false)
	private Farmacia farmacia;
	
	@ManyToOne
	@JoinColumn(name="idMedicamento", nullable = false)
	private Medicamento medicamento;
	

	public Stock() {
		super();
	}


	public Stock(int idStock, int cantStock, int precioStock, Farmacia farmacia, Medicamento medicamento) {
		super();
		this.idStock = idStock;
		this.cantStock = cantStock;
		this.precioStock = precioStock;
		this.farmacia = farmacia;
		this.medicamento = medicamento;
	}


	public int getIdStock() {
		return idStock;
	}


	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}


	public int getCantStock() {
		return cantStock;
	}


	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}


	public int getPrecioStock() {
		return precioStock;
	}


	public void setPrecioStock(int precioStock) {
		this.precioStock = precioStock;
	}


	public Farmacia getFarmacia() {
		return farmacia;
	}


	public void setFarmacia(Farmacia farmacia) {
		this.farmacia = farmacia;
	}


	public Medicamento getMedicamento() {
		return medicamento;
	}


	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
}