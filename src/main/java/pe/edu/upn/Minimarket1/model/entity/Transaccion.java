package pe.edu.upn.Minimarket1.model.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="transaccion")
public class Transaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codTransaccion",nullable=false)
	private Integer codTransaccion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codCliente")
	private Cliente cliente;
	
	@Column(name="fechaEmision")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@OneToMany(mappedBy = "transaccion", fetch = FetchType.LAZY)
	private List<Pedido> pedido;
	
	@Column(name="estado",length=1,nullable=false)
	private char estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codVendedor")
	private Vendedor vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codFactura")
	private Factura factura;
	
	public Transaccion() {
		this.pedido = new ArrayList<>();
	}
}
