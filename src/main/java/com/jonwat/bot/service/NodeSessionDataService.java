package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.NodeSession;
import com.jonwat.bot.repository.NodeSessionDataRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NodeSessionDataService {

	@Autowired
	private NodeSessionDataRepository nodesessiondataRepository;

	public List<NodeSession> findAll() {
		return nodesessiondataRepository.findAll();
	}

	public Optional<NodeSession> findOne(Integer id) {
		return nodesessiondataRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public NodeSession save(NodeSession entity) {
		return nodesessiondataRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(NodeSession entity) {
		nodesessiondataRepository.delete(entity);
	}

}
	
