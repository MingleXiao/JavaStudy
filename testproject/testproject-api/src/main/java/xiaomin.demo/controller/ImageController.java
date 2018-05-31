package xiaomin.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;

@RestController
public class ImageController {

    @RequestMapping(value="/getBase64",method= RequestMethod.GET)
    public String getBase64(){
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream("C:\\Users\\Administrator\\Pictures\\网银支付.PNG");
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }
}
