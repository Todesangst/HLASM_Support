package com.HLASMplugin;

import com.intellij.lang.Language;

public class HLASMLanguage extends Language {
    public static final HLASMLanguage INSTANCE = new HLASMLanguage();

    private HLASMLanguage() {
        super("HLASM");
    }
}