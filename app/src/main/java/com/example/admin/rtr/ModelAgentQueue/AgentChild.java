package com.example.admin.rtr.ModelAgentQueue;

/**
 * Created by Admin on 14-07-2017.
 */

public class AgentChild
{
    private String
            agent_abandoned_calls,
            agent_answers_call,
            agent_inbound_calls,
            agent_outbound_total_calls,
            agent_outbound_total_duration,
            agent_acd_state,
            agent_acd_state_duration,
            agent_total_call_duration,
            agent_outbound_internal_calls,
            agent_outbound_external_calls,
            agent_inbound_outbound_total_calls,
            agent_inbound_outbound_call_duration,
            agent_transferred_call,
            agent_voice_mail,agent_id;


    public AgentChild(String agent_abandoned_calls, String agent_answers_call, String agent_inbound_calls, String agent_outbound_total_calls, String agent_outbound_total_duration, String agent_acd_state, String agent_acd_state_duration, String agent_total_call_duration, String agent_outbound_internal_calls, String agent_outbound_external_calls, String agent_inbound_outbound_total_calls, String agent_inbound_outbound_call_duration, String agent_transferred_call, String agent_voice_mail,String agent_id) {
        this.agent_abandoned_calls = agent_abandoned_calls;
        this.agent_answers_call = agent_answers_call;
        this.agent_inbound_calls = agent_inbound_calls;
        this.agent_outbound_total_calls = agent_outbound_total_calls;
        this.agent_outbound_total_duration = agent_outbound_total_duration;
        this.agent_acd_state = agent_acd_state;
        this.agent_acd_state_duration = agent_acd_state_duration;
        this.agent_total_call_duration = agent_total_call_duration;
        this.agent_outbound_internal_calls = agent_outbound_internal_calls;
        this.agent_outbound_external_calls = agent_outbound_external_calls;
        this.agent_inbound_outbound_total_calls = agent_inbound_outbound_total_calls;
        this.agent_inbound_outbound_call_duration = agent_inbound_outbound_call_duration;
        this.agent_transferred_call = agent_transferred_call;
        this.agent_voice_mail = agent_voice_mail;
        this.agent_id=agent_id;
    }



    public String getAgent_abandoned_calls() {
        return agent_abandoned_calls;
    }

    public void setAgent_abandoned_calls(String agent_abandoned_calls) {
        this.agent_abandoned_calls = agent_abandoned_calls;
    }

    public String getAgent_answers_call() {
        return agent_answers_call;
    }

    public void setAgent_answers_call(String agent_answers_call) {
        this.agent_answers_call = agent_answers_call;
    }

    public String getAgent_inbound_calls() {
        return agent_inbound_calls;
    }

    public void setAgent_inbound_calls(String agent_inbound_calls) {
        this.agent_inbound_calls = agent_inbound_calls;
    }

    public String getAgent_outbound_total_calls() {
        return agent_outbound_total_calls;
    }

    public void setAgent_outbound_total_calls(String agent_outbound_total_calls) {
        this.agent_outbound_total_calls = agent_outbound_total_calls;
    }

    public String getAgent_outbound_total_duration() {
        return agent_outbound_total_duration;
    }

    public void setAgent_outbound_total_duration(String agent_outbound_total_duration) {
        this.agent_outbound_total_duration = agent_outbound_total_duration;
    }

    public String getAgent_acd_state() {
        return agent_acd_state;
    }

    public void setAgent_acd_state(String agent_acd_state) {
        this.agent_acd_state = agent_acd_state;
    }

    public String getAgent_acd_state_duration() {
        return agent_acd_state_duration;
    }

    public void setAgent_acd_state_duration(String agent_acd_state_duration) {
        this.agent_acd_state_duration = agent_acd_state_duration;
    }

    public String getAgent_total_call_duration() {
        return agent_total_call_duration;
    }

    public void setAgent_total_call_duration(String agent_total_call_duration) {
        this.agent_total_call_duration = agent_total_call_duration;
    }

    public String getAgent_outbound_internal_calls() {
        return agent_outbound_internal_calls;
    }

    public void setAgent_outbound_internal_calls(String agent_outbound_internal_calls) {
        this.agent_outbound_internal_calls = agent_outbound_internal_calls;
    }

    public String getAgent_outbound_external_calls() {
        return agent_outbound_external_calls;
    }

    public void setAgent_outbound_external_calls(String agent_outbound_external_calls) {
        this.agent_outbound_external_calls = agent_outbound_external_calls;
    }

    public String getAgent_inbound_outbound_total_calls() {
        return agent_inbound_outbound_total_calls;
    }

    public void setAgent_inbound_outbound_total_calls(String agent_inbound_outbound_total_calls) {
        this.agent_inbound_outbound_total_calls = agent_inbound_outbound_total_calls;
    }

    public String getAgent_inbound_outbound_call_duration() {
        return agent_inbound_outbound_call_duration;
    }

    public void setAgent_inbound_outbound_call_duration(String agent_inbound_outbound_call_duration) {
        this.agent_inbound_outbound_call_duration = agent_inbound_outbound_call_duration;
    }

    public String getAgent_transferred_call() {
        return agent_transferred_call;
    }

    public void setAgent_transferred_call(String agent_transferred_call) {
        this.agent_transferred_call = agent_transferred_call;
    }

    public String getAgent_voice_mail() {
        return agent_voice_mail;
    }

    public void setAgent_voice_mail(String agent_voice_mail) {
        this.agent_voice_mail = agent_voice_mail;
    }

    public String getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }
}
