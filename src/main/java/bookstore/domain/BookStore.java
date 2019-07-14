package bookstore.domain;

import java.util.ArrayList;

/**
 * Bookstore
 */
public class BookStore
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Catalog or book lists
     */
    private ArrayList catalog;

    /**
     * Book shopping cart
     */
    private ShoppingCart cart;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Creates the bookstore with an empty catalog and shopping cart
     */
    public BookStore( )
    {
        catalog = new ArrayList( );
        cart = new ShoppingCart( );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Adds a new book to the catalog. <br>
     * <b>post: </b> the book was added on the catalog.
     * @param newBook New book for the catalog. newBook != null.
     */
    public void addBookToCatalog( Book newBook )
    {
        // Checks if the book doesn't already exist
        Book book = findBook( newBook.getISBN( ) );
        // only adds the book if it doesn't exist
        if( book == null )
            catalog.add( newBook );
    }

    /**
     * Creates a new shopping cart. <br>
     * <b>post: </b> an empty shopping cart is created.
     */
    public void createNewCart( )
    {
        cart = new ShoppingCart( );
    }

    /**
     * Returns the store catalog. <br>
     * @return store catalog.
     */
    public ArrayList getCatalog( )
    {
        return catalog;
    }

    /**
     * Returns the shopping cart.
     * @return The shopping cart.
     */
    public ShoppingCart getShoppingCart( )
    {
        return cart;
    }

    /**
     * Returns a book if it exists on the catalog with the given ISBN.
     * @param isbn ISBN for the book that were looking for in the catalog.
     * @return book Book found in the catalog or null if it doesnt exist.
     */
    public Book findBook( String isbn )
    {
        int index = 0;
        int totalBooks = catalog.size( );
        Book foundBook = null;
        boolean found = false;
        while( index < totalBooks && !found )
        {
            foundBook = ( Book )catalog.get( index );
            if( foundBook.sameBook( isbn ) )
                found = true;
            index++;
        }
        if( found )
            return foundBook;
        else
            return null;
    }

    // -----------------------------------------------------------------
    // Extension points
    // -----------------------------------------------------------------

    /**
     * Extension method 1 for the exercise
     * @return Answer
     */

    public String method1( )
    {
        return "Answer 1";
    }

    /**
     * Extension method 2 for the exercise
     * @return Answer
     */
    public String method2( )
    {
        return "Answer 2";
    }

}