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
@Table(name = "nodeUserInputs")
public class NodeUserInput implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "inputKey")
    private String inputKey;

    @Column(name = "inputValue")
    private String inputValue;

    @Column(name = "nodeId")
    private String nodeId;
 
}
