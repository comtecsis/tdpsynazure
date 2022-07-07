package ws.synopsis.clients.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ws.synopsis.clients.dao.converter.ClientAddReqToDaoConverter;
import ws.synopsis.clients.service.converter.ClientDaoToServConverter;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		//Service
		registry.addConverter(new ClientDaoToServConverter());
		//Dao
		registry.addConverter(new ClientAddReqToDaoConverter());
	}

}
