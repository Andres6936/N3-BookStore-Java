package bookstore.view.desktop.javafx;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

public class PanelCatalogBookOption extends Pane
{
    Button buttonAddBook;
    Button buttonOption1;
    Button buttonOption2;

    HBox layout;

    PanelCatalogBookOption()
    {
        setPrefHeight( 40 );
        setPrefWidth( 500 );
        setStyle( "-fx-background-color: white;" );

        layout = new HBox( );
        layout.setAlignment( Pos.CENTER );
        layout.setPrefHeight( 40 );
        layout.setPrefWidth( 500 );

        buttonAddBook = new Button( "Add Book" );
        configurationButtonStyle( buttonAddBook );

        buttonOption1 = new Button( "Option 1" );
        configurationButtonStyle( buttonOption1 );

        buttonOption2 = new Button( "Option 2" );
        configurationButtonStyle( buttonOption2 );

        layout.getChildren().addAll( buttonAddBook,
                                     buttonOption1,
                                     buttonOption2 );

        getChildren().addAll( layout );
    }

    private static void configurationButtonStyle( Button button )
    {
        button.setAlignment( Pos.CENTER );
        button.setMnemonicParsing( false );
        button.prefHeight( 35 );
        button.setPrefWidth( 160 );
        button.setStyle( "-fx-background-color: white;" +
                         "-fx-background-radius: 0;" );
        // The text of button has already been established.
        button.setTextAlignment( TextAlignment.CENTER );
    }
}
