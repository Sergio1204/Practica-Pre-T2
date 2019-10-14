package pe.edu.upn.Minimarket1.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.Minimarket1.model.entity.Almacen;
import pe.edu.upn.Minimarket1.model.entity.Categoria;
import pe.edu.upn.Minimarket1.model.entity.Pedido;
import pe.edu.upn.Minimarket1.model.entity.Producto;
import pe.edu.upn.Minimarket1.service.AlmacenService;
import pe.edu.upn.Minimarket1.service.CategoriaService;
import pe.edu.upn.Minimarket1.service.PedidoService;
import pe.edu.upn.Minimarket1.service.ProductoService;
import pe.edu.upn.Minimarket1.service.ProveedorService;

@Controller
@RequestMapping("/Productos")
public class ProductoController {
	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	@Autowired
	ProveedorService proveedorService;
	@Autowired
	AlmacenService almacenService;
	@Autowired
	PedidoService pedidoService;
	
	List<Producto> pedidoProducto = new ArrayList<>();
	
	@GetMapping
	public String consultar(Model model) {
		try {
			List<Producto> productos = productoService.findAll();
			model.addAttribute("productos",productos);
			pedidoProducto.clear();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "/Productos/catalogo";
	}
	
	@GetMapping("/edit/{codProd}")
	public String editar(@PathVariable("codProd") String id,Model model) {
		try {
			Optional<Producto> optional = productoService.findById(id);
			
			if(optional.isPresent()) {
				List<Categoria> categorias = categoriaService.findAll();
				List<Almacen> almacenes = almacenService.findAll();
				
				
				model.addAttribute("producto", optional.get());
				model.addAttribute("categorias", categorias);
				model.addAttribute("almacenes", almacenes);
			}else {
				return "redirect:/Principal";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Productos/edit";
	}
	
	@GetMapping("/register")
	public String registrar(Model model) {
		Producto producto = new Producto();
		
		model.addAttribute("producto",producto);
		try {
			List<Categoria> categorias = categoriaService.findAll();
			List<Almacen> almacenes = almacenService.findAll();
			
			model.addAttribute("categorias",categorias);
			model.addAttribute("almacenes",almacenes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Productos/register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("producto") Producto producto,
			Model model, SessionStatus status) {
		try {
			productoService.save(producto);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/Productos";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		try {
			Optional<Producto> producto = productoService.findById(id);
			if(producto.isPresent()) {
				productoService.deleteById(id);
			}
		}catch(Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violacion contra el principio de integridad referencial");
			try {
				List<Producto> productos = productoService.findAll();
				model.addAttribute("productos",productos);
			}catch(Exception ex) {
				System.out.println(e.getMessage());
			}
			return "/Productos/catalogo";
		}
		return "redirect:/Productos";
	}
	
	@GetMapping("/carrito/{id}")
	public String carro(@PathVariable("id") String id, Model model) {
		try {
			List<Producto> productos = productoService.findAll();
			Optional<Producto> optional = productoService.findById(id);
			if(optional.isPresent()) {
				pedidoProducto.add(optional.get());
			}
			model.addAttribute("productosPedido",pedidoProducto);
			model.addAttribute("productos",productos);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Operaciones/Pedido/nuevo";
	}
	
	@GetMapping("/delPedido/{id}")
	public String borrar(@PathVariable("id") String id, Model model) {
		Optional<Producto> p = null;
		
		try {
			p = productoService.findById(id);
			List<Producto> productos = productoService.findAll();
			
			model.addAttribute("productos",productos);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(p.isPresent()) {
			for(int i=0;i<pedidoProducto.size();i++) {
				Producto pr = pedidoProducto.get(i);
				
				if(pr.getCodProd().compareTo(p.get().getCodProd()) == 0) {
					pedidoProducto.remove(i);
				}
				
			}
		}else {
			return "redirect:/Productos/carrito/0";
		}
		model.addAttribute("productosPedido",pedidoProducto);
		
		return "/Operaciones/Pedido/nuevo";
	}
	
	@GetMapping("/confirmarP")
	public String confirmarP(Model model, SessionStatus status) {
		Date d = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		Pedido p;
		
		try {
			p = new Pedido(formato.format(d),pedidoProducto);
			
			pedidoService.save(p);
			status.setComplete();
			
			if(status.isComplete()) {
				return "/principal";
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Operaciones/Pedido/nuevo";
	}
}
