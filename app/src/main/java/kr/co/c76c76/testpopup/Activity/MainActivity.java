package kr.co.c76c76.testpopup.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.c76c76.testpopup.R;
import kr.co.c76c76.testpopup.Util.DialogSupport;
import kr.co.c76c76.testpopup.Util.MyUtil;

public class MainActivity extends BaseActivity {

    private static String TAG_APP = "POPUP_APP";
    @Override
    protected void createActivity() {
        setContentView(R.layout.activity_main);
        initUI();
    }

    @Override
    protected void viewClick(View view) {

        switch (view.getId()) {

            case R.id.btn01:
                m_dialogSupport.showAlert(TAG_APP, "normal", true, null);
                break;

            case R.id.btn02:
                m_dialogSupport.showAlert(TAG_APP, "Dlg.lstner", true, onclklstner);
                break;

            case R.id.btn03:
                m_dialogSupport.showAlert(TAG_APP, "Dlg.lstner (canceler:false)", false, onclklstner);
                break;

            case R.id.btn04:
                m_dialogSupport.showAlert(TAG_APP, "Dlg.lstner (canceler:true)", true, onclklstner);
                break;

            case R.id.btn05:
                m_dialogSupport.showInfo(TAG_APP,"info", onclklstner);
                break;

            case R.id.btn06:
                m_dialogSupport.showConfirm1(TAG_APP, "yes/no (cancel)", true, onclklstner, onclklstner2);
                break;

            case R.id.btn07:
                m_dialogSupport.showConfirm1(TAG_APP, "yes/no (no cancel)", false, onclklstner, onclklstner2);
                break;

            case R.id.btn08:
                m_dialogSupport.showConfirm2(TAG_APP, "yes/no/cancel (cancel)", true, onclklstner, onclklstner2, onclklstner3);
                break;

            case R.id.btn09:
                m_dialogSupport.showConfirm2(TAG_APP, "yes/no/cancel (no cancel)", false, onclklstner, onclklstner2, onclklstner3);
                break;

            case R.id.btn10:
                m_dialogSupport.showToast("Toast show");
                break;

            case R.id.btn11:
                m_dialogSupport.hideToast();
                break;

            case R.id.btn12:
                m_dialogSupport.showProgress(TAG_APP, "show progress (canceler)", true);
                break;

            case R.id.btn13:
                m_dialogSupport.showProgress(TAG_APP, "show progress (no canceler)", false);
                break;

            case R.id.btn14:
                m_dialogSupport.hideProgress();
                break;

            default:
                MyUtil.SEN_LOG("Defaut !!!");
                break;
        }
    }


    void initUI()
    {
        Button btn01 = findViewById(R.id.btn01);
        Button btn02 = findViewById(R.id.btn02);
        Button btn03 = findViewById(R.id.btn03);
        Button btn04 = findViewById(R.id.btn04);
        Button btn05 = findViewById(R.id.btn05);
        Button btn06 = findViewById(R.id.btn06);
        Button btn07 = findViewById(R.id.btn07);
        Button btn08 = findViewById(R.id.btn08);
        Button btn09 = findViewById(R.id.btn09);
        Button btn10 = findViewById(R.id.btn10);
        Button btn11 = findViewById(R.id.btn11);
        Button btn12 = findViewById(R.id.btn12);
        Button btn13 = findViewById(R.id.btn13);
        Button btn14 = findViewById(R.id.btn14);


        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn05.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);
        btn08.setOnClickListener(this);
        btn09.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
    }


    DialogInterface.OnClickListener onclklstner = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MyUtil.SEN_LOG("--YES!!--");
        }
    };


    DialogInterface.OnClickListener onclklstner2 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MyUtil.SEN_LOG("--NO!!--");
        }
    };

    DialogInterface.OnClickListener onclklstner3 = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            MyUtil.SEN_LOG("--CANCEL!!--");
        }
    };
}