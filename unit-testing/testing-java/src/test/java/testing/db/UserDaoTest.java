package testing.db;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:testing/db/spring.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional(transactionManager = "tx-users")
public class UserDaoTest {

    @Autowired
    private UserDao dao;

    @Test
    public void test_create_1() {
        // check precondition
        assertEquals(0, dao.findAll().size());

        dao.create(1, "John");
    }

    @Test
    public void test_create_2() {
        // check precondition
        assertEquals(0, dao.findAll().size());

        dao.create(2, "Mike");
    }
}
