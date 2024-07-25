package com.edu.api_srv.entity.currency;

import com.edu.api_srv.util.xml.adapter.StringToDecimalAdapter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Currency {

    private int numCode;
    private String charCode;
    private BigDecimal value;
    private String ID;

    @XmlElement(name = "NumCode")
    public int getNumCode() {
        return numCode;
    }

    @XmlElement(name = "CharCode")
    public String getCharCode() {
        return charCode;
    }

    @XmlElement(name = "Value")
    @XmlJavaTypeAdapter(StringToDecimalAdapter.class)
    public BigDecimal getValue() {
        return value;
    }

    @XmlAttribute(name = "ID")
    public String getID() {
        return ID;
    }
}
