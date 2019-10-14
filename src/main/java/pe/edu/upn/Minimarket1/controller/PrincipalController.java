package pe.edu.upn.Minimarket1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upn.Minimarket1.model.entity.Producto;
import pe.edu.upn.Minimarket1.model.entity.Usuario;
import pe.edu.upn.Minimarket1.service.ProductoService;
import pe.edu.upn.Minimarket1.service.UsuarioService;

@Controller
@RequestMapping("/principal")
public class PrincipalController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private ProductoService productoService;
	
	@GetMapping()
	public String Principal() {
		return "Principal";	// Archivo html que se devuelve
	}
	
	@GetMapping("/login")
	public String logeo(Model model) {
		Usuario usuario = new Usuario();
		
		model.addAttribute("usuario", usuario);
		
		return "/login";
	}
	
	@PostMapping("/logeo")
	public String iniciar(@ModelAttribute("usuario") Usuario usuario, Model model) {
		int band = 3;
		
		try {
			List<Usuario> usuarios = usuarioService.findAll();
			
			for(Usuario us : usuarios) {
				if(usuario.getCodUsuario().compareTo(us.getCodUsuario()) == 0) {
					if(usuario.getPw().compareTo(us.getPw()) == 0) {
						band=1;	
					}else {
						band=2;
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(band == 1) {
			try {
				List<Producto> productos = productoService.findAll();
				model.addAttribute("productos", productos);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			model.addAttribute("sessInic",usuario.getNombre());
			return "/Productos/catalogo";
		}
		if(band == 2){
			model.addAttribute("passIM", "ERROR - Contraseña Incorrecta");
			return "/login";
		}
		if(band == 3) {
			model.addAttribute("accessDM", "ERROR - Usted no cuenta con permisos para acceder a la plataforma");
			return "/login";
		}
		return "redirect:/principal";
	}
}
