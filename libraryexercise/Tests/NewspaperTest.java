import com.company.entity.Author;
import com.company.entity.Entity;
import com.company.libraryitems.LibraryItem;
import com.company.libraryitems.Newspaper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static com.company.libraryitems.TypeOfNewspaper.*;

public class NewspaperTest {


    LibraryItem testing;
    Entity author;


    @Before
    public void setUp() {


        author = new Author("Ben", "UK",
                LocalDate.of(1993, Month.JANUARY, 1));
        testing = new Newspaper("Independent", author,
                LocalDate.of(2000, Month.JANUARY, 1), Tabloid, false);

    }

    @Test
    public void setTypeOfNewspaper_Test(){
    ((Newspaper)testing).setTypeOfNewspaper(Broadsheet);
    Assert.assertEquals(Broadsheet, ((Newspaper)testing).getTypeOfNewspaper());
    }

    @Test
    public void setNSFW_Test(){
        ((Newspaper)testing).setNSFW(true);
        Assert.assertTrue("Not true", ((Newspaper)testing).isNSFW());
    }

    @Test
    public void generateNewspaperReport_Test(){
        String tmp = "";
        String checkout;
        String reserved;
        String nsfw="";

        if (testing.isCheckedOut()) {
            checkout = "checked out";
        } else checkout = " not checked out";
        if (testing.isReserved()) {
            reserved = "reserved.";
        } else {
            reserved = "not reserved.";
        }
        if(((Newspaper)testing).isNSFW()){
            nsfw = "not suitable for minors.";
        }else nsfw = "safe for minors.";

        tmp += testing.getClass().getSimpleName() + " Report:\n" +
                "Name: " + testing.getTitle() +
                "\nItem ID: " + testing.getItemID() +
                "\nSource: " + testing.getSource().getName() +
                "\nIt is " + checkout +
                "\nIt is " + reserved +
                "\nIt is "+ nsfw+
                "\nIt is a "+((Newspaper) testing).getTypeOfNewspaper()+" newspaper.";
        System.out.println(tmp);
    }

}
