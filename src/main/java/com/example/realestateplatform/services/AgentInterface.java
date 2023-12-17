package com.example.realestateplatform.services;

import com.example.realestateplatform.model.Agent;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AgentInterface {
    Agent addAgent(Agent agen);
    Agent updateAgent(Agent agen);
    void deleteAgent(Long agen);
    List<Agent> agentList();
    Agent findAgentByAgentId(Long agen);
    Page<Agent> pagenateAgent(int pageNo, int pageSize);

}
