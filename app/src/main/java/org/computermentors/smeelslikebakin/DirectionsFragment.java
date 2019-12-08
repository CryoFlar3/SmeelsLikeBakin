package org.computermentors.smeelslikebakin;

public class DirectionsFragment extends CheckBoxesFragments{
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}