package com.example.realestateplatform.controller;

import com.example.realestateplatform.model.Agent;
import com.example.realestateplatform.securityconfig.EmailSenderServiceConfig;
import com.example.realestateplatform.services.AgentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@Controller
public class AgentController {
    @Autowired
    private AgentInterface agentService;
    @Autowired
    private EmailSenderServiceConfig emailSenderServiceConfig;

    @GetMapping("/landing")
    public String landingPage(Model model) {

        return findPaginated(1, model);
    }

    @GetMapping("/fron")
    public String ind() {
        return "landings";
    }

    @GetMapping("/")
    public String homme() {
        return "aboutus";
    }

    @GetMapping("/come")
    public String landings() {
        return "login";
    }

    @GetMapping("/estate")
    public String estate() {
        return "package";
    }

    @GetMapping("/tem")
    public String temp() {
        return "land";
    }

    @GetMapping("/creation1")
    public String addAgentPage(Model model) {
        Agent agen = new Agent();
        model.addAttribute("agent", agen);
        return "create";
    }

    @GetMapping("/agent-page")
    public String agentpage(Model model) {
        Agent agen = new Agent();
        model.addAttribute("agent", agen);
        return "agent";
    }

    @PostMapping("/add")
    public String addAgent(@ModelAttribute("agent") Agent theAgent) throws MessagingException {
        Agent savedAgent = agentService.addAgent(theAgent);
        if (savedAgent != null) {
            emailSenderServiceConfig.sendCitizenEmail(theAgent.getEmailAddress(), "REGISTRATION", theAgent.getFullNames());
            return "redirect:/agent-page?success";
        } else {
            return "redirect:/agent-page?error";
        }
    }

    @PostMapping("/reg")
    public String addAgentInDb(@ModelAttribute("agent") Agent theAgent) throws MessagingException {
        Agent savedAgent = agentService.addAgent(theAgent);
        if (savedAgent != null) {
            emailSenderServiceConfig.sendCitizenEmail(theAgent.getEmailAddress(), "REGISTRATION", theAgent.getFullNames());

            return "redirect:/creation1?success";
        } else {
            return "redirect:/creation1?error";
        }
    }

    @GetMapping("/landing/update/{id}")
    public String editAgent(@PathVariable String id, Model model) {

        Long agentId = Long.parseLong(id);
        model.addAttribute("agent", agentService.findAgentByAgentId(agentId));
        return "update";
    }

    @PostMapping("/landing/{id}")
    public String updateAgent(@PathVariable String id,
                                @ModelAttribute("agent") Agent agent, Model model) {

        Long agentId = Long.parseLong(id);
        Agent existingAgent = agentService.findAgentByAgentId(agentId);
        existingAgent.setTelephone(agent.getTelephone());
        existingAgent.setId(agent.getId());
        existingAgent.setFullNames(agent.getFullNames());
        existingAgent.setEstate(agent.getEstate());
        existingAgent.setDate(agent.getDate());
        existingAgent.setEmailAddress(agent.getEmailAddress());
        existingAgent.setLocation(agent.getLocation());
        agentService.updateAgent(existingAgent);
        return "redirect:/landing";
    }

    @GetMapping("/landing/{id}")
    public String deleteAgent(@PathVariable String id) {
        Long agentId = Long.parseLong(id);
        agentService.deleteAgent(agentId);
        return "redirect:/landing";
    }

    @GetMapping("/find")
    public String finding(Model model) {
        Agent agent = new Agent();
        model.addAttribute("finding", agent);

        return "finding";
    }

    @PostMapping("/find")
    public String findingg(@ModelAttribute("finding") Agent agent, Model model) {
        Agent agent1 = agentService.findAgentByAgentId(agent.getId());
        if (agent1 != null) {
            model.addAttribute("agent1", agent1);
            return "finding";
        } else {
            model.addAttribute("error", "account not added");
            return "finding";
        }
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Agent> page = agentService.pagenateAgent(pageNo, pageSize);
        List<Agent> agentList = page.getContent();
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listAgents", agentList);
        return "landing-page";

    }

}
