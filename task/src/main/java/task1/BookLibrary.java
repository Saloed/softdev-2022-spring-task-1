package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookLibrary {

    Map<String, Book> mapBooks;

    BookLibrary() {
        mapBooks = new HashMap<>();
    }

    public static class Book {
        public String name;
        public String author;
        public String genre;
        public String shelfCode;

        private Book(String n, String a, String g, String s) {
            name = n;
            author = a;
            genre = g;
            shelfCode = s;
        }

    }

    public void addBook(String name, String author, String genre, String shelf) {
        Book newBook = new Book(name, author, genre, shelf);
        mapBooks.put(name, newBook);
    }

    public void removeBook(String bookName) {
        mapBooks.remove(bookName);
    }

    public void changeShelf(String bookName, String newShelf) {
        mapBooks.get(bookName).shelfCode = newShelf;
    }

    public void changeName(String bookName, String newName) {
        mapBooks.get(bookName).name = newName;
        Book book = mapBooks.get(bookName);
        mapBooks.remove(bookName);
        mapBooks.put(newName, book);
    }

    public void changeAuthor(String bookName, String newAuthor) {
        mapBooks.get(bookName).author = newAuthor;
    }

    public void changeGenre(String bookName, String newGenre) {
        mapBooks.get(bookName).genre = newGenre;
    }

    public List<Book> search(String bookName, String bookAuthor, String bookGenre, String bookShelf) {
        List<Book> found = new ArrayList<>();
        for (Book book : mapBooks.values()) {
            boolean n = bookName.equals("");
            boolean a = bookAuthor.equals("");
            boolean g = bookGenre.equals("");
            boolean s = bookShelf.equals("");
            if ((book.name.contains(bookName) || n) && (book.author.equals(bookAuthor) || a) && (book.genre.equals(bookGenre) || g)
                    && (book.shelfCode.equals(bookShelf) || s)) {
                found.add(book);
            }
        }
        return found;
    }
}
