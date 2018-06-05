package com.danielsims.testapp.fitnessplanner.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "modules")
public class Module {
    public enum ModuleType {
        Workout,
        WeightTracker
    }

    @PrimaryKey
    @NonNull
    public final String id;

    public final String name;
    public final String title;
    public final String description;
    public final String actionName;

    //Add a converter to allow storing the module type enum
    public final String moduleType;

    public Module(String id, String name, String title, String description, String moduleType, String actionName) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.moduleType = moduleType;
        this.actionName = actionName;
    }
}
