package springInAction.hittingTheDBwithSpringandJDBC.domain.db.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import springInAction.hittingTheDBwithSpringandJDBC.domain.Spitter;
import springInAction.hittingTheDBwithSpringandJDBC.domain.db.SpitterRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Asus x556 on 01-Jul-17.
 */
public class JdbcSpitterRepository implements SpitterRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    @Override
    public long count() {
        return jdbcTemplate.queryForObject("select count(id) from Spitter",Long.class);
    }

    @Override
    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if(id == null){
            long spitterId = insertSpitterAndReturnId(spitter);
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(), spitter.getFullName(), spitter.getEmail(), spitter.isUpdateByEmail());

        }else{
            jdbcTemplate.update("update Spitter set username=?, password=?, fullname=?, email=?, updateByEmail=? where id=?",
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFullName(),
                    spitter.getEmail(),
                    spitter.isUpdateByEmail(),
                    id);
        }
        return spitter;
    }

    private long insertSpitterAndReturnId(Spitter spitter){
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("Spitter");
        jdbcInsert.setGeneratedKeyName("id");

        Map<String, Object> args = new HashMap<>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("fullname", spitter.getFullName());
        args.put("email", spitter.getEmail());
        args.put("updateByEmail", spitter.isUpdateByEmail());

        long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
        return spitterId;

    }

    @Override
    public Spitter findOne(long id) {
        return jdbcTemplate.queryForObject(
                SELECT_SPITTER + " where id=?", new SpitterRowMapper(), id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return jdbcTemplate.queryForObject("select id, username, password, fullname, email, updateByEmail from Spitter where username=?", new SpitterRowMapper(), username);
    }

    @Override
    public List<Spitter> findAll() {
        return jdbcTemplate.query("select id, username, password, fullname, email, updateByEmail from Spitter order by id", new SpitterRowMapper());
    }



    private static final class SpitterRowMapper implements RowMapper<Spitter>{
        @Override
        public Spitter mapRow(ResultSet rs, int i) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullname");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullName, email, updateByEmail);

        }
    }

    private static final String INSERT_SPITTER  ="insert into Spitter(username,password,fullname,email,updateByEmail) values(?,?,?,?,?)";
    private static final String SELECT_SPITTER = "select id, username, password, fullname, email, updateByEmail from Spitter";

}