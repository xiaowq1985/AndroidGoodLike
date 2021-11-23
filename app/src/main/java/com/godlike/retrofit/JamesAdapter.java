package com.godlike.retrofit;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.james.godlike.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class JamesAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public JamesAdapter(int layoutResId, @Nullable @org.jetbrains.annotations.Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull @NotNull BaseViewHolder helper, String item) {
        helper.setText(R.id.txt_item, item);
    }
}