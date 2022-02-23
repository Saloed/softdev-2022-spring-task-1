package task1;

import java.util.ArrayList;

public class BookLibrary {

    ArrayList<Book> Books;

    BookLibrary() {
        Books = new ArrayList<>(0);
    }

    public static class Book {
        public String name;
        public String author;
        public String genre;
        public String shelfCode;
        private final String list;

        private Book(String n, String a, String g, String s) {
            name = n;
            author = a;
            genre = g;
            shelfCode = s;
            list = "Название: " + n + "\n" + "Автор: " + a + "\n" + "Жанр: " + g + "\n" + "Лежит на полке: " + s + "\n";
        }

    }

    public void addBook(String name, String author, String genre, String shelf) {
        Book newBook = new Book(name, author, genre, shelf);
        Books.add(newBook);
    }

    public void removeBook(String bookName) {
        for (int i = 0; i < Books.size(); i++) {
            if (Books.get(i).name.equals(bookName)) {
                Books.remove(i);
                break;
            }
        }
    }

    public void changeShelf(String bookName, String newShelf) {
        for (Book book : Books) {
            if (book.name.equals(bookName)) {
                book.shelfCode = newShelf;
                break;
            }
        }
    }

    public void changeName(String bookName, String newName) {
        for (Book book : Books) {
            if (book.name.equals(bookName)) {
                book.name = newName;
                break;
            }
        }
    }

    public void changeAuthor(String bookName, String newAuthor) {
        for (Book book : Books) {
            if (book.name.equals(bookName)) {
                book.author = newAuthor;
                break;
            }
        }
    }

    public void changeGenre(String bookName, String newGenre) {
        for (Book book : Books) {
            if (book.name.equals(bookName)) {
                book.genre = newGenre;
                break;
            }
        }
    }

    public String search(String bookName, String bookAuthor, String bookGenre, String bookShelf) {
        StringBuilder found = new StringBuilder();
        for (Book book : Books) {
            boolean n = bookName.equals("");
            boolean a = bookAuthor.equals("");
            boolean g = bookGenre.equals("");
            boolean s = bookShelf.equals("");
            if ((book.name.contains(bookName) || n) && (book.author.equals(bookAuthor) || a) && (book.genre.equals(bookGenre) || g)
                    && (book.shelfCode.equals(bookShelf) || s)) {
                System.out.println(book.list);
                found.append(book.name);
            }
        }
        return found.toString();
    }

}
