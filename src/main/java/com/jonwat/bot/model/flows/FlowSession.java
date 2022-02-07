
package com.jonwat.bot.model.flows;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "FlowUserData",
    "FlowChannelData",
    "flowState"
})
@Generated("jsonschema2pojo")
public class FlowSession implements Serializable
{

    @JsonProperty("FlowUserData")
    private List<FlowUserData> flowUserData = null;
    @JsonProperty("FlowChannelData")
    private List<FlowChannelData> flowChannelData = null;
    @JsonProperty("flowState")
    private List<FlowState> flowState = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3620895135742442721L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FlowSession() {
    }

    /**
     * 
     * @param flowChannelData
     * @param flowUserData
     * @param flowState
     */
    public FlowSession(List<FlowUserData> flowUserData, List<FlowChannelData> flowChannelData, List<FlowState> flowState) {
        super();
        this.flowUserData = flowUserData;
        this.flowChannelData = flowChannelData;
        this.flowState = flowState;
    }

    @JsonProperty("FlowUserData")
    public List<FlowUserData> getFlowUserData() {
        return flowUserData;
    }

    @JsonProperty("FlowUserData")
    public void setFlowUserData(List<FlowUserData> flowUserData) {
        this.flowUserData = flowUserData;
    }

    @JsonProperty("FlowChannelData")
    public List<FlowChannelData> getFlowChannelData() {
        return flowChannelData;
    }

    @JsonProperty("FlowChannelData")
    public void setFlowChannelData(List<FlowChannelData> flowChannelData) {
        this.flowChannelData = flowChannelData;
    }

    @JsonProperty("flowState")
    public List<FlowState> getFlowState() {
        return flowState;
    }

    @JsonProperty("flowState")
    public void setFlowState(List<FlowState> flowState) {
        this.flowState = flowState;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FlowSession.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("flowUserData");
        sb.append('=');
        sb.append(((this.flowUserData == null)?"<null>":this.flowUserData));
        sb.append(',');
        sb.append("flowChannelData");
        sb.append('=');
        sb.append(((this.flowChannelData == null)?"<null>":this.flowChannelData));
        sb.append(',');
        sb.append("flowState");
        sb.append('=');
        sb.append(((this.flowState == null)?"<null>":this.flowState));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.flowUserData == null)? 0 :this.flowUserData.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.flowState == null)? 0 :this.flowState.hashCode()));
        result = ((result* 31)+((this.flowChannelData == null)? 0 :this.flowChannelData.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FlowSession) == false) {
            return false;
        }
        FlowSession rhs = ((FlowSession) other);
        return (((((this.flowUserData == rhs.flowUserData)||((this.flowUserData!= null)&&this.flowUserData.equals(rhs.flowUserData)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.flowState == rhs.flowState)||((this.flowState!= null)&&this.flowState.equals(rhs.flowState))))&&((this.flowChannelData == rhs.flowChannelData)||((this.flowChannelData!= null)&&this.flowChannelData.equals(rhs.flowChannelData))));
    }

}
