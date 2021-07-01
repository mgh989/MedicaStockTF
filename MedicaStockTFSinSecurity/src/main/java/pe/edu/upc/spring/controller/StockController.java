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

import pe.edu.upc.spring.model.Farmacia;
import pe.edu.upc.spring.model.Medicamento;
import pe.edu.upc.spring.model.Stock;
import pe.edu.upc.spring.service.IFarmaciaService;
import pe.edu.upc.spring.service.IMedicamentoService;
import pe.edu.upc.spring.service.IStockService;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private IMedicamentoService mService;
	
	@Autowired
	private IFarmaciaService fService;
	
	@Autowired
	private IStockService sService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoStock(Map<String, Object> model) {
		model.put("listaStock", sService.listar());
		return "listStock";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroStock(Model model) {

		model.addAttribute("listaMedicamentos", mService.listar());
		model.addAttribute("listaFarmacias", fService.listar());
		
		model.addAttribute("medicamento", new Medicamento());
		model.addAttribute("farmacia", new Farmacia());
		model.addAttribute("stock", new Stock());
		
		return "stock";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Stock objStock, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()){ 
			
			model.addAttribute("listaMedicamentos", mService.listar());
			model.addAttribute("listaFarmacias", fService.listar());
			
			return "stock";
		}
		else {
			boolean flag = sService.insertar(objStock);
			if(flag)
				return "redirect:/stock/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/stock/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Stock> objStock=sService.buscarId(id); //
		if(objStock== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/stock/listar";
		}
		else {
			
			model.addAttribute("listaMedicamentos", mService.listar());
			model.addAttribute("listaFarmacias", fService.listar());
			
			if(objStock.isPresent())
				objStock.ifPresent(o->model.addAttribute("stock",o));
						
			return "stock";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				sService.eliminar(id);
				model.put("listaStock", sService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaStock", sService.listar());
		}
		return "listStock";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaStock", sService.listar());
		return "listStock";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Stock stock) throws ParseException {
		sService.listarId(stock.getIdStock());
		return "listStock";
	}
		
}