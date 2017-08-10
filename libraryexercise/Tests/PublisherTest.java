import com.company.entity.Entity;
import com.company.entity.Publisher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class PublisherTest {

    Entity testing;

    @Before
    public void setUp() {
         testing = new Publisher("Oxford", "Oxford Road",
                "Uk", LocalDate.of(1900, Month.JANUARY, 1));
    }

    @Test
    public void setName_Test() {
        Assert.assertNotNull(testing);
        Assert.assertEquals("Oxford", testing.getName());
    }

    @Test
    public void getEstablishedYear_Test() {
        Assert.assertEquals(1900, ((Publisher) testing).getEstablished().getYear());
    }

    @Test
    public void getEstablishedMonth_Test() {
        Assert.assertEquals(Month.JANUARY, ((Publisher) testing).getEstablished().getMonth());
    }

    @Test
    public void getEstablishedDay_Test() {
        Assert.assertEquals(1, ((Publisher) testing).getEstablished().getDayOfMonth());
    }





}
