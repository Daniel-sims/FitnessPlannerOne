package com.danielsims.testapp.fitnessplanner.DataProviders;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.danielsims.testapp.fitnessplanner.DataProviders.DAO.ModuleDao;
import com.danielsims.testapp.fitnessplanner.Entities.Module;

//ExportSchema is apparently good practice to have a history of your schema but don't have the need to have one atm
@Database(entities = {Module.class}, version = FitnessPlannerDatabase.VERSION, exportSchema = false)
public abstract class FitnessPlannerDatabase extends RoomDatabase {
    static final int VERSION = 1;
    private static final String DB_NAME = "fitnessPlanner.db";

    //This is volatile to avoid issues with multi threading.
    //When multiple threads access this database instance they take their own copy of the local cache for this
    //and when saving it saves it to that local cache meaning other threads don't know about the changes.
    //By declaring this volatile all threads save to the main memory instance so others threads can access it.
    // See - https://stackoverflow.com/questions/9851133/when-to-use-volatile-and-synchronized?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    private static volatile FitnessPlannerDatabase instance;

    //This is syncronized to avoid multiple threads access the method at the same time
    //See - https://stackoverflow.com/questions/9851133/when-to-use-volatile-and-synchronized?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
    static synchronized FitnessPlannerDatabase getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }

    private static FitnessPlannerDatabase create(final Context context){
        return Room.databaseBuilder(
                context,
                FitnessPlannerDatabase.class,
                DB_NAME).build();
    }

    public abstract ModuleDao getModuleDao();
}
