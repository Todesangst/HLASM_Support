
package com.HLASMplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.HLASMplugin.HLASMLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HLASMElementType extends IElementType {
    public HLASMElementType(@NotNull @NonNls String debugName) {
        super(debugName, HLASMLanguage.INSTANCE);
    }
}