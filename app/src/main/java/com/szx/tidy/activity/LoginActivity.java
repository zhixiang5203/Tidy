package com.szx.tidy.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.ums.OperationCallback;
import com.mob.ums.UMSSDK;
import com.mob.ums.User;
import com.szx.tidy.R;
import com.szx.tidy.manager.UserManager;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = LoginActivity.class.getSimpleName();
    private Context mContext;
    Button login;
    TextView register;
    EditText account, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = this;
        login = findViewById(R.id.btn_login);
        register = findViewById(R.id.tv_register);
        account = findViewById(R.id.ed_account);
        password = findViewById(R.id.ed_password);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // 执行登录
//                UMSSDK.loginWithPhoneNumber("86", "13800138000", "123abc", new OperationCallback<AnalySDKWrapper.User>() {});
                UMSSDK.loginWithPhoneNumber("86", account.getText().toString().trim(), password.getText().toString().trim(), new OperationCallback<User>() {
                    @Override
                    public void onSuccess(User user) {
                        super.onSuccess(user);
                        Toast.makeText(mContext, "登录成功:" + user.toString(), Toast.LENGTH_LONG).show();
                        Log.i(TAG, "登录成功:" + user.toString());
                        UserManager.getInstance().setLogin(UserManager.LOGIN_SUCCESS);
                        UserManager.getInstance().setUser(user);
                        LoginActivity.this.finish();
                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        super.onFailed(throwable);
                        Toast.makeText(mContext, "登录失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        super.onCancel();
                        Toast.makeText(mContext, "登录取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.tv_register:
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                UMSSDK.registerWithPhoneNumber("86", "13918826110", "123456", new OperationCallback<User>() {
//                    @Override
//                    public void onSuccess(User user) {
//                        super.onSuccess(user);
//                    }
//
//                    @Override
//                    public void onFailed(Throwable throwable) {
//                        super.onFailed(throwable);
//                    }
//
//                    @Override
//                    public void onCancel() {
//                        super.onCancel();
//                    }
//                });
                break;
            default:
                break;
        }

    }

    @Override
    public void onBackPressed() {
    }
}
