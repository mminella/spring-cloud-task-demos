package pluralsight.demo;

import javax.management.MBeanServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.monitor.IntegrationMBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication
@EnableTaskLauncher
public class PsPlaceholderTaskAppSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PsPlaceholderTaskAppSinkApplication.class, args);
	}
	
	@Bean
	 public IntegrationMBeanExporter integrationMbeanExporter(
	               @Value("spring.jmx.default-domain") String domain, 
	               MBeanServer mBeanServer) {
	           IntegrationMBeanExporter exporter = new IntegrationMBeanExporter();
	           exporter.setDefaultDomain(domain);
	           exporter.setServer(mBeanServer);
	           return exporter;
	}

	@Bean
	@Primary
	public AnnotationMBeanExporter mbeanExporter(ObjectNamingStrategy namingStrategy, MBeanServer mBeanServer) {
	        AnnotationMBeanExporter exporter = new AnnotationMBeanExporter();
	        exporter.setRegistrationPolicy(RegistrationPolicy.FAIL_ON_EXISTING);
	        exporter.setNamingStrategy(namingStrategy);
	        exporter.setServer(mBeanServer);
	        return exporter;
	}
}


