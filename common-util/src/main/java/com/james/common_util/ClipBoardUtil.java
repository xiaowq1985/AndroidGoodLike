package com.james.common_util;

import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;

/**
 * 剪切板读写工具
 */
public class ClipBoardUtil {
    /**
     * 获取剪切板内容
     *
     * @return
     */
    public static String getPasteContent(Context context) {
        ClipboardManager manager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (manager != null) {
            if (manager.hasPrimaryClip() && manager.getPrimaryClip().getItemCount() > 0) {
                CharSequence addedText = manager.getPrimaryClip().getItemAt(0).getText();
                String addedTextString = String.valueOf(addedText);
                if (!TextUtils.isEmpty(addedTextString)) {
                    return addedTextString;
                }
            }
        }
        return "";
    }

    public static void clear(Context context) {
        ClipboardManager manager = (ClipboardManager) context.getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
        if (manager != null) {
            try {
                manager.setText("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
