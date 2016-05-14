package tm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bregm_000
 */
public class LocalDateTimeAdapter extends XmlAdapter <String, LocalDateTime>{
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
    @Override
    public LocalDateTime unmarshal(String v) throws Exception {
        if(null==v || v.isEmpty()){
            return LocalDateTime.parse("");
        }
        LocalDateTime ldt = LocalDateTime.parse(v, dtf);
        return ldt;
    }
    
    @Override
    public String marshal(LocalDateTime v) throws Exception {
        if(null==v){
            return "";
        }
        return v.format(dtf);
    }    
}
