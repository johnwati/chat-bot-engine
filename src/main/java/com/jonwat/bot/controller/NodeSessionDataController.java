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
import com.jonwat.bot.model.flow.NodeSession;
import com.jonwat.bot.service.NodeSessionDataService;
import java.util.Optional;

@Controller
@RequestMapping("/nodesessiondatas")
public class NodeSessionDataController {

	private static final String MSG_SUCESS_INSERT = "NodeSessionData inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "NodeSessionData successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted NodeSessionData successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private NodeSessionDataService nodesessiondataService;

	@GetMapping
	public String index(Model model) {
		List<NodeSession> all = nodesessiondataService.findAll();
		model.addAttribute("listNodeSessionData", all);
		return "nodesessiondata/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<NodeSession> nodesessiondata = nodesessiondataService.findOne(id);
			model.addAttribute("nodesessiondata", nodesessiondata);
		}
		return "nodesessiondata/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute NodeSession entity) {
		model.addAttribute("nodesessiondata", entity);
		return "nodesessiondata/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute NodeSession entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NodeSession nodesessiondata = null;
		try {
			nodesessiondata = nodesessiondataService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodesessiondatas/" + nodesessiondata.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<NodeSession> entity = nodesessiondataService.findOne(id);
				model.addAttribute("nodesessiondata", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "nodesessiondata/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute NodeSession entity, BindingResult result, RedirectAttributes redirectAttributes) {
		NodeSession nodesessiondata = null;
		try {
			nodesessiondata = nodesessiondataService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/nodesessiondatas/" + nodesessiondata.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<NodeSession> entity = nodesessiondataService.findOne(id);
				nodesessiondataService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/nodesessiondatas/index";
	}

}
