package org.computermentors.smeelslikebakin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import static org.computermentors.smeelslikebakin.ViewPagerFragment.KEY_RECIPE_INDEX;

public class DualPaneFragment extends Fragment {
    private static final String INGREDIENTS_FRAGMENT = "ingredients_fragment";
    private static final String DIRECTIONS_FRAGMENT = "directions_fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);
        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        FragmentManager fragmentManager = getChildFragmentManager();

        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT);

        if (savedIngredientsFragment == null){
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENTS_FRAGMENT).commit();
        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT);

        if (savedDirectionsFragment == null){
            DirectionsFragment directionsFragments = new DirectionsFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_RECIPE_INDEX, index);
            directionsFragments.setArguments(bundle);
            fragmentManager.beginTransaction().add(R.id.rightPlaceholder, directionsFragments, DIRECTIONS_FRAGMENT).commit();
        }

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
