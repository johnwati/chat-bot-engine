package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.PrevNode;
import com.jonwat.bot.repository.PrevNodeRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PrevNodeService {

	@Autowired
	private PrevNodeRepository prevnodeRepository;

	public List<PrevNode> findAll() {
		return prevnodeRepository.findAll();
	}

	public Optional<PrevNode> findOne(Integer id) {
		return prevnodeRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public PrevNode save(PrevNode entity) {
		return prevnodeRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(PrevNode entity) {
		prevnodeRepository.delete(entity);
	}

}
	
