/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tm;

import java.time.Duration;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author bregm_000
 */
public class DurationAdapter extends XmlAdapter<Integer, Duration> {

    @Override
    public Duration unmarshal(Integer v) throws Exception {
        if(null==v){
            return null;
       }
        return Duration.parse(v.toString());
    }
    @Override
    public Integer marshal(Duration v) throws Exception {
        return Integer.parseInt("" + v.toMinutes());
    }
}
