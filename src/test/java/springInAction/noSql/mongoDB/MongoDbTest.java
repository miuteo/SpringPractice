package springInAction.noSql.mongoDB;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springInAction.noSql.mongDB.Item;
import springInAction.noSql.mongDB.Order;
import springInAction.noSql.mongDB.config.MongoConfig;
import springInAction.noSql.mongDB.db.OrderRepository;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration(classes=MongoConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MongoDbTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    MongoOperations mongoOps;

    @Before
    public void cleanup(){
        orderRepository.deleteAll();
    }

    @Test
    public void testMongoRepository(){
        Assert.assertEquals(0,orderRepository.count());

        Order order = createAnOrder();

        Order savedOrder = orderRepository.save(order);
        Assert.assertEquals(1, orderRepository.count());

        List<Order> netOrders  = orderRepository.findOrderByType("NET");
        Assert.assertEquals(1,netOrders.size());

        Order foundOrder = orderRepository.findOne(savedOrder.getId());
        Assert.assertEquals("Chuck Wagon", foundOrder.getCustomer());
        Assert.assertEquals(2, foundOrder.getItems().size());

        // Finding an order by a single field value
        List<Order> chucksOrders = orderRepository.findByCustomer("Chuck Wagon");
        Assert.assertEquals(1, chucksOrders.size());
        Assert.assertEquals("Chuck Wagon", chucksOrders.get(0).getCustomer());
        Assert.assertEquals(2, chucksOrders.get(0).getItems().size());

        // Finding an order by a single field value like
        List<Order> chuckLikeOrders = orderRepository.findByCustomerLike("Chuck");
        Assert.assertEquals(1, chuckLikeOrders.size());
        Assert.assertEquals("Chuck Wagon", chuckLikeOrders.get(0).getCustomer());
        Assert.assertEquals(2, chuckLikeOrders.get(0).getItems().size());

        // Finding an order by multiple field values
        List<Order> chucksWebOrders = orderRepository.findByCustomerAndType("Chuck Wagon", "WEB");
        Assert.assertEquals(1, chucksWebOrders.size());
        Assert.assertEquals("Chuck Wagon", chucksWebOrders.get(0).getCustomer());
        Assert.assertEquals(2, chucksWebOrders.get(0).getItems().size());

        List<Order> chucksPhoneOrders = orderRepository.findByCustomerAndType("Chuck Wagon", "PHONE");
        Assert.assertEquals(0, chucksPhoneOrders.size());

        // Finding an order by a custom query method
        List<Order> chucksOrders2 = orderRepository.findChucksOrders();
        Assert.assertEquals(1, chucksOrders2.size());
        Assert.assertEquals("Chuck Wagon", chucksOrders2.get(0).getCustomer());
        Assert.assertEquals(2, chucksOrders2.get(0).getItems().size());

        savedOrder.setType("AAA");
        orderRepository.save(savedOrder);
        Assert.assertEquals(1, orderRepository.count());
        // Deleting an order
        orderRepository.delete(savedOrder.getId());
        Assert.assertEquals(0, orderRepository.count());
    }

    private Order createAnOrder() {
        Order order = new Order();
        order.setCustomer("Chuck Wagon");
        order.setType("WEB");
        Item item1 = new Item();
        item1.setProduct("Spring in Action");
        item1.setQuantity(2);
        item1.setPrice(29.99);
        Item item2 = new Item();
        item2.setProduct("Module Java");
        item2.setQuantity(31);
        item2.setPrice(29.95);
        order.setItems(Arrays.asList(item1, item2));
        return order;
    }
}
