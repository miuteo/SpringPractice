package springInAction.noSql.mongDB.db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import springInAction.noSql.mongDB.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String>, OrderOperations{
    List<Order> findByCustomer(String customer);
    List<Order> findByCustomerLike(String customer);
    List<Order> findByCustomerAndType(String customer,String type);
    List<Order> getByType(String type);

//    @Query("{customer:'Chuck Wagon',type : ?0}")
//    List<Order> findChucksOrders(String t);
@Query("{customer:'Chuck Wagon'}")
List<Order> findChucksOrders();
}
