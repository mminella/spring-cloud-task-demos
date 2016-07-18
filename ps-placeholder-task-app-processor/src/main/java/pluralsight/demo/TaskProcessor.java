package pluralsight.demo;


//import org.springframework.cloud.stream.messaging.Processor; Source for apps with single outbound, Sink for apps with single inbound, processor for both
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.annotation.Transformer;
//import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;

//@EnableBinding(Processor.class)
@EnableBinding(Source.class)
public class TaskProcessor {
	
	
	@Transformer(outputChannel = Source.OUTPUT)
	@InboundChannelAdapter(value = Source.OUTPUT,  poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
	public Object setupRequest() {
		
		String url = "maven://com.example:task-app-task:jar:0.0.1-SNAPSHOT";
		
		TaskLaunchRequest request = new TaskLaunchRequest(url, null, null, null);
		
		System.out.println("created task launch request ...");
		
		return new GenericMessage<TaskLaunchRequest>(request);
	}
	
}
