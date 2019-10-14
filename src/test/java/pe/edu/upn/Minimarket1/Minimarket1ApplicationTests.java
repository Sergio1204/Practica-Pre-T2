package pe.edu.upn.Minimarket1;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.upn.Minimarket1.model.entity.*;
import pe.edu.upn.Minimarket1.model.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Minimarket1ApplicationTests {
	@Autowired
	private ProveedorRepository proveedorRepository;
	@Autowired
	private AlmacenRepository almacenRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired 
	private UsuarioRepository usuarioRepository;
	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	public void contextLoads() {
		try {
			
			//Proveedores
				Proveedor p1 = new Proveedor();
				p1.setCalle("Armendariz");
				p1.setDireccion("Jiron Armendariz Urb. C Lote 12");
				p1.setDistrito("Villa el Salvador");
				p1.setNomProv("Importaciones BebiCol S.A");
				p1.setTelefono("017261485");
				
				Proveedor p2 = new Proveedor();
				p2.setCalle("Otuzco");
				p2.setDireccion("Calle Otuzco Urb. Las Begonias Lote 40");
				p2.setDistrito("La Molina");
				p2.setNomProv("DulImport S.A");
				p2.setTelefono("013308415");
				
				Proveedor p3 = new Proveedor();
				p3.setCalle("Mariano Dominguez");
				p3.setDireccion("Avenida Mariano Dominguez 8604");
				p3.setDistrito("Callao");
				p3.setNomProv("LimpIndustrial S.A");
				p3.setTelefono("017148596");
				
				Proveedor p4 = new Proveedor();
				p3.setCalle("-");
				p3.setDireccion("Panamericana Sur Km.42");
				p3.setDistrito("Lurin");
				p3.setNomProv("Importaciones Yaco S.A");
				p3.setTelefono("017258417");
				
				proveedorRepository.save(p1);
				proveedorRepository.save(p2);
				proveedorRepository.save(p3);
				proveedorRepository.save(p4);
				
			//Almacen
				Almacen a1 = new Almacen("A001");
				Almacen a2 = new Almacen("A002");
				
				almacenRepository.save(a1);
				almacenRepository.save(a2);
				
			//Categoria
				
				Categoria c1 = new Categoria("C001", "Bebidas");
				Categoria c2 = new Categoria("C002", "Comestibles");
				Categoria c3 = new Categoria("C003", "Productos Limpieza");
				Categoria c4 = new Categoria("C004", "Otros");
				
				categoriaRepository.save(c1);
				categoriaRepository.save(c2);
				categoriaRepository.save(c3);
				categoriaRepository.save(c4);
				
			//Usuario
				
				Usuario us1 = new Usuario("JO014", "06025828", "Jose", "5493", new Date(2019,9,1));
				Usuario us2 = new Usuario("SS123", "72673301", "Sergio", "1234", new Date(2019,9,1));
				
				usuarioRepository.save(us1);
				usuarioRepository.save(us2);
				
			//Cliente
				
				Cliente cliente1 = new Cliente("SS123", "Sergio", "Siccha", "del Campo");
				Cliente cliente2 = new Cliente("JR123", "Jair", "Rivero", "Palomino");
				
				clienteRepository.save(cliente1);
				clienteRepository.save(cliente2);
				
			//Producto
				
				//Comestibles
				Producto prod1 = new Producto("PC0000001", "Galleta Oreo", 0.7 , 6000);
				Producto prod2 = new Producto("PC0000002", "Sublime Xtremo", 2.7 , 6000);
				Producto prod3 = new Producto("PC0000003", "Enrrollado de Carne", 6.5 , 6000);
				Producto prod4 = new Producto("PC0000004", "Pizza Familiar x32", 25.0 , 6000);
				Producto prod5 = new Producto("PC0000005", "Pringless 200g.", 8.5 , 6000);
				//Bebidas
				Producto prod6 = new Producto("PB0000001", "Coca Cola 750ml.", 2.3 , 6000);
				Producto prod7 = new Producto("PB0000002", "Fanta 3L", 9.5 , 6000);
				Producto prod8 = new Producto("PB0000003", "Aquarios 750ml", 2.0 , 6000);
				Producto prod9 = new Producto("PB0000004", "Pilsen 473ml", 4.7 , 6000);
				Producto prod10 = new Producto("PB0000005", "FourLoko 473ml", 10.5 , 6000);
				//Limpieza
				Producto prod11 = new Producto("PL0000001", "Poett Flores del Campo 900ml", 19.5 , 6000);
				Producto prod12 = new Producto("PL0000002", "Lavavajillas Sapolio 1kg", 12.0 , 6000);
				Producto prod13 = new Producto("PL0000003", "Lejia Clorox 3L", 13.9 , 6000);
				Producto prod14 = new Producto("PL0000004", "Jabon Liquido Protex 221ml", 15.5 , 6000);
				Producto prod15 = new Producto("PL0000005", "Cera en pasta Sapolio 300ml", 10.0 , 6000);
				
				productoRepository.save(prod1);
				productoRepository.save(prod2);
				productoRepository.save(prod3);
				productoRepository.save(prod4);
				productoRepository.save(prod5);
				productoRepository.save(prod6);
				productoRepository.save(prod7);
				productoRepository.save(prod8);
				productoRepository.save(prod9);
				productoRepository.save(prod10);
				productoRepository.save(prod11);
				productoRepository.save(prod12);
				productoRepository.save(prod13);
				productoRepository.save(prod14);
				productoRepository.save(prod15);
				
			//RELACIONES Producto - Proveedor
				prod6.setProveedor(p1);
				prod7.setProveedor(p1);
				prod8.setProveedor(p1);
				prod9.setProveedor(p1);
				prod10.setProveedor(p1);
				
				prod1.setProveedor(p2);
				prod2.setProveedor(p2);
				prod3.setProveedor(p2);
				prod4.setProveedor(p2);
				prod5.setProveedor(p2);
				
				prod11.setProveedor(p3);
				prod12.setProveedor(p3);
				prod14.setProveedor(p3);
				prod14.setProveedor(p3);
				prod15.setProveedor(p3);
				
			//RELACIONES Producto - Almacen
				
				prod1.setAlmacen(a1);
				prod2.setAlmacen(a1);
				prod3.setAlmacen(a1);
				prod4.setAlmacen(a1);
				prod5.setAlmacen(a1);
				prod6.setAlmacen(a1);
				prod7.setAlmacen(a1);
				prod8.setAlmacen(a1);
				prod9.setAlmacen(a1);
				prod10.setAlmacen(a1);
				
				prod11.setAlmacen(a2);
				prod12.setAlmacen(a2);
				prod13.setAlmacen(a2);
				prod14.setAlmacen(a2);
				prod15.setAlmacen(a2);
				
			//RELACIONES Categoria - Producto
				
				prod6.setCategoria(c1);
				prod7.setCategoria(c1);
				prod8.setCategoria(c1);
				prod9.setCategoria(c1);
				prod10.setCategoria(c1);
				
				prod1.setCategoria(c2);
				prod2.setCategoria(c2);
				prod3.setCategoria(c2);
				prod4.setCategoria(c2);
				prod5.setCategoria(c2);
				
				prod11.setCategoria(c3);
				prod12.setCategoria(c3);
				prod13.setCategoria(c3);
				prod14.setCategoria(c3);
				prod15.setCategoria(c3);
				
			//RELACIONES Cliente-Usuario
				cliente1.setUsuario(us2);
				us2.setCliente(cliente1);
				
				proveedorRepository.save(p1);
				proveedorRepository.save(p2);
				proveedorRepository.save(p3);
				
				almacenRepository.save(a1);
				almacenRepository.save(a2);
				
				categoriaRepository.save(c1);
				categoriaRepository.save(c2);
				categoriaRepository.save(c3);
				
				usuarioRepository.save(us2);
				clienteRepository.save(cliente1);
				
				productoRepository.save(prod1);
				productoRepository.save(prod2);
				productoRepository.save(prod3);
				productoRepository.save(prod4);
				productoRepository.save(prod5);
				productoRepository.save(prod6);
				productoRepository.save(prod7);
				productoRepository.save(prod8);
				productoRepository.save(prod9);
				productoRepository.save(prod10);
				productoRepository.save(prod11);
				productoRepository.save(prod12);
				productoRepository.save(prod13);
				productoRepository.save(prod14);
				productoRepository.save(prod15);
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
