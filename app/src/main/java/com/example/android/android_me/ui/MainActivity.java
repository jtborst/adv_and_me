/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

import java.util.concurrent.ExecutionException;

// This activity is responsible for displaying the master list of all images
// Implement the MasterListFragment callback, OnImageClickListener
public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    public static final String HEAD_POSITION_ID = "head";
    public static final String BODY_POSITION_ID = "body";
    public static final String LEG_POSITION_ID = "leg";
    private int headPos, bodyPos, legPos;
    private static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Define the behavior for onImageSelected
    public void onImageSelected(int position) {
        // Create a Toast that displays the position that was clicked
        Toast.makeText(this, "Position clicked = " + position, Toast.LENGTH_SHORT).show();

        // TODO (2) Based on where a user has clicked, store the selected list index for the head, body, and leg BodyPartFragments
        String bodyType;
        switch (position / 12) {
            case 0:
                headPos = position % 12;
            case 1:
                bodyPos = position % 12;
            case 2:
                legPos = position % 12;
        }

        // TODO (3) Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity


        final Intent intent = new Intent(this, AndroidMeActivity.class);

        intent.putExtra(HEAD_POSITION_ID, headPos);
        intent.putExtra(BODY_POSITION_ID, bodyPos);
        intent.putExtra(LEG_POSITION_ID, legPos);
        Log.i(TAG, "" + position % 12);

        // TODO (4) Get a reference to the "Next" button and launch the intent when this button is clicked
        Button nextButton = (Button) findViewById(R.id.button_grid_view);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

    }
}
