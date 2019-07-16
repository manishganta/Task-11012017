import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


public class QuartzJob implements Job{
	public void execute(JobExecutionContext arg0) throws JobExecutionException{
		
		System.out.println("Hey, Welcome to see my page");
		System.out.println(new Date());
	}

}
