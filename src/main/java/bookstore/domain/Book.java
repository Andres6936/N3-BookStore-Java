package bookstore.domain;

/**
 * Book in the book store
 */
public class Book
{
    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /** Book title */
    private String title;

    /** ISBN for the book */
    private String isbn;

    /** Book price */
    private int price;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Creates the book with its most basic information: title, ISBN and price.
     * @param aTitle Book title. aTitle!= null.
     * @param anISBN ISBN for the book. anISBN != null.
     * @param aPrice Book price. aPrice >= 0.
     */
    public Book( String aTitle, String anISBN, int aPrice )
    {
        title = aTitle;
        isbn = anISBN;
        price = aPrice;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Returns the book title.
     * @return Book title.
     */
    public String getTitle( )
    {
        return title;
    }

    /**
     * Returns the ISBN code for the book.
     * @return ISBN for the book.
     */
    public String getISBN( )
    {
        return isbn;
    }

    /**
     * Returns the book price.
     * @return Book price.
     */
    public int getPrice( )
    {
        return price;
    }

    /**
     * indicates whether this book is the same as an other book.
     * @param otherISBN ISBN from the other book which were comparing with this one. otherISBN != null.
     * @return true if both books are the same, false otherwise.
     */
    public boolean sameBook( String otherISBN )
    {
        boolean same = isbn.equals( otherISBN );
        return same;
    }

}