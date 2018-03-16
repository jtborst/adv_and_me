package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by jtborst on 16/03/2018.
 */

public class BodyPartFragment extends Fragment {

    public BodyPartFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View baseView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView mImageView = (ImageView) baseView.findViewById(R.id.body_part_image_view);

        mImageView.setImageResource(AndroidImageAssets.getHeads().get(0));

        return baseView;
    }
}
