package manoj.com.dynamicview.property.params;

import android.view.View;

import manoj.com.dynamicview.property.Utils;
import manoj.com.dynamicview.property.style.StyleProperty;

/**
 * Created by manoj on 16/09/16.
 */
public class PPadding extends StyleProperty {

    public PPadding(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        view.setPadding(getValue(), getValue(), getValue(), getValue());
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return true;
    }

    public int getValue() {
        //Parsing data and check its type
        float value = Utils.parseDimenValue(getData());
        return (int) Utils.dpToPx(value);
    }
}
