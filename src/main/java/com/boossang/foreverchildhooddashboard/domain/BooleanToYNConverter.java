package com.boossang.foreverchildhooddashboard.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if(attribute == null)
            return "";
        else if(attribute)
            return "Y";
        else
            return "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if("Y".equalsIgnoreCase(dbData))
            return true;
        else if("N".equalsIgnoreCase(dbData))
            return false;
        else
            return null;
    }
}
