package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Historial;
import pe.edu.upc.spring.model.Pedido;
import pe.edu.upc.spring.service.IHistorialService;
import pe.edu.upc.spring.service.IPedidoService;

@Controller
@RequestMapping("/historial")
public class HistorialController {
	
	@Autowired
	private IPedidoService pService;
	
	@Autowired
	private IHistorialService hService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoHistorial(Map<String, Object> model) {
		model.put("listaHistorial", hService.listar());
		return "listHistorial";		
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroHistorial(Model model) {

		model.addAttribute("listaPedidos", pService.listar());
		
		model.addAttribute("pedido", new Pedido());
		model.addAttribute("historial", new Historial());
		
		return "historial";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Historial objHistorial, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()){ 
			
			model.addAttribute("listaPedidos", pService.listar());
						
			return "historial";
		}
		else {
			boolean flag = hService.insertar(objHistorial);
			if(flag)
				return "redirect:/historial/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/historial/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaHistorial", hService.listar());
		return "listHistorial";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Historial historial) throws ParseException {
		hService.listarId(historial.getIdHistorial());
		return "listHistorial";
	}
}