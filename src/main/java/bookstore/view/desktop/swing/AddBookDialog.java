package bookstore.view.desktop.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Form used to add a new book to the catalog
 */
public class AddBookDialog extends JDialog
{
    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------
    /**
     * Buttons image pane
     */
    private ButtonsImagePane buttonsImagePane;

    /**
     * Title label
     */
    private JLabel titleLabel;

    /**
     * Title field
     */
    private JTextField txtTitle;

    /**
     * ISBN label
     */
    private JLabel isbnLabel;

    /**
     * ISBN field
     */
    private JTextField txtIsbn;

    /**
     * Price label
     */
    private JLabel priceLabel;

    /**
     * Price field
     */
    private JTextField txtPrice;

    /**
     * Main GUI
     */
    private BookStoreSwing mainWindow;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the form used to add books
     * @param window mainWindow. window != null.
     */
    public AddBookDialog( BookStoreSwing window )
    {
        mainWindow = window;

        setLayout( new GridLayout( 1, 4 ) );
        setPreferredSize( new Dimension( 350, 100 ) );

        //Títle
        JPanel titleImagePane = new JPanel( );
        titleLabel = new JLabel( "Title " );
        titleLabel.setPreferredSize( new Dimension( 100, 20 ) );
        txtTitle = new JTextField( );
        txtTitle.setPreferredSize( new Dimension( 100, 20 ) );
        txtTitle.setColumns( 15 );
        titleImagePane.setLayout( new GridLayout( 3, 0 ) );
        titleImagePane.setPreferredSize( new Dimension( 200, 15 ) );
        titleImagePane.add( titleLabel );
        titleImagePane.add( txtTitle );
        add( titleImagePane );

        //ISBN
        JPanel isbnImagePane = new JPanel( );
        isbnLabel = new JLabel( "ISBN " );
        isbnLabel.setPreferredSize( new Dimension( 100, 20 ) );
        txtIsbn = new JTextField( );
        txtIsbn.setPreferredSize( new Dimension( 100, 20 ) );
        txtIsbn.setColumns( 15 );
        isbnImagePane.setLayout( new GridLayout( 3, 0 ) );
        isbnImagePane.setPreferredSize( new Dimension( 200, 15 ) );
        isbnImagePane.add( isbnLabel );
        isbnImagePane.add( txtIsbn );
        add( isbnImagePane );

        //Price
        JPanel priceImagePane = new JPanel( );
        priceLabel = new JLabel( "Price " );
        priceLabel.setPreferredSize( new Dimension( 100, 20 ) );
        txtPrice = new JTextField( );
        txtPrice.setPreferredSize( new Dimension( 100, 20 ) );
        txtPrice.setColumns( 15 );
        priceImagePane.setLayout( new GridLayout( 3, 0 ) );
        priceImagePane.setPreferredSize( new Dimension( 200, 15 ) );
        priceImagePane.add( priceLabel );
        priceImagePane.add( txtPrice );
        add( priceImagePane );

        // Adds the buttons
        buttonsImagePane = new ButtonsImagePane( this );
        add( buttonsImagePane );

        setTitle( "Add a new book to the catalog" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Actions that go on when the Add button is used
     */
    public void whenConfirmed( )
    {
        String title, isbn, price;
        title = txtTitle.getText( );
        isbn = txtIsbn.getText( );
        price = txtPrice.getText( );
        int bookPrice;

        if( title == null || title.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "The book must have a title", "Add a book", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( isbn == null || isbn.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "the book must have an ISBN", "Add a book", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( mainWindow.bookExists( isbn ) )
        {
            JOptionPane.showMessageDialog( this, "there is already a book on thecatalog with that same ISBN", "Add a book", JOptionPane.ERROR_MESSAGE );
            return;
        }

        try
        {
            bookPrice = Integer.parseInt( price );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "that is not a valid price", "Add a book", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( bookPrice <= 0 )
        {
            JOptionPane.showMessageDialog( this, "the price can't be zero", "Add a book", JOptionPane.ERROR_MESSAGE );
            return;
        }
        mainWindow.addBookToCatalog( title, isbn, bookPrice );
        txtTitle.setText( "" );
        txtIsbn.setText( "" );
        txtPrice.setText( "" );
        dispose( );

    }

    /**
     * Action that occurs when the cancel button is pressed
     */
    public void cancelAction( )
    {
        txtTitle.setText( "" );
        txtIsbn.setText( "" );
        txtPrice.setText( "" );
        dispose( );
    }
}