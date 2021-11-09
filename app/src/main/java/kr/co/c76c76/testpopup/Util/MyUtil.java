package kr.co.c76c76.testpopup.Util;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.co.c76c76.testpopup.MyConst;

public class MyUtil {

    public static final boolean DEBUG_WRITE_FILE = false;

    public static int REQUEST_PERMISSIONS = 9999;




    public static void SEN_LOG (String msg){
        if(MyConst.IS_DEBUG)
        {
            Log.i("SEN_LOG", msg);

            if(DEBUG_WRITE_FILE)
            {
                writeLog(msg);
            }
        }
    }


    public static void writeLog(String str)
    {
        String str_Path_Full = Environment.getExternalStorageDirectory().getAbsolutePath() + "/download/log2.txt";

        // 시간 stamp
        str = "[" + getNowTimeString() + "] " + str;

        File file = new File(str_Path_Full);

        if (file.exists() == false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
            }
        } else {
            try {
                BufferedWriter bfw = new BufferedWriter(new FileWriter(str_Path_Full,true));
                bfw.write(str);
                bfw.write("\n");
                bfw.flush();
                bfw.close();
            } catch (FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
    }


    public static String getNowTimeString() {

        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formatDate = sdfNow.format(date);

        return formatDate;
    }

}
