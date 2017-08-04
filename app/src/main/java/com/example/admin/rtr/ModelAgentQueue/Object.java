
package com.example.admin.rtr.ModelAgentQueue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Object {

    @SerializedName("callcenter")
    @Expose
    private Callcenter callcenter;
    @SerializedName("agent")
    @Expose
    private Agent agent;

    public Callcenter getCallcenter() {
        return callcenter;
    }

    public void setCallcenter(Callcenter callcenter) {
        this.callcenter = callcenter;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

}
