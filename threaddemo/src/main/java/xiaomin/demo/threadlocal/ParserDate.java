package xiaomin.demo.threadlocal;

import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParserDate implements Runnable {

    private static final SimpleDateFormat sdf=new SimpleDateFormat();
    int i=0;

    @Override
    public void run() {
        try{
            Date t=sdf.parse("2015-03-29 19:29:"+i%60);
            System.out.println(i +":"+t);
        }catch (ParseException e){
            e.printStackTrace();
        }

    }

    public ParserDate(int i){
        this.i=i;
    }

}
