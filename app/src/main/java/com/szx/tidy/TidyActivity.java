package com.szx.tidy;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.mob.bbssdk.gui.pages.forum.PageMain;
import com.mob.bbssdk.gui.views.MainViewInterface;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.ResHelper;
import com.mob.ums.OperationCallback;
import com.mob.ums.UMSSDK;
import com.mob.ums.User;
import com.mob.wrappers.UMSSDKWrapper;
import com.szx.tidy.activity.LoginActivity;
import com.szx.tidy.activity.MvvmActivity;
import com.szx.tidy.activity.RegisterActivity;
import com.szx.tidy.activity.SecondActivity;
import com.szx.tidy.activity.WebActivity;
import com.szx.tidy.manager.UserManager;
import com.szx.tidy.model.MVVMViewModel;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;

public class TidyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView nickname, signature;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tidy);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("8888");
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(TidyActivity.this, MvvmActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        nickname = navigationView.getHeaderView(0).findViewById(R.id.nickname);
        signature = navigationView.getHeaderView(0).findViewById(R.id.signature);
        if (!UserManager.getInstance().isLogin()) {
//            startActivity(new Intent(TidyActivity.this, LoginActivity.class));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        User user = UserManager.getInstance().getUser();
        nickname.setText(user.nickname.get());
        signature.setText(user.signature.get());
        if (UserManager.getInstance().isLogin()) {
//            MainViewInterface mainView = (MainViewInterface) findViewById(ResHelper.getIdRes(this, "mainView"));
//            mainView.loadData();

//            PageMain pageMain = new PageMain();
//            pageMain.show(mContext);
//            pageMain.showForResult(mContext, new FakeActivity() {
//                public void onResult(HashMap<String, Object> data) {
//                    //TODO 界面返回回调
//                    Toast.makeText(TidyActivity.this, "data!" + data.toString(), Toast.LENGTH_LONG).show();
//                }
//            });


        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tidy, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            sendCode(TidyActivity.this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//            Intent intent = new Intent(TidyActivity.this, SecondActivity.class);
//            TidyActivity.this.startActivity(intent);
//        } else if (id == R.id.nav_send) {
//            Intent intent = new Intent(TidyActivity.this, WebActivity.class);
//            TidyActivity.this.startActivity(intent);
//        }
        if (id == R.id.nav_loginout) {
            UMSSDK.logout(new OperationCallback<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    super.onSuccess(aVoid);
                    nickname.setText("");
                    signature.setText("");
                    UserManager.getInstance().setLogin(UserManager.NOT_LOGIN);
                    UserManager.getInstance().setUser(new User());
                }

                @Override
                public void onFailed(Throwable throwable) {
                    super.onFailed(throwable);
                }
            });
        }else if (id == R.id.nav_share) {
            MVVMViewModel mvvmViewModel = ViewModelProviders.of(this).get(MVVMViewModel.class);
            mvvmViewModel.setData2();
            Intent intent = new Intent(TidyActivity.this, SecondActivity.class);
            TidyActivity.this.startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void sendCode(Context context) {
        RegisterPage page = new RegisterPage();
        //如果使用我们的ui，没有申请模板编号的情况下需传null
        page.setTempCode(null);
        page.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (result == SMSSDK.RESULT_COMPLETE) {
                    // 处理成功的结果
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country"); // 国家代码，如“86”
                    String phone = (String) phoneMap.get("phone"); // 手机号码，如“13800138000”
                    Toast.makeText(TidyActivity.this, "验证成功：country:" + country + "    phone:" + phone, Toast.LENGTH_LONG).show();
                    // TODO 利用国家代码和手机号码进行后续的操作
                } else {
                    // TODO 处理错误的结果
                    Toast.makeText(TidyActivity.this, "验证失败!", Toast.LENGTH_LONG).show();
                }
            }
        });
        page.show(context);
    }
}
