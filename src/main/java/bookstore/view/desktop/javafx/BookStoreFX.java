package bookstore.view.desktop.javafx;

import bookstore.Main;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BookStoreFX extends Application
{

    @Override
    public void start( Stage stage ) throws Exception
    {
        VBox layout = new VBox( new PanelCatalogBookOption( ),
                                new PanelCatalogBook( ),
                                new PanelCatalogBookBuy( ),
                                new PanelShoppingCart( ) );

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
