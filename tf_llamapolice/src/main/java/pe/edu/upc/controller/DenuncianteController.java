package pe.edu.upc.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.service.IDenuncianteService;

import pe.edu.upc.model.Denunciante;


@Controller
@RequestMapping("/denunciante")
public class DenuncianteController {
	@Autowired
	private IDenuncianteService dService;
	
	@RequestMapping("/bienvenido")
	public String irDenuncianteBienvenido() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irDenunciante(Map<String, Object>model) {
		model.put("listaDenunciante", dService.listar());
		return "listDenunciante";
	}
	
	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("denunciante", new Denunciante());
		return "denunciante";
		
		
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Denunciante objDenunciante, BindingResult binRes, Model model)
	throws ParseException{
		if(binRes.hasErrors())
			return "denunciante";
		else{
			boolean flag=dService.insertar(objDenunciante);
			if(flag) {
				return "redirect:/denunciante/bienvenido";
			}
			else {
				model.addAttribute("mensaje ", "Ocurrió un error");
				return "redirect:/denunciante/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/actualizar")
	public String actualizar(@ModelAttribute @Valid Denunciante objDenunciante, BindingResult binRes, Model model, RedirectAttributes objRedir)
	throws ParseException{
		if(binRes.hasErrors())
			return "redirect:/denunciante/listar";
		else{
			boolean flag=dService.modificar(objDenunciante);
			if(flag) {
				objRedir.addFlashAttribute("mensaje","Se actualizó correctamente");
				return "redirect:/denunciante/listar";
			}
			else
			{
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/denunciante/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException{
		Optional<Denunciante>objDueno=dService.buscarId(id);
		if(objDueno==null)
		{
			objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
			return "redirect:/denunciante/listar";
		}
		else {
			model.addAttribute("denunciante",objDueno);
			return "denunciante";
		}
		
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id")Integer id) {
		try {
			if(id!=null&&id>0)
			{
				dService.eliminar(id);
				model.put("listaDenunciantes", dService.listar());
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaDenunciantes", dService.listar());
		}
		return "listDenunciantes";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaDenunciantes", dService.listar());
		return "listDenunciantes";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Denunciante Denunciante)
	throws ParseException{
		dService.listarId(Denunciante.getIdDenunciante());
		return "listDenunciante";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object>model, @ModelAttribute Denunciante Denunciante)
	throws ParseException{
		List<Denunciante>listaDuenos;
		Denunciante.setNombreDenunciante(Denunciante.getNombreDenunciante());
		listaDuenos=dService.buscarNombre(Denunciante.getNombreDenunciante());
		
		if(listaDuenos.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaDenunciantes", listaDuenos);
		return "buscar";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("denunciantes",new Denunciante());
		return "buscar";
	}
	
	
}