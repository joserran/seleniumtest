package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by joserran on 10/8/2015.
 */

@RunWith(Categories.class)
@Categories.IncludeCategory({Critical.class})
public interface Critical {

}
