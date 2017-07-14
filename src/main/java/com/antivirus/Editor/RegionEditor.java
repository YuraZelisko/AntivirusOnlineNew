package com.antivirus.Editor;


    import com.antivirus.entity.Region;

    import java.beans.PropertyEditorSupport;

    public class RegionEditor extends PropertyEditorSupport {

        @Override
        public void setAsText(String idRegionFromJSP) throws IllegalArgumentException {

            Region region = new Region();
            region.setId(Integer.valueOf(idRegionFromJSP));

            setValue(region);

        }
    }

