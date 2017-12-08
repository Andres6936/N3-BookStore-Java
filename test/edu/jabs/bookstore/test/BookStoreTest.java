package edu.jabs.bookstore.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import edu.jabs.bookstore.domain.Book;
import edu.jabs.bookstore.domain.BookStore;
import edu.jabs.bookstore.domain.PurchaseItem;
import edu.jabs.bookstore.domain.ShoppingCart;

/**
 * Test class for the bookstore
 */
public class BookStoreTest extends TestCase
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * A test book
     */
    private Book book1;

    /**
     * A second test book
     */
    private Book book2;

    /**
     * the Bookstore
     */
    private BookStore store;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Test Scenario 1
     */
    private void setupScenario1( )
    {
        String title, isbn;
        int price, amount;
        ShoppingCart cart;

        // Creates the first test book
        title = "Title 1";
        isbn = "ISBN 1";
        price = 1000;
        book1 = new Book( title, isbn, price );

        // Creates the second test book
        title = "Title 2";
        isbn = "ISBN 2";
        price = 2000;
        book2 = new Book( title, isbn, price );

        // Adds the books to the catalog
        store = new BookStore( );
        store.addBookToCatalog( book1 );
        store.addBookToCatalog( book2 );

        // Initializes the shopping cart
        cart = store.getShoppingCart( );
        amount = 1;
        cart.addPurchase( book1, amount );
    }

    /**
     * Test Scenario 2
     */
    private void setupScenario2( )
    {
        String title, isbn;
        int price, amount;
        ShoppingCart cart;

        // Creates the first test book
        title = "Title 3";
        isbn = "ISBN 3";
        price = 10;
        book1 = new Book( title, isbn, price );

        // Creates the second test book
        title = "Title 4";
        isbn = "ISBN 4";
        price = 20;
        book2 = new Book( title, isbn, price );

        // Adds the books to the catalog
        store = new BookStore( );
        store.addBookToCatalog( book1 );
        store.addBookToCatalog( book2 );

        // Initializes the shopping cart
        cart = store.getShoppingCart( );
        amount = 2;
        cart.addPurchase( book1, amount );
    }

    /**
     * Test Scenario 3
     */
    private void setupScenario3( )
    {
        String title, isbn;
        int price, amount;
        ShoppingCart cart;
        // gets the test data

        // Creates the first test book
        title = "Title 5";
        isbn = "ISBN 5";
        price = 100;
        book1 = new Book( title, isbn, price );

        // Creates the second test book
        title = "Title 6";
        isbn = "ISBN 6";
        price = 200;
        book2 = new Book( title, isbn, price );

        // Adds the books to the catalog
        store = new BookStore( );
        store.addBookToCatalog( book1 );
        store.addBookToCatalog( book2 );

        // Initializes the shopping cart
        cart = store.getShoppingCart( );
        amount = 3;
        cart.addPurchase( book1, amount );
    }

    /**
     * Tests the adding and getting of books from the catalog
     */
    public void testAddBookToCatalog( )
    {
        setupScenario1( );
        Book theBook;
        theBook = store.findBook( book1.getISBN( ) );
        assertTrue( "Adding a Book", theBook.sameBook( book1.getISBN( ) ) );
        assertEquals( "ISBN adding a Book", theBook.getISBN( ), book1.getISBN( ) );
        assertEquals( "Title adding a Book", theBook.getTitle( ), book1.getTitle( ) );
        assertEquals( "Price adding a Book", theBook.getPrice( ), book1.getPrice( ) );
    }

    /**
     * Tests that the application doesn't add books that are already on the catalog
     */
    public void testAddExistingBook( )
    {
        setupScenario2( );
        int amountOfBooksBefore, amountOfBooksAfter;

        amountOfBooksBefore = store.getCatalog( ).size( );
        store.addBookToCatalog( book1 );
        amountOfBooksAfter = store.getCatalog( ).size( );

        assertEquals( "Adding an existing book", amountOfBooksBefore, amountOfBooksAfter );
    }

    /**
     * tests the get catalog method
     */
    public void testGetCatalog( )
    {
        setupScenario3( );
        Book book;
        ArrayList catalog = store.getCatalog( );

        // Checks that the first book is correct
        book = ( Book )catalog.get( 0 );
        assertTrue( book.sameBook( book1.getISBN( ) ) );

        // Checks that the second book is correct
        book = ( Book )catalog.get( 1 );
        assertTrue( book.sameBook( book2.getISBN( ) ) );
    }

    /**
     * Tests the get shopping cart method
     */
    public void testGetCart( )
    {
        setupScenario1( );
        ShoppingCart cart = store.getShoppingCart( );
        PurchaseItem item = cart.findPurchaseItemBook( book1.getISBN( ) );
        assertTrue( book1.sameBook( item.getBook( ).getISBN( ) ) );
    }

    /**
     * Checks that the cart is empty upon creation
     */
    public void testNewPurchase( )
    {
        setupScenario2( );
        store.createNewCart( );
        ShoppingCart cart = store.getShoppingCart( );
        assertEquals( 0, cart.getShoppingList( ).size( ) );
    }

    /**
     * checks that the application finds the added book
     */
    public void testFindBook( )
    {
        setupScenario3( );
        ShoppingCart cart = store.getShoppingCart( );
        PurchaseItem item = cart.findPurchaseItemBook( book1.getISBN( ) );
        Book book = item.getBook( );
        assertEquals( book, store.findBook( book.getISBN( ) ) );
    }

}