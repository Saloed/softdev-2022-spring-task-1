package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class PriceListTest {
    @Test
    void addElementTest() { 
        PriceList pl = new PriceList();
        pl.addElement("Phone", 50000.0);
        //надо придумать как получать айди
        assertEquals("Phone", pl.getElement(pl.getId("Phone")).getName());
    }

    @Test
    void replaceCostTest() {
        PriceList pl = new PriceList();
        pl.addElement("Phone", 50000.0);
        //надо придумать как получать айди
        pl.replaceCost(pl.getId("Phone"),60000.0);
        assertEquals(60000.0, pl.getElement(pl.getId("Phone")).getCost());
    }

    @Test
    void replaceNameTest() {
        PriceList pl = new PriceList();
        pl.addElement("Phone", 50000.0);
        //надо придумать как получать айди
        pl.replaceName(pl.getId("Phone"),"Phone for teenagers");
        assertEquals("Phone for teenagers",pl.getElement(pl.getId("Phone for teenagers")).getName());
    }

    @Test
    void deleteItemTest() {
        PriceList pl = new PriceList();
        pl.addElement("Phone", 50000.0);
        int idBy = pl.getId("Phone");
        pl.deleteItem(pl.getId("Phone"));
        assertFalse(pl.getListOfPrices().containsKey(idBy));

    }

    @Test
    void totalTest() {
        PriceList pl = new PriceList();
        pl.addElement("Apple", 500.00);
        assertEquals(1500,pl.total(pl.getId("Apple"),3));
    }
}
