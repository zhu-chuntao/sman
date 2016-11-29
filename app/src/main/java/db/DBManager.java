package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.hban.sman.data.DaoMaster;
import com.hban.sman.data.DaoSession;
import com.hban.sman.data.Drug;
import com.hban.sman.data.DrugDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class DBManager {
    private final static String dbName = "test_db";
    private static DBManager mInstance;
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
        openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
    }

    /**
     * 获取单例引用
     *
     * @param context
     * @return
     */
    public static DBManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName, null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    /**
     * 插入一条记录
     *
     * @param drug
     */
    public void insertUser(Drug drug) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DrugDao drugDao = daoSession.getDrugDao();
        drugDao.insert(drug);
    }

    /**
     * 查询用户列表
     */
    public List<Drug> queryUserList() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DrugDao drugDao = daoSession.getDrugDao();
        QueryBuilder<Drug> qb = drugDao.queryBuilder();
        List<Drug> list = qb.list();
        return list;
    }


    /**
     * 更新一条记录
     *
     * @param user
     */
    public void updateUser(Drug user) {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DrugDao drugDao = daoSession.getDrugDao();
        drugDao.update(user);
    }


}