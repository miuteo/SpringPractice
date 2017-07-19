package springInAction.hittingTheDBwithSpringAndJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jpa.JpaSpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jpa.JpaSpittleRepository;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages="springInAction.hittingTheDBwithSpringandJDBC.domain.db.springDataJpa")
public class SpringDataJpaConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:springInAction/hittingTheDBwithSpringAndJDBC/schema.sql",
                        "classpath:springInAction/hittingTheDBwithSpringAndJDBC/test-data.sql")
                .build();
    }
    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("springInAction.hittingTheDBwithSpringandJDBC.domain");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }




    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return adapter;
    }

}
