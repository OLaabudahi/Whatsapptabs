package com.example.whatsapptabs;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new CallsFragment();
            case 1: return new ChatsFragment();
            case 2: return new StatusFragment();
            default: return new ChatsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}