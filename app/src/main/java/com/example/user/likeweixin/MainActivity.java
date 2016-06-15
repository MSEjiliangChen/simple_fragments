package com.example.user.likeweixin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.user.likeweixin.myfrag.FoodFragment;
import com.example.user.likeweixin.myfrag.FriendFragment;
import com.example.user.likeweixin.myfrag.GameFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mTabFriend;
    private Button mTabFood;
    private Button mTabGame;

    private FriendFragment mFriend;
    private FoodFragment mFood;
    private GameFragment mGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // 初始化控件和声明事件
        mTabFriend = (Button) findViewById(R.id.friends_btn);
        mTabFood = (Button) findViewById(R.id.foods_btn);
        mTabGame = (Button) findViewById(R.id.games_btn);
        mTabFriend.setOnClickListener(this);
        mTabFood.setOnClickListener(this);
        mTabGame.setOnClickListener(this);

        // 设置默认的Fragment
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if(mFriend == null){
            mFriend = new FriendFragment();
        }

        transaction.replace(R.id.id_content, mFriend,"friend");
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();

        switch (v.getId()) {
            case R.id.foods_btn:
                if (mFood == null) {
                    mFood = new FoodFragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_left_exit, R.animator.fragment_slide_right_enter, R.animator.fragment_slide_right_exit);
                transaction.replace(R.id.id_content, mFood,"food");
                transaction.addToBackStack(null);
                break;
            case R.id.friends_btn:
                if (mFriend == null) {
                    mFriend = new FriendFragment();
                }
                transaction.setCustomAnimations(R.animator.fragment_slide_left_enter, R.animator.fragment_slide_left_exit, R.animator.fragment_slide_right_enter, R.animator.fragment_slide_right_exit);
                transaction.replace(R.id.id_content, mFriend,"friend");
                transaction.addToBackStack(null);
                break;
            case R.id.games_btn:
                if (mGame == null) {
                    mGame = new GameFragment();
                }
                transaction.setCustomAnimations(R.animator.fragment_scale_enter, R.animator.fragment_scale_exit, R.animator.fragment_scale_enter, R.animator.fragment_scale_exit);
                transaction.replace(R.id.id_content, mGame,"game");
                transaction.addToBackStack(null);
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }
}
