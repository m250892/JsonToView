package manoj.com.dynamicview.property;

import manoj.com.dynamicview.property.params.PLayoutHeight;
import manoj.com.dynamicview.property.params.PLayoutWidth;
import manoj.com.dynamicview.property.style.POrientation;
import manoj.com.dynamicview.property.params.PPadding;
import manoj.com.dynamicview.property.style.PBackground;
import manoj.com.dynamicview.property.style.PText;

/**
 * Created by manoj on 16/09/16.
 */
public class FactoryProperty {

    public static Property getProperty(String key, String value) {
        switch (key.toLowerCase()) {
            case "layout_width":
                return new PLayoutWidth(value);
            case "layout_height":
                return new PLayoutHeight(value);
            case "background":
                return new PBackground(value);
            case "padding":
                return new PPadding(value);
            case "text":
                return new PText(value);
            case "orientation":
                return new POrientation(value);
        }
        return null;
    }
}
