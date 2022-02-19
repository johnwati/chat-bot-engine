package com.jonwat.bot.model.flow;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.String;
import lombok.Data;

@Data
@Entity
@Table(name = "nodes")
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "flowId")
    private String flowId;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "transitionCondition")
    private String transitionCondition;

    @Column(name = "nodeClass")
    private String nodeClass;

    @Column(name = "html")
    private String html;

    @Column(name = "prevNode")
    private String prevNode;

    @Column(name = "nextNode")
    private String nextNode;

    @Column(name = "onEnter")
    private String onEnter;

    @Column(name = "onReceive")
    private String onReceive;
 
}
