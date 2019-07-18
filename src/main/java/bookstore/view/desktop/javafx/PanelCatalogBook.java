package bookstore.view.desktop.javafx;

import bookstore.domain.Book;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class PanelCatalogBook extends Pane
{
    private TableView tableView;

    private TableColumn columnISBN;
    private TableColumn columnTitle;
    private TableColumn columnPrice;

    public PanelCatalogBook( )
    {
        setPrefHeight( 190 );
        setPrefWidth( 500 );
        setStyle( "-fx-background-color: white;" );

        tableView = new TableView< Book >( );
        tableView.setLayoutX( 10 );
        tableView.setLayoutY( 5 );
        tableView.setPrefHeight( 180 );
        tableView.setPrefWidth( 480 );

        columnISBN = new TableColumn< Book, String >( "ISBN" );
        configurationStyleColumn( columnISBN, 140 );


        columnTitle = new TableColumn< Book, String >( "Title" );
        configurationStyleColumn( columnTitle, 230 );

        columnPrice = new TableColumn< Book, String >( "Price" );
        configurationStyleColumn( columnPrice, 110 );

        tableView.getColumns( ).add( columnISBN );
        tableView.getColumns( ).add( columnTitle );
        tableView.getColumns( ).add( columnPrice );

        getChildren( ).add( tableView );
    }

    private static void configurationStyleColumn( TableColumn column,
                                                  final double width )
    {
        column.setEditable( false );
        column.setResizable( false );
        column.setPrefWidth( width );
    }
}
