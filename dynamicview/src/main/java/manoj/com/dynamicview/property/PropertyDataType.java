package manoj.com.dynamicview.property;

import java.util.List;

/**
 * Created by manoj on 19/09/16.
 */
public enum PropertyDataType {
    WRAP_CONTENT("^wrap_content$"),
    MATCH_PARENT("^match_parent$"),
    VERTICAL("^vertical$"),
    HORIZONTAL("^horizontal$"),
    DP("^\\d+dp$"),
    SP("^\\d+sp$"),
    REFERENCE("^@ref/[\\w]+$"), //@ref/ssss
    COLOR("^#[a-f0-9]{6}$"), //#00ff00
    BOOLEAN("^(true)|(false)$"),
    INTEGER("^\\d+$"),
    STRING(".");

    private String regex;

    PropertyDataType(String regex) {
        this.regex = regex;
    }

    public static PropertyDataType getDataType(List<PropertyDataType> matches, String data) {
        for (PropertyDataType propertyDataType : matches) {
            if (data.toLowerCase().matches(propertyDataType.regex)) {
                return propertyDataType;
            }
        }
        return STRING;
    }
}
