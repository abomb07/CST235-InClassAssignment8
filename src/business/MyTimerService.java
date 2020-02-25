package business;

import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

@Stateless
public class MyTimerService {

	@Resource
    TimerService timerService;
	
	private static final Logger logger = Logger.getLogger("logger");
	
    public MyTimerService() 
    {
    }
    
    public void setTimer(long interval)
    {
    	timerService.createTimer(interval, "Setting a timer");
    }
    
    @Timeout
    public void programmaticTimeout(Timer timer)
    {
    	logger.info("@Timeout in programmaticTimeout() called");
    }
	
	@SuppressWarnings("unused")
	@Schedule(second="*/10", minute="*", hour="0-23", dayOfWeek="Mon-Fri",
      dayOfMonth="*", month="*", year="*", info="MyTimer")
    private void scheduledTimeout(final Timer t) {
        logger.info("@Schedule in scheduledTimeout() called");
    }
}