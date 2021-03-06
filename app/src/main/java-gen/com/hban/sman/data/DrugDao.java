package com.hban.sman.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DRUG".
*/
public class DrugDao extends AbstractDao<Drug, Void> {

    public static final String TABLENAME = "DRUG";

    /**
     * Properties of entity Drug.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property DrugName = new Property(0, String.class, "drugName", false, "DRUG_NAME");
        public final static Property DrugCode = new Property(1, String.class, "drugCode", false, "DRUG_CODE");
    };


    public DrugDao(DaoConfig config) {
        super(config);
    }
    
    public DrugDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DRUG\" (" + //
                "\"DRUG_NAME\" TEXT," + // 0: drugName
                "\"DRUG_CODE\" TEXT);"); // 1: drugCode
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DRUG\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Drug entity) {
        stmt.clearBindings();
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(1, drugName);
        }
 
        String drugCode = entity.getDrugCode();
        if (drugCode != null) {
            stmt.bindString(2, drugCode);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Drug entity) {
        stmt.clearBindings();
 
        String drugName = entity.getDrugName();
        if (drugName != null) {
            stmt.bindString(1, drugName);
        }
 
        String drugCode = entity.getDrugCode();
        if (drugCode != null) {
            stmt.bindString(2, drugCode);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Drug readEntity(Cursor cursor, int offset) {
        Drug entity = new Drug( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // drugName
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // drugCode
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Drug entity, int offset) {
        entity.setDrugName(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setDrugCode(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Drug entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Drug entity) {
        return null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
