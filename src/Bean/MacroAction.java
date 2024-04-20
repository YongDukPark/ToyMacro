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
    private int indexNumber = 0;
    private String actionType = null;
    private HashMap<Object, Object> actionValue = new HashMap<>();
    private boolean action = true;
    
    public MacroAction(int indexNumber, String actionType, HashMap<Object, Object> clickPoint, boolean action){
        this.indexNumber = indexNumber;
        this.actionType = actionType;
        this.actionValue = actionValue;
        this.action = action;
    }
    
    public void setIndexNumber(int indexNumber) {
        this.indexNumber = indexNumber;
    }
    
    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public void setActionValue(HashMap<Object, Object> clickPoint) {
        this.actionValue = clickPoint;
    }

    public void setAction(boolean action) {
        this.action = action;
    }
    
    public int getIndexNumber() {
        return indexNumber;
    }
    
    public String getActionType() {
        return actionType;
    }

    public HashMap<Object, Object> getActionValue() {
        return actionValue;
    }

    public boolean isAction() {
        return action;
    }
    
    
    
}
