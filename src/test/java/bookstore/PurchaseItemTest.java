package bookstore;

import junit.framework.TestCase;

import bookstore.domain.Book;
import bookstore.domain.PurchaseItem;

/**
 * Purchase item test class
 */
public class PurchaseItemTest extends TestCase
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

    /**
     * Purchase item 1 for tests
     */
    private PurchaseItem item1;

    /**
     * Purchase item 2 for tests
     */
    private PurchaseItem item2;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Test scenario 1
     */
    private void setupScenario1( )
    {
        String title, isbn;
        int price, amount1, amount2;

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

        // Creates a purchase item
        amount1 = 2;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second purchase item
        amount2 = 3;
        item2 = new PurchaseItem( book2, amount2 );

    }

    /**
     * Test scenario 2
     */
    private void setupScenario2( )
    {
        String title, isbn;
        int price, amount1, amount2;

        // Creates the first test book
        title = "Title 3";
        isbn = "ISBN 3";
        price = 10000;
        book1 = new Book( title, isbn, price );

        // Creates the second test book
        title = "Title 4";
        isbn = "ISBN 4";
        price = 20000;
        book2 = new Book( title, isbn, price );

        // Creates a purchase item
        amount1 = 20;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second purchase item
        amount2 = 30;
        item2 = new PurchaseItem( book2, amount2 );

    }

    /**
     * Test scenario 3
     */
    private void setupScenario3( )
    {
        String title, isbn;
        int price, amount1, amount2;

        // gets the test data

        // Creates the first test book
        title = "Title 5";
        isbn = "ISBN 5";
        price = 10;
        book1 = new Book( title, isbn, price );

        // Creates the second test book
        title = "Title 6";
        isbn = "ISBN 6";
        price = 20;
        book2 = new Book( title, isbn, price );

        // Creates a purchase item
        amount1 = 1;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second purchase item
        amount2 = 2;
        item2 = new PurchaseItem( book2, amount2 );

    }

    /**
     * Tests the creation of a purchase item
     */
    public void testCreatePurchaseItem( )
    {
        setupScenario1( );
        int amount = 2;

        // checks the amounts
        assertEquals( amount, item1.getRequestedAmount( ) );

        // checks the books
        assertTrue( item1.getBook( ).sameBook( book1.getISBN( ) ) );

    }

    /**
     * checks the same as item method by comparing an item to itself, must return true
     */
    public void testSameItems( )
    {
        setupScenario2( );
        assertTrue( item1.sameAsItem( item1 ) );
    }

    /**
     * checks the same as item method by comparing an item to a different item, must return false
     */
    public void testDifferentItems( )
    {
        setupScenario3( );
        assertFalse( item1.sameAsItem( item2 ) );
    }

    /**
     * checks that the changing of an amount happens correctly
     */
    public void testChangeItemAmount( )
    {
        setupScenario1( );
        int amount = 4;
        item2.changeAmountPurchased( amount );
        assertEquals( amount, item2.getRequestedAmount( ) );
    }

    /**
     * checks that the total price for the purchase item is correct
     */
    public void testCalculateTotal( )
    {
        setupScenario2( );
        int amount = 20;
        int price = 10000;

        assertEquals( amount * price, item1.calculateTotalItem( ) );
    }

    /**
     * Checks the isbn for the book
     */
    public void testISBNItem( )
    {
        setupScenario1( );
        // Checks the isbn for the book
        assertEquals( item1.getIsbnItem( ), book1.getISBN( ) );
    }

    /**
     * checks that the books are the same
     */
    public void testBook( )
    {
        setupScenario2( );
        // Checks the isbn for the book
        assertEquals( item2.getBook( ), book2 );
    }

}