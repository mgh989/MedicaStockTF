package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="nombreUsuario", length = 60, nullable = false)
	private String nombreUsuario;
	
	@Column(name="dniUsuario", length = 8, nullable = false)
	private int dniUsuario;
	
	@Column(name="correoUsuario", length = 100, nullable = false)
	private String correoUsuario;
	
	@Column(name="contraseñaUsuario", length = 100, nullable = false)
	private String contrasenaUsuario;

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombreUsuario, int dniUsuario, String correoUsuario,
			String contrasenaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.dniUsuario = dniUsuario;
		this.correoUsuario = correoUsuario;
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(int dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}
}