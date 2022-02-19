package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.DialogFlow;
import com.jonwat.bot.repository.DialogFlowRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DialogFlowService {

	@Autowired
	private DialogFlowRepository dialogflowRepository;

	public List<DialogFlow> findAll() {
		return dialogflowRepository.findAll();
	}

	public Optional<DialogFlow> findOne(Integer id) {
		return dialogflowRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public DialogFlow save(DialogFlow entity) {
		return dialogflowRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(DialogFlow entity) {
		dialogflowRepository.delete(entity);
	}

}
	
