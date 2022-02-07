
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
    "id",
    "name",
    "data",
    "class",
    "html",
    "typenode",
    "input",
    "output",
    "onEnter",
    "onReceive",
    "pos_x",
    "pos_y"
})
@Generated("jsonschema2pojo")
public class Node implements Serializable
{

    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("html")
    private String html;
    @JsonProperty("typenode")
    private Boolean typenode;
    @JsonProperty("input")
    private PreviousNode input;
    @JsonProperty("output")
    private NextNode output;
    @JsonProperty("onEnter")
    private List<String> onEnter = null;
    @JsonProperty("onReceive")
    private List<String> onReceive = null;
    @JsonProperty("pos_x")
    private Long posX;
    @JsonProperty("pos_y")
    private Long posY;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -547358370215540081L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Node() {
    }

    /**
     * 
     * @param typenode
     * @param output
     * @param posX
     * @param input
     * @param onEnter
     * @param posY
     * @param data
     * @param name
     * @param html
     * @param id
     * @param _class
     * @param onReceive
     */
    public Node(Long id, String name, Data data, String _class, String html, Boolean typenode, PreviousNode input, NextNode output, List<String> onEnter, List<String> onReceive, Long posX, Long posY) {
        super();
        this.id = id;
        this.name = name;
        this.data = data;
        this._class = _class;
        this.html = html;
        this.typenode = typenode;
        this.input = input;
        this.output = output;
        this.onEnter = onEnter;
        this.onReceive = onReceive;
        this.posX = posX;
        this.posY = posY;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
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

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("typenode")
    public Boolean getTypenode() {
        return typenode;
    }

    @JsonProperty("typenode")
    public void setTypenode(Boolean typenode) {
        this.typenode = typenode;
    }

    @JsonProperty("input")
    public PreviousNode getInput() {
        return input;
    }

    @JsonProperty("input")
    public void setInput(PreviousNode input) {
        this.input = input;
    }

    @JsonProperty("output")
    public NextNode getOutput() {
        return output;
    }

    @JsonProperty("output")
    public void setOutput(NextNode output) {
        this.output = output;
    }

    @JsonProperty("onEnter")
    public List<String> getOnEnter() {
        return onEnter;
    }

    @JsonProperty("onEnter")
    public void setOnEnter(List<String> onEnter) {
        this.onEnter = onEnter;
    }

    @JsonProperty("onReceive")
    public List<String> getOnReceive() {
        return onReceive;
    }

    @JsonProperty("onReceive")
    public void setOnReceive(List<String> onReceive) {
        this.onReceive = onReceive;
    }

    @JsonProperty("pos_x")
    public Long getPosX() {
        return posX;
    }

    @JsonProperty("pos_x")
    public void setPosX(Long posX) {
        this.posX = posX;
    }

    @JsonProperty("pos_y")
    public Long getPosY() {
        return posY;
    }

    @JsonProperty("pos_y")
    public void setPosY(Long posY) {
        this.posY = posY;
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
        sb.append(Node.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("data");
        sb.append('=');
        sb.append(((this.data == null)?"<null>":this.data));
        sb.append(',');
        sb.append("_class");
        sb.append('=');
        sb.append(((this._class == null)?"<null>":this._class));
        sb.append(',');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("typenode");
        sb.append('=');
        sb.append(((this.typenode == null)?"<null>":this.typenode));
        sb.append(',');
        sb.append("input");
        sb.append('=');
        sb.append(((this.input == null)?"<null>":this.input));
        sb.append(',');
        sb.append("output");
        sb.append('=');
        sb.append(((this.output == null)?"<null>":this.output));
        sb.append(',');
        sb.append("onEnter");
        sb.append('=');
        sb.append(((this.onEnter == null)?"<null>":this.onEnter));
        sb.append(',');
        sb.append("onReceive");
        sb.append('=');
        sb.append(((this.onReceive == null)?"<null>":this.onReceive));
        sb.append(',');
        sb.append("posX");
        sb.append('=');
        sb.append(((this.posX == null)?"<null>":this.posX));
        sb.append(',');
        sb.append("posY");
        sb.append('=');
        sb.append(((this.posY == null)?"<null>":this.posY));
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
        result = ((result* 31)+((this.typenode == null)? 0 :this.typenode.hashCode()));
        result = ((result* 31)+((this.data == null)? 0 :this.data.hashCode()));
        result = ((result* 31)+((this.onReceive == null)? 0 :this.onReceive.hashCode()));
        result = ((result* 31)+((this.output == null)? 0 :this.output.hashCode()));
        result = ((result* 31)+((this.posX == null)? 0 :this.posX.hashCode()));
        result = ((result* 31)+((this.input == null)? 0 :this.input.hashCode()));
        result = ((result* 31)+((this.onEnter == null)? 0 :this.onEnter.hashCode()));
        result = ((result* 31)+((this.posY == null)? 0 :this.posY.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.html == null)? 0 :this.html.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this._class == null)? 0 :this._class.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Node) == false) {
            return false;
        }
        Node rhs = ((Node) other);
        return ((((((((((((((this.typenode == rhs.typenode)||((this.typenode!= null)&&this.typenode.equals(rhs.typenode)))&&((this.data == rhs.data)||((this.data!= null)&&this.data.equals(rhs.data))))&&((this.onReceive == rhs.onReceive)||((this.onReceive!= null)&&this.onReceive.equals(rhs.onReceive))))&&((this.output == rhs.output)||((this.output!= null)&&this.output.equals(rhs.output))))&&((this.posX == rhs.posX)||((this.posX!= null)&&this.posX.equals(rhs.posX))))&&((this.input == rhs.input)||((this.input!= null)&&this.input.equals(rhs.input))))&&((this.onEnter == rhs.onEnter)||((this.onEnter!= null)&&this.onEnter.equals(rhs.onEnter))))&&((this.posY == rhs.posY)||((this.posY!= null)&&this.posY.equals(rhs.posY))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.html == rhs.html)||((this.html!= null)&&this.html.equals(rhs.html))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this._class == rhs._class)||((this._class!= null)&&this._class.equals(rhs._class))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
