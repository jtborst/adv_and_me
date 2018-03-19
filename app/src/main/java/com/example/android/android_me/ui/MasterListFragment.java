package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

/**
 * Created by jtborst on 16/03/2018.
 */

public class MasterListFragment extends Fragment {

    private List<Integer> mImageResources;

    public MasterListFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mImageResources = AndroidImageAssets.getAll();

        View mRootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gv = (GridView) mRootView.findViewById(R.id.image_grid);
        gv.setNumColumns(3);
        gv.setAdapter(new MasterListAdapter(getContext(), mImageResources));

        return mRootView;
    }
}
