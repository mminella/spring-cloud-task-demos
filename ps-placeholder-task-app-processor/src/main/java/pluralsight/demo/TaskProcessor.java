package pluralsight.demo;


//import org.springframework.cloud.stream.messaging.Processor; Source for apps with single outbound, Sink for apps with single inbound, processor for both
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;


//@EnableBinding(Processor.class)
@Component
@EnableBinding(Source.class)
public class TaskProcessor {
	
	@Autowired
	private Source source;
	
	//@Autowired
	//private MessageChannel output;
	
	//@Autowired
	//private TaskChannels taskChannels;
	
	//@Transformer(outputChannel = Source.OUTPUT)
//	@InboundChannelAdapter(value = Source.OUTPUT,  poller = @Poller(fixedDelay = "10000", maxMessagesPerPoll = "1"))
//	public Object setupRequest() {
//		
//		String url = "maven://com.example:task-app-task:jar:0.0.1-SNAPSHOT";
//		
//		TaskLaunchRequest request = new TaskLaunchRequest(url, null, null, null);
//		
//		System.out.println("created task launch request ...");
//		
//		return new GenericMessage<TaskLaunchRequest>(request);
//	}
	
//	@Bean
//	public String setupRequest() {
//		
//		String url = "maven://com.example:task-app-task:jar:0.0.1-SNAPSHOT";
//		
//		TaskLaunchRequest request = new TaskLaunchRequest(url, null, null, null);
//		
//		System.out.println("created task launch request ...");
//		
//		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
//		this.source.output().send(message);
//		
//		//output.send(message);
//		
//		//taskChannels.save().send(message);
//		
//		return "success";
//	}
	
	public void setupRequest() {
		
		String url = "maven://com.example:task-app-task:jar:0.0.1-SNAPSHOT";
		
		TaskLaunchRequest request = new TaskLaunchRequest(url, null, null, null);
		
		System.out.println("created task launch request ...");
		
		GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
		this.source.output().send(message);
	}

}
