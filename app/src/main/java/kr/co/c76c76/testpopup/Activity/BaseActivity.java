package kr.co.c76c76.testpopup.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import kr.co.c76c76.testpopup.Util.DialogSupport;

public abstract class BaseActivity extends Activity implements View.OnClickListener{


    protected DialogSupport m_dialogSupport = null;


    protected abstract void createActivity();
    protected abstract void viewClick(View view);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.m_dialogSupport = new DialogSupport(this);
        this.createActivity();
    }

    @Override
    public void onClick(View v) {
        this.viewClick(v);
    }


}
