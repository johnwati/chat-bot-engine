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
import com.jonwat.bot.model.flow.NextNode;
import com.jonwat.bot.service.NextNodeService;
import java.util.Optional;

@Controller
@RequestMapping("/nextnodes")
public class NextNodeController {

	private static final String MSG_SUCESS_INSERT = "NextNode inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "NextNode successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted NextNode successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NextNodeService nextnodeService;

	@GetMapping
	public String index(Model model) {
		List<NextNode> all = nextnodeService.findAll();
		model.addAttribute("listNextNode", all);
		return "nextnode/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<NextNode> nextnode = nextnodeService.findOne(id);
			model.addAttribute("nextnode", nextnode);
		}
		return "nextnode/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute NextNode entity) {
		model.addAttribute("nextnode", entity);
		return "nextnode/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute NextNode entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NextNode nextnode = null;
		try {
			nextnode = nextnodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nextnodes/" + nextnode.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<NextNode> entity = nextnodeService.findOne(id);
				model.addAttribute("nextnode", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "nextnode/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute NextNode entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NextNode nextnode = null;
		try {
			nextnode = nextnodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nextnodes/" + nextnode.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<NextNode> entity = nextnodeService.findOne(id);
				nextnodeService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nextnodes/index";
	}

}
