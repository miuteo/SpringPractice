package springInAction.noSql.mongDB.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.web.config.QuerydslWebConfiguration;
import springInAction.noSql.mongDB.Order;

import java.util.List;

public class OrderRepositoryImpl implements OrderOperations {
    @Autowired
    private MongoOperations mongo;

    @Override
    public List<Order> findOrderByType(String t) {
       t = t.equals("NET") ? "WEB" : t;

        Criteria where = Criteria.where("type").is(t);
        Query query = Query.query(where);

        return mongo.find(query, Order.class);
    }
}
