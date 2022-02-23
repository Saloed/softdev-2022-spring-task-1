package task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookLibraryTest {

    @Test
    public void testAddBook() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        assertEquals(2, schoolLibrary.Books.size());
    }

    @Test
    public void testRemoveBook() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        schoolLibrary.removeBook("451 градус по Фаренгейту");
        assertEquals(1, schoolLibrary.Books.size());
    }

    @Test
    public void testChangeName() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeName("451 градус по Фаренгейту", "a book");
        assertEquals("a book", schoolLibrary.Books.get(0).name);
    }

    @Test
    public void testChangeAuthor() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeAuthor("451 градус по Фаренгейту", "NewAuthor");
        assertEquals("NewAuthor", schoolLibrary.Books.get(0).author);
    }

    @Test
    public void testChangeGenre() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeGenre("451 градус по Фаренгейту", "Драма");
        assertEquals("Драма", schoolLibrary.Books.get(0).genre);
    }

    @Test
    public void testChangeShelf() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.changeShelf("451 градус по Фаренгейту", "B");
        assertEquals("B", schoolLibrary.Books.get(0).shelfCode);
    }

    @Test
    public void testSearch() {
        BookLibrary schoolLibrary = new BookLibrary();
        schoolLibrary.addBook("451 градус по Фаренгейту", "Бредбери", "Фантастика", "A");
        schoolLibrary.addBook("1984", "Оруэлл", "Фантастика", "A");
        schoolLibrary.addBook("Портрет Дориана Грея", "Оскар Уайльд", "Фантастика", "B");
        assertEquals("451 градус по Фаренгейту" + "1984", schoolLibrary.search("", "", "Фантастика", "A"));
        assertEquals("Портрет Дориана Грея", schoolLibrary.search("Портрет Дориана", "Оскар Уайльд", "", ""));
    }
}
