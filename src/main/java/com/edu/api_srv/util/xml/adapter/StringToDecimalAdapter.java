package com.edu.api_srv.util.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class StringToDecimalAdapter extends XmlAdapter<String, BigDecimal> {

    private final String PATTERN = "#,#";

    @Override
    public BigDecimal unmarshal(String s) throws Exception {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat(PATTERN, symbols);
        decimalFormat.setParseBigDecimal(true);

        return (BigDecimal) decimalFormat.parse(s);
    }

    @Override
    public String marshal(BigDecimal bigDecimal) throws Exception {
        return null;
    }
}
