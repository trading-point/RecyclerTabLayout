package com.nshmura.recyclertablayout;

import android.support.v4.view.ViewPager;

public class ViewPagerOnPageChangeListener implements ViewPager.OnPageChangeListener {

    private final RecyclerTabLayout mRecyclerTabLayout;
    private int mScrollState;

    public ViewPagerOnPageChangeListener(RecyclerTabLayout recyclerTabLayout) {
        mRecyclerTabLayout = recyclerTabLayout;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        mRecyclerTabLayout.scrollToTab(position, positionOffset, false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        mScrollState = state;
    }

    @Override
    public void onPageSelected(int position) {
        if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
            if (mRecyclerTabLayout.mIndicatorPosition != position) {
                mRecyclerTabLayout.scrollToTab(position);
            }
        }
    }
}

