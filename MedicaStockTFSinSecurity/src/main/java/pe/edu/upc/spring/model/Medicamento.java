package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Medicamento")
public class Medicamento implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMedicamento;
	
	@Column(name="nombreMedicamento", length = 60, nullable = false)
	private String nombreMedicamento;
	
	@Column(name="desMedicamento", length = 500, nullable = false)
	private String desMedicamento;

	public Medicamento() {
		super();
	}

	public Medicamento(int idMedicamento, String nombreMedicamento, String desMedicamento) {
		super();
		this.idMedicamento = idMedicamento;
		this.nombreMedicamento = nombreMedicamento;
		this.desMedicamento = desMedicamento;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public String getDesMedicamento() {
		return desMedicamento;
	}

	public void setDesMedicamento(String desMedicamento) {
		this.desMedicamento = desMedicamento;
	}
}