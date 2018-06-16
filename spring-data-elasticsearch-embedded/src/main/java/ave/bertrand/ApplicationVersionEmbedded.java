package ave.bertrand;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ApplicationVersionEmbedded {

	private static final Logger log = LoggerFactory.getLogger(ApplicationVersionEmbedded.class);

	public static void main(String args[]) {
		SpringApplication app = new SpringApplication(ApplicationVersionEmbedded.class);
		Environment env = app.run(args).getEnvironment();

		String host = env.getProperty("server.address");
		String contextPath = env.getProperty("server.contextPath");
		String serverPort = env.getProperty("server.port");

		log.info("\n\nAccess URLs:\n----------------------------------------\n\tLocal: \t\thttp://{}:{}{}\n\n", host,
				serverPort, contextPath);
		log.info("http://localhost:8080/swagger-ui.html");
	}
}
