package springInAction.hittingTheDBwithSpringAndJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;

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
        emf.setPersistenceUnitName("");//TODO
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("springInAction.hittingTheDBwithSpringandJDBC.domain");
        return emf;
    }
}
