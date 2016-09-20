package manoj.com.dynamicview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import manoj.com.dynamicview.widget.Widget;

/**
 * Created by manoj on 20/09/16.
 */
public class ConverterWidgetToView {

    public static View buildView(Context context, Widget widget, ViewGroup parent) {
        if (widget == null) {
            return null;
        }

        View view = widget.createView(context);

        /* default Layout in case the user not set it */
        ViewGroup.LayoutParams params = createLayoutParams(parent);
        widget.applyLayoutProperties(params);
        view.setLayoutParams(params);

        widget.applyStyleProperties(view);

        if (view instanceof ViewGroup && widget.getChildViews() != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (Widget child : widget.getChildViews()) {
                View dynamicChildView = buildView(context, child, parent);
                if (dynamicChildView != null) {
                    viewGroup.addView(dynamicChildView);
                }
            }
        }

        return view;
    }

    private static ViewGroup.LayoutParams createLayoutParams(ViewGroup viewGroup) {
        ViewGroup.LayoutParams params = null;
        if (viewGroup != null) {
            try {
                /* find parent viewGroup and create LayoutParams of that class */
                Class layoutClass = viewGroup.getClass();
                while (!classExists(layoutClass.getName() + "$LayoutParams")) {
                    layoutClass = layoutClass.getSuperclass();
                }
                String layoutParamsClassname = layoutClass.getName() + "$LayoutParams";
                Class layoutParamsClass = Class.forName(layoutParamsClassname);
                /* create the actual layoutParams object */
                params = (ViewGroup.LayoutParams) layoutParamsClass.getConstructor(Integer.TYPE, Integer.TYPE).newInstance(new Object[]{ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (params == null)
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        return params;
    }

    private static boolean classExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (ClassNotFoundException ex) {
            return false;
        }
    }
}
