package manoj.com.dynamicview.property;

import java.util.List;

/**
 * Created by manoj on 19/09/16.
 */
public enum PropertyValueType {
    ID("^@id/[\\w]+$"),
    WRAP_CONTENT("^wrap_content$"),
    MATCH_PARENT("^match_parent$"),
    VERTICAL("^vertical$"),
    HORIZONTAL("^horizontal$"),
    DP("^\\d+dp$"),
    SP("^\\d+sp$"),
    BASE64("^@base64/(.)+$"),
    REFERENCE("^@ref/[\\w]+$"),
    COLOR("^#[a-f0-9]{6}$"),
    BOOLEAN("^(true)|(false)$"),
    INTEGER("^\\d+$"),
    STRING("."),
    SCALE_TYPE("^(center)|(center_crop)|(center_inside)|(fit_center)|(fit_end)|(fit_start)|(fit_xy)|(matrix)$"),
    GRAVITY_TYPE("^(center)|(center_horizontal)|(center_vertical)|(end)|(fill)|(left)|(right)|(start)|(top)|(bottom)|(no_gravity)|(flip_horizontal)|(flip_vertical)$");

    private String regex;

    PropertyValueType(String regex) {
        this.regex = regex;
    }

    public static PropertyValueType getDataType(List<PropertyValueType> matches, String data) {
        for (PropertyValueType propertyDataType : matches) {
            if (data.toLowerCase().matches(propertyDataType.regex)) {
                return propertyDataType;
            }
        }
        return STRING;
    }
}
