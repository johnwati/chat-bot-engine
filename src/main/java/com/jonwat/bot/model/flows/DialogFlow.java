
package com.jonwat.bot.model.flows;

import java.io.Serializable;
import java.util.HashMap;
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
    "id",
    "name",
    "version",
    "startNode",
    "flowSession",
    "node"
})
@Generated("jsonschema2pojo")
public class DialogFlow implements Serializable
{

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private String version;
    @JsonProperty("startNode")
    private String startNode;
    @JsonProperty("flowSession")
    private FlowSession flowSession;
    @JsonProperty("node")
    private Node node;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8849480396660831576L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DialogFlow() {
    }

    /**
     * 
     * @param node
     * @param flowSession
     * @param startNode
     * @param name
     * @param id
     * @param version
     */
    public DialogFlow(String id, String name, String version, String startNode, FlowSession flowSession, Node node) {
        super();
        this.id = id;
        this.name = name;
        this.version = version;
        this.startNode = startNode;
        this.flowSession = flowSession;
        this.node = node;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("startNode")
    public String getStartNode() {
        return startNode;
    }

    @JsonProperty("startNode")
    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    @JsonProperty("flowSession")
    public FlowSession getFlowSession() {
        return flowSession;
    }

    @JsonProperty("flowSession")
    public void setFlowSession(FlowSession flowSession) {
        this.flowSession = flowSession;
    }

    @JsonProperty("node")
    public Node getNode() {
        return node;
    }

    @JsonProperty("node")
    public void setNode(Node node) {
        this.node = node;
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
        sb.append(DialogFlow.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("startNode");
        sb.append('=');
        sb.append(((this.startNode == null)?"<null>":this.startNode));
        sb.append(',');
        sb.append("flowSession");
        sb.append('=');
        sb.append(((this.flowSession == null)?"<null>":this.flowSession));
        sb.append(',');
        sb.append("node");
        sb.append('=');
        sb.append(((this.node == null)?"<null>":this.node));
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
        result = ((result* 31)+((this.node == null)? 0 :this.node.hashCode()));
        result = ((result* 31)+((this.flowSession == null)? 0 :this.flowSession.hashCode()));
        result = ((result* 31)+((this.startNode == null)? 0 :this.startNode.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DialogFlow) == false) {
            return false;
        }
        DialogFlow rhs = ((DialogFlow) other);
        return ((((((((this.node == rhs.node)||((this.node!= null)&&this.node.equals(rhs.node)))&&((this.flowSession == rhs.flowSession)||((this.flowSession!= null)&&this.flowSession.equals(rhs.flowSession))))&&((this.startNode == rhs.startNode)||((this.startNode!= null)&&this.startNode.equals(rhs.startNode))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))));
    }

}
