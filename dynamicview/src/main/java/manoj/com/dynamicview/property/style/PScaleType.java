package manoj.com.dynamicview.property.style;

import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;

/**
 * Created by manoj on 20/09/16.
 */
public class PScaleType extends StyleProperty {

    public PScaleType(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case SCALE_TYPE:
                ImageView.ScaleType scaleType = ImageView.ScaleType.valueOf(getData().toUpperCase());
                ((ImageView) view).setScaleType(scaleType);
                break;
            default:
                return;
        }
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view instanceof ImageView;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(PropertyValueType.SCALE_TYPE);
    }
}
