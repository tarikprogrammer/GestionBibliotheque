package com.library.service;
import com.library.dao.BookDAO; // Importation de BookDAO
import com.library.model.Book;   // Importation de Book
import java.util.List;


public class BookService {
    private BookDAO bookDAO;  // Utilisation de DAO pour la gestion des livres

    // Constructeur qui initialise l'objet BookDAO
    public BookService(BookDAO bookDAO) {
        this.bookDAO = new BookDAO();
    }


    public BookService(){

    }

    // Ajouter un livre
    public void addBook(Book book) {
        bookDAO.add(book);
    }

    // Afficher tous les livres
    public void displayBooks() {
        List<Book> books = bookDAO.getAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Trouver un livre par ID
    public Book findBookById(int id) {
        return bookDAO.getBookById(id);
    }

    // Supprimer un livre par ID
    public void deleteBook(int id) {
        bookDAO.delete(id);
    }

    // Mise à jour des informations d'un livre
    public void updateBook(Book book) {
        bookDAO.update(book);
    }

    public void updateBook(int i, String advancedJava, String janeDoe, boolean b) {
        Book book = bookDAO.getBookById(i);
        book.setYear(Integer.parseInt(advancedJava));
        book.setAuthor(janeDoe);
        bookDAO.update(book);
    }
}
