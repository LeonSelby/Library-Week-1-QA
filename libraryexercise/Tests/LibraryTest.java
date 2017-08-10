import com.company.Library;
import com.company.entity.Author;
import com.company.entity.Customer;
import com.company.libraryitems.Book;
import com.company.libraryitems.LibraryItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

import static com.company.libraryitems.Backing.Hardback;
import static com.company.libraryitems.Genre.Fantasy;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    Library testing;
    LibraryItem book;
    Author author;
    Customer customer;

    @Before
    public void setUp() {
        testing = new Library();
        author = new Author("Ben", "UK",
                LocalDate.of(1993, Month.JANUARY, 1));
        book = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
        customer = new Customer("Leon", "14 Nelson Street", "UK",
                LocalDate.of(2017, Month.AUGUST, 9), 23);
    }

    @Test
    public void addItemToInv() {
        testing.getInventoryList().add(book);
        assertTrue(testing.getInventoryList().contains(book));
    }

    @Test
    public void removeItemFromList() {
        testing.getInventoryList().add(book);
        assertTrue(testing.getInventoryList().contains(book));
        testing.getInventoryList().remove(book);
        Assert.assertFalse(testing.getInventoryList().contains(book));
    }

    @Test
    public void addCustomer_Test() {
        testing.getCustomerList().add(customer);
        assertTrue(testing.getCustomerList().contains(customer));
    }

    @Test
    public void removeCustomer_Test() {
        testing.getCustomerList().remove(customer);
        assertTrue(!testing.getCustomerList().contains(customer));
    }
}
