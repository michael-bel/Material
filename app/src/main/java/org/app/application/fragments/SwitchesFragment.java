package org.app.application.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

import org.app.application.R;
import org.app.material.widget.LayoutHelper;
import org.app.material.widget.Switch;

public class SwitchesFragment extends Fragment {

    private Switch switch1;
    private Switch switch2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_switches, vGroup, false);

        FrameLayout layout = (FrameLayout) view.findViewById(R.id.frameLock);
        layout.setBackgroundColor(0xFFF0F0F0);

        switch1 = (Switch) view.findViewById(R.id.m_switch);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // do something
            }
        });

        switch2 = new Switch(getContext());
        switch2.withRTL(false);
        switch2.withAnimationDuration(220);
        switch2.withThumbColorNormal(0xFFF1F1F1);
        switch2.withTrackColorNormal(0xFFB0AFAF);
        switch2.withThumbColorActivated(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        switch2.withTrackColorActivated(ContextCompat.getColor(getContext(), R.color.md_blue_200));
        switch2.setLayoutParams(LayoutHelper.makeFrame(getContext(), LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.END | Gravity.TOP, 0, 50, 100, 0));
        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // do something
            }
        });
        layout.addView(switch2);

        return view;
    }
}