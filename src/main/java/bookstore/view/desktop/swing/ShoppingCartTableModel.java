package bookstore.view.desktop.swing;

import bookstore.domain.Book;
import bookstore.domain.PurchaseItem;
import bookstore.domain.ShoppingCart;

import javax.swing.table.AbstractTableModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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
    private static final String[] COLUMN_NAMES = new String[]{ "ISBN", "Title", "Amount", "Subtotal" };

    /**
     * the shopping cart
     */
    private ShoppingCart shoppingCart;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the model for the catalog with the information from the store
     * @param shoppingCart Shopping cart to be displayed. shoppingCart != null.
     */
    public ShoppingCartTableModel( ShoppingCart shoppingCart )
    {
        this.shoppingCart = shoppingCart;
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
        return shoppingCart.getShoppingList( ).size( );
    }

    /**
     * Implements the method for table model and returns the number of columns to adjust to the shopping car.
     * @return total columns. total >= 0
     */
    public int getColumnCount( )
    {
        return COLUMN_NAMES.length;
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
        final Object[] items = shoppingCart.getShoppingList( ).toArray( );
        PurchaseItem purchaseItem = ( PurchaseItem ) items[ rowIndex ];
        Book itemBook = purchaseItem.getBook( );

        if( columnIndex == -1 )
        {
            datoItem = purchaseItem;
        }
        else if( columnIndex == 0 )
        {
            datoItem = itemBook.getISBN( );
        }
        else if( columnIndex == 1 )
        {
            datoItem = itemBook.getTitle( );
        }
        else if ( columnIndex == 2 )
        {
            datoItem = purchaseItem.getRequestedAmount( );
        }
        else if ( columnIndex == 3 )
        {
            datoItem = giveValueFormatt( purchaseItem.calculateTotalItem( ) );
        }

        return datoItem;
    }

    /**
     * SImplements the method for table model and returns the column name.
     * @param col Column whose name we want. col >= 0.
     * @return column name
     */
    public String getColumnName( int col )
    {
        return COLUMN_NAMES[ col ];
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