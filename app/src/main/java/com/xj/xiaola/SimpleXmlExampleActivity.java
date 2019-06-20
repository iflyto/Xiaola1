/*
 * Copyright (C) 2016 Ronald Martin <hello@itsronald.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 10/12/16 11:22 PM.
 */

package com.xj.xiaola;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.LinearLayout;

import com.itsronald.widget.ViewPagerIndicator;

public class SimpleXmlExampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_xml_example);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);

//        final ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
//        layoutParams.width = LinearLayout.LayoutParams.MATCH_PARENT;
//        layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
//        layoutParams.gravity = Gravity.BOTTOM;
//
//        final ViewPagerIndicator viewPagerIndicator = new ViewPagerIndicator(this);
//        viewPager.addView(viewPagerIndicator, layoutParams);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    private static class PagerAdapter extends FragmentPagerAdapter {

        private static final int NUM_PAGES = 5;

        private PagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance("Page Number " + position);
        }
    }
}
