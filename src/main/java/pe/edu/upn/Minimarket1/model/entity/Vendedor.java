package pe.edu.upn.Minimarket1.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="vendedor")
public class Vendedor {
	@Id
	@Column(name="codVendedor",length=5,nullable=false)
	private String codVendedor;
	
	@Column(name="dni",length=8,nullable=false)
	private String dni;
	
	@Column(name="nombre",length=20,nullable=false)
	private String nombre;	
	
	@OneToMany(mappedBy = "vendedor" , fetch = FetchType.LAZY)
	private List<Transaccion> transacciones;
}
