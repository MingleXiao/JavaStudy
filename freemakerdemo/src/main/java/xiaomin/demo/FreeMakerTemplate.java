package xiaomin.demo;

import freemarker.template.Template;

import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/12/24.
 */
public class FreeMakerTemplate {
    static String templateString="<h1>Welcome ${user}!</h1>";

    public static void OutPut() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("user", "xiaomin");
        Template t = new Template(null,templateString,null);
        Writer writer = new StringWriter();
        t.process(map, writer);
        System.out.println(writer.toString());
    }
}
