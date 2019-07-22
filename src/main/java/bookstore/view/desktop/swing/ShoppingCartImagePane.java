package bookstore.view.desktop.swing;

import bookstore.domain.PurchaseItem;
import bookstore.domain.ShoppingCart;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Shopping cart image pane
 */
public class ShoppingCartImagePane extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String DELETE_CAR = "DELETE_CAR";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Shopping cart table model
     */
    private ShoppingCartTableModel tableModel;

    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------

    /**
     * Shopping cart table
     */
    private JTable cartTable;

    /**
     * Amount field
     */
    private JTextField amountField;

    /**
     * Main GUI
     */
    private BookStoreSwing mainwindow;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the operations image pane
     * @param aWindow Main window. aWindow != null.
     * @param aCart Main shopping cart. aCart != null.
     */
    public ShoppingCartImagePane( BookStoreSwing aWindow, ShoppingCart aCart )
    {
        mainwindow = aWindow;

        setLayout( new BorderLayout( ) );
        setBorder( new EmptyBorder( 5, 1, 5, 1 ) );
        setBorder( BorderFactory.createTitledBorder( "Shopping cart details" ) );

        // Creates the image pane to display the cart
        tableModel = new ShoppingCartTableModel( aCart );
        cartTable = new JTable( tableModel );
        cartTable.setPreferredScrollableViewportSize( new Dimension( 475, 100 ) );

        // Drag bar
        JScrollPane dragImagePane = new JScrollPane( cartTable );

        add( dragImagePane, BorderLayout.CENTER );

        //Management buttons
        JPanel panelOpciones = new JPanel( );
        panelOpciones.setLayout( new GridLayout( 1, 4, 8, 2 ) );
        panelOpciones.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Delete book button
        JButton deleteBookButton = new JButton( );
        initializeButtons( deleteBookButton, "Delete", ShoppingCartImagePane.DELETE_CAR, Color.black, "Deletes a book from the shopping cart" );

        // Amount label
        JLabel amount = new JLabel( "Total" );
        amount.setHorizontalAlignment( SwingConstants.RIGHT );
        amountField = new JTextField( "" + 0 );
        amountField.setPreferredSize( new Dimension( 100, 20 ) );
        amountField.setEditable( false );
        panelOpciones.add( deleteBookButton );
        panelOpciones.add( amount );
        panelOpciones.add( amountField );
        add( panelOpciones, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * Updates the information displayed on the kart
     */
    public void updateCart( )
    {
        tableModel.fireTableDataChanged( );
    }

    /**
     * Responds to the events produced by the user
     * @param event Event produced by the user. event != null.
     */
    public void actionPerformed( ActionEvent event )
    {
        String actionCommand = event.getActionCommand( );

        // Delete cart button
        if( actionCommand.equals( ShoppingCartImagePane.DELETE_CAR ) )
        {
            try
            {
                //looks for the item that is to be deleted
                int selectedRow = cartTable.getSelectedRow( );

                if( selectedRow == -1 )
                {
                    JOptionPane.showMessageDialog( this, "you must first select an item in order to delete", "Book purchase", JOptionPane.WARNING_MESSAGE );
                    return;
                }

                PurchaseItem deleteItem = ( PurchaseItem )cartTable.getValueAt( selectedRow, -1 );

                //Deletes the item
                mainwindow.deletePurchase( deleteItem );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "you must first select an item in order to delete", "Book purchase", JOptionPane.WARNING_MESSAGE );
            }
        }

    }

    /**
     * changes the amount
     * @param value new value.
     */
    public void setAmount( int value )
    {
        amountField.setText( giveValueFormatt( value ) );
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