
package com.library.service;

import com.library.dao.BookDAO;
import com.library.dao.StudentDAO;
import com.library.model.Student;
import com.library.dao.BorrowDAO;
import com.library.model.Borrow;

public class BorrowService {

    private BorrowDAO borrowDAO;

    // Constructeur avec BorrowDAO
    public BorrowService(BorrowDAO borrowDAO) {
        this.borrowDAO = borrowDAO;
    }

    public BorrowService(BookDAO bookDAO, StudentDAO studentDAO) {

    }


    // Méthode pour emprunter un livre
    public void borrowBook(Borrow borrow) {
        // Sauvegarde de l'emprunt dans la base de données
        borrowDAO.save(borrow);
    }

    // Afficher les emprunts (méthode fictive, à adapter)
    public void displayBorrows() {
        System.out.println("Liste des emprunts...");
        borrowDAO.getAllBorrows().forEach(System.out::println);

    }

    public String borrowBook(int i, int i1) {
        return null;
    }

    public String returnBook(int i, int i1) {
        return null;
    }
}
