package edu.jabs.bookstore.domain;

import java.util.ArrayList;

/**
 * Shopping cart for the bookstore. adds the purchase items the client wants
 */
public class ShoppingCart
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /** list of shopping items added on the shopping cart*/
    private ArrayList shoppingItems;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates an empty shopping cart.
     */
    public ShoppingCart( )
    {
        shoppingItems = new ArrayList( );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * returns the purchase item that contains the book consulted with the given ISBN.
     * @param isbnConsulted ISBN for the consulted book.
     * @return purchase item with the book or null if it doesn't exist.
     */
    public PurchaseItem findPurchaseItemBook( String isbnConsulted )
    {
        boolean found = false;
        PurchaseItem item = null;

        // Index to search the container
        int i = 0;
        int totalItems = shoppingItems.size( );
        // as long as the item isnt found or the whole container has been checked, continue
        while( i < totalItems && !found )
        {
            item = ( PurchaseItem )shoppingItems.get( i );
            if( item.getBook( ).sameBook( isbnConsulted ) )
                found = true;
            i++;
        }
        if( found )
            return item;
        else
            return null;
    }

    /**
     * Adds a new item to the shopping cart if the book wasn't already in it, if the book was already in it, then the amount is increased<br>
     * <b>post: </b> if the book wasnt already on the cart, the purchase item is added. if the book did exist, then the amount is increased
     * <br>
     * @param book Book to buy. book != null.
     * @param amount Amount of the book to buy. amount >= 0.
     */
    public void addPurchase( Book book, int amount )
    {
        // Checks to see if the book already exists on the shopping cart
        PurchaseItem anItem = findPurchaseItemBook( book.getISBN( ) );
        // If it doesn't exist, it is added
        if( anItem == null )
        {
            PurchaseItem newItem = new PurchaseItem( book, amount );
            shoppingItems.add( newItem );
        }
        else
        {
            // if it already exists, the amount is increased
            anItem.changeAmountPurchased( anItem.getRequestedAmount( ) + amount );
        }
    }

    /**
     * Deletes a purchase item from the shopping cart <br>
     * <b>post: </b> the purchase item is eliminated. <br>
     * @param anItem item to look for and delete. anItem != null.
     */
    public void deletePurchaseItem( PurchaseItem anItem )
    {
        PurchaseItem item = null;
        boolean found = false;

        // the index to run thru the array
        int i = 0;
        int index = shoppingItems.size( );

        // advances as long as there is still room or if the book hasn't been found
        while( i < index && !found )
        {
            item = ( PurchaseItem )shoppingItems.get( i );
            if( item.sameAsItem( anItem ) )
                found = true;
            i++;
        }
        if( found )
            shoppingItems.remove( item );
    }

    /**
     * Returns the list of purchase items.
     * @return List of purchase items.
     */
    public ArrayList getShoppingList( )
    {
        return shoppingItems;
    }

    /**
     * Calculates the total value for the purchase.
     * @return Total purchase.
     */
    public int calculateTotalPurchaseValue( )
    {
        int total = 0;
        int index = 0;
        int totalItems = shoppingItems.size( );
        while( index < totalItems )
        {
            PurchaseItem currentItem = ( PurchaseItem )shoppingItems.get( index );
            // adds the totals of each purchase item
            total += currentItem.calculateTotalItem( );
            index++;
        }
        return total;
    }
}