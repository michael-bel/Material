/*
 * Copyright 2015 Michael Bel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.app.application.cells;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import org.app.application.R;
import org.app.material.AndroidUtilities;
import org.app.material.widget.LayoutHelper;

public class CardCell extends CardView {

    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private ImageView mImageView;
    private ImageView mOptionButton;

    private Rect rect = new Rect();

    public CardCell(Context context) {
        super(context);

        mImageView = new ImageView(context);
        mImageView.setFocusable(false);
        mImageView.setScaleType(ImageView.ScaleType.CENTER);
        mImageView.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.START | Gravity.CENTER_VERTICAL, 10, 0, 10, 0));
        addView(mImageView);

        mTextView1 = new TextView(context);
        mTextView1.setTextColor(ContextCompat.getColor(context, R.color.textColorPrimary));
        mTextView1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        mTextView1.setTypeface(Typeface.create("sans-serif-medium", Typeface.NORMAL));
        mTextView1.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.START | Gravity.TOP, 100, 17, 21, 0));
        addView(mTextView1);

        mTextView2 = new TextView(context);
        mTextView2.setTextColor(ContextCompat.getColor(context, R.color.textColorSecondary));
        mTextView2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
        mTextView2.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.START | Gravity.CENTER_VERTICAL, 100, 0, 21, 0));
        addView(mTextView2);

        mTextView3 = new TextView(context);
        mTextView3.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryLight));
        mTextView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        mTextView3.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.START | Gravity.BOTTOM, 100, 0, 21, 17));
        addView(mTextView3);

        mOptionButton = new ImageView(context);
        mOptionButton.setFocusable(false);
        mOptionButton.setScaleType(ImageView.ScaleType.CENTER);
        mOptionButton.setBackgroundResource(AndroidUtilities.selectableItemBackgroundBorderless());
        mOptionButton.setImageDrawable(AndroidUtilities.getIcon(R.drawable.ic_dots_menu,
                ContextCompat.getColor(context, R.color.textColorSecondary)));
        mOptionButton.setLayoutParams(LayoutHelper.makeFrame(context, LayoutHelper.WRAP_CONTENT,
                LayoutHelper.WRAP_CONTENT, Gravity.END | Gravity.TOP, 5, 5, 5, 5));
        addView(mOptionButton);
    }

    public CardCell setText1(String text) {
        mTextView1.setText(text);
        return this;
    }

    public CardCell setText2 (String text) {
        mTextView2.setText(text);
        return this;
    }

    public CardCell setText3 (String text) {
        mTextView3.setText(text);
        return this;
    }

    public CardCell setImage(int image) {
        mImageView.setImageResource(image);
        return this;
    }

    public void setOnOptionsClick(OnClickListener listener) {
        mOptionButton.setOnClickListener(listener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(100), MeasureSpec.EXACTLY));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (Build.VERSION.SDK_INT >= 21 && getBackground() != null) {
            if (rect.contains((int) event.getX(), (int) event.getY())) {
                return true;
            }

            if (event.getAction() == MotionEvent.ACTION_DOWN ||
                    event.getAction() == MotionEvent.ACTION_MOVE) {
                getBackground().setHotspot(event.getX(), event.getY());
            }
        }

        return super.onTouchEvent(event);
    }
}