package bookstore.view.desktop.swing;

import bookstore.domain.Book;
import bookstore.domain.BookStore;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Catalog image pane
 */
public class CatalogImagePane extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------

    private static final String ADD_CART = "ADD_CART";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
    /**
     * Catalog table model
     */
    private CatalogTableModel catalog;

    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------

    /**
     * CAtalog table
     */
    private JTable catalogTable;

    /**
     * drag bar
     */
    private JScrollPane dragImaegePane;

    /**
     * Main GUI class
     */
    private BookStoreSwing mainwindow;

    /**
     * Buy book button
     */
    private JButton buyBookButton;

    /**
     * Title Label
     */
    private JLabel titleLabel;

    /**
     * Title Field
     */
    private JTextField txtAmount;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the image pane that handles the dialog
     * @param gui Main GUI. gui != null.
     * @param store Book store to display. store != null.
     */

    public CatalogImagePane( BookStoreSwing gui, BookStore store )
    {
        mainwindow = gui;

        setLayout( new BorderLayout( ) );
        setBorder( new EmptyBorder( 5, 1, 5, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Catalog details" ) );

        // Creates a table for the catalog
        catalog = new CatalogTableModel( store );
        catalogTable = new JTable( catalog );
        catalogTable.setPreferredScrollableViewportSize( new Dimension( 480, 100 ) );

        dragImaegePane = new JScrollPane( catalogTable );
        add( dragImaegePane, BorderLayout.CENTER );

        //buy and amount buttons
        JPanel buyPanel = new JPanel( );
        buyPanel.setLayout( new FlowLayout( ) );
        buyPanel.setPreferredSize( new Dimension( 200, 50 ) );

        //amount
        JPanel amountPanel = new JPanel( );
        titleLabel = new JLabel( "Amount " );
        titleLabel.setPreferredSize( new Dimension( 100, 20 ) );
        txtAmount = new JTextField( );
        txtAmount.setPreferredSize( new Dimension( 100, 20 ) );
        txtAmount.setColumns( 15 );
        txtAmount.setPreferredSize( new Dimension( 100, 20 ) );
        amountPanel.setLayout( new GridLayout( 3, 0 ) );
        amountPanel.setPreferredSize( new Dimension( 80, 50 ) );
        amountPanel.add( titleLabel );
        amountPanel.add( txtAmount );
        buyPanel.add( amountPanel );

        buyBookButton = new JButton( );
        initializeButtons( buyBookButton, "Buy", CatalogImagePane.ADD_CART, Color.black, "Add a book to the shopping cart" );
        buyPanel.add( buyBookButton );
        add( buyPanel, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Updates the information displayed on the catalog
     */
    public void updateCatalog( )
    {
        catalog.fireTableDataChanged( );
    }

    /**
     * Defines the properties for a button
     * @param button buttons whose properties are being defined. button !=null.
     * @param label Text on the button. label != null.
     * @param command ACtion associated with the button. command != null
     * @param textColor Color text color for the text on the button. textColor != null.
     * @param help help text for the button. help != null.
     */
    private void initializeButtons( JButton button, String label, String command, Color textColor, String help )
    {
        button.setText( label );
        button.setFocusable( false );
        button.setActionCommand( command );
        button.addActionListener( this );
        button.setForeground( textColor );
        button.setToolTipText( help );
        button.setDefaultCapable( false );
    }

    /**
     * Responds to the events produced by the user
     * @param evento Event produced by the user. event != null.
     */
    public void actionPerformed( ActionEvent evento )
    {
        String actionCommand = evento.getActionCommand( );

        if( actionCommand.equals( CatalogImagePane.ADD_CART ) )
        {
            //Gets the amount
            int amount;
            try
            {
                amount = Integer.parseInt( txtAmount.getText( ) );
                if( amount <= 0 )
                {
                    JOptionPane.showMessageDialog( this, "The amount must be greater than 0", "Book purchase", JOptionPane.ERROR_MESSAGE );
                    return;
                }
            }
            catch( Exception exception )
            {
                JOptionPane.showMessageDialog( this, "you must input a number", "Book purchase", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //Gets the book
            Book book;
            try
            {
                book = ( Book )catalogTable.getValueAt( catalogTable.getSelectedRow( ), -1 );
            }
            catch( Exception e )
            {
                JOptionPane.showMessageDialog( this, "You must select a book", "Book purchase", JOptionPane.ERROR_MESSAGE );
                return;
            }

            //continues with the event
            mainwindow.addPurchase( book, amount );
        }

    }
}
