package task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookLibraryTest {

    @Test
    public void testAddBook() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        assertEquals(2, schoolLibrary.mapBooks.size());
    }

    @Test
    public void testRemoveBook() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        schoolLibrary.removeBook("451 градус по Фаренгейту");
        assertEquals(1, schoolLibrary.mapBooks.size());
    }

    @Test
    public void testChangeName() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeName("451 градус по Фаренгейту", "a book");
        assertEquals("a book", schoolLibrary.mapBooks.get("a book").name);
    }

    @Test
    public void testChangeAuthor() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeAuthor("451 градус по Фаренгейту", "NewAuthor");
        assertEquals("NewAuthor", schoolLibrary.mapBooks.get("451 градус по Фаренгейту").author);
    }

    @Test
    public void testChangeGenre() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeGenre("451 градус по Фаренгейту", "Драма");
        assertEquals("Драма", schoolLibrary.mapBooks.get("451 градус по Фаренгейту").genre);
    }

    @Test
    public void testChangeShelf() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeShelf("451 градус по Фаренгейту", "B");
        assertEquals("B", schoolLibrary.mapBooks.get("451 градус по Фаренгейту").shelfCode);
    }

   @Test
    public void testSearch() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        schoolLibrary.addBook("Портрет Дориана Грея", "Оскар Уайльд", "Фантастика", "B");
        List<BookLibrary.Book> list1 = new ArrayList<>();
        list1.add(schoolLibrary.mapBooks.get("1984"));
        list1.add(schoolLibrary.mapBooks.get("451 градус по Фаренгейту"));
        List<BookLibrary.Book> list2 = new ArrayList<>();
        list2.add(schoolLibrary.mapBooks.get("Портрет Дориана Грея"));
        assertEquals(list2, schoolLibrary.search("Портрет Дориана", "Оскар Уайльд", "", ""));
        assertEquals(list1, schoolLibrary.search("", "", "Фантастика", "A"));
    }
}
