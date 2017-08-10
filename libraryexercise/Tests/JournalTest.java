import com.company.entity.Author;
import com.company.libraryitems.Book;
import com.company.libraryitems.Genre;
import com.company.libraryitems.Journal;
import com.company.libraryitems.LibraryItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.time.Month;

import static com.company.libraryitems.Backing.Hardback;
import static com.company.libraryitems.Genre.Fantasy;

public class JournalTest {

Journal testing;
Author author;
Book book;

@Before
public void setUp(){

    author = new Author("Ben", "UK",
            LocalDate.of(1993, Month.JANUARY, 1));
    testing = new Journal("JTitle", author, LocalDate.of(2000, Month.JANUARY, 1),
            2, 2);


}
@Test
    public void setName_Test() {
        Assert.assertNotNull(testing);
        Assert.assertEquals("JTitle", testing.getTitle());
    }
@Test
    public void generateReportJournal_Test(){
        String tmp = "";
        String checkout;
        String reserved;
        if (testing.isCheckedOut()) {
            checkout = "checked out";
        } else checkout = " not checked out";
        if (testing.isReserved()) {
            reserved = "reserved.";
        } else {
            reserved = "not reserved.";
        }

        tmp += testing.getClass().getSimpleName() + " Report:\n" +
                "Name: " + testing.getTitle() +
                "\nItem ID: " + testing.getItemID() +
                "\nIt is " + checkout +
                "\nIt is " + reserved +
                "\nSource: " + (testing).getSource().getName() +
                "\n"+ testing.getIssueVolumeString()+".";
    System.out.println(tmp);    }
}
