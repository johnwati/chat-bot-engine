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
@Table(name = "nodeSessions")
public class NodeSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "SessionKey")
    private String SessionKey;

    @Column(name = "SessionValue")
    private String SessionValue;

    @Column(name = "nodeId")
    private String nodeId;

    @Column(name = "sessionId")
    private String sessionId;
 
}
