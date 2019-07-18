package bookstore.view.desktop.javafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;

public class PanelCatalogBookBuy extends Pane
{
    HBox layout;

    Label labelAmount;

    TextField textAmount;

    Button buttonBuy;

    PanelCatalogBookBuy()
    {
        setPrefHeight( 40 );
        setPrefWidth( 500 );
        setStyle( "-fx-background-color: white;" );

        layout = new HBox( );
        layout.setAlignment( Pos.CENTER );
        layout.setPrefHeight( 40 );
        layout.setPrefWidth( 500 );

        labelAmount = new Label( "Amount" );
        labelAmount.setTextAlignment( TextAlignment.CENTER );

        layout.getChildren( ).addAll( labelAmount );
        HBox.setMargin( labelAmount,
                        new Insets( 0, 12, 0, 0 ) );

        textAmount = new TextField( );
        textAmount.setStyle( "-fx-background-radius: 0;" );

        layout.getChildren( ).addAll( textAmount );

        buttonBuy = new Button( "Button" );
        buttonBuy.setMnemonicParsing( false );
        buttonBuy.setStyle( "-fx-background-color: white;" +
                                    "-fx-background-radius: 0;" );

        layout.getChildren( ).addAll( buttonBuy );
        HBox.setMargin( buttonBuy,
                        new Insets( 0, 0, 0, 12 ) );

        getChildren( ).addAll( layout );
    }
}
