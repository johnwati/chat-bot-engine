package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.FlowSession;
import com.jonwat.bot.repository.FlowSessionDataRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class FlowSessionDataService {

	@Autowired
	private FlowSessionDataRepository flowsessiondataRepository;

	public List<FlowSession> findAll() {
		return flowsessiondataRepository.findAll();
	}

	public Optional<FlowSession> findOne(Integer id) {
		return flowsessiondataRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public FlowSession save(FlowSession entity) {
		return flowsessiondataRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(FlowSession entity) {
		flowsessiondataRepository.delete(entity);
	}

}
	
