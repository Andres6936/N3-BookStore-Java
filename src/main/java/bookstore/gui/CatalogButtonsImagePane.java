package bookstore.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Image pane that organizes the buttons for the catalog
 */
public class CatalogButtonsImagePane extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    private static final String OPTION_1 = "OPTION_1";
    private static final String OPTION_2 = "OPTION_2";
    private static final String ADD_BOOK = "ADD_BOOK";

    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------

    /**
     * Extension button 1
     */
    private JButton buttonOption1;

    /**
     * Extension button 2
     */
    private JButton buttonOption2;
    /**
     * Add book button
     */
    private JButton addBookButton;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * Instance for the main GUI class
     */
    private BookStoreGUI mainWindow;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------

    /**
     * Creates the operations image pane.
     * @param window Main window. window != null.
     */
    public CatalogButtonsImagePane( BookStoreGUI window )
    {
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
        setLayout( new GridLayout( 1, 3, 8, 1 ) );
        mainWindow = window;

        addBookButton = new JButton( );
        initializeButtons( addBookButton, "Add book", CatalogButtonsImagePane.ADD_BOOK, Color.black, "Add a new book to the catalog" );
        add( addBookButton );

        buttonOption1 = new JButton( );
        initializeButtons( buttonOption1, "Option 1", CatalogButtonsImagePane.OPTION_1, Color.black, "Option 1" );
        add( buttonOption1 );

        buttonOption2 = new JButton( );
        initializeButtons( buttonOption2, "Option 2", CatalogButtonsImagePane.OPTION_2, Color.black, "Option 2" );
        add( buttonOption2 );

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
     * @param event Event produced by the user. event != null.
     */
    public void actionPerformed( ActionEvent event )
    {
        String actionCommand = event.getActionCommand( );

        // Add book
        if( actionCommand.equals( CatalogButtonsImagePane.ADD_BOOK ) )
        {
            mainWindow.addBook( );
        }
        // Option 1
        else if( actionCommand.equals( CatalogButtonsImagePane.OPTION_1 ) )
        {
            mainWindow.funcReqOption1( );
        }
        // Option 2
        else if( actionCommand.equals( CatalogButtonsImagePane.OPTION_2 ) )
        {
            mainWindow.funcReqOption2( );
        }
    }
}