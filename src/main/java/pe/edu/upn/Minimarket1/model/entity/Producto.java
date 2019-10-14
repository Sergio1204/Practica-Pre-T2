 package pe.edu.upn.Minimarket1.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {
	@Id
	@Column(name="codProducto")
	private String codProd;
	
	@Column(name="nombre")
	private String nomProd;
	
	@Column(name="precioUnitario")
	private float precioUnitario;
	
	@Column(name="stock")
	private int stock;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codCategoria")
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codAlmacen")
	private Almacen almacen;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rucProveedor")
	private Proveedor proveedor;
	
	@ManyToMany(mappedBy = "productos")
	private List<Pedido> pedidos;
	
	public Producto(){
		pedidos = new ArrayList<>();
	}

	public Producto(String codProd, String nomProd, double precioUnitario, int stock) {
		this.codProd = codProd;
		this.nomProd = nomProd;
		this.precioUnitario = (float)precioUnitario;
		this.stock = stock;
	}
	
	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
}
