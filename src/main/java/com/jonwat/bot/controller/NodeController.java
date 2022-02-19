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
import com.jonwat.bot.model.flow.Node;
import com.jonwat.bot.service.NodeService;
import java.util.Optional;

@Controller
@RequestMapping("/nodes")
public class NodeController {

	private static final String MSG_SUCESS_INSERT = "Node inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "Node successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted Node successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NodeService nodeService;

	@GetMapping
	public String index(Model model) {
		List<Node> all = nodeService.findAll();
		model.addAttribute("listNode", all);
		return "node/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<Node> node = nodeService.findOne(id);
			model.addAttribute("node", node);
		}
		return "node/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute Node entity) {
		model.addAttribute("node", entity);
		return "node/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute Node entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Node node = null;
		try {
			node = nodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodes/" + node.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<Node> entity = nodeService.findOne(id);
				model.addAttribute("node", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "node/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute Node entity, BindingResult result, RedirectAttributes redirectAttributes) {
		Node node = null;
		try {
			node = nodeService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodes/" + node.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<Node> entity = nodeService.findOne(id);
				nodeService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nodes/index";
	}

}
