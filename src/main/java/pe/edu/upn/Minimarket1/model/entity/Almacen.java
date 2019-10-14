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
@Table(name="almacen")
public class Almacen {
	@Id
	@Column(name="codAlmacen",length=5,nullable=false)
	private String codAlmacen;
	
	@OneToMany(mappedBy = "almacen", fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	public Almacen() {
		productos = new ArrayList<>();
	}
	
	public Almacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}
	
	//----------------------------------------------------------------
	public void addProducto(Producto producto) {
		producto.setAlmacen(this);
		productos.add(producto);
	}
	//----------------------------------------------------------------

	public String getCodAlmacen() {
		return codAlmacen;
	}

	public void setCodAlmacen(String codAlmacen) {
		this.codAlmacen = codAlmacen;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
