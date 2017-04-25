package ce.simple.spring_boot.junitTest.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import ce.simple.spring_boot.junitTest.asserts.AssertTest;

@RunWith(Categories.class)
@SuiteClasses(AssertTest.class)
@IncludeCategory(AssertEqual.class)
@ExcludeCategory(AssertOther.class)
public class AssertCategoryTest {
	
}
