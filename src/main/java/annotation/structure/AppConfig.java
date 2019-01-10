package annotation.structure;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.data.rest.webmvc.halbrowser.HalBrowser;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@EnableAspectJAutoProxy
@Import({RepositoryRestMvcConfiguration.class,HalBrowser.class})
@ComponentScan(basePackages = { "annotation"})
@EnableJpaRepositories(basePackages={"annotation.repository"})
public class AppConfig implements WebMvcConfigurer {
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.tiles();
    }
	
	@Bean(name = "viewResolver")
    public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions("/WEB-INF/config/tiles.xml");
        return configurer;
    }
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("ultra.audiotele.ru");
		mailSender.setPort(25);
		mailSender.setUsername("");
		mailSender.setPassword("");
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.starttls.enable", "false");
		props.put("mail.debug", "true");
		return mailSender;
	}
}
