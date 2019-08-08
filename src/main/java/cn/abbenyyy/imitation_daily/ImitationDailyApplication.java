package cn.abbenyyy.imitation_daily;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import java.time.Instant;

@SpringBootApplication
public class ImitationDailyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImitationDailyApplication.class, args);
	}

//	@Bean
//	public ServletWebServerFactory servletContainer(){
//		TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//		tomcatServletWebServerFactory.addAdditionalTomcatConnectors(createHTTPConnector());
//		return tomcatServletWebServerFactory;
//	}
//
//	private Connector createHTTPConnector(){
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		connector.setSecure(false);
//		connector.setPort(8080);
//		return connector;
//	}
}
