package ce.simple.spring_boot.junitTest;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.CombinableMatcher;
import org.hamcrest.CoreMatchers;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import ce.simple.spring_boot.common.calculator.Calculator;
import ce.simple.spring_boot.entity.embedded.Duration;
import ce.simple.spring_boot.enums.RepaymentMethod;

/**
 * 单元测试基本功能
 * @author zss
 * @date 2017年4月20日
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloTest {
	
	@Test(timeout=100)
	public void interestTest(){
		Duration duration = new Duration(1,0,0);
		
		BigDecimal interest = Calculator.quickInterest(10000, 850, duration, RepaymentMethod.BulletRepayment);
		
		System.out.println(interest);
		assertEquals(new BigDecimal("850.00"), interest);
		assertThat(7, CoreMatchers.not(CombinableMatcher.<Integer> either(CoreMatchers.equalTo(3)).or(CoreMatchers.equalTo(4))));
	}
	
	//assertSame ==
	@Ignore("Test is ignored as a demonstration") //忽略
	@Test
	public void aTest(){
		assertSame("aaa","aaa");
	}
	
	//简单方法，抛出异常
	@Test(expected = IndexOutOfBoundsException.class) 
	public void empty() { 
	     new ArrayList<Object>().get(0); 
	}
	
	//定位异常内容
	@Test
	public void testExceptionMessage() {
	    try {
	        new ArrayList<Object>().get(0);
	        fail("Expected an IndexOutOfBoundsException to be thrown");
	    } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	        assertThat(anIndexOutOfBoundsException.getMessage(), CoreMatchers.is("Index: 0, Size: 0"));
	    }
	}
	
	//定位问题及错误信息方法二
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
	    List<Object> list = new ArrayList<Object>();
	 
	    thrown.expect(IndexOutOfBoundsException.class);
	    thrown.expectMessage("Index: 0, Size: 0"); 
//	    thrown.expectMessage(CoreMatchers.containsString("Size: 0"));
//	    thrown.expectMessage(CoreMatchers.startsWith("Index: 0"));
	    list.get(0); // execution will never get past this line
	}
}
