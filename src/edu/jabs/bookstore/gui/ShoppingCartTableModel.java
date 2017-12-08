package edu.jabs.bookstore.gui;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.table.AbstractTableModel;

import edu.jabs.bookstore.domain.Book;
import edu.jabs.bookstore.domain.PurchaseItem;
import edu.jabs.bookstore.domain.ShoppingCart;

/**
 * table model for the shopping cart
 */
public class ShoppingCartTableModel extends AbstractTableModel
{

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Column titles
     */
    private String[] columnNames;

    /**
     * the shopping cart
     */
    private ShoppingCart cart;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the model for the catalog with the information from the store
     * @param aCart Shopping cart to be displayed. aCart != null.
     */
    public ShoppingCartTableModel( ShoppingCart aCart )
    {
        cart = aCart;
        String[] columnNamesAux = { "ISBN", "Title", "Amount", "Subtotal" };
        columnNames = columnNamesAux;

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Implements the method for table model and returns the number of rows to adjust to the shopping cart.
     * @return total rows. total >= 0.
     */
    public int getRowCount( )
    {
        int count = cart.getShoppingList( ).size( );
        return count;
    }

    /**
     * Implements the method for table model and returns the number of columns to adjust to the shopping car.
     * @return total columns. total >= 0
     */
    public int getColumnCount( )
    {
        int count = columnNames.length;
        return count;
    }

    /**
     * Implements the method for table model and returns the object in that cell.
     * @param rowIndex index for the rows. rowIndex >= 0
     * @param columnIndex Index for the columns. columIndex >= -1
     * @return data in the table. if the columnIndex is -1 returns the whole item.
     */
    public Object getValueAt( int rowIndex, int columnIndex )
    {

        Object datoItem = null;
        Object[] items = cart.getShoppingList( ).toArray( );
        PurchaseItem item = ( PurchaseItem )items[ rowIndex ];
        Book libroItem = item.getBook( );

        if( columnIndex == -1 )
            datoItem = item;
        else if( columnIndex == 0 )
            datoItem = libroItem.getISBN( );
        else if( columnIndex == 1 )
            datoItem = libroItem.getTitle( );
        else if( columnIndex == 2 )
            datoItem = new Integer( item.getRequestedAmount( ) );
        else if( columnIndex == 3 )
            datoItem = giveValueFormatt( item.calculateTotalItem( ) );

        return datoItem;
    }

    /**
     * SImplements the method for table model and returns the column name.
     * @param col Column whose name we want. col >= 0.
     * @return column name
     */
    public String getColumnName( int col )
    {
        String name = columnNames[ col ];
        return name;
    }

    /**
     * Implements the method for table model and decides whether the cell is editable or not.
     * @param row row index. row >= 0.
     * @param col column index. col >=0 .
     * @return true if it can be edited, false otherwise
     */
    public boolean isCellEditable( int row, int col )
    {
        return false;
    }

    /**
     * Gives the numbers that will be displayed in the gui a proper format.
     * @param valor  numeric value to be given format.
     * @return String with the number in the correct format.
     */
    private String giveValueFormatt( int valor )
    {
        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( valor );
    }

}