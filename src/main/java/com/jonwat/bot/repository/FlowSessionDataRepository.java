package com.jonwat.bot.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jonwat.bot.model.flow.FlowSession;

@Repository
public interface FlowSessionDataRepository extends JpaRepository<FlowSession, Integer> {
	
}