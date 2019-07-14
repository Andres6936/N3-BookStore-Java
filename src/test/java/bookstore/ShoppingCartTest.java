package bookstore;

import junit.framework.TestCase;

import bookstore.domain.Book;
import bookstore.domain.PurchaseItem;
import bookstore.domain.ShoppingCart;

import java.util.ArrayList;

/**
 * Shopping cart test class
 */
public class ShoppingCartTest extends TestCase
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
     * first test purchase item
     */
    private PurchaseItem item1;

    /**
     * Second test purchase item
     */
    private PurchaseItem item2;

    /**
     * Shopping cart
     */
    private ShoppingCart cart;

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Test Scenario 1
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

        // Creates a second test book
        title = "Title 2";
        isbn = "ISBN 2";
        price = 2000;
        book2 = new Book( title, isbn, price );

        // Creates a test purchase item
        amount1 = 2;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second test purchase item
        amount2 = 3;
        item2 = new PurchaseItem( book2, amount2 );

        // Creates the shopping cart with the purchase items
        cart = new ShoppingCart( );
        cart.addPurchase( book1, amount1 );
        cart.addPurchase( book2, amount2 );
    }

    /**
     * Test Scenario 2
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

        // Creates a second test book
        title = "Title 4";
        isbn = "ISBN 4";
        price = 20000;
        book2 = new Book( title, isbn, price );

        // Creates a test purchase item
        amount1 = 20;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second test purchase item
        amount2 = 30;
        item2 = new PurchaseItem( book2, amount2 );

        // Creates the shopping cart with the purchase items
        cart = new ShoppingCart( );
        cart.addPurchase( book1, amount1 );
        cart.addPurchase( book2, amount2 );
    }

    /**
     * Test Scenario 3
     */
    private void setupScenario3( )
    {
        String title, isbn;
        int price, amount1, amount2;

        // Creates the first test book
        title = "Title 5";
        isbn = "ISBN 5";
        price = 10;
        book1 = new Book( title, isbn, price );

        // Creates a second test book
        title = "Title 6";
        isbn = "ISBN 6";
        price = 20;
        book2 = new Book( title, isbn, price );

        // Creates a test purchase item
        amount1 = 1;
        item1 = new PurchaseItem( book1, amount1 );

        // Creates a second test purchase item
        amount2 = 2;
        item2 = new PurchaseItem( book2, amount2 );

        // Creates the shopping cart with the purchase items
        cart = new ShoppingCart( );
        cart.addPurchase( book1, amount1 );
        cart.addPurchase( book2, amount2 );
    }

    /**
     * tests the adding of an item to the cart
     */
    public void testAddPurchaseItem( )
    {
        setupScenario1( );
        int amount;
        PurchaseItem item;

        // must get book 1 from the purchase item
        item = cart.findPurchaseItemBook( book1.getISBN( ) );

        assertTrue( item.getBook( ).sameBook( book1.getISBN( ) ) );

        // checks the amount
        amount = 2;

        assertEquals( amount, item.getRequestedAmount( ) );
    }

    /**
     * tests that if you add a purchase item with a book already on the cart, the amounts are added correctly
     */
    public void testAddExistingPurchaseItem( )
    {
        setupScenario2( );
        PurchaseItem item;
        int amount;

        // Adds the same purchase item to the cart
        cart.addPurchase( item1.getBook( ), item1.getRequestedAmount( ) );

        // gets the book, it should be book 1
        item = cart.findPurchaseItemBook( book1.getISBN( ) );

        assertTrue( item.getBook( ).sameBook( book1.getISBN( ) ) );

        // checks the amounts
        amount = 20;

        assertEquals( amount * 2, item.getRequestedAmount( ) );
    }

    /**
     * Tests the deleting of a purchase item
     */
    public void testDeletePurchaseItem( )
    {
        setupScenario3( );
        cart.deletePurchaseItem( item1 );

        // tries to find the deleted item
        PurchaseItem item = cart.findPurchaseItemBook( book1.getISBN( ) );

        if( item != null )
            fail( "the book shouldn't appear on the cart anymore" );
    }

    /**
     * tests the return items list method
     */
    public void testObtenerListaItems( )
    {
        setupScenario1( );
        ArrayList items;
        PurchaseItem item;
        int amount1, amount2;

        amount1 = 2;
        amount2 = 3;

        // gets the purchase items
        items = cart.getShoppingList( );

        // checks the amount of items
        assertEquals( 2, items.size( ) );

        // checks the books and amounts
        item = ( PurchaseItem )items.get( 0 );
        assertTrue( book1.sameBook( item.getBook( ).getISBN( ) ) );
        assertEquals( amount1, item.getRequestedAmount( ) );
        item = ( PurchaseItem )items.get( 1 );
        assertTrue( book2.sameBook( item.getBook( ).getISBN( ) ) );
        assertEquals( amount2, item.getRequestedAmount( ) );
    }

    /**
     * test the calculation of the total
     */
    public void testCalculateTotal( )
    {
        setupScenario2( );
        int price1, price2, amount1, amount2, expectedTotal;

        // Adds the purchase items again, (double purchase)
        cart.addPurchase( item1.getBook( ), item1.getRequestedAmount( ) );
        cart.addPurchase( item2.getBook( ), item2.getRequestedAmount( ) );

        price1 = 10000;
        price2 = 20000;
        amount1 = 2 * 20;
        amount2 = 2 * 30;

        expectedTotal = price1 * amount1 + price2 * amount2;

        assertEquals( expectedTotal, cart.calculateTotalPurchaseValue( ) );
    }

    /**
     * Tests the search of a book using the ISBN
     */
    public void testFindPurchaseItemBook( )
    {
        setupScenario3( );
        cart.addPurchase( item1.getBook( ), item1.getRequestedAmount( ) );
        // tries to find the book
        PurchaseItem item = cart.findPurchaseItemBook( book1.getISBN( ) );
        assertEquals( item.getIsbnItem( ), item1.getIsbnItem( ) );
    }

}