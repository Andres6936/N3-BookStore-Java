package edu.jabs.bookstore.gui;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import edu.jabs.bookstore.domain.Book;
import edu.jabs.bookstore.domain.BookStore;

/**
 * Data model from the catalog used to display the tables
 */
public class CatalogTableModel extends AbstractTableModel
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Column titles
     */
    private String[] columnNames;

    /**
     * Bookstore
     */
    private BookStore store;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * creates the model for the catalog with the information from the store.
     * @param aStore Bookstore. aStore != null.
     */
    public CatalogTableModel( BookStore aStore )
    {
        super( );
        store = aStore;
        String[] auxColumnNames = { "ISBN", "Title", "Price" };
        columnNames = auxColumnNames;
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Implements the method for table model and returns the number of rows so as to fit the book store catalog.
     * @return number of rows.
     */
    public int getRowCount( )
    {
        return store.getCatalog( ).size( );
    }

    /**
     * Implements the method for table model and returns the number of columns so as to fit the book store catalog.
     * @return number of columns.
     */
    public int getColumnCount( )
    {
        return columnNames.length;
    }

    /**
     * Implements the method for table model and returns the object in the cell consulted.
     * @param rowIndex row index. rowIndex >= 0.
     * @param columnIndex Column index. columnIndex >= -1.
     * @return information in the cell. if the column index is -1 return the whole book is returned.
     */
    public Object getValueAt( int rowIndex, int columnIndex )
    {
        Object bookData = null;
        Object[] catalog = store.getCatalog( ).toArray( );
        Book book = ( Book )catalog[ rowIndex ];

        if( columnIndex == -1 )
            bookData = book;
        else if( columnIndex == 0 )
            bookData = book.getISBN( );
        else if( columnIndex == 1 )
            bookData = book.getTitle( );
        else if( columnIndex == 2 )
            bookData = giveNumberFormat( book.getPrice( ) );

        return bookData;
    }

    /**
     * Implements the method for table model and returns the column name.
     * @param col Column whose name were interested in. col >= 0.
     * @return Column name
     */
    public String getColumnName( int col )
    {
        return columnNames[ col ];
    }

    /**
     * Implements the method for table model and decides whether the cell is editable or not.
     * @param row row index. row >= 0.
     * @param col column index. col >=0 .
     * @return true if the cell is editable, false otherwise.
     */
    public boolean isCellEditable( int row, int col )
    {
        return false;
    }

    /**
     * Gives the numbers that will be displayed in the gui a proper format.
     * @param value  numeric value to be given format.
     * @return String with the number in the correct format.
     */
    private String giveNumberFormat( int value )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( value );
    }

}