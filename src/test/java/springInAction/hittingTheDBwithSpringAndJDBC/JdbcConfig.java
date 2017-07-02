package springInAction.hittingTheDBwithSpringAndJDBC;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpittleRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jdbc.JdbcSpitterRepository;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.jdbc.JdbcSpittleRepository;

import javax.sql.DataSource;

/**
 * Created by Asus x556 on 01-Jul-17.
 */
@Configuration
public class JdbcConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2)
                .addScripts("classpath:springInAction/hittingTheDBwithSpringAndJDBC/schema.sql",
                        "classpath:springInAction/hittingTheDBwithSpringAndJDBC/test-data.sql")
        .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpitterRepository(jdbcTemplate);
    }

    @Bean
    public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcSpittleRepository(jdbcTemplate);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
