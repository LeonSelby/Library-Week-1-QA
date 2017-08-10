import com.company.entity.Author;
import com.company.entity.Entity;
import org.junit.*;

import java.time.LocalDate;
import java.time.Month;

public class AuthorTest {

Entity testing;

    @Before
    public void setUp() {
     testing = new Author("Leon", "UK", LocalDate.of(1993, Month.DECEMBER, 9));
}

    @Test
    public void setName_Test() {

        Assert.assertNotNull(testing);
        Assert.assertEquals("Leon", testing.getName());
    }

    @Test
    public void setCountry_Test() {
        Assert.assertEquals("UK", testing.getCountry());
    }

    @Test
    public void setDateYear_Test(){
        Assert.assertEquals(1993, ((Author)testing).getDateOfBirth().getYear());
}

    @Test
    public void setDateMonth_Test(){
        Assert.assertEquals(Month.DECEMBER, ((Author)testing).getDateOfBirth().getMonth());
    }

    @Test
    public void setDateDayDate_Test(){
        Assert.assertEquals(9, ((Author)testing).getDateOfBirth().getDayOfMonth());
    }


}
