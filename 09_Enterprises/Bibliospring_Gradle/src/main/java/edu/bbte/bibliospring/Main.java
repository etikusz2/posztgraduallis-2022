package edu.bbte.bibliospring;

import edu.bbte.bibliospring.backend.model.Authors;
import edu.bbte.bibliospring.backend.model.Books;
import edu.bbte.bibliospring.backend.model.User;
import edu.bbte.bibliospring.backend.repository.AuthorsDAO;
import edu.bbte.bibliospring.backend.repository.BooksDAO;
import edu.bbte.bibliospring.backend.repository.RepositoryException;
import edu.bbte.bibliospring.backend.repository.jdbc.JdbcAuthorsDAO;
import edu.bbte.bibliospring.backend.repository.jdbc.JdbcBooksDAO;
import edu.bbte.bibliospring.backend.service.LoginService;
import edu.bbte.bibliospring.backend.service.ServiceException;
import edu.bbte.bibliospring.backend.service.impl.LoginServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private JPanel startPanel;
    private final BooksDAO booksDAO = new JdbcBooksDAO(new JdbcAuthorsDAO());
    private final AuthorsDAO authorsDAO = new JdbcAuthorsDAO();
    private final LoginService loginService = new LoginServiceImpl();
    private List<Books> initialBooks;

    public Main() {
        initialize();
        initialBooks = new ArrayList<>(booksDAO.getAll());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main window = new Main();
                window.frame.setVisible(true);
                window.showStartPanel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startPanel = new JPanel();
        frame.getContentPane().add(startPanel, BorderLayout.SOUTH);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        startPanel.add(loginButton);
        startPanel.add(registerButton);

        loginButton.addActionListener(e -> showLoginDialog());

        registerButton.addActionListener(e -> showRegisterDialog());

        // Tábla inicializációja és a menü
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        String[] columnNames = {"Title", "Author", "Position", "ISBN"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table.setModel(tableModel);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // JMenu actionsMenu = new JMenu("Actions");
        // menuBar.add(actionsMenu);

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        JButton editButton = new JButton("Edit");
        JButton searchButton = new JButton("Search");
        JButton refreshButton = new JButton("Refresh");
        JButton exitButton = new JButton("Exit");

        menuBar.add(addButton);
        menuBar.add(deleteButton);
        menuBar.add(editButton);
        menuBar.add(searchButton);
        menuBar.add(refreshButton);
        menuBar.add(exitButton);


        addButton.addActionListener(e -> addBook());

        deleteButton.addActionListener(e -> deleteBook());

        editButton.addActionListener(e -> editBook());

        searchButton.addActionListener(e -> searchBooks());

        refreshButton.addActionListener(e -> refreshTable());

        exitButton.addActionListener(e -> System.exit(0));

        showStartPanel();
    }

    private void loadBooksData() {
        List<Books> books = booksDAO.getAll();
        for (Books book : books) {
            Object[] data = {book.getTitle(), book.getAuthor().getAuthor(), book.getPosition(), book.getIsbn()};
            tableModel.addRow(data);
        }
    }

    private void addBook() {
        JPanel addPanel = new JPanel(new GridLayout(0, 2));
        JTextField titleField = new JTextField();
        JTextField authorField = new JTextField();
        JTextField positionField = new JTextField();
        JTextField isbnField = new JTextField();

        addPanel.add(new JLabel("Title:"));
        addPanel.add(titleField);
        addPanel.add(new JLabel("Author:"));
        addPanel.add(authorField);
        addPanel.add(new JLabel("Position:"));
        addPanel.add(positionField);
        addPanel.add(new JLabel("ISBN:"));
        addPanel.add(isbnField);

        int result = JOptionPane.showConfirmDialog(null, addPanel, "Add Book", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String newTitle = titleField.getText();
            String newAuthorName = authorField.getText();
            final String newPosition = positionField.getText();
            final String newIsbn = isbnField.getText();

            Authors author = authorsDAO.getAuthorByName(newAuthorName);
            if (author == null) {
                author = new Authors();
                author.setUid(generateUniqueUid());
                author.setAuthor(newAuthorName);
                author = authorsDAO.create(author);
            }

            Books newBook = new Books();
            newBook.setUid(generateUniqueUid());
            newBook.setTitle(newTitle);
            newBook.setAuthor(author);
            newBook.setPosition(newPosition);
            newBook.setIsbn(newIsbn);

            Books createdBook = booksDAO.create(newBook);
            if (createdBook != null) {
                Object[] data = {
                        createdBook.getTitle(),
                        createdBook.getAuthor().getAuthor(),
                        createdBook.getPosition(),
                        createdBook.getIsbn()
                };
                tableModel.addRow(data);
            }
            initialBooks.add(createdBook);
        }
        refreshDataAndTable();
    }

    private void deleteBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            try {
                String titleToDelete = (String) tableModel.getValueAt(selectedRow, 0);

                int confirmResult = JOptionPane.showConfirmDialog(frame,
                        "Are you sure to delete this book?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);

                if (confirmResult == JOptionPane.YES_OPTION) {
                    Long idToDelete = booksDAO.getIdByTitle(titleToDelete);
                    booksDAO.delete(idToDelete);
                    tableModel.removeRow(selectedRow);
                    initialBooks.removeIf(book -> book.getTitle().equals(titleToDelete));

                    refreshDataAndTable();
                }
            } catch (RepositoryException e) {
                e.printStackTrace();
            }
        }
    }


    private void editBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String newTitle = JOptionPane.showInputDialog(frame, "Enter new title:");
            String newAuthorName = JOptionPane.showInputDialog(frame, "Enter new author:");
            final String newPosition = JOptionPane.showInputDialog(frame, "Enter new position:");
            final String newIsbn = JOptionPane.showInputDialog(frame, "Enter new ISBN:");

            Authors author = authorsDAO.getAuthorByName(newAuthorName);
            if (author == null) {
                author = new Authors();
                author.setUid(generateUniqueUid());
                author.setAuthor(newAuthorName);
                author = authorsDAO.create(author);
            }

            Long selectedBookId = getIdFromDatabase(selectedRow);

            Books bookToEdit = new Books();
            bookToEdit.setUid(generateUniqueUid());
            bookToEdit.setTitle(newTitle);
            bookToEdit.setAuthor(author);
            bookToEdit.setPosition(newPosition);
            bookToEdit.setIsbn(newIsbn);
            bookToEdit.setId(selectedBookId);

            booksDAO.update(bookToEdit);

            updateTableModelAndInitialBooks(selectedRow, bookToEdit);
        }
        refreshDataAndTable();
    }

    private Long getIdFromDatabase(int rowIndex) {
        return booksDAO.getIdByTitle(tableModel.getValueAt(rowIndex, 0).toString());
    }

    private void updateTableModelAndInitialBooks(int rowIndex, Books updatedBook) {
        if (updatedBook != null && updatedBook.getId() != null) {
            tableModel.setValueAt(updatedBook.getTitle(), rowIndex, 0);
            tableModel.setValueAt(updatedBook.getAuthor().getAuthor(), rowIndex, 1);
            tableModel.setValueAt(updatedBook.getPosition(), rowIndex, 2);
            tableModel.setValueAt(updatedBook.getIsbn(), rowIndex, 3);

            initialBooks.removeIf(book -> book != null
                    && book.getId() != null
                    && book.getId().equals(updatedBook.getId()));
            initialBooks.add(updatedBook);

            for (int i = 0; i < initialBooks.size(); i++) {
                Books initialBook = initialBooks.get(i);
                if (initialBook != null
                        && initialBook.getId() != null
                        && initialBook.getId().equals(updatedBook.getId())) {
                    initialBooks.remove(i);
                    break;
                }
            }
        }
    }

    private void searchBooks() {
        String searchTerm = JOptionPane.showInputDialog(frame, "Enter search term:");

        if (searchTerm != null) {
            List<Books> searchResults = booksDAO.searchByTitleOrAuthor(searchTerm);
            updateTableWithSearchResults(searchResults);
        }
        refreshTable();
    }

    private void updateTableWithSearchResults(List<Books> searchResults) {
        tableModel.setRowCount(0);
        for (Books book : searchResults) {
            Object[] data = {book.getTitle(), book.getAuthor().getAuthor(), book.getPosition(), book.getIsbn()};
            tableModel.addRow(data);
        }
    }

    private void refreshTable() {
        tableModel.setRowCount(0);

        for (Books book : initialBooks) {
            Object[] data = {book.getTitle(), book.getAuthor().getAuthor(), book.getPosition(), book.getIsbn()};
            tableModel.addRow(data);
        }
    }

    private void refreshDataAndTable() {
        refreshData();
        refreshTable();
    }

    private void refreshData() {
        initialBooks = booksDAO.getAll(); // Az összes könyv lekérése az adatbázisból
    }

    private void showLoginDialog() {
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JPasswordField();
        Object[] fields = {
            "Username:", usernameField,
            "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Login", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            User user = new User();
            user.setUserName(username);
            user.setPassword(password);

            try {
                if (loginService.login(user)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                    showBooksPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Invalid username or password.");
                }
            } catch (ServiceException e) {
                LOG.error("Login failed.", e);
                JOptionPane.showMessageDialog(null, "Login failed. An error occurred.");
            }
        }
    }

    private void showRegisterDialog() {
        JTextField usernameField = new JTextField();
        JTextField passwordField = new JPasswordField();
        Object[] fields = {
            "Username:", usernameField,
            "Password:", passwordField
        };

        int option = JOptionPane.showConfirmDialog(null, fields, "Register", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            User newUser = new User();
            newUser.setUserName(username);
            newUser.setPassword(password);

            try {
                User registeredUser = loginService.register(newUser);
                if (registeredUser != null) {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed. Username might be already taken.");
                }
            } catch (ServiceException e) {
                LOG.error("Registration failed.", e);
                JOptionPane.showMessageDialog(null, "Registration failed. An error occurred.");
            }
        }
    }

    private void showStartPanel() {
        startPanel.setVisible(true);
        table.setVisible(false);
    }

    private void showBooksPanel() {
        startPanel.setVisible(false);
        table.setVisible(true);
        loadBooksData();
    }


    private String generateUniqueUid() {
        return "UID_" + System.currentTimeMillis();
    }
}
