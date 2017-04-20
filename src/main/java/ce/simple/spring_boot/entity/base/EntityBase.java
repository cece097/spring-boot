package ce.simple.spring_boot.entity.base;

import java.io.Serializable;

/**
 * 实体公共属性或方法
 * @author zss
 * @date 2017年4月20日
 */
public abstract class EntityBase implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public String toString() {
        return "111";
    }
}
