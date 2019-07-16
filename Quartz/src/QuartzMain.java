import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class QuartzMain {
	
	public static void main(String[] args) throws SchedulerException{
		
		JobDetail Job =	JobBuilder.newJob(QuartzJob.class).build();
		
		//SimpleTrigger
		
		//Trigger t1 = TriggerBuilder.newTrigger().withIdentity("Simple Trigger").startNow().build();
		
		
		// CronTrigger
		
		//Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();
		
		Trigger t1 = TriggerBuilder.newTrigger().withIdentity("CronTrigger").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(05).repeatForever()).build();
		Scheduler sc = StdSchedulerFactory.getDefaultScheduler();
		
		sc.start();
		sc.scheduleJob(Job, t1);
	}

}
