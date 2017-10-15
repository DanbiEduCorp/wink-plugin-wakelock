package com.eduterm.wakelock;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.LOG;
import android.content.Intent;
import android.content.Context;
import android.os.Environment;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.util.Log;


public class wakelock extends CordovaPlugin {
    private static final String TAG = "REMEDU_WAKELOCK";
    private WakeLock mWakeLock;

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        PowerManager powerManager = (PowerManager) cordova.getActivity().getSystemService(Context.POWER_SERVICE);
        mWakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP ,
                "DanbiEduWakeLock");
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        if (action.equals("aquire")) {
            aquire(args, callbackContext);
        }
        return false;
    }

    private boolean aquire(JSONArray args, final CallbackContext callbackContext) throws JSONException {
        LOG.d(TAG, "aquire");

        if (mWakeLock != null) {
            mWakeLock.acquire();

            // Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            // intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            // cordova.getActivity().startActivity(intent);
        }

        callbackContext.success();
        return true;
    }

    public void onResume(boolean multitasking) {
        if (mWakeLock != null) {
            cordova.getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    Window win = cordova.getActivity().getWindow();

                    win.addFlags(LayoutParams.FLAG_DISMISS_KEYGUARD);
                    win.addFlags(LayoutParams.FLAG_SHOW_WHEN_LOCKED);
                    win.addFlags(LayoutParams.FLAG_TURN_SCREEN_ON);
                }
            });

            if (mWakeLock.isHeld()) {
                mWakeLock.release();
                mWakeLock = null;
                Log.d(TAG, "WakeLock released");
            }
        }
    }
}
