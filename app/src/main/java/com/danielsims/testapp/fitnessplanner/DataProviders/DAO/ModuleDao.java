package com.danielsims.testapp.fitnessplanner.DataProviders.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.danielsims.testapp.fitnessplanner.Entities.Module;

import java.util.List;

@Dao
public interface ModuleDao {
    @Query("SELECT * FROM modules")
    List<Module> getAllModules();

    @Insert
    void insert(List<Module> modules);

    @Insert
    void insert(Module... modules);

    @Update
    void update(Module... modules);

    @Delete
    void delete(Module... modules);

}
