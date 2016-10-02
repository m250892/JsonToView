package manoj.com.dynamicview.property.params;

import android.view.ViewGroup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.MATCH_PARENT;
import static manoj.com.dynamicview.property.PropertyValueType.WRAP_CONTENT;

/**
 * Created by manoj on 19/09/16.
 */
public class PLayoutHeight extends LayoutProperty {

    public PLayoutHeight(String data) {
        super(data);
    }

    @Override
    protected void addRule(ViewGroup.LayoutParams params, HashMap<String, Integer> ids) {
        params.height = getValue();
    }

    @Override
    protected boolean isParamsTypeValid(ViewGroup.LayoutParams params) {
        return params != null;
    }

    protected int getValue() {
        int result = -1;
        switch (getType()) {
            case MATCH_PARENT:
                result = -1;
                break;
            case WRAP_CONTENT:
                result = -2;
                break;
            case DP:
                result = (int) Utils.dpToPx(Utils.parseDimenValue(getData()));
                break;
        }
        return result;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(MATCH_PARENT, WRAP_CONTENT, PropertyValueType.DP);
    }
}