package com.appsenseca.categories;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;

/**
 * Created by joserran on 10/8/2015.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Major.class})
public interface Major {

}
