package bookstore.view.desktop.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookStoreFX extends Application
{

    @Override
    public void start( Stage stage ) throws Exception
    {
        VBox layout = new VBox( new PanelCatalogBookOption( ),
                                new PanelCatalogBookTable( ),
                                new PanelCatalogBookBuy( ),
                                new PanelShoppingCartTable( ),
                                new PanelShoppingCartOption( ) );

        layout.setPrefHeight( 500 );
        layout.setPrefWidth( 500 );

        Group rootGroup = new Group( layout );

        Scene scene = new Scene( rootGroup, 500, 500 );

        stage.setTitle( "Book Store" );
        stage.setScene( scene );
        stage.setResizable( false );
        stage.show();
    }

    public static void main( String[] args )
    {
        launch( args );
    }
}
