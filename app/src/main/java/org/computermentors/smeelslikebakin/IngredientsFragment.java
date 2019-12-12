package org.computermentors.smeelslikebakin;

public class IngredientsFragment extends CheckBoxesFragments{
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
