package annotation.structure;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean getSessionFactory(@Autowired HikariDataSource dataSource) {
    	LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
    	lsfb.setDataSource(dataSource);
    	lsfb.setPackagesToScan("annotation.entity", "annotation.hibernateRepository");
    	lsfb.setHibernateProperties(getHibernateProperties());  
    	return lsfb;
    }

    @Bean(name = "transactionManager1")
    @Qualifier("hibernateTX")
    public HibernateTransactionManager getTransactionManager(
    		LocalSessionFactoryBean sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory.getObject());
        return transactionManager;
    }
    
    
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(){
       JpaTransactionManager transactionManager = new JpaTransactionManager();
       transactionManager.setEntityManagerFactory(entityManagerFactory() );
       return transactionManager;
    }
	
    
	private Properties getHibernateProperties() { 
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        
        return properties;
    }
	
	@Bean
	  public EntityManagerFactory entityManagerFactory() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("annotation.entity");
	    factory.setDataSource(getDataSource());
	    factory.afterPropertiesSet();
	    return factory.getObject();
	  }

    @Bean(name = "dataSource")
    public HikariDataSource getDataSource() {
    	HikariDataSource dataSource = new HikariDataSource();
        
        dataSource.addDataSourceProperty( "cachePrepStmts" , "true" );
        dataSource.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        dataSource.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        return dataSource;
    }
}
