package manoj.com.dynamicview.property;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;

/**
 * Created by manoj on 19/09/16.
 */
public class Utils {

    public static float parseDimenValue(String dimen) {
        return Float.parseFloat(dimen.substring(0, dimen.length() - 2));
    }

    public static float dpToPx(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static int convertColor(String color) {
        return Color.parseColor(color);
    }
}
