package pluralsight.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class PsPlaceholderTaskAppTaskApplication {
	
	@Bean
	public LoggingTask loggingTask(){
		return new LoggingTask();
	}

	public static void main(String[] args) {
		SpringApplication.run(PsPlaceholderTaskAppTaskApplication.class, args);

	}
	
	public class LoggingTask implements CommandLineRunner {
		
		@Override
		public void run(String...strings) throws Exception {
			System.out.println("logging task called, sucka!");
		}
	}
}
