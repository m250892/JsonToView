package manoj.com.dynamicview.property.style;

import android.view.View;

import manoj.com.dynamicview.IOnClickListener;

/**
 * Created by manoj on 21/09/16.
 */
public class POnClickProperty extends StyleProperty {

    private IOnClickListener onClickListener;

    public POnClickProperty(String data) {
        super(data);
    }

    public void registerClickListener(IOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override
    public void addStyle(final View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickListener != null) {
                    onClickListener.onDynamicViewClick(view, getData());
                }
            }
        });
    }

    @Override
    protected boolean isViewTypeValid(View view) {
        return view != null;
    }
}
