package com.jonwat.bot.model.flow;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.String;

@Entity
@Table(name = "flowActions")
public class FlowAction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nodeId")
    private String nodeId;

    @Column(name = "methodType")
    private String methodType;

    @Column(name = "language")
    private String language;

    @Column(name = "script")
    private String script;

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setMethodType(String methodType) {
        this.methodType = methodType;
    }

    public String getMethodType() {
        return methodType;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getScript() {
        return script;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
