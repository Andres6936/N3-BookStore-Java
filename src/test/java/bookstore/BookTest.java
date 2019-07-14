package bookstore;

import junit.framework.TestCase;

import bookstore.domain.Book;

/**
 * Book test class
 */
public class BookTest extends TestCase
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Book 1 for tests
     */
    private Book book1;

    /**
     * Book 2 for tests
     */
    private Book book2;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Test scenario 1
     */
    private void setupScenario1( )
    {
        String title, isbn;
        int price;

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

    }

    /**
     * Test scenario 2
     */
    private void setupScenario2( )
    {
        String title, isbn;
        int price;

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

    }

    /**
     * Test scenario 3
     */
    private void setupScenario3( )
    {
        String title, isbn;
        int price;

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

    }

    /**
     * Checks that the info for the book was added correctly
     */
    public void testCreateBook( )
    {
        setupScenario1( );
        String title, isbn;
        int price;

        title = "Title 1";
        isbn = "ISBN 1";
        price = 1000;

        assertEquals( title, book1.getTitle( ) );
        assertEquals( isbn, book1.getISBN( ) );
        assertEquals( price, book1.getPrice( ) );
    }

    /**
     * checks that the sameBook method works comparing a book to its self
     */
    public void testSameBook( )
    {
        setupScenario3( );
        assertTrue( book1.sameBook( book1.getISBN( ) ) );
    }

    /**
     * checks the same book method when the books are different
     */
    public void testDifferentBooks( )
    {
        setupScenario1( );
        assertFalse( book1.sameBook( book2.getISBN( ) ) );
    }

    /**
     * checks the book titles
     */
    public void testGetTitles( )
    {
        setupScenario2( );
        String titulo = "Title 3";

        assertEquals( book1.getTitle( ), titulo );
    }

    /**
     * Checks the ISBN for the books
     */
    public void testGetISBN( )
    {
        setupScenario3( );
        String ISBN = "ISBN 5";

        assertEquals( book1.getISBN( ), ISBN );
    }

    /**
     * checks the price of the books
     */
    public void testGetPrice( )
    {
        setupScenario1( );
        int precio = 1000;

        assertEquals( book1.getPrice( ), precio );
    }

}