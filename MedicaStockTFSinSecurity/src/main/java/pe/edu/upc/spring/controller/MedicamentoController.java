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

import pe.edu.upc.spring.model.Medicamento;
import pe.edu.upc.spring.service.IMedicamentoService;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private IMedicamentoService mService;
	
	@RequestMapping("/index")
	public String irPaginaBienvenida() {
		return "index";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMedicamentos(Map<String, Object> model) {
		model.put("listaMedicamentos", mService.listar());
		return "listMedicamentos";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("medicamento", new Medicamento());
		return "medicamento";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Medicamento objMedicamento, BindingResult binRes,Model model) throws ParseException{
		if (binRes.hasErrors()) 
			return "medicamento";
		else {
			boolean flag = mService.insertar(objMedicamento);
			if(flag)
				return "redirect:/medicamento/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/medicamento/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Medicamento> objMedicamento =mService.listarId(id);
		if(objMedicamento == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/medicamento/listar";
		}else {
			model.addAttribute("medicamento", objMedicamento);
			return "medicamento";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				mService.eliminar(id);
				model.put("listaMedicamentos", mService.listar());

			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMedicamentos", mService.listar());
		}
		return "listMedicamentos";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaMedicamentos", mService.listar());
		return "listMedicamentos";
	}
}