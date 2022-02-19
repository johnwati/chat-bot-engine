package com.jonwat.bot.model.flow;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import java.lang.String;
import lombok.Data;

@Data
@Entity
@Table(name = "nextNodes")
public class NextNode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nodeId")
    private String nodeId;

    @Column(name = "NextNodeId")
    private String NextNodeId;

    @Column(name = "OutPut")
    private String OutPut;

    @Column(name = "transitionCondition")
    private String transitionCondition;
 
}
