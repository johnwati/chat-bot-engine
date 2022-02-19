package com.jonwat.bot.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jonwat.bot.model.flow.NodeSession;

@Repository
public interface NodeSessionDataRepository extends JpaRepository<NodeSession, Integer> {
	
}