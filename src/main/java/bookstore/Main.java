package bookstore;

import bookstore.view.desktop.IBookStoreUI;
import bookstore.view.desktop.javafx.BookStoreFX;
import bookstore.view.desktop.swing.BookStoreSwing;

public class Main
{
    private static IBookStoreUI application;

    /**
     * Main execution method.
     * @param args The command line arguments.
     */
    public static void main( String[] args )
    {
        if ( args.length == 0 )
        {
            System.out.println( "\nPlease, Choice User Interface:\n" );
            System.out.println( "-Swing: Run Swing Application" );
            System.out.println( "-JavaFX: Run JavaFX Application" );
        }
        else
        {
            if ( args[ 0 ].equals( "-Swing" ) )
            {
                application = new BookStoreSwing( );
            }
            else if ( args[ 0 ].equals( "-JavaFX" ) )
            {
                application = new BookStoreFX( );
            }

            application.abracadabra( args );
        }
    }
}
