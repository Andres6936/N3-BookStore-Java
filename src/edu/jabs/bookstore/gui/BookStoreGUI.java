package edu.jabs.bookstore.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.jabs.bookstore.domain.Book;
import edu.jabs.bookstore.domain.BookStore;
import edu.jabs.bookstore.domain.PurchaseItem;
import edu.jabs.bookstore.domain.ShoppingCart;

/**
 * Main gui window
 */
public class BookStoreGUI extends JFrame
{

    // -----------------------------------------------------------------
    // Gui Attributes
    // -----------------------------------------------------------------

    /**
     * Image pane for the shopping cart
     */
    private ShoppingCartImagePane cartImagePane;

    /**
     * Catalog image pane
     */
    private CatalogImagePane catalogImagePane;

    /**
     * Buttons image pane
     */
    private CatalogButtonsImagePane buttonsImagePane;

    /**
     * Dialog frame used to add a new book to the catalog
     */
    private AddBookDialog addBook;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Shopping cart
     */
    private ShoppingCart cart;

    /**
     * Bookstore
     */
    private BookStore store;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the main window for the bookstore
     */
    public BookStoreGUI( )
    {

        store = new BookStore( );
        cart = store.getShoppingCart( );

        JPanel upperImagePane = new JPanel( new BorderLayout( ) );
        catalogImagePane = new CatalogImagePane( this, store );
        buttonsImagePane = new CatalogButtonsImagePane( this );
        upperImagePane.add( buttonsImagePane, BorderLayout.NORTH );
        upperImagePane.add( catalogImagePane, BorderLayout.CENTER );

        JPanel bottomImagePane = new JPanel( new BorderLayout( ) );
        cartImagePane = new ShoppingCartImagePane( this, cart );
        bottomImagePane.add( cartImagePane, BorderLayout.CENTER );

        addBook = new AddBookDialog( this );
        setPreferredSize( new Dimension( 500, 500 ) );

        add( upperImagePane, BorderLayout.NORTH );
        add( bottomImagePane, BorderLayout.CENTER );
        setTitle( "Bookstore" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Method that displays the add book dialog
     */
    public void addBook( )
    {
        addBook.setLocation( calculaPosicionCentral( this, addBook ) );
        addBook.setVisible( true );
        addBook.setModal( true );
    }

    /**
     * Adds a book to the bookstore catalog.
     * @param title Book title. title != null.
     * @param isbn ISBN for the book. isbn != null.
     * @param price Book price. price != null.
     */
    public void addBookToCatalog( String title, String isbn, int price )
    {
        Book newBook = new Book( title, isbn, price );
        store.addBookToCatalog( newBook );
        catalogImagePane.updateCatalog( );
    }

    /**
     * thecks if the isbn already exists on the catalog.
     * @param isbn ISBN for the book. isbn != null.
     * @return true if the ISBN already exists on the catalog, false otherwise.
     */
    public boolean bookExists( String isbn )
    {
        boolean exists = false;
        Book theBook = store.findBook( isbn );
        if( null != theBook )
            exists = true;
        return exists;
    }

    /**
     * Adds a purchase to the shopping cart
     * @param bookToPurchase book that is going to be purchased. libroCompra != null.
     * @param amount Amount of books that are going to be purchased. amount >= 0.
     */
    public void addPurchase( Book bookToPurchase, int amount )
    {
        if( amount != 0 )
        {
            cart.addPurchase( bookToPurchase, amount );
            cartImagePane.updateCart( );
            cartImagePane.setAmount( cart.calculateTotalPurchaseValue( ) );
        }
    }

    /**
     * removes a purchase from the shopping cart.
     * @param itemToDelete item to delete from the cart. itemToDelete != null.
     */
    public void deletePurchase( PurchaseItem itemToDelete )
    {
        cart.deletePurchaseItem( itemToDelete );
        cartImagePane.updateCart( );
        cartImagePane.setAmount( cart.calculateTotalPurchaseValue( ) );
    }

    /**
     * Calculates the center pivot point for the frame.
     * @param fatherComponent Main window. componentePadre !=null.
     * @param sonComponent window to close. componenteHijo != null.
     * @return coordinate point for the new window. point != null.
     */
    private Point calculaPosicionCentral( Component fatherComponent, Component sonComponent )
    {
        Dimension screenSize, fatherSize, sonSize;
        Point fatherLocation;

        // Places the frame on a center position and verifies that its not bigger than the screen size
        screenSize = Toolkit.getDefaultToolkit( ).getScreenSize( );
        int max_y = screenSize.height;
        int min_y = 0;

        // Screen size and resolution
        fatherSize = fatherComponent.getSize( );
        fatherLocation = fatherComponent.getLocation( );
        sonSize = sonComponent.getSize( );
        int x = ( fatherSize.width - sonSize.width ) / 2 + fatherLocation.x;
        int y = ( fatherSize.height - sonSize.height ) / 2 + fatherLocation.y;

        // Lower adjustment
        if( y + sonSize.height > max_y )
        {
            y = max_y - sonSize.height;
        }

        // upper adjustment
        if( y < min_y )
        {
            y = 0;
        }
        return new Point( x, y );
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Method that executes extension 1
     */
    public void funcReqOption1( )
    {
        String answer = store.method1( );
        JOptionPane.showMessageDialog( this, answer, "Option 1", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Method that executes extension 2.
     */

    public void funcReqOption2( )
    {
        String answer = store.method2( );
        JOptionPane.showMessageDialog( this, answer, "Option 2", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Execution
    // -----------------------------------------------------------------

    /**
     * Main execution method
     * @param args Arguments for the application, not used
     */
    public static void main( String[] args )
    {
        try
        {
            BookStoreGUI gui = new BookStoreGUI( );
            gui.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
