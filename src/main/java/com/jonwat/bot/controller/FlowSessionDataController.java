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
import com.jonwat.bot.model.flow.FlowSession;
import com.jonwat.bot.service.FlowSessionDataService;
import java.util.Optional;

@Controller
@RequestMapping("/flowsessiondatas")
public class FlowSessionDataController {

	private static final String MSG_SUCESS_INSERT = "FlowSessionData inserted successfully.";
	private static final String MSG_SUCESS_UPDATE = "FlowSessionData successfully changed.";
	private static final String MSG_SUCESS_DELETE = "Deleted FlowSessionData successfully.";
	private static final String MSG_ERROR = "Error.";

	@Autowired
	private FlowSessionDataService flowsessiondataService;

	@GetMapping
	public String index(Model model) {
		List<FlowSession> all = flowsessiondataService.findAll();
		model.addAttribute("listFlowSessionData", all);
		return "flowsessiondata/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Integer id) {
		if (id != null) {
			Optional<FlowSession> flowsessiondata = flowsessiondataService.findOne(id);
			model.addAttribute("flowsessiondata", flowsessiondata);
		}
		return "flowsessiondata/show";
	}

	@GetMapping(value = "/new")
	public String create(Model model, @ModelAttribute FlowSession entity) {
		model.addAttribute("flowsessiondata", entity);
		return "flowsessiondata/form";
	}
	
	@PostMapping
	public String create(@Valid @ModelAttribute FlowSession entity, BindingResult result, RedirectAttributes redirectAttributes) {
		FlowSession flowsessiondata = null;
		try {
			flowsessiondata = flowsessiondataService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_INSERT);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/flowsessiondatas/" + flowsessiondata.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String update(Model model, @PathVariable("id") Integer id) {
		try {
			if (id != null) {
				Optional<FlowSession> entity = flowsessiondataService.findOne(id);
				model.addAttribute("flowsessiondata", entity);
			}
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
		return "flowsessiondata/form";
	}
	
	@PutMapping
	public String update(@Valid @ModelAttribute FlowSession entity, BindingResult result, RedirectAttributes redirectAttributes) {
		FlowSession flowsessiondata = null;
		try {
			flowsessiondata = flowsessiondataService.save(entity);
			redirectAttributes.addFlashAttribute("success", MSG_SUCESS_UPDATE);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			e.printStackTrace();
		}
		return "redirect:/flowsessiondatas/" + flowsessiondata.getId();
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		try {
			if (id != null) {
				Optional<FlowSession> entity = flowsessiondataService.findOne(id);
				flowsessiondataService.delete(entity.get());
				redirectAttributes.addFlashAttribute("success", MSG_SUCESS_DELETE);
			}
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", MSG_ERROR);
			throw new ServiceException(e.getMessage());
		}
		return "redirect:/flowsessiondatas/index";
	}

}
