package demo.springboot.junitmockito.demospringbootjunitmockito.unittest;

import demo.springboot.junitmockito.demospringbootjunitmockito.unittesting.BusinessService;
import demo.springboot.junitmockito.demospringbootjunitmockito.unittesting.DataService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessServiceMockContextTest {
    
    @MockBean
    DataService dataServiceMock;
    
    @Autowired
    BusinessService businessImpl;
    
    @Test
    public void testFindTheGrestFromAllData() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
                24,
                15,
                3
        });
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testFindTheGreatFromAllData_ForOneValue() {
        
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
                15
        });
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testFindTheGreatFromAllData_NoValues() {
        
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
    
}
