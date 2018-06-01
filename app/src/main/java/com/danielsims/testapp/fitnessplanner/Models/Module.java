package com.danielsims.testapp.fitnessplanner.Models;

import android.content.Intent;

public class Module {
    private String Title;
    private String Description;
    private String ActionName;
    private Intent ActionIntent;

    public Module(String title, String description, String actionName, Intent actionIntent) {
        Title = title;
        Description = description;

        ActionName = actionName;
        ActionIntent = actionIntent;

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

    public Intent getActionIntent() {
        return ActionIntent;
    }

    public void setActionIntent(Intent actionIntent) {
        ActionIntent = actionIntent;
    }

}
