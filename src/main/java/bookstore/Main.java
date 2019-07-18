package bookstore;

import bookstore.gui.BookStoreGUI;

public class Main
{
    /**
     * Main execution method
     * @param args The command line arguments
     */
    public static void main( String[] args )
    {
        try
        {
            BookStoreGUI gui = new BookStoreGUI( );
            gui.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
}
