package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.FlowAction;
import com.jonwat.bot.repository.FlowActionRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FlowActionService {

	@Autowired
	private FlowActionRepository flowactionRepository;

	public List<FlowAction> findAll() {
		return flowactionRepository.findAll();
	}

	public Optional<FlowAction> findOne(Integer id) {
		return flowactionRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public FlowAction save(FlowAction entity) {
		return flowactionRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(FlowAction entity) {
		flowactionRepository.delete(entity);
	}

}
	
