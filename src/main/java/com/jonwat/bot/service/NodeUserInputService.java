package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.NodeUserInput;
import com.jonwat.bot.repository.NodeUserInputRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NodeUserInputService {

	@Autowired
	private NodeUserInputRepository nodeuserinputRepository;

	public List<NodeUserInput> findAll() {
		return nodeuserinputRepository.findAll();
	}

	public Optional<NodeUserInput> findOne(Integer id) {
		return nodeuserinputRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public NodeUserInput save(NodeUserInput entity) {
		return nodeuserinputRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(NodeUserInput entity) {
		nodeuserinputRepository.delete(entity);
	}

}
	
