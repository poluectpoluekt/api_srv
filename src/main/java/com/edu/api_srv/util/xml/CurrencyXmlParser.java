package com.edu.api_srv.util.xml;

import com.edu.api_srv.dto.cbr.RequestCurrencyDto;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class CurrencyXmlParser {

    public RequestCurrencyDto toObject(String xml){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(RequestCurrencyDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (RequestCurrencyDto) unmarshaller.unmarshal(new StringReader(xml));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }


}
