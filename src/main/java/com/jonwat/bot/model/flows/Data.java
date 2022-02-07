
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
    "nodeoutput",
    "userdata"
})
@Generated("jsonschema2pojo")
public class Data implements Serializable
{

    @JsonProperty("nodeoutput")
    private String nodeoutput;
    @JsonProperty("userdata")
    private List<NodeUserInput> userdata = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8802139763972048866L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param userdata
     * @param nodeoutput
     */
    public Data(String nodeoutput, List<NodeUserInput> userdata) {
        super();
        this.nodeoutput = nodeoutput;
        this.userdata = userdata;
    }

    @JsonProperty("nodeoutput")
    public String getNodeoutput() {
        return nodeoutput;
    }

    @JsonProperty("nodeoutput")
    public void setNodeoutput(String nodeoutput) {
        this.nodeoutput = nodeoutput;
    }

    @JsonProperty("userdata")
    public List<NodeUserInput> getUserdata() {
        return userdata;
    }

    @JsonProperty("userdata")
    public void setUserdata(List<NodeUserInput> userdata) {
        this.userdata = userdata;
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
        sb.append(Data.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("nodeoutput");
        sb.append('=');
        sb.append(((this.nodeoutput == null)?"<null>":this.nodeoutput));
        sb.append(',');
        sb.append("userdata");
        sb.append('=');
        sb.append(((this.userdata == null)?"<null>":this.userdata));
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
        result = ((result* 31)+((this.userdata == null)? 0 :this.userdata.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.nodeoutput == null)? 0 :this.nodeoutput.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Data) == false) {
            return false;
        }
        Data rhs = ((Data) other);
        return ((((this.userdata == rhs.userdata)||((this.userdata!= null)&&this.userdata.equals(rhs.userdata)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.nodeoutput == rhs.nodeoutput)||((this.nodeoutput!= null)&&this.nodeoutput.equals(rhs.nodeoutput))));
    }

}
