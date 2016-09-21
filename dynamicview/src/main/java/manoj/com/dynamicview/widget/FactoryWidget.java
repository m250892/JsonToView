package manoj.com.dynamicview.widget;

/**
 * Created by manoj on 16/09/16.
 */
public class FactoryWidget {
    public static Widget getWidget(String value) {
        switch (value.toLowerCase()) {
            case "linearlayout":
                return new WLinearLayout();
            case "relativelayout":
                return new WRelativeLayout();
            case "textview":
                return new WTextView();
            case "imageview":
                return new WImageView();
            case "button":
                return new WButton();
            case "scrollview":
                return new PScrollView();
        }
        return null;
    }
}
