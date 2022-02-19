package com.jonwat.bot.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.jonwat.bot.model.flow.NodeUserInput;
import com.jonwat.bot.service.NodeUserInputService;
import java.util.Optional;

@Controller
@RequestMapping("/nodeuserinputs")
public class NodeUserInputController {

	private static final String MSG_SUCESS_INSERT = "NodeUserInput inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "NodeUserInput successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted NodeUserInput successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NodeUserInputService nodeuserinputService;

	@GetMapping
	public String index(Model model) {
		List<NodeUserInput> all = nodeuserinputService.findAll();
		model.addAttribute("listNodeUserInput", all);
		return "nodeuserinput/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<NodeUserInput> nodeuserinput = nodeuserinputService.findOne(id);
			model.addAttribute("nodeuserinput", nodeuserinput);
		}
		return "nodeuserinput/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute NodeUserInput entity) {
		model.addAttribute("nodeuserinput", entity);
		return "nodeuserinput/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute NodeUserInput entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NodeUserInput nodeuserinput = null;
		try {
			nodeuserinput = nodeuserinputService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodeuserinputs/" + nodeuserinput.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<NodeUserInput> entity = nodeuserinputService.findOne(id);
				model.addAttribute("nodeuserinput", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "nodeuserinput/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute NodeUserInput entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NodeUserInput nodeuserinput = null;
		try {
			nodeuserinput = nodeuserinputService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodeuserinputs/" + nodeuserinput.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<NodeUserInput> entity = nodeuserinputService.findOne(id);
				nodeuserinputService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nodeuserinputs/index";
	}

}
