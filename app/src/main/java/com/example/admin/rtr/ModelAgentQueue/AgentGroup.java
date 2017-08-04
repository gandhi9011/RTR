package com.example.admin.rtr.ModelAgentQueue;

/**
 * Created by Admin on 14-07-2017.
 */

public class AgentGroup
{
private String agent_name,agent_dnd_status;
private AgentChild agentChild;

    public AgentGroup(String agent_name, String agent_dnd_status, AgentChild agentChild) {
        this.agent_name = agent_name;
        this.agent_dnd_status = agent_dnd_status;
        this.agentChild = agentChild;
    }

    public String getAgent_name() {
        return agent_name;
    }

    public void setAgent_name(String agent_name) {
        this.agent_name = agent_name;
    }

    public String getAgent_dnd_status() {
        return agent_dnd_status;
    }

    public void setAgent_dnd_status(String agent_dnd_status) {
        this.agent_dnd_status = agent_dnd_status;
    }

    public AgentChild getAgentChild() {
        return agentChild;
    }

    public void setAgentChild(AgentChild agentChild) {
        this.agentChild = agentChild;
    }
}
