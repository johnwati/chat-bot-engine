package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.Node;
import com.jonwat.bot.repository.NodeRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NodeService {

	@Autowired
	private NodeRepository nodeRepository;

	public List<Node> findAll() {
		return nodeRepository.findAll();
	}

	public Optional<Node> findOne(Integer id) {
		return nodeRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public Node save(Node entity) {
		return nodeRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Node entity) {
		nodeRepository.delete(entity);
	}

}
	
