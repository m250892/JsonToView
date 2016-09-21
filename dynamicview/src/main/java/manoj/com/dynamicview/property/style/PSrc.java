package manoj.com.dynamicview.property.style;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.property.PropertyValueType;
import manoj.com.dynamicview.Utils;

import static manoj.com.dynamicview.property.PropertyValueType.BASE64;
import static manoj.com.dynamicview.property.PropertyValueType.REFERENCE;

/**
 * Created by manoj on 20/09/16.
 */
public class PSrc extends StyleProperty {

    public PSrc(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case BASE64:
                ((ImageView) view).setImageBitmap(getValue());
                break;
            case REFERENCE:
                break;
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
        return Arrays.asList(BASE64, REFERENCE);
    }

    public Bitmap getValue() {
        return Utils.convertBase64ToBitmap(Utils.getDataWithoutPrefix(getType(), getData()));
    }
}
