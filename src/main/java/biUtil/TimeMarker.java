package biUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMarker {
    public String timer(){
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("YYMMdd_hhmmss");
        String time = ft.format(dNow);
        return time;
    }
}
