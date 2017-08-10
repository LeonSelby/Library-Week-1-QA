import com.company.Booking;
import com.company.Library;
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

public class BookingTest {

    Booking testing;
    Entity customer;
    LibraryItem book;
    Entity author = new Author("Ben", "UK",
            LocalDate.of(1993, Month.JANUARY, 1));

    @Before
    public void setUp() {
        customer = new Customer("Leon", "14 Nelson Street", "UK",
                LocalDate.of(2017, Month.AUGUST, 9), 23);
        testing = new Booking((Customer)customer, LocalDate.of(2017, Month.AUGUST, 8));
        book = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
    }

    @Test
    public void getStartDate_Test() {
        LocalDate tmp = LocalDate.of(2017, Month.AUGUST, 9);
        Assert.assertEquals(tmp, testing.getStartDate());
    }

    @Test
    public void addToBooking_Test() {
        testing.getLibraryItems().add(book);
        Assert.assertTrue(testing.getLibraryItems().contains(book));
    }

    @Test
    public void removeFromBooking_Test() {
        testing.getLibraryItems().add(book);
        testing.getLibraryItems().remove(book);
        Assert.assertFalse(testing.getLibraryItems().contains(book));
    }

    @Test
    public void getDueDate_Test(){
       LocalDate tmp = LocalDate.of(2017,Month.AUGUST,22);
        Assert.assertEquals(tmp,testing.getStartDate().plusDays(testing.getDurationInDays()));
    }

    @Test
    public void setAccCustomer(){
        testing.setAssociatedCustomer((Customer)customer);
        Assert.assertEquals(customer, testing.getAssociatedCustomer());
    }

}
