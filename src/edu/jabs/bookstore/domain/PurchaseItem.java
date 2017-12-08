package edu.jabs.bookstore.domain;
/**
 * Shopping cart item. it is composed of a book and an amount
 */
public class PurchaseItem
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Book to be purchased
     */
    private Book book;

    /**
     * Amount of the book to be purchased
     */
    private int amount;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates a purchase item with a book and an amount
     * @param aBook Book to be purchased. aBook != null.
     * @param anAmount Amount of books to buy. anAmount != null.
     */
    public PurchaseItem( Book aBook, int anAmount )
    {
        book = aBook;
        amount = anAmount;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Returns the book in the purchase item.
     * @return book Book to purchase. book != null.
     */
    public Book getBook( )
    {
        return book;
    }

    /**
     * Returns the ISBN for the book to be purchased.
     * @return ISBN for the book to be purchased.
     */
    public String getIsbnItem( )
    {
        return book.getISBN( );
    }

    /**
     * Returns the amount of the book to be purchased.
     * @return amount to be purchased.
     */
    public int getRequestedAmount( )
    {
        return amount;
    }

    /**
     * CModifies the amount to be purchased. <br>
     * <b>post: </b> the amount to be purchased is updated. <br>
     * @param newAmount new amount of books to be bought. newAmount > 0.
     */
    public void changeAmountPurchased( int newAmount )
    {
        amount = newAmount;
    }

    /**
     * Indicates if the purchase item is the same as an other purchase item.
     * @param otherItem the other item that were comparing. otherItem != null.
     * @return true if the items are the same, false otherwise
     */
    public boolean sameAsItem( PurchaseItem otherItem )
    {
        boolean same = book.sameBook( otherItem.getIsbnItem( ) );
        return same;
    }

    /**
     * returns the total for this purchase item. book price * amount.
     * @return total price of the purchase. total > 0.
     */
    public int calculateTotalItem( )
    {
        int total = book.getPrice( ) * amount;
        return total;
    }
}