package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Denunciante")
public class Denunciante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idDenunciante;
    
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="nombreDenunciante", nullable = false, length=60)
	private String nombreDenunciante;
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="apellidoDenunciante", nullable = false, length=60)
	private String apellidoDenunciante;
	
	
	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="descripcionDenunciante", nullable=false, length=60)
	private String descripcionDenunciante;

	@NotEmpty(message = "No puede estar vacio")
	@NotBlank(message = "No puede estar en blanco")
	@Column(name="direccionDenunciante", nullable=false, length=60)
	private String direccionDenunciante;

	@NotNull
	@Past(message="No puedes seleccionar un dia que NO Existe")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaDenunciante")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaDenunciante;
	
	
	
	public Denunciante() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Denunciante(int idDenunciante,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String nombreDenunciante,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String apellidoDenunciante,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String descripcionDenunciante,
			@NotEmpty(message = "No puede estar vacio") @NotBlank(message = "No puede estar en blanco") String direccionDenunciante,
			@NotNull @Past(message = "No puedes seleccionar un dia que NO Existe") Date fechaDenunciante) {
		super();
		this.idDenunciante = idDenunciante;
		this.nombreDenunciante = nombreDenunciante;
		this.apellidoDenunciante = apellidoDenunciante;
		this.descripcionDenunciante = descripcionDenunciante;
		this.direccionDenunciante = direccionDenunciante;
		this.fechaDenunciante = fechaDenunciante;
	}

	

	
	public int getIdDenunciante() {
		return idDenunciante;
	}



	public void setIdDenunciante(int idDenunciante) {
		this.idDenunciante = idDenunciante;
	}



	public String getNombreDenunciante() {
		return nombreDenunciante;
	}



	public void setNombreDenunciante(String nombreDenunciante) {
		this.nombreDenunciante = nombreDenunciante;
	}



	public String getApellidoDenunciante() {
		return apellidoDenunciante;
	}



	public void setApellidoDenunciante(String apellidoDenunciante) {
		this.apellidoDenunciante = apellidoDenunciante;
	}



	public String getDescripcionDenunciante() {
		return descripcionDenunciante;
	}



	public void setDescripcionDenunciante(String descripcionDenunciante) {
		this.descripcionDenunciante = descripcionDenunciante;
	}



	public String getDireccionDenunciante() {
		return direccionDenunciante;
	}



	public void setDireccionDenunciante(String direccionDenunciante) {
		this.direccionDenunciante = direccionDenunciante;
	}




	public void setFechaDenunciante(Date fechaDenunciante) {
		this.fechaDenunciante = fechaDenunciante;
	}

	
	public Date getFechaDenunciante() {
		return fechaDenunciante;
	}
	

	
	
	
}
