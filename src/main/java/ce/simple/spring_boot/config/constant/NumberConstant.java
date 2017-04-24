package ce.simple.spring_boot.config.constant;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class NumberConstant {
	
	/**BigDecimal 运算默认保留位数 **/
	public static final int DEFAULT_SCALE = 2;
	
	/**利率计算默认系数（n/10000） **/
	public static final int DEFAULT_RATESCALE = 10000;
	
	public static final BigDecimal ZERO = new BigDecimal(BigInteger.ZERO, DEFAULT_SCALE, MathContext.DECIMAL64);
	
	/** 银行家舍入法 **/
	public static final RoundingMode ROUNDING_MODE = RoundingMode.HALF_EVEN;
}
