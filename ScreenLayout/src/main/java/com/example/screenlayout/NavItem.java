package com.example.screenlayout;

/**
 * Created by stephen on 13-7-11.
 */
public class NavItem {
    private String title;
    private String target;
    private String targetType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public NavItem(String title, String target, String targetType) {
        this.title = title;
        this.target = target;
        this.targetType = targetType;
    }
}
