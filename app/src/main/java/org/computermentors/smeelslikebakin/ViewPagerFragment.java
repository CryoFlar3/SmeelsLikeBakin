package org.computermentors.smeelslikebakin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "recipe_index";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        final IngredientsFragment ingredientsFragment = new IngredientsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        ingredientsFragment.setArguments(bundle);
        final DirectionsFragment directionsFragment = new DirectionsFragment();
        bundle = new Bundle();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        directionsFragment.setArguments(bundle);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                return 2;
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
