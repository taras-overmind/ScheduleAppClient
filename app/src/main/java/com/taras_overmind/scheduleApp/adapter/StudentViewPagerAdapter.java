package com.taras_overmind.scheduleApp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.taras_overmind.scheduleApp.fragment.student.FridayFragment;
import com.taras_overmind.scheduleApp.fragment.student.MondayFragment;
import com.taras_overmind.scheduleApp.fragment.student.ThursdayFragment;
import com.taras_overmind.scheduleApp.fragment.student.TuesdayFragment;
import com.taras_overmind.scheduleApp.fragment.student.WednesdayFragment;

public class StudentViewPagerAdapter extends FragmentStateAdapter {
        public StudentViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1: return new TuesdayFragment();
            case 2: return new WednesdayFragment();
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
