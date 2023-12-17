package com.example.realestateplatform.services.implementation;

import com.example.realestateplatform.model.Agent;
import com.example.realestateplatform.repository.AgentRepository;
import com.example.realestateplatform.services.AgentInterface;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.List;

@Lazy
@Service
public class Agentimple implements AgentInterface {
 
   private AgentRepository agentRepository;

    
    public Agentimple(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public Agent addAgent(Agent agen) {
        return agentRepository.save(agen);
    }

    @Override
    public Agent updateAgent(Agent agen) {
        return agentRepository.save(agen);
    }

    @Override
    public void deleteAgent(Long agen) {
        agentRepository.deleteById(agen);
    }


    @Override
    public List<Agent> agentList() {
        return agentRepository.findAll();
    }

    @Override
    public Agent findAgentByAgentId(Long agen) {
        return agentRepository.findById(agen).get();
    }

    @Override
    public Page<Agent> pagenateAgent(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo -1,pageSize);
        return this.agentRepository.findAll(pageable);
    }


}
