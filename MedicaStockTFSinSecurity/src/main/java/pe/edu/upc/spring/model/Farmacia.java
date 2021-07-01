package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Farmacia")
public class Farmacia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFarmacia;
	
	@Column(name="nombreFarmacia", length = 60, nullable = false)
	private String nombreFarmacia;
/*
	@Column(name="rucFarmacia", length = 11, nullable = false)
	private String rucFarmacia;
	
	@Column(name="correoFarmacia", length = 100, nullable = false)
	private String correoFarmacia;
	
	@Column(name="contraseñaFarmacia", length = 100, nullable = false)
	private String contraseñaFarmacia;
*/
	
	public Farmacia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Farmacia(int idFarmacia, String nombreFarmacia) {
		super();
		this.idFarmacia = idFarmacia;
		this.nombreFarmacia = nombreFarmacia;
	}

	public int getIdFarmacia() {
		return idFarmacia;
	}

	public void setIdFarmacia(int idFarmacia) {
		this.idFarmacia = idFarmacia;
	}

	public String getNombreFarmacia() {
		return nombreFarmacia;
	}

	public void setNombreFarmacia(String nombreFarmacia) {
		this.nombreFarmacia = nombreFarmacia;
	}	
}