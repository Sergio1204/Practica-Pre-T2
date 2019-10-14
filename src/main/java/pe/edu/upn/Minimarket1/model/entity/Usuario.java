package pe.edu.upn.Minimarket1.model.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@Column(name="idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@Column(name="codUsuario",length=5,nullable=false)
	private String codUsuario;
	
	@Column(name="dniUsuario",length=8,nullable=false)
	private String dni;
	
	@Column(name="nombreUsuario",length=20,nullable=false)
	private String nombre;
	
	@Column(name="pw",length=4,nullable=false)
	private String pw;
	
	@Column(name="fechaCreacion",nullable=false)
	private Date fechaCreacion;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Cliente cliente;
	
	public Usuario() {
	}
	
	public Usuario(String codUsuario, String dni, String nombre, String pw, Date fecha) {
		this.codUsuario = codUsuario;
		this.dni = dni;
		this.nombre = nombre;
		this.pw = pw;
		this.fechaCreacion = fecha;
	}

	public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
