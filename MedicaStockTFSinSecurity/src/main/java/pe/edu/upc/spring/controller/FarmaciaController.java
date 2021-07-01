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
import pe.edu.upc.spring.service.IFarmaciaService;

@Controller
@RequestMapping("/farmacia")
public class FarmaciaController {

	@Autowired
	private IFarmaciaService fService;
	
	@RequestMapping("/bienvenido")
	public String irFarmaciaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irFarmacia(Map<String, Object> model) {
		model.put("listaFarmacias", fService.listar());
		return "listFarmacia";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("farmacia", new Farmacia());
		return "farmacia";		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Farmacia objFarmacia, BindingResult binRes,Model model) throws ParseException {
		if (binRes.hasErrors()) 
			return "farmacia";
		else {
			boolean flag = fService.insertar(objFarmacia);
			if(flag)
				return "redirect:/farmacia/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/farmacia/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Farmacia> objFarmacia = fService.listarId(id);
		if(objFarmacia == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/farmacia/listar";
		}
		else {
			model.addAttribute("farmacia", objFarmacia);
			return "farmacia";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				fService.eliminar(id);
				model.put("listaFarmacias", fService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaFarmacias", fService.listar());
		}
		return "listFarmacia";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaFarmacias", fService.listar());
		return "listFarmacia";
	}
}