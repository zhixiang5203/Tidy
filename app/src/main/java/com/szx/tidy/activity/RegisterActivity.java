package com.szx.tidy.activity;

import android.content.Context;
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

import java.util.logging.Logger;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private static String TAG = RegisterActivity.class.getSimpleName();
    private Context mContext;
    Button register, verification;
    EditText account, password, verificationCode;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = this;
        register = findViewById(R.id.btn_register);
        verification = findViewById(R.id.btn_verification);
        account = findViewById(R.id.ed_account);
        password = findViewById(R.id.ed_password);
        verificationCode = findViewById(R.id.ed_verification_code);
        register.setOnClickListener(this);
        verification.setOnClickListener(this);
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

            case R.id.btn_register:
                User user = new User();
                UMSSDK.registerWithPhoneNumber("86", account.getText().toString().trim(), verificationCode.getText().toString().trim(), password.getText().toString().trim(), user, new OperationCallback<User>() {
                    @Override
                    public void onSuccess(User user) {
                        super.onSuccess(user);
                        Toast.makeText(mContext, "注册成功:" + user.toString(), Toast.LENGTH_LONG).show();
                        Log.i(TAG, "注册成功:" + user.toString());
                        RegisterActivity.this.finish();
                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        super.onFailed(throwable);
                        Toast.makeText(mContext, "注册失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        super.onCancel();
                        Toast.makeText(mContext, "注册取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_verification:
                UMSSDK.sendVerifyCode("86", account.getText().toString().trim(), new OperationCallback<Boolean>() {
                    @Override
                    public void onSuccess(Boolean aBoolean) {
                        super.onSuccess(aBoolean);
                        if (aBoolean) {
                            Toast.makeText(mContext, "发送成功：" + aBoolean, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(mContext, "发送成功：" + aBoolean, Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailed(Throwable throwable) {
                        super.onFailed(throwable);
                        Toast.makeText(mContext, "验证码发送失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancel() {
                        super.onCancel();
                        Toast.makeText(mContext, "验证码发送取消", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            default:
                break;
        }

    }
}
