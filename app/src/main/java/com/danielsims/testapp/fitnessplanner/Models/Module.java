package com.danielsims.testapp.fitnessplanner.Models;

public class Module {
    private String Title;
    private String Description;
    private String ActionName;

    public Module(String title, String description, String actionName) {
        Title = title;
        Description = description;
        ActionName = actionName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getActionName() {
        return ActionName;
    }

    public void setActionName(String actionName) {
        ActionName = actionName;
    }
}
