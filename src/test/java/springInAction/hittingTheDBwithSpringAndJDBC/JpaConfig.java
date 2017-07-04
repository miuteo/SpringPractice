package springInAction.hittingTheDBwithSpringAndJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
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

/**
 * Created by Asus x556 on 03-Jul-17.
 */
@Configuration
public class JpaConfig {
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:springInAction/hittingTheDBwithSpringAndJDBC/schema.sql",
                        "classpath:springInAction/hittingTheDBwithSpringAndJDBC/test-data.sql")
                .build();
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
    @Bean
    public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
//        emf.setPersistenceUnitName("");
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("springInAction.hittingTheDBwithSpringandJDBC.domain");
        return emf;
    }
    @Bean
    public SpitterRepository spitterRepository() {
        return new JpaSpitterRepository();
    }
    @Bean
    public SpittleRepository spittleRepository() {
        return new JpaSpittleRepository();
    }

    @Configuration
    @EnableTransactionManagement
    public static class TransactionConfig implements TransactionManagementConfigurer {
        @Inject
        private EntityManagerFactory emf;

        public PlatformTransactionManager annotationDrivenTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(emf);
            return transactionManager;
        }
    }
}
