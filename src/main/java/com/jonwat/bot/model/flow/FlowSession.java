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
@Table(name = "flowSessions")
public class FlowSession implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sessionKey")
    private String sessionKey;

    @Column(name = "sessionValue")
    private String sessionvalue;

    @Column(name = "type")
    private String type;

    @Column(name = "flowId")
    private String flowId;

    
}
