package ui;

import Model.Book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class BookView extends JFrame {

    private JPanel contentPane;
    private Book book;


    /**
     * Create the frame.
     */
    public BookView(Book book) {
        this.book = book;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 493, 433);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setUndecorated(true);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btClose = new JButton("");
        btClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btClose.setEnabled(true);
        btClose.setIcon(new ImageIcon(BookView.class.getResource("/img/x.png")));
        btClose.setBackground(Color.WHITE);
        btClose.setBounds(453, 10, 30, 23);
        contentPane.add(btClose);

        JLabel lblImg = new JLabel("");
        lblImg.setBounds(28, 35, 109, 129);
        ImageIcon imageIcon = new ImageIcon(BookView.class.getResource(this.book.getImagePath()));
        lblImg.setIcon(imageIcon);
        Dimension labelSize = lblImg.getPreferredSize();
        Image image = imageIcon.getImage().getScaledInstance(labelSize.width, labelSize.height, Image.SCALE_SMOOTH);
        ImageIcon adjustedImageIcon = new ImageIcon(image);
        lblImg.setIcon(adjustedImageIcon);
        contentPane.add(lblImg);

        JLabel lblTitle = new JLabel(this.book.getTitle());
        lblTitle.setFont(new Font("Leelawadee UI Semilight", Font.BOLD, 14));
        lblTitle.setBounds(187, 35, 91, 23);
        contentPane.add(lblTitle);

        JLabel lblAuthor = new JLabel(this.book.getAuthor());
        lblAuthor.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        lblAuthor.setBounds(187, 82, 91, 23);
        contentPane.add(lblAuthor);

        JLabel lblGenre = new JLabel(this.book.getGenre());
        lblGenre.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 13));
        lblGenre.setBounds(187, 129, 91, 23);
        contentPane.add(lblGenre);

        JTextArea taDescription = new JTextArea();
        taDescription.setText(this.book.getDescription());
        taDescription.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 12));
        taDescription.setEditable(false);
        taDescription.setBounds(28, 188, 442, 110);
        contentPane.add(taDescription);

        JButton btReserved = new JButton("");
        if(this.book.isRented()) {
            btReserved.setEnabled(false);
        }
        btReserved.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!book.isRented()) {
                    book.setRented(true);
                    //TO DO
                    //save info into database
                    btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/x-red.png")));
                    btReserved.setText("Book is not available");
                    btReserved.setEnabled(false);
                }
            }
        });
        btReserved.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        if(this.book.isRented()) {
            btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/x-red.png")));
            btReserved.setText("Book is not available");
        } else {
            btReserved.setIcon(new ImageIcon(BookView.class.getResource("/img/hourglass.png")));
            btReserved.setText("Reserve for 2 days");
        }
        btReserved.setHorizontalAlignment(SwingConstants.LEFT);
        btReserved.setBounds(63, 339, 298, 21);
        contentPane.add(btReserved);

        JButton btFavourites = new JButton("");
        btFavourites.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(book.isFavourite()) {
                    book.setFavourite(false);
                    //TO DO
                    //save info into database
                    btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-empty.png")));
                    btFavourites.setText("Add to favourites");
                }else {
                    book.setFavourite(true);
                    //TO DO
                    //save info into database
                    btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-red.png")));
                    btFavourites.setText("Remove from favourites");
                }
            }
        });
        btFavourites.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 11));
        if(this.book.isFavourite()) {
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-red.png")));
            btFavourites.setText("Remove from favourites");
        } else {
            btFavourites.setIcon(new ImageIcon(BookView.class.getResource("/img/heart-empty.png")));
            btFavourites.setText("Add to favourites");
        }
        btFavourites.setHorizontalAlignment(SwingConstants.LEFT);
        btFavourites.setBounds(63, 378, 298, 21);
        contentPane.add(btFavourites);

        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(218, 165, 32));
        separator.setBounds(28, 312, 109, 2);
        contentPane.add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBackground(new Color(211, 211, 211));
        separator_1.setBounds(187, 60, 70, 2);
        contentPane.add(separator_1);

        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setBackground(new Color(211, 211, 211));
        separator_1_1.setBounds(187, 103, 70, 2);
        contentPane.add(separator_1_1);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBackground(new Color(211, 211, 211));
        separator_1_2.setBounds(187, 151, 70, 2);
        contentPane.add(separator_1_2);
    }
}