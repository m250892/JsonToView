package manoj.com.dynamicview.property;

import manoj.com.dynamicview.property.params.PAlignBaseLine;
import manoj.com.dynamicview.property.params.PAlignBottom;
import manoj.com.dynamicview.property.params.PAlignEnd;
import manoj.com.dynamicview.property.params.PAlignLeft;
import manoj.com.dynamicview.property.params.PAlignParentBottom;
import manoj.com.dynamicview.property.params.PAlignParentEnd;
import manoj.com.dynamicview.property.params.PAlignParentLeft;
import manoj.com.dynamicview.property.params.PAlignParentRight;
import manoj.com.dynamicview.property.params.PAlignParentStart;
import manoj.com.dynamicview.property.params.PAlignParentTop;
import manoj.com.dynamicview.property.params.PAlignRight;
import manoj.com.dynamicview.property.params.PAlignStart;
import manoj.com.dynamicview.property.params.PAlignTop;
import manoj.com.dynamicview.property.params.PCenterHorizontal;
import manoj.com.dynamicview.property.params.PCenterInParent;
import manoj.com.dynamicview.property.params.PCenterVertical;
import manoj.com.dynamicview.property.params.PLMargin;
import manoj.com.dynamicview.property.params.PLMarginBottom;
import manoj.com.dynamicview.property.params.PLMarginLeft;
import manoj.com.dynamicview.property.params.PLMarginRight;
import manoj.com.dynamicview.property.params.PLMarginTop;
import manoj.com.dynamicview.property.params.PLayoutAbove;
import manoj.com.dynamicview.property.params.PLayoutBelow;
import manoj.com.dynamicview.property.params.PLayoutGravity;
import manoj.com.dynamicview.property.params.PLayoutHeight;
import manoj.com.dynamicview.property.params.PLayoutWidth;
import manoj.com.dynamicview.property.params.PToEndOf;
import manoj.com.dynamicview.property.params.PToLeftOf;
import manoj.com.dynamicview.property.params.PToRightOf;
import manoj.com.dynamicview.property.params.PToStartOf;
import manoj.com.dynamicview.property.style.PBackground;
import manoj.com.dynamicview.property.style.PClickable;
import manoj.com.dynamicview.property.style.PEnabled;
import manoj.com.dynamicview.property.style.PGravity;
import manoj.com.dynamicview.property.style.PID;
import manoj.com.dynamicview.property.style.POnClickProperty;
import manoj.com.dynamicview.property.style.POrientation;
import manoj.com.dynamicview.property.style.PPadding;
import manoj.com.dynamicview.property.style.PPaddingBottom;
import manoj.com.dynamicview.property.style.PPaddingLeft;
import manoj.com.dynamicview.property.style.PPaddingRight;
import manoj.com.dynamicview.property.style.PPaddingTop;
import manoj.com.dynamicview.property.style.PScaleType;
import manoj.com.dynamicview.property.style.PSelected;
import manoj.com.dynamicview.property.style.PSrc;
import manoj.com.dynamicview.property.style.PText;
import manoj.com.dynamicview.property.style.PTextColor;
import manoj.com.dynamicview.property.style.PTextSize;

/**
 * Created by manoj on 16/09/16.
 */
public class FactoryProperty {

    public static Property getProperty(String key, String value) {
        switch (key.toLowerCase()) {
            case "id":
                return new PID(value);
            case "layout_width":
                return new PLayoutWidth(value);
            case "layout_height":
                return new PLayoutHeight(value);
            case "layout_margin":
                return new PLMargin(value);
            case "layout_marginLeft":
                return new PLMarginLeft(value);
            case "layout_marginTop":
                return new PLMarginTop(value);
            case "layout_marginRight":
                return new PLMarginRight(value);
            case "layout_marginBottom":
                return new PLMarginBottom(value);


            case "background":
                return new PBackground(value);
            case "padding":
                return new PPadding(value);
            case "padding_left":
                return new PPaddingLeft(value);
            case "padding_right":
                return new PPaddingRight(value);
            case "padding_top":
                return new PPaddingTop(value);
            case "padding_bottom":
                return new PPaddingBottom(value);
            case "text":
                return new PText(value);
            case "orientation":
                return new POrientation(value);
            case "textcolor":
                return new PTextColor(value);
            case "textsize":
                return new PTextSize(value);
            case "gravity":
                return new PGravity(value);
            case "src":
                return new PSrc(value);
            case "scaletype":
                return new PScaleType(value);
            case "enabled":
                return new PEnabled(value);
            case "selected":
                return new PSelected(value);
            case "clickable":
                return new PClickable(value);


            case "layout_above":
                return new PLayoutAbove(value);
            case "layout_below":
                return new PLayoutBelow(value);
            case "layout_alignbaseline":
                return new PAlignBaseLine(value);
            case "layout_alignbottom":
                return new PAlignBottom(value);
            case "layout_alignend":
                return new PAlignEnd(value);
            case "layout_alignleft":
                return new PAlignLeft(value);
            case "layout_alignright":
                return new PAlignRight(value);
            case "layout_alignstart":
                return new PAlignStart(value);
            case "layout_aligntop":
                return new PAlignTop(value);
            case "layout_toendof":
                return new PToEndOf(value);
            case "layout_toleftof":
                return new PToLeftOf(value);
            case "layout_torightof":
                return new PToRightOf(value);
            case "layout_tostartof":
                return new PToStartOf(value);
            case "layout_alignparentbottom":
                return new PAlignParentBottom(value);
            case "layout_alignparentend":
                return new PAlignParentEnd(value);
            case "layout_alignparentleft":
                return new PAlignParentLeft(value);
            case "layout_alignparentright":
                return new PAlignParentRight(value);
            case "layout_alignparentstart":
                return new PAlignParentStart(value);
            case "layout_alignparenttop":
                return new PAlignParentTop(value);
            case "layout_centehorizontal":
                return new PCenterHorizontal(value);
            case "layout_centerinparent":
                return new PCenterInParent(value);
            case "layout_centervertical":
                return new PCenterVertical(value);
            case "layout_gravity":
                return new PLayoutGravity(value);

            case "onclick":
                return new POnClickProperty(value);
        }
        return null;
    }
}
