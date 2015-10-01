package me.qmx.uf.client.screens;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;

import com.ait.lienzo.client.core.shape.Layer;
import com.ait.lienzo.client.core.shape.Text;
import com.ait.lienzo.client.core.types.Shadow;
import com.ait.lienzo.client.widget.LienzoPanel;
import com.ait.lienzo.shared.core.types.ColorName;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import org.uberfire.client.annotations.WorkbenchPartTitle;
import org.uberfire.client.annotations.WorkbenchScreen;

@Dependent
@WorkbenchScreen(identifier = "LienzoScreen")
public class LienzoScreen extends Composite {

    interface Binder
            extends
            UiBinder<Widget, LienzoScreen> {

    }

    @UiField
    FlowPanel sample;


    private static Binder uiBinder = GWT.create( Binder.class );

    @PostConstruct
    public void init() {
        initWidget( uiBinder.createAndBindUi( this ) );
        generateLienzoStuff();
    }

    private void generateLienzoStuff() {
        //the api should use GWT.Create on gwt components
        //but that is not my api.
        LienzoPanel panel = new LienzoPanel(400, 300);

        Text text = new Text("Hello World!", "Verdana, sans-serif", "italic bold", 40);
        text.setX(10).setY(100);
        text.setFillColor( ColorName.CORNFLOWERBLUE);
        text.setStrokeColor(ColorName.BLUE);
        text.setShadow(new Shadow(ColorName.DARKMAGENTA, 6, 4, 4));

        Layer layer = new Layer();
        panel.add(layer);

        layer.add(text);
        layer.draw();

        sample.add( panel );

    }

    @WorkbenchPartTitle
    public String getTitle() {
        return "Greetings";
    }

}
