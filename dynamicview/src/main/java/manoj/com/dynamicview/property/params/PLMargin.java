package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.Utils;

import static manoj.com.dynamicview.property.PropertyValueType.DP;

/**
 * Created by manoj on 20/09/16.
 */
public class PLMargin extends LayoutProperty {

    public PLMargin(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        ViewGroup.MarginLayoutParams p = ((ViewGroup.MarginLayoutParams) params);
        p.bottomMargin = p.topMargin = p.leftMargin = p.rightMargin = getValue();
    }

    @Override
    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return getType() == DP && params instanceof ViewGroup.MarginLayoutParams;
    }

    public int getValue() {
        //Parsing data and check its type
        float value = Utils.parseDimenValue(getData());
        return (int) Utils.dpToPx(value);
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(DP);
    }
}
