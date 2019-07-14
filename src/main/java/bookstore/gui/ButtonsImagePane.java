package bookstore.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Image pane that displays the book's information
 */
public class ButtonsImagePane extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // GUI Attributes
    // -----------------------------------------------------------------
    /**
     * Confirm button
     */
    private JButton confirmButton;

    /**
     * Cancel button
     */
    private JButton cancelButton;

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * dialog window
     */
    private AddBookDialog window;

    // -----------------------------------------------------------------
    // Constructors
    // -----------------------------------------------------------------
    /**
     * Creates the image pane where the buttons go
     * @param aWindow the dialog window. aWindow != null.
     */
    public ButtonsImagePane( AddBookDialog aWindow )
    {

        window = aWindow;
        setPreferredSize( new Dimension( 200, 100 ) );
        setLayout( new FlowLayout( ) );

        // Confirm
        confirmButton = new JButton( );
        confirmButton.setPreferredSize( new Dimension( 80, 25 ) );
        inicializarBotones( confirmButton, "Confirm", "CONFIRM", Color.black );
        add( confirmButton );

        // Cancel
        cancelButton = new JButton( );
        cancelButton.setPreferredSize( new Dimension( 80, 25 ) );
        inicializarBotones( cancelButton, "Cancel", "CANCEL", Color.black );
        add( cancelButton );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------
    /**
     * Defines the properties for a button
     * @param button buttons whose properties are being defined. button !=null.
     * @param label Text on the button. label != null.
     * @param command ACtion associated with the button. command != null
     * @param textColor Color text color for the text on the button. textColor != null.
     */
    private void inicializarBotones( JButton button, String label, String command, Color textColor )
    {
        button.setText( label );
        button.setFocusable( false );
        button.setActionCommand( command );
        button.addActionListener( this );
        button.setForeground( textColor );
        button.setDefaultCapable( false );
    }

    /**
     * Responds to the events produced by the user
     * @param event Event produced by the user. event != null.
     */
    public void actionPerformed( ActionEvent event )
    {
        String actionCommand = event.getActionCommand( );

        // Confirm button
        if( actionCommand.equals( "CONFIRM" ) )
        {
            window.whenConfirmed( );
        }
        // Cancel button
        if( actionCommand.equals( "CANCEL" ) )
        {
            window.cancelAction( );
        }
    }
}
