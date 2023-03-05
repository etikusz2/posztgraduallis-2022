import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Application extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private List<Book> books;

    public Application() {
        setTitle("Bookshelf Application");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        books = new ArrayList<>();

        // Inicializáljuk a táblázatunkat
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Author");
        tableModel.addColumn("Title");
        tableModel.addColumn("Publisher");
        tableModel.addColumn("Date");
        tableModel.addColumn("Shelf");
        tableModel.addColumn("Position");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        JMenuBar menuBar = new JMenuBar();

        // "Add Book" menüpont
        JMenu bookM = new JMenu("Book");
        JMenuItem addMenuItem = new JMenuItem("Add Book");
        addMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBook();
            }

        });
        bookM.add(addMenuItem);


        // "Remove Book" menüpont
        JMenuItem removeMenuItem = new JMenuItem("Remove Book");
        removeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBook();
            }
        });
        bookM.add(removeMenuItem);


        // "Save Bookshelf" menüpont
        JMenu fileMenu = new JMenu("File");
        JMenuItem saveMenuItem = new JMenuItem("Save Bookshelf");
        saveMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showSaveDialog(Application.this);
                saveBookshelf(fileChooser.getSelectedFile());
            }
        });
        fileMenu.add(saveMenuItem);

        // "Load Bookshelf" menüpont
        JMenu loadMenu = new JMenu("Load Bookshelf");
        JMenuItem loadMenuItem = new JMenuItem("Load Bookshelf");
        loadMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(Application.this);
                loadBookshelf(fileChooser.getSelectedFile());
            }
        });
        fileMenu.add(loadMenuItem);

        // "Find a Book" menüpont
        JMenu findMenu = new JMenu("Find a Book");
        JMenuItem findMenuItem = new JMenuItem("Find a Book");
        findMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
        bookM.add(findMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(bookM);
        setJMenuBar(menuBar);
    }

    public void addBook() {
        JDialog addDialog = new JDialog(this, "Add Book", true);
        addDialog.setSize(600, 400);

        // A dialógus ablak paneljét
        JPanel addPanel = new JPanel();
        addPanel.setLayout(new BoxLayout(addPanel, BoxLayout.Y_AXIS));
        addPanel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField();
        addPanel.add(authorField);
        addPanel.add(new JLabel("Title:"));
        JTextField titleField = new JTextField();
        addPanel.add(titleField);
        addPanel.add(new JLabel("Publisher:"));
        JTextField publisherField = new JTextField();
        addPanel.add(publisherField);
        addPanel.add(new JLabel("Date:"));
        JTextField dateField = new JTextField();
        addPanel.add(dateField);
        addPanel.add(new JLabel("Shelf:"));
        JTextField shelfField = new JTextField();
        addPanel.add(shelfField);
        addPanel.add(new JLabel("Position:"));
        JTextField positionField = new JTextField();
        addPanel.add(positionField);
        addDialog.add(addPanel, BorderLayout.CENTER);
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hozzáadjuk az új könyvet a listához
                if (!authorField.getText().isEmpty() && !titleField.getText().isEmpty() && !publisherField.getText().isEmpty()
                        && !dateField.getText().isEmpty() && !shelfField.getText().isEmpty() && !positionField.getText().isEmpty()) {
                    Book book = new Book(authorField.getText(), titleField.getText(), publisherField.getText(), dateField.getText(), shelfField.getText(), positionField.getText());
                    books.add(book);
                    refreshTable();
                }
                // Bezárjuk a dialógus ablakot
                addDialog.dispose();
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog.dispose();
            }
        });
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        addDialog.add(buttonPanel, BorderLayout.SOUTH);
        addDialog.setVisible(true);
    }

    private void removeBook() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a book to remove.");
            return;
        }

        books.remove(selectedRow);
        refreshTable();
    }

    private void refreshTable() {
        // Frissítjük a táblázatot a könyvek listája alapján
        for (Book book : books) {
            // Ellenőrizzük, hogy a könyv még nincs-e a táblázatban
            boolean exists = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(book.getAuthor()) &&
                        tableModel.getValueAt(i, 1).equals(book.getTitle()) &&
                        tableModel.getValueAt(i, 2).equals(book.getPublisher()) &&
                        tableModel.getValueAt(i, 3).equals(book.getDate()) &&
                        tableModel.getValueAt(i, 4).equals(book.getShelf()) &&
                        tableModel.getValueAt(i, 5).equals(book.getPosition())) {
                    exists = true;
                    break;
                }
            }
            // Ha a könyv még nincs a táblázatban, hozzáadjuk
            if (!exists) {
                Object[] rowData = {book.getAuthor(), book.getTitle(), book.getPublisher(), book.getDate(), book.getShelf(), book.getPosition()};
                tableModel.addRow(rowData);
            }
        }
    }

    private void searchBook() {
        // Létrehozunk egy dialógus ablakot az író nevének bekérésére
        String author = (String) JOptionPane.showInputDialog(this, "Enter author name:", "Search Book", JOptionPane.PLAIN_MESSAGE, null, null, "");

        if (author != null && !author.isEmpty()) {
            // Létrehozunk egy listát, amely tartalmazza az összes olyan könyvet, amelynek szerzője az adott író
            List<Book> authorBooks = new ArrayList<>();
            for (Book book : books) {
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    authorBooks.add(book);
                }
            }

            if (!authorBooks.isEmpty()) {
                // Létrehozunk egy legördülő listát az összes adott író által írt könyvek címével
                String[] bookTitles = new String[authorBooks.size()];
                for (int i = 0; i < authorBooks.size(); i++) {
                    bookTitles[i] = authorBooks.get(i).getTitle();
                }
                String selectedBookTitle = (String) JOptionPane.showInputDialog(this, "Select a book:", "Search Book", JOptionPane.PLAIN_MESSAGE, null, bookTitles, "");

                if (selectedBookTitle != null && !selectedBookTitle.isEmpty()) {
                    // Megkeressük a kiválasztott könyv adatait
                    for (Book book : authorBooks) {
                        if (book.getTitle().equalsIgnoreCase(selectedBookTitle)) {
                            String result = "Author: " + book.getAuthor() + "\nTitle: " + book.getTitle() + "\nPublisher: " + book.getPublisher() + "\nDate: " + book.getDate() + "\nShelf: " + book.getShelf() + "\nPosition: " + book.getPosition();
                            JOptionPane.showMessageDialog(this, result, "Book Details", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(this, "Book not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void saveBookshelf(File selectedFile) {
        try {
            PrintWriter writer = new PrintWriter(selectedFile);
            for (Book book : books) {
                writer.println(book.getAuthor() + "," +
                        book.getTitle() + ","
                        + book.getPublisher() + ","
                        + book.getDate() + ","
                        + book.getShelf() + ","
                        + book.getPosition());
            }
            writer.close();
            JOptionPane.showMessageDialog(this, "Bookshelf saved successfully.");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void loadBookshelf(File selectedFile) {
        try {
            FileReader fileReader = new FileReader(selectedFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(",");
                String author = parts[0];
                String title = parts[1];
                String publisher = parts[2];
                String year = parts[3];
                String shelf = parts[4];
                String position = parts[5];

                Book book = new Book(author, title, publisher, year, shelf, position);
                books.add(book);
            }

            bufferedReader.close();
            fileReader.close();

            // Távolítsuk el a régi sorokat a táblázatból
            tableModel.setRowCount(0);

            // Hozzuk létre az új sorokat a beolvasott adatok alapján
            for (Book book : books) {
                Object[] row = {book.getAuthor(), book.getTitle(), book.getPublisher(), book.getDate(), book.getShelf(), book.getPosition()};
                tableModel.addRow(row);
            }
            JOptionPane.showMessageDialog(this, "Bookshelf loaded successfully.");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
