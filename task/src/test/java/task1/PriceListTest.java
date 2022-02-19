package task1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceListTest {
    @Test
    public void addTest() {
        String products = "Молоко; Хлеб; Сало; Яблоки; Бананы";
        String prices = "60.50; 40.0; 150.87; 35.82; 53.99";
        PriceList tester = new PriceList(products, prices);
        tester.add("Рыба", 354.21);
        String exp = "Молоко 60.5; Хлеб 40.0; Сало 150.87; Яблоки 35.82; Бананы 53.99; Рыба 354.21";
        assertEquals(exp, tester.toString());
    }


    @Test
    public void priceReplaceTest() {
        String products = "Молоко; Хлеб; Сало; Яблоки; Бананы";
        String prices = "60.50; 40.0; 150.87; 35.82; 53.99";
        PriceList tester = new PriceList(products, prices);
        tester.replacePriceById(1, 51.21);
        String exp = "Молоко 60.5; Хлеб 51.21; Сало 150.87; Яблоки 35.82; Бананы 53.99";
        assertEquals(exp, tester.toString());
        tester.replacePriceByName("Молоко", 62.32);
        exp = "Молоко 62.32; Хлеб 51.21; Сало 150.87; Яблоки 35.82; Бананы 53.99";
        assertEquals(exp, tester.toString());

    }

    @Test
    public void deleteTest() {
        String products = "Молоко; Хлеб; Сало; Яблоки; Бананы";
        String prices = "60.50; 40.0; 150.87; 35.82; 53.99";
        PriceList tester = new PriceList(products, prices);
        tester.deleteByName("Хлеб");
        String exp = "Молоко 60.5; Сало 150.87; Яблоки 35.82; Бананы 53.99";
        assertEquals(exp, tester.toString());
        tester.deleteById(2);
        exp = "Молоко 60.5; Сало 150.87; Бананы 53.99";
        assertEquals(exp, tester.toString());

    }

    @Test
    public void replaceTest() {
        String products = "Молоко; Хлеб; Сало; Яблоки; Бананы";
        String prices = "60.50; 40.0; 150.87; 35.82; 53.99";
        PriceList tester = new PriceList(products, prices);
        tester.replacePriceById(2, "Хамон");
        String exp = "Молоко 60.5; Хлеб 40.0; Хамон 150.87; Яблоки 35.82; Бананы 53.99";
        assertEquals(exp, tester.toString());
        tester.replaceNameByName("Молоко", "Молоко безлактозное");
        exp = "Молоко безлактозное 60.5; Хлеб 40.0; Хамон 150.87; Яблоки 35.82; Бананы 53.99";
        assertEquals(exp, tester.toString());

    }
    @Test
    public void purchaseAmountTest(){
        String products = "Молоко; Хлеб; Сало; Яблоки; Бананы";
        String prices = "60.50; 40.0; 150.87; 35.87; 53.99";
        PriceList tester = new PriceList(products, prices);
        double exp = 754.35;
        assertEquals(exp,tester.purchaseAmount(2,5));
    }
}
