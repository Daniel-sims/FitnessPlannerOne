package com.danielsims.testapp.fitnessplanner.Models;

public class Module {
    public static enum ModuleType {
        Fitness
    }
    private String Title;
    private String Description;
    private String ActionName;
    private ModuleType mModuleType;

    public Module(String title, String description, String actionName, ModuleType moduleType) {
        Title = title;
        Description = description;
        ActionName = actionName;
        mModuleType = moduleType;

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

    public ModuleType getModuleType() {
        return mModuleType;
    }

    public void setModuleType(ModuleType moduleType) {
        mModuleType = moduleType;
    }
}
