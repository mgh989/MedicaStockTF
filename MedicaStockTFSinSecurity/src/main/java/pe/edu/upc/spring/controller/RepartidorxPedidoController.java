package pe.edu.upc.spring.controller;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.spring.model.Pedido;
import pe.edu.upc.spring.model.Repartidor;
import pe.edu.upc.spring.model.RepartidorxPedido;
import pe.edu.upc.spring.service.IPedidoService;
import pe.edu.upc.spring.service.IRepartidorService;
import pe.edu.upc.spring.service.IRepartidorxPedidoService;

@Controller
@RequestMapping("/repartidorxPedido")
public class RepartidorxPedidoController {

	@Autowired
	private IRepartidorService rService;
	
	@Autowired
	private IPedidoService pService;
	
	@Autowired
	private IRepartidorxPedidoService rpService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoRepartidorxPedido(Map<String, Object> model) {
		model.put("listaRepartidorxPedido", rpService.listar());
		return "listRepartidorxPedido";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroPedido(Model model) {

		model.addAttribute("listaRepartidor", rService.listar());
		model.addAttribute("listaPedido", pService.listar());
				
		model.addAttribute("repartidor", new Repartidor());
		model.addAttribute("pedido", new Pedido());
		model.addAttribute("repartidorxPedido", new RepartidorxPedido());
		
		return "repartidorxPedido";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute RepartidorxPedido objRepartidorxPedido, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()){ 
			
			model.addAttribute("listaRepartidor", rService.listar());
			model.addAttribute("listaPedido", pService.listar());
			
			return "repartidorxPedido";
		}
		else {
			boolean flag = rpService.insertar(objRepartidorxPedido);
			if(flag)
				return "redirect:/repartidorxPedido/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/repartidorxPedido/irRegistrar";
			}
		}
	}
	
	/* @RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Pedido> objPedido=pService.buscarId(id); //
		if(objPedido== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/pedido/listar";
		}
		else {
			
			model.addAttribute("listaCliente", cService.listar());
			model.addAttribute("listaStock", sService.listar());
			model.addAttribute("listaMetodoPago", mpService.listar());
			
			if(objPedido.isPresent())
				objPedido.ifPresent(o->model.addAttribute("pedido",o));
						
			return "pedido";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				pService.eliminar(id);
				model.put("listaPedido", pService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPedido", pService.listar());
		}
		return "listPedido";
	}*/
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaRepartidorxPedido", rpService.listar());
		return "listRepartidorxPedido";
	}
	
	/* @RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute RepartidorxPedido repartidorxPedido) throws ParseException {
		rpService.listarId(repartidorxPedido.getIdRepartidorxPedido());
		return "listPedido";
	}*/
}