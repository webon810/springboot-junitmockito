package demo.springboot.junitmockito.demospringbootjunitmockito.unittest;

import demo.springboot.junitmockito.demospringbootjunitmockito.unittesting.BusinessService;
import demo.springboot.junitmockito.demospringbootjunitmockito.unittesting.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class) 
public class BusinessServiceMockTest {
    
    @Mock
    DataService dataServiceMock;
    
    @InjectMocks
    BusinessService businessImpl;
    
    @Test
    public void testFindTheGreatestFromAllData(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
                24,
                15, 
                3
        });
        assertEquals(24, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testfindTheGreatestFromAllData_ForOneValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {
                15
        });
        assertEquals(15, businessImpl.findTheGreatestFromAllData());
    }
    
    @Test
    public void testfindTheGreatestFromAllData_NoValue() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
    
}
