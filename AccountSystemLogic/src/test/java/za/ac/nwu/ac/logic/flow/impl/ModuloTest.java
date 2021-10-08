package za.ac.nwu.ac.logic.flow.impl;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ModuloTest {

    private Modulo mod;

    @Before
    public void setUp() throws Exception
    {
        mod = new Modulo();
    }
    @Test
    public void testMod()
    {
      Integer result =  mod.doMod(9, 5);
      assertNotNull("should not be null", result);
      assertEquals("Should be value 4", 4,result.intValue());
    }

    @Test()
    public  void testModBy0() {
        try{
            mod.doMod(9, 0);
            fail("show throw an exception");
        }
        catch(Exception e)
        {
            assertTrue("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason"));
        }

    }
}
