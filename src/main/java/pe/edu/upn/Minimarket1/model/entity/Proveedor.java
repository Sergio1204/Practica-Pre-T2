package pe.edu.upn.Minimarket1.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codProveedor")
	private Integer id;
	
	@Column(name="nombreProv",length=50)
	private String nomProv;
	
	@Column(name="direccion",length=60)
	private String direccion;
	
	@Column(name="distrito",length=30)
	private String distrito;
	
	@Column(name="calle",length=20)
	private String calle;
	
	@Column(name="telefono",length=9)
	private String telefono;
	
	@OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Proveedor() {
		this.productos = new ArrayList<>();
	}
	
	//----------------------------------------------------------------
	public void addProducto(Producto producto) {
		producto.setProveedor(this);
		productos.add(producto);
	}
	//----------------------------------------------------------------

	public String getNomProv() {
		return nomProv;
	}

	public void setNomProv(String nomProv) {
		this.nomProv = nomProv;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public Integer Id() {
		return id;
	}
}
