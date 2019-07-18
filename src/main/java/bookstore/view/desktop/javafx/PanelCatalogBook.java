package bookstore.view.desktop.javafx;

import bookstore.domain.Book;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class PanelCatalogBook extends Pane
{
    private TableView< Book > tableView;

    private TableColumn< Book, String > columnISBN;
    private TableColumn< Book, String > columnTitle;
    private TableColumn< Book, String > columnPrice;

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

        columnISBN = new TableColumn<>( "ISBN" );
        configurationStyleColumn( columnISBN, 140 );


        columnTitle = new TableColumn<>( "Title" );
        configurationStyleColumn( columnTitle, 230 );

        columnPrice = new TableColumn<>( "Price" );
        configurationStyleColumn( columnPrice, 110 );

        tableView.getColumns( ).add( columnISBN );
        tableView.getColumns( ).add( columnTitle );
        tableView.getColumns( ).add( columnPrice );

        getChildren( ).add( tableView );
    }

    private static void configurationStyleColumn( TableColumn< Book, String > column,
                                                  final double width )
    {
        column.setEditable( false );
        column.setResizable( false );
        column.setPrefWidth( width );
    }
}
