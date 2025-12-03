package library.service;

import library.model.Librarian;

public interface LibrarianService {
    // TODO: Implement all methods
    
    Librarian login(String username, String password);
    boolean logout();
    Librarian getCurrentLibrarian();
}

