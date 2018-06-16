package ave.bertrand.config;

import java.util.UUID;

import org.elasticsearch.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.NodeClientFactoryBean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "ave/bertrand/repository")
public class ElasticsearchConfiguration {

	@Bean
	public NodeClientFactoryBean clientEmbedded() {

		NodeClientFactoryBean bean = new NodeClientFactoryBean(true);
		bean.setClusterName(UUID.randomUUID().toString());
		bean.setEnableHttp(false);
		bean.setPathData("target/elasticsearchTestData");
		bean.setPathHome("src/test/resources/test-home-dir");

		return bean;
	}

	@Bean
	public ElasticsearchTemplate elasticsearchTemplate(Client client) throws Exception {
		return new ElasticsearchTemplate(client);
	}

	/*
	 * @Bean public ElasticsearchOperations elasticsearchTemplate() {
	 * 
	 * ElasticsearchTemplate template = new ElasticsearchTemplate( (Client)
	 * RestClient.builder(new HttpHost("localhost", 9200, "http")).build());
	 * 
	 * return template; }
	 */
}