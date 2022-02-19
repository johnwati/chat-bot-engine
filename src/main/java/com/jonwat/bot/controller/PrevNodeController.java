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
import com.jonwat.bot.model.flow.PrevNode;
import com.jonwat.bot.service.PrevNodeService;
import java.util.Optional;

@Controller
@RequestMapping("/prevnodes")
public class PrevNodeController {

	private static final String MSG_SUCESS_INSERT = "PrevNode inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "PrevNode successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted PrevNode successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private PrevNodeService prevnodeService;

	@GetMapping
	public String index(Model model) {
		List<PrevNode> all = prevnodeService.findAll();
		model.addAttribute("listPrevNode", all);
		return "prevnode/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<PrevNode> prevnode = prevnodeService.findOne(id);
			model.addAttribute("prevnode", prevnode);
		}
		return "prevnode/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute PrevNode entity) {
		model.addAttribute("prevnode", entity);
		return "prevnode/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute PrevNode entity, BindingResult result, RedirectAttributes redirectAttributes) {
		PrevNode prevnode = null;
		try {
			prevnode = prevnodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/prevnodes/" + prevnode.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<PrevNode> entity = prevnodeService.findOne(id);
				model.addAttribute("prevnode", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "prevnode/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute PrevNode entity, BindingResult result, RedirectAttributes redirectAttributes) {
		PrevNode prevnode = null;
		try {
			prevnode = prevnodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/prevnodes/" + prevnode.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<PrevNode> entity = prevnodeService.findOne(id);
				prevnodeService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/prevnodes/index";
	}

}
