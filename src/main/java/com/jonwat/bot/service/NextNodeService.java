package com.jonwat.bot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.jonwat.bot.model.flow.NextNode;
import com.jonwat.bot.repository.NextNodeRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class NextNodeService {

	@Autowired
	private NextNodeRepository nextnodeRepository;

	public List<NextNode> findAll() {
		return nextnodeRepository.findAll();
	}

	public Optional<NextNode> findOne(Integer id) {
		return nextnodeRepository.findById(id);
	}
	
	@Transactional(readOnly = false)
	public NextNode save(NextNode entity) {
		return nextnodeRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(NextNode entity) {
		nextnodeRepository.delete(entity);
	}

}
	
