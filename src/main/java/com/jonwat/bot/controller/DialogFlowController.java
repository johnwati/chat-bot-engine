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
import com.jonwat.bot.model.flow.DialogFlow;
import com.jonwat.bot.service.DialogFlowService;
import java.util.Optional;

@Controller
@RequestMapping("/dialogflows")
public class DialogFlowController {

	private static final String MSG_SUCESS_INSERT = "DialogFlow inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "DialogFlow successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted DialogFlow successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private DialogFlowService dialogflowService;

	@GetMapping
	public String index(Model model) {
		List<DialogFlow> all = dialogflowService.findAll();
		model.addAttribute("listDialogFlow", all);
		return "dialogflow/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<DialogFlow> dialogflow = dialogflowService.findOne(id);
			model.addAttribute("dialogflow", dialogflow);
		}
		return "dialogflow/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute DialogFlow entity) {
		model.addAttribute("dialogflow", entity);
		return "dialogflow/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute DialogFlow entity, BindingResult result, RedirectAttributes redirectAttributes) {
		DialogFlow dialogflow = null;
		try {
			dialogflow = dialogflowService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/dialogflows/" + dialogflow.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<DialogFlow> entity = dialogflowService.findOne(id);
				model.addAttribute("dialogflow", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "dialogflow/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute DialogFlow entity, BindingResult result, RedirectAttributes redirectAttributes) {
		DialogFlow dialogflow = null;
		try {
			dialogflow = dialogflowService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/dialogflows/" + dialogflow.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<DialogFlow> entity = dialogflowService.findOne(id);
				dialogflowService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/dialogflows/index";
	}

}
