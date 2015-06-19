
package com.HLASMplugin;

import com.HLASMplugin.HLASMLanguage;
import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class HLASMFileType extends LanguageFileType {
    public static final HLASMFileType INSTANCE = new HLASMFileType();

    private HLASMFileType() {
        super(HLASMLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "HLASM file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "HLASM language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "HLASM";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return HLASMIcons.FILE;
    }
}