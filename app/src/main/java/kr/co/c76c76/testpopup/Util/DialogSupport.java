package kr.co.c76c76.testpopup.Util;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class DialogSupport {


    /* Context */
    private Context context = null;
    /* AlertDialog */
    private AlertDialog alertDialog = null;
    /* ConfirmDialog */
    private AlertDialog confirmDialog = null;
    /* Toast */
    private Toast toast = null;
    /* ProgressDialog */
    private ProgressDialog progressDialog = null;

    public DialogSupport(Context context) {
        this.context = context;
    }


    /*
    public void showAlert(String title, String message) {
        this.showAlert(title, message, null);
    }

    public void showAlert(String title, String message, DialogInterface.OnClickListener onClickPositiveButton) {

        try {
            this.alertDialog = new AlertDialog.Builder(this.context).setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("확인", onClickPositiveButton).create();
            this.alertDialog.setTitle(title);
            this.alertDialog.setMessage(message);
            this.alertDialog.show();
        } catch (Exception e) {
        }
    }
    */



    /*
     * 확인키 하나 존재하는 alert 팝업
     *
     * onClickPositiveButton (cancelable)
     *    DialogInterface.OnClickListener : 확인키 callback
     *    null : 처리 없음
     *
     * setCancle (cancelable 설정)
     *    true : cancel 가능 (배경 터치, back key 가능)
     *    false : cancel 불가
     */
    public void showAlert(String title, String message, boolean setCancle,
                          DialogInterface.OnClickListener onClickPositiveButton) {
        try {
            this.alertDialog = new AlertDialog.Builder(this.context).setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton("확인", onClickPositiveButton).create();
            this.alertDialog.setTitle(title);
            this.alertDialog.setMessage(message);
            this.alertDialog.setCancelable(setCancle);
            this.alertDialog.show();
        } catch (Exception e) {
        }
    }


    /*
    * 확인키 하나 존재하는 info 팝업. (cancelable)
     */
    public void showInfo(String title, String message, DialogInterface.OnClickListener onClickPositiveButton) {

        try {
            this.alertDialog = new AlertDialog.Builder(this.context).setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("확인", onClickPositiveButton).create();
            this.alertDialog.setTitle(title);
            this.alertDialog.setMessage(message);
            this.alertDialog.show();
        } catch (Exception e) {
        }
    }


    /*
     * "예/아니오" 질문 펍업 (cancelable 설정)
     * 시스템에 따라 "아니오/예" 순서가 될수도 있음.
     *
     * setCancle (cancelable 설정)
     *    true : cancel 가능 (배경 터치, back key 가능)
     *    false : cancel 불가
     *
     * onClickPositiveButton
     *    예 callback
     * onClickNegativeButton
     *    아니오 callback
     */
    public void showConfirm1(String title, String message, boolean setCancle,
                             DialogInterface.OnClickListener onClickPositiveButton,
                             DialogInterface.OnClickListener onClickNegativeButton) {

        try {
            this.confirmDialog = new AlertDialog.Builder(this.context).setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("예", onClickPositiveButton).setNegativeButton("아니오", onClickNegativeButton)
                    .create();
            this.confirmDialog.setTitle(title);
            this.confirmDialog.setCancelable(setCancle);
            this.confirmDialog.setMessage(message);
            this.confirmDialog.show();
        } catch (Exception e) {
        }
    }


    /*
    * "예/아니오/취소" 질문 펍업 (cancelable 설정)
    *
    * setCancle (cancelable 설정)
    *
    * onClickNeutralButton
    *    취소 callback
     */
    public void showConfirm2(String title, String message, boolean setCancle,
                             DialogInterface.OnClickListener onClickPositiveButton,
                             DialogInterface.OnClickListener onClickNegativeButton,
                             DialogInterface.OnClickListener onClickNeutralButton) {

        try {
            this.confirmDialog = new AlertDialog.Builder(this.context).setIcon(android.R.drawable.ic_dialog_info)
                    .setPositiveButton("예", onClickPositiveButton).setNegativeButton("아니오", onClickNegativeButton)
                    .setNeutralButton("취소", onClickNeutralButton).create();
            this.confirmDialog.setTitle(title);
            this.confirmDialog.setCancelable(setCancle);
            this.confirmDialog.setMessage(message);
            this.confirmDialog.show();
        } catch (Exception e) {
        }
    }


    public void showToast(String message) {

        try {
            if (this.toast == null) {
                this.toast = Toast.makeText(this.context, message, Toast.LENGTH_SHORT);
            } else {
                this.toast.cancel();
                this.toast = Toast.makeText(this.context, message, Toast.LENGTH_SHORT);
            }

            this.toast.show();
        } catch (Exception e) {
        }
    }

    public void hideToast() {

        try {
            if (this.toast != null) {
                this.toast.cancel();
            }
        } catch (Exception e) {
        }
    }

    /*
    public void showProgress(String title, String message) {
        this.showProgress(title, message, true);
    }
    */


    /*
    * 프로그래스 펍업 (cancelable 설정)
    *
    * setCancle (cancelable 설정)
    */
    public void showProgress(String title, String message, Boolean cancelable) {

        try {
            this.progressDialog = new ProgressDialog(this.context);
            this.progressDialog.setIndeterminate(true);
            this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            this.progressDialog.setTitle(title);
            this.progressDialog.setMessage(message);
            this.progressDialog.setCancelable(cancelable);
            // this.m_ProgressDialog.setCanceledOnTouchOutside(cancelable);
            this.progressDialog.show();
        } catch (Exception e) {
        }
    }

    public void hideProgress() {

        try {
            if (this.progressDialog != null) {
                this.progressDialog.cancel();
            }
        } catch (Exception e) {
        }
    }
}
