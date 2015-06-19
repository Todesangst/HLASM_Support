
package com.HLASMplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.HLASMplugin.HLASMLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HLASMTokenType extends IElementType {
    public HLASMTokenType(@NotNull @NonNls String debugName) {
        super(debugName, HLASMLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "HLASMTokenType." + super.toString();
    }
}