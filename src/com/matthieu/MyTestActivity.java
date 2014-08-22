package com.matthieu;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyTestActivity extends Activity {
    private static final int MAX_PAGES = 10;

    private int num_pages = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final ViewPagerParallax pager = (ViewPagerParallax) findViewById(R.id.pager);
        pager.set_max_pages(MAX_PAGES);
        pager.setBackgroundAsset(R.raw.sanfran);
        pager.setAdapter(new my_adapter());

    }

    private class my_adapter extends PagerAdapter {
        @Override
        public int getCount() {
            return num_pages;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View new_view=null;

            LayoutInflater inflater = getLayoutInflater();
            new_view = inflater.inflate(R.layout.page, null);
            TextView num = (TextView) new_view.findViewById(R.id.page_number);
            num.setText(Integer.toString(position));

            container.addView(new_view);

            return new_view;
        }

    }
}

