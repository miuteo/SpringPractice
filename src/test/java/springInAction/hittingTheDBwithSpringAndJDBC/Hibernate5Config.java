package springInAction.hittingTheDBwithSpringAndJDBC;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.hibernate5.HibernateSpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.hibernate5.HibernateSpittleRepository;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by teodor.miu on 03-Jul-17.
 */
@Configuration

public class Hibernate5Config implements TransactionManagementConfigurer{

    @Inject
    private SessionFactory sessionFactory;

    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:springInAction/hittingTheDBwithSpringAndJDBC/schema.sql",
                        "classpath:springInAction/hittingTheDBwithSpringAndJDBC/test-data.sql")
                .build();
    }



    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        System.out.println("sessionFactory="+sessionFactory);
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public SessionFactory sessionFactoryBean(){
        try{
            LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
            lsfb.setDataSource(dataSource());
            lsfb.setPackagesToScan("springInAction.hittingTheDBwithSpringandJDBC.domain");
            Properties props = new Properties();
            props.setProperty("dialect","org.hibernate.dialect.H2Dialect");
//            props.setProperty("current_session_context_class","thread");
            lsfb.setHibernateProperties(props);
            lsfb.afterPropertiesSet();
            SessionFactory obj = lsfb.getObject();
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public SpitterRepository spitterRepository(SessionFactory sessionFactory) {
        return new HibernateSpitterRepository(sessionFactory);
    }
    @Bean
    public SpittleRepository spittleRepository(SessionFactory sessionFactory){
        return new HibernateSpittleRepository(sessionFactory);
    }


}
