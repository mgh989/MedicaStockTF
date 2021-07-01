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

import pe.edu.upc.spring.model.MetodoPago;
import pe.edu.upc.spring.service.IMetodoPagoService;

@Controller
@RequestMapping("/metodoPago")
public class MetodoPagoController {

	@Autowired
	private IMetodoPagoService mpService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMetodoPago(Map<String, Object> model) {
		model.put("listaMetodoPago", mpService.listar());
		return "listMetodoPago";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("metodoPago", new MetodoPago());
		return "metodoPago";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute MetodoPago objMetodoPago, BindingResult binRes,Model model) throws ParseException{
		if (binRes.hasErrors()) 
			return "metodoPago";
		else {
			boolean flag = mpService.insertar(objMetodoPago);
			if(flag)
				return "redirect:/metodoPago/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/metodoPago/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<MetodoPago> objMetodoPago = mpService.listarId(id);
		if(objMetodoPago == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/metodoPago/listar";
		}else {
			model.addAttribute("metodoPago", objMetodoPago);
			return "metodoPago";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				mpService.eliminar(id);
				model.put("listaMetodoPago", mpService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMetodoPago", mpService.listar());
		}
		return "listMetodoPago";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaMetodoPago", mpService.listar());
		return "listMetodoPago";
	}
}