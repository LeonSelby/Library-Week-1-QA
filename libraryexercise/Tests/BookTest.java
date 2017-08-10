import com.company.Booking;
import com.company.entity.Author;
import com.company.entity.Customer;
import com.company.entity.Entity;
import com.company.libraryitems.Book;
import com.company.libraryitems.Genre;
import com.company.libraryitems.LibraryItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.company.libraryitems.Backing.*;
import static com.company.libraryitems.Genre.*;

public class BookTest {

    LibraryItem testing;
    Entity author = new Author("Ben", "UK",
            LocalDate.of(1993, Month.JANUARY, 1));
    Booking booking;
    Customer customer;

    @Before
    public void setUp() {
        testing = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
        customer = new Customer("Leon", "14 Nelson Street", "UK",
                LocalDate.of(2017, Month.AUGUST,9), 23);
        booking = new Booking(customer, LocalDate.of(2017, Month.AUGUST, 9));
    }

    @After
    public void setDown(){
        LibraryItem.totalID = 1;
    }

    @Test
    public void setName_Test() {
        Assert.assertNotNull("Not null", testing);
        Assert.assertEquals("Moby Dick", testing.getTitle());
    }

    @Test
    public void setSource_Test() {
        Assert.assertEquals(author, testing.getSource());
    }

    @Test
    public void addGenre_Test() {
        ((Book) testing).addGenre(Horror);
        boolean working = false;
        for (Genre g : ((Book) testing).getGenre()) {
            if (g.equals(Horror)) {
                working = true;
            }
        }
        Assert.assertTrue("Genre was not added", working);
    }

    @Test
    public void removeGenre_Test() {
        ((Book) testing).addGenre(Horror);
        ((Book) testing).removeGenre(Horror);
        boolean present = false;
        for (Genre g : ((Book) testing).getGenre()) {
            if (g.equals(Horror)) {
                present = true;
            }
        }
        Assert.assertFalse("Genre was not removed", present);
    }

    @Test
    public void getBacking_Test() {
        Assert.assertEquals(Hardback, ((Book) testing).getBacking());
    }

    @Test
    public void setBacking_Test() {
        ((Book)testing).setBacking(Paperback);
        Assert.assertEquals(Paperback, ((Book) testing).getBacking());
    }

    @Test
    public void hasGenre_Test() {
        Assert.assertTrue("Fantasy not present", ((Book) testing).hasGenre(Fantasy));
    }

    //Library Item Tests
    @Test
    public void getItemID_Test() {
        Assert.assertEquals(1, testing.getItemID());

        LibraryItem b = new Book("Moby Dick", author,
                LocalDate.of(1993, Month.DECEMBER, 31), Fantasy, Hardback);
        Assert.assertEquals(2, b.getItemID());
    }

    @Test
    public void  getPublishDate_Test(){
        Assert.assertEquals(LocalDate.of(1993, Month.DECEMBER, 31),
                testing.getPublishDate());
    }

    @Test
    public void setCheckOut_Test(){
        testing.setCheckedOut(true);
        Assert.assertTrue("Not true", testing.isCheckedOut());
}
    @Test
    public void setReserved_Test(){
        testing.setReserved(true);
        Assert.assertTrue("Not true", testing.isReserved());
    }

    @Test
    public void addToListOfPrevBookings_Test(){
        testing.addToListOfPrevBookings(booking);
        boolean present = false;
        for (Booking b : testing.getListOfPrevBookings()) {
            if (b.equals(booking)) {
                present = true;
            }}
        Assert.assertTrue("Not present", true);
    }

    @Test
    public void generateReport_Book_Test(){

        String tmp = "";
        String genres = "";
        String checkout;
        String reserved;
        if(testing.isCheckedOut()){
            checkout = "checked out";
        }else checkout = " not checked out";

        if(testing.isReserved()){
            reserved = "reserved.";
        }else{ reserved = "not reserved.";}

            for (Genre g:((Book)testing).getGenreList()){
                genres += " "+g;

        }
        tmp += testing.getClass().getSimpleName() + " Report:\n" +
                "Name: " + testing.getTitle() +
                "\nItem ID: "+ testing.getItemID()+
                "\n It is "+ checkout +
                "\n It is "+ reserved +
                "\nSource: " + (testing).getSource().getName() +
                "\nBacking: " + ((Book)testing).getBacking() +
                "\nGenres are:" + genres + ".";
        System.out.println(tmp);
    }


}