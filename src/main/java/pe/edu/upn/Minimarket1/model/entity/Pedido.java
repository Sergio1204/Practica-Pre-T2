package pe.edu.upn.Minimarket1.model.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPedido")
	private Integer codPedido;

	@Column(name="fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmisionP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codTransaccion")
	private Transaccion transaccion;
	
	@ManyToMany
	@JoinTable(name="Detalle_Pedido",
		joinColumns = @JoinColumn(columnDefinition ="codPedido"),
			inverseJoinColumns = @JoinColumn(columnDefinition = "codProd")
			)
	private List<Producto> productos;
	
	public Pedido() {
		productos = new ArrayList<>();
	}
	
	public Pedido(String fechaEmisionP, List<Producto> productos) throws ParseException {
		Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaEmisionP);
		
		this.fechaEmisionP = fecha;
		this.productos = productos;
	}

	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public Date getFechaEmisionP() {
		return fechaEmisionP;
	}

	public void setFechaEmisionP(Date fechaEmisionP) {
		this.fechaEmisionP = fechaEmisionP;
	}
	
	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
