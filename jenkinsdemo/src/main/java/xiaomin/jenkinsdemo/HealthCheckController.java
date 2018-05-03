package xiaomin.jenkinsdemo;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.offbytwo.jenkins.model.QueueReference;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/**
 */
@RestController
public class HealthCheckController {
	private static final Log logger = LogFactory.getLog(HealthCheckController.class);

	/**
	 * 健康检查
	 */
	@ApiOperation(value="健康检查服务", notes="正常返回200,异常返回500")
    @RequestMapping(value="/healthCheck",method= RequestMethod.GET)
    public Object healthCheck(HttpServletResponse response){
    	HashMap<String,String> resultMap = new HashMap<String,String>();
    	try {
			response.setStatus(HttpServletResponse.SC_OK);
			resultMap.put("result", "success");
		}catch (Exception e) {
			logger.error("健康检查异常: " , e);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resultMap.put("result", "error");
		}
		return resultMap;
    }
    
    /**
     * 当前版本号
     * @return
     */
	@ApiOperation(value="当前版本号服务", notes="返回当前服务版本号")
    @RequestMapping(value="/currentVersion",method= RequestMethod.GET)
    public String currentVersion(){
        return "1.0";
    }

	@ApiOperation(value="构建job", notes="构建job")
	@RequestMapping(value="/buildJob",method= RequestMethod.GET)
    public String buildJob(String jobName){
		try {
			JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "admin", "ea7004637aac48fa879ede0b8931b427");
			JobWithDetails job= jenkins.getJob(jobName);
			int nextBuildNumber= job.getNextBuildNumber();
			QueueReference queueReference= job.build(true);

			return String.valueOf(nextBuildNumber);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	@ApiOperation(value="getBuildInfo", notes="getBuildInfo")
	@RequestMapping(value="/getBuildInfo",method= RequestMethod.GET)
	public String getBuildInfo(String jobName,int buildNumber){
		try {
			JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080"), "admin", "ea7004637aac48fa879ede0b8931b427");
			JobWithDetails job= jenkins.getJob(jobName);
			Build build= job.getBuildByNumber(buildNumber);

			return build.details().getConsoleOutputText();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}
}

