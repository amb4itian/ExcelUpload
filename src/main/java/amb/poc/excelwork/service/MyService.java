package amb.poc.excelwork.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@org.springframework.stereotype.Service
public class MyService {

    public Date getDate(String DDMMYYYY) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        return format.parse(DDMMYYYY);
    }
}
