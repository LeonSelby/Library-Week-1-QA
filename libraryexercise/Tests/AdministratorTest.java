import com.company.Booking;
import com.company.Library;
import com.company.entity.Author;
import com.company.entity.Customer;
import com.company.libraryitems.Book;
import com.company.libraryitems.LibraryItem;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.company.libraryitems.Backing.Hardback;
import static com.company.libraryitems.Genre.Fantasy;
import static org.junit.Assert.*;

public class AdministratorTest {


    Library testing;
    LibraryItem book;
    Author author;
    Customer customer;
    Booking booking;

    @Before
    public void setUp() {
        testing = new Library();
        author = new Author("Ben", "UK",
                LocalDate.of(1993, Month.JANUARY, 1));
        book = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
        customer = new Customer("Leon", "14 Nelson Street", "UK",
                LocalDate.of(2017, Month.AUGUST, 9), 23);
        booking = new Booking(customer, LocalDate.of(2017, Month.JULY, 1));
        booking.addToBooking(book);
    }

    @Test
    public void checkOut_Test() {
        //ADDS BOOKING TO CUSTOMERS ACTIVE BOOKINGS
        booking.getAssociatedCustomer().addToActiveBookings(booking);

        assertTrue(booking.getAssociatedCustomer()
                .getActiveBookings().get(0).getLibraryItems().contains(book));

        //Sets Items in booking to Checked OUT
        booking.getLibraryItems().get(0).setCheckedOut(true);
        assertTrue(booking.getLibraryItems().get(0).isCheckedOut());

    }

    @Test
    public void checkIn_Test() {

        booking.getAssociatedCustomer().removeFromActiveBookings(booking);
        assertFalse(booking.getAssociatedCustomer().getActiveBookings().contains(booking));

        booking.getAssociatedCustomer().addToPrevBookings(booking);
        assertTrue(booking.getAssociatedCustomer().getListOfPrevBookings().contains(booking));

        booking.getLibraryItems().get(0).addToListOfPrevBookings(booking);
        assertTrue(booking.getLibraryItems().get(0).getListOfPrevBookings().contains(booking));

        booking.getLibraryItems().get(0).setCheckedOut(false);
        assertFalse(booking.getLibraryItems().get(0).isCheckedOut());

    }



}
