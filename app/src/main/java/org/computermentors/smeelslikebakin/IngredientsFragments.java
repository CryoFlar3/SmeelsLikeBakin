package org.computermentors.smeelslikebakin;

public class IngredientsFragments extends CheckBoxesFragments{
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
