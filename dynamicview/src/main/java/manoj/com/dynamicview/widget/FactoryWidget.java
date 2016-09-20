package manoj.com.dynamicview.widget;

/**
 * Created by manoj on 16/09/16.
 */
public class FactoryWidget {
    public static Widget getWidget(String value) {
        switch (value.toLowerCase()) {
            case "linearlayout":
                return new WLinearLayout();
            case "textview":
                return new WTextView();
        }
        return null;
    }
}
