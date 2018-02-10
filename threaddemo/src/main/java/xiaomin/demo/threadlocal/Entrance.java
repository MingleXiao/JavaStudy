package xiaomin.demo.threadlocal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController
public class Entrance {

    @RequestMapping(value = "threadlocal/entrance" ,method = RequestMethod.GET)
    public static void run(){
        ExecutorService es= Executors.newFixedThreadPool(10);

        for(int i=0;i<1000;i++){
            es.execute(new ParserDate(i));
        }
    }
}
