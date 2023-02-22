package toymacro;

import java.awt.Robot;

public class MACRO_SETTING {
    Object keyInfo = null;
    Robot rob;
    
    MACRO_SETTING(){
        
    }
    
    
    //마우스 좌클릭 Event
    public void MouseClick_Left(Object keyInfo)throws Exception {
        rob = new Robot();
        
    }
    //마우스 휠클릭 Event
    public void MouseClick_Center(Object keyInfo)throws Exception {
        rob = new Robot();
        
    }
    //마우스 우클릭 Event
    public void MouseClick_Right(Object keyInfo)throws Exception {
        rob = new Robot();
        
    }
    
    
    
}
