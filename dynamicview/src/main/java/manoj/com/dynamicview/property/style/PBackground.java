package manoj.com.dynamicview.property.style;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

import java.util.Arrays;
import java.util.List;

import manoj.com.dynamicview.Utils;
import manoj.com.dynamicview.property.PropertyValueType;

import static manoj.com.dynamicview.property.PropertyValueType.BASE64;
import static manoj.com.dynamicview.property.PropertyValueType.COLOR;
import static manoj.com.dynamicview.property.PropertyValueType.REFERENCE;

/**
 * Created by manoj on 17/09/16.
 */
public class PBackground extends StyleProperty {

    public PBackground(String data) {
        super(data);
    }

    @Override
    public void addStyle(View view) {
        switch (getType()) {
            case COLOR:
                view.setBackgroundColor((Integer) getValue(view.getContext()));
                break;
            case BASE64:
                Drawable drawable = (Drawable) getValue(view.getContext());
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN)
                    view.setBackground(drawable);
                else
                    view.setBackgroundDrawable(drawable);
                break;
            case REFERENCE:
                view.setBackgroundResource((Integer) getValue(view.getContext()));
                break;
        }
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view != null;
    }

    public PropertyValueType getType() {
        return PropertyValueType.getDataType(getPropertyTypes(), getData());
    }

    public List<PropertyValueType> getPropertyTypes() {
        return Arrays.asList(COLOR, REFERENCE, BASE64);
    }

    public Object getValue(Context context) {
        switch (getType()) {
            case COLOR:
                return Utils.convertColor(getData());
            case BASE64:
                String data = Utils.getDataWithoutPrefix(BASE64, getData());
                Bitmap bitmap = Utils.convertBase64ToBitmap(data);
                return new BitmapDrawable(Resources.getSystem(), bitmap);
            case REFERENCE:
                String dataName = Utils.getDataWithoutPrefix(REFERENCE, getData());
                return Utils.getDrawableId(context, dataName);
        }
        return null;
    }
}
