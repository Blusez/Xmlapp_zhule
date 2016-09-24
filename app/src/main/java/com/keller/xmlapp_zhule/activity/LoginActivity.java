package com.keller.xmlapp_zhule.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.keller.xmlapp_zhule.R;
import com.keller.xmlapp_zhule.util.ThreadUtils;
import com.keller.xmlapp_zhule.util.ToastUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class LoginActivity extends AppCompatActivity {

    public static final String HOST = "172.17.32.100";
    public static final int PORT = 5222;
    private TextView mEtUserName;
    private TextView mEtPsssword;
    private Button mBtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initListener() {

        mBtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String userName = mEtUserName.getText().toString();
                final String password = mEtPsssword.getText().toString();
                //判断用户是否为空
                if (TextUtils.isEmpty(userName)){
                    mEtUserName.setError("用户名不能为空！");
                    return;
                }
                //判断密码是否为空
                if (TextUtils.isEmpty(password)){
                    mEtPsssword.setError("密码不能为空！");
                    return;
                }
                ThreadUtils.runInThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //创建连接配置对象
                            ConnectionConfiguration config = new ConnectionConfiguration(HOST,PORT);
                            //额外的配置,方便我们开发，上线的时候可以去除
                            config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);//明文传输
                            config.setDebuggerEnabled(true);//开启调试模式，方便我们查看发送的具体内容
                            //开始创建连接对象
                            XMPPConnection conn = new XMPPConnection(config);
                            //开始连接
                            conn.connect();
                            //连接成功
                            //开始登陆
                            conn.login(userName,password);
                            //登陆成功 子线程中不能直接使用toast，需要再开辟一个子线程来
                            ToastUtils.showToastSafe(LoginActivity.this,"登陆成功");
                           // Toast.makeText(getApplicationContext(),"登陆失败"+userName+password,Toast.LENGTH_SHORT).show();

                            finish();


                            //跳到主界面
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        } catch (XMPPException e) {
                            e.printStackTrace();
                            ToastUtils.showToastSafe(LoginActivity.this,"登陆失败");
                        }
                    }
                });
            }
        });
    }

    private void initView() {
        mEtUserName = (TextView) findViewById(R.id.et_username);
        mEtPsssword = (TextView) findViewById(R.id.et_password);
        mBtLogin = (Button) findViewById(R.id.bt_login);
    }
}
