package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Repartidor;
import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.service.IRepartidorService;
import pe.edu.upc.spring.service.IUsuarioService;

@Controller
@RequestMapping("/repartidor")
public class RepartidorController {
	
	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private IRepartidorService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRepartidor(Map<String, Object> model) {
		model.put("listaRepartidor", rService.listar());
		return "listRepartidor";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroRepartidor(Model model) {

		model.addAttribute("listaUsuarios", uService.listar());
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("repartidor", new Repartidor());
		
		return "repartidor";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Repartidor objRepartidor, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()){ 
			
			model.addAttribute("listaUsuarios", uService.listar());
						
			return "repartidor";
		}
		else {
			boolean flag = rService.insertar(objRepartidor);
			if(flag)
				return "redirect:/repartidor/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/repartidor/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Repartidor> objRepartidor=rService.buscarId(id); //
		if(objRepartidor== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/repartidor/listar";
		}
		else {
			
			model.addAttribute("listaUsuarios", uService.listar());
			
			if(objRepartidor.isPresent())
				objRepartidor.ifPresent(o->model.addAttribute("repartidor",o));
						
			return "repartidor";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaRepartidor", rService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaRepartidor", rService.listar());
		}
		return "listRepartidor";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaRepartidor", rService.listar());
		return "listRepartidor";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Repartidor repartidor) throws ParseException {
		rService.listarId(repartidor.getIdRepartidor());
		return "listRepartidor";
	}
}