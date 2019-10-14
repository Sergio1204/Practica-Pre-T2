 package pe.edu.upn.Minimarket1.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@Column(name="idCategoria", length = 5, nullable = false)
	private String codCategoria;
	
	@Column(name="categoria", length = 20, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Categoria() {
		productos = new ArrayList<>();
	}
	
	public Categoria(String codCategoria, String nombre) {
		this.codCategoria = codCategoria;
		this.nombre = nombre;
	}
	
	//----------------------------------------------------------------
	public void addProducto(Producto producto) {
		producto.setCategoria(this);
		productos.add(producto);
	}
	//----------------------------------------------------------------

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
