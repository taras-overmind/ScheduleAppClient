package com.taras_overmind.scheduleApp.adapter;

import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.taras_overmind.scheduleApp.FridayFragment;
import com.taras_overmind.scheduleApp.MondayFragment;
import com.taras_overmind.scheduleApp.ThursdayFragment;
import com.taras_overmind.scheduleApp.TuesdayFragment;
import com.taras_overmind.scheduleApp.WendesdayFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: return new TuesdayFragment();
            case 2: return new WendesdayFragment();
            case 3: return new ThursdayFragment();
            case 4: return new FridayFragment();
            default: return new MondayFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
