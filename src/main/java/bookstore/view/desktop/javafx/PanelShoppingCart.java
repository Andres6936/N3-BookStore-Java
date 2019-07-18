package bookstore.view.desktop.javafx;

import bookstore.domain.ShoppingCart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class PanelShoppingCart extends Pane
{
    TableView< ShoppingCart > tableView;

    TableColumn< ShoppingCart, String > columnISBN;
    TableColumn< ShoppingCart, String > columnTitle;
    TableColumn< ShoppingCart, String > columnAmount;
    TableColumn< ShoppingCart, String > columnSubtotal;

    public PanelShoppingCart( )
    {
        setPrefHeight( 190 );
        setPrefWidth( 500 );
        setStyle( "-fx-background-color: white" );

        tableView = new TableView<>( );
        tableView.setLayoutX( 10 );
        tableView.setLayoutY( 5 );
        tableView.setPrefHeight( 180 );
        tableView.setPrefWidth( 480 );

        columnISBN = new TableColumn<>( "ISBN" );
        configurationStyleColumn( columnISBN, 120 );

        columnTitle = new TableColumn<>( "Title" );
        configurationStyleColumn( columnTitle, 200 );

        columnAmount = new TableColumn<>( "Amount" );
        configurationStyleColumn( columnAmount, 80 );

        columnSubtotal = new TableColumn<>( "Subtotal" );
        configurationStyleColumn( columnSubtotal, 80 );

        tableView.getColumns( ).add( columnISBN );
        tableView.getColumns( ).add( columnTitle );
        tableView.getColumns( ).add( columnAmount );
        tableView.getColumns( ).add( columnSubtotal );

        getChildren( ).add( tableView );
    }

    private static void configurationStyleColumn(
            TableColumn< ShoppingCart, String > column, final double width )
    {
        column.setPrefWidth( width );
        column.setResizable( false );
    }
}
