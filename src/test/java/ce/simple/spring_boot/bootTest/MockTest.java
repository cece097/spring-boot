package ce.simple.spring_boot.bootTest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import ce.simple.spring_boot.service.ContractService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockTest {
	
	@MockBean
    private ContractService contractService;
	
	@Test
    public void exampleTest() {
		BDDMockito.given(this.contractService.count()).willReturn(100);
		int count = this.contractService.count();
		Assertions.assertThat(count).isEqualTo(101); //org.junit.ComparisonFailure: expected:<10[1]> but was:<10[0]>
	}
}
