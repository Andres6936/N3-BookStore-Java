package bookstore.view.desktop.javafx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PanelShoppingCartOption extends Pane
{
    private HBox layout;

    private Button buttonDelete;

    private Label labelTotal;

    private TextField textField;

    public PanelShoppingCartOption( )
    {
        setLayoutX( 450 );
        setPrefHeight( 40 );
        setPrefWidth( 500 );
        setStyle( "-fx-background-color: white" );

        layout = new HBox( );
        layout.setAlignment( Pos.CENTER_LEFT );
        layout.setPrefHeight( 40 );
        layout.setPrefWidth( 500 );

        buttonDelete = new Button( "Delete" );
        buttonDelete.setMnemonicParsing( false );
        buttonDelete.setStyle( "-fx-background-color: white;" +
                                       "-fx-background-radius: 0;" );

        layout.getChildren( ).add( buttonDelete );
        HBox.setMargin( buttonDelete,
                        new Insets( 0, 0, 0, 10 ) );

        labelTotal = new Label( "Total" );

        layout.getChildren( ).add( labelTotal );
        HBox.setMargin( labelTotal,
                        new Insets( 0, 10, 0, 205 ) );

        textField = new TextField( );
        textField.setAlignment( Pos.CENTER );
        textField.setStyle( "-fx-background-radius: 0;" );

        layout.getChildren( ).add( textField );

        getChildren( ).add( layout );
    }
}
