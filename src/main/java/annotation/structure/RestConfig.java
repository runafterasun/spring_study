package annotation.structure;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import annotation.entity.Table_temp;
import annotation.projectrions.Test_temp_Projections;
import annotation.repository.TableTempRepository;

@Configuration
public class RestConfig implements RepositoryRestConfigurer{
	
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.getProjectionConfiguration().addProjection(Test_temp_Projections.class);
    }
	
}
