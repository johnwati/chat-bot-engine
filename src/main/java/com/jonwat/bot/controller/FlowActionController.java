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
import com.jonwat.bot.model.flow.FlowAction;
import com.jonwat.bot.service.FlowActionService;
import java.util.Optional;

@Controller
@RequestMapping("/flowactions")
public class FlowActionController {

	private static final String MSG_SUCESS_INSERT = "FlowAction inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "FlowAction successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted FlowAction successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private FlowActionService flowactionService;

	@GetMapping
	public String index(Model model) {
		List<FlowAction> all = flowactionService.findAll();
		model.addAttribute("listFlowAction", all);
		return "flowaction/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<FlowAction> flowaction = flowactionService.findOne(id);
			model.addAttribute("flowaction", flowaction);
		}
		return "flowaction/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute FlowAction entity) {
		model.addAttribute("flowaction", entity);
		return "flowaction/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute FlowAction entity, BindingResult result, RedirectAttributes redirectAttributes) {
		FlowAction flowaction = null;
		try {
			flowaction = flowactionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/flowactions/" + flowaction.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<FlowAction> entity = flowactionService.findOne(id);
				model.addAttribute("flowaction", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "flowaction/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute FlowAction entity, BindingResult result, RedirectAttributes redirectAttributes) {
		FlowAction flowaction = null;
		try {
			flowaction = flowactionService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/flowactions/" + flowaction.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<FlowAction> entity = flowactionService.findOne(id);
				flowactionService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/flowactions/index";
	}

}
