package springInAction.noSql.mongDB.db;

import springInAction.noSql.mongDB.Order;

import java.util.List;

public interface OrderOperations {
    List<Order> findOrderByType(String t);
}
