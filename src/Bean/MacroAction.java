/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class MacroAction {
    private String actionType = null;
    private HashMap<Object, Object> clickPoint = new HashMap<>();
    private boolean action = true;
    
    public MacroAction(String actionType, HashMap<Object, Object> clickPoint, boolean action){
        this.actionType = actionType;
        this.clickPoint = clickPoint;
        this.action = action;
    }
    
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void setClickPoint(HashMap<Object, Object> clickPoint) {
        this.clickPoint = clickPoint;
    }

    public void setAction(boolean action) {
        this.action = action;
    }

    public String getActionType() {
        return actionType;
    }

    public HashMap<Object, Object> getClickPoint() {
        return clickPoint;
    }

    public boolean isAction() {
        return action;
    }
    
    
    
}
