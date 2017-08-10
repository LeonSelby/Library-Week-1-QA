import com.company.Booking;
import com.company.entity.Author;
import com.company.entity.Customer;
import com.company.entity.Entity;
import com.company.libraryitems.Book;
import com.company.libraryitems.LibraryItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.company.libraryitems.Backing.Hardback;
import static com.company.libraryitems.Genre.Fantasy;

// Do Generate Report Test

public class CustomerTest {

    private Entity testing;
    LibraryItem book;
    LibraryItem book2;

    Author author;
    Booking booking;
    Booking booking2;


    @Before
    public void setUp() {
        testing = new Customer("Leon", "14 Nelson Street", "UK",
                LocalDate.of(2017, Month.AUGUST, 9), 23);
        author = new Author("Ben", "UK",
                LocalDate.of(1993, Month.JANUARY, 1));
        book = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
        book2 = new Book("Moby Dick2", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
       booking = new Booking((Customer)testing, LocalDate.of(2017, Month.JULY, 1));

       booking2 = new Booking((Customer)testing, LocalDate.of(2017, Month.JULY, 1));

       booking.addToBooking(book);
       booking2.addToBooking(book2);
    }

    @Test
    public void setName_Test() {
        Assert.assertNotNull(testing);
        Assert.assertEquals("Leon", testing.getName());
    }

    @Test
    public void setAddressLn1_Test() {
        Assert.assertEquals("14 Nelson Street", testing.getAddressLine1());
    }

    @Test
    public void setCountry_Test() {
        Assert.assertEquals("UK", testing.getCountry());
    }

    @Test
    public void setDateYear_Test() {
        Assert.assertEquals(2017, ((Customer) testing).getDateJoined().getYear());
    }

    @Test
    public void setDateMonth_Test() {
        Assert.assertEquals(Month.AUGUST, ((Customer) testing).getDateJoined().getMonth());
    }

    @Test
    public void setDateDayDate_Test() {
        Assert.assertEquals(9, ((Customer) testing).getDateJoined().getDayOfMonth());
    }

    @Test
    public void isOver18_Test() {
        Assert.assertEquals(true, ((Customer) testing).isOver18());
    }

    @Test
    public void isAnOAP_Test() {
        Assert.assertEquals(false, ((Customer) testing).isAnOAP());
    }

    @Test
    public void isVIP_Test() {
        Assert.assertEquals(false, ((Customer) testing).isVip());
    }

    @Test
    public void setIsVIP_Test() {
        ((Customer) testing).setVip(true);
        Assert.assertEquals(true, ((Customer) testing).isVip());
    }

    @Test
    public void getActiveBookings() {
        Assert.assertEquals(null, ((Customer) testing).getActiveBookings());
    }

    @Test
    public void addToActiveBookings(){
        ((Customer)testing).getActiveBookings().add(booking);
        Assert.assertTrue(((Customer) testing).getActiveBookings().contains(booking));
    }

    @Test
    public void removeFromActiveBookings(){
        ((Customer)testing).getActiveBookings().remove(booking);
        Assert.assertFalse(((Customer)testing).getActiveBookings().contains(booking));
    }

@Test
    public void generateReportCustomer_Test(){
    ((Customer)testing).addToActiveBookings(booking);
    ((Customer)testing).addToPrevBookings(booking2);
        String tmp = "";
    String membership = " ";
    String renting = "";
    String rented = "";
    if (((Customer)testing).isVip()) {
        membership = "VIP";
    } else {
        membership = "Standard";
    }

    for (LibraryItem li : ((Customer)testing).getActiveBookings().get(0).getLibraryItems()) {
        renting += " "+li.getTitle();
    }

    for (Booking b : ((Customer)testing).getListOfPrevBookings()) {

        for (LibraryItem li : b.getLibraryItems()) {
            rented += " "+li.getTitle();
        }
    }
    tmp += testing.getClass().getSimpleName()+ " Report:\n" +
            "Name: " + testing.getName() +
            "\nAge: " + ((Customer)testing).getAge() +
            "\nMembership: " + membership +
            "\nCurrently has:" + renting + "." +
            "\nAnd has previously rented: " + rented + ".";

    System.out.println(tmp);
    }
}
