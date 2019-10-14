package pe.edu.upn.Minimarket1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upn.Minimarket1.model.entity.Pedido;
import pe.edu.upn.Minimarket1.service.PedidoService;

@Controller
@RequestMapping("/Pedidos")
public class PedidosController {
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public String consultar(Model model) {
		try {
			List<Pedido> pedidos = pedidoService.findAll();
			model.addAttribute("pedidos",pedidos);
			
			for(Pedido p : pedidos) {
				System.out.println(p.getCodPedido());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Operaciones/Pedido/reporte";
	}
	
	@GetMapping("/detallePedido/{id}")
	public String detalle(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Pedido> pedido = pedidoService.findById(id);
			model.addAttribute("pedido",pedido.get());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return "/Operaciones/Pedido/detallePedido";
	}
}
