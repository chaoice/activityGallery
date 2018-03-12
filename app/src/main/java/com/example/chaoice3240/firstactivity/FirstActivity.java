package com.example.chaoice3240.firstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class FirstActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private static final String TAG = "FirstActivity";
    public static final String EXTRA_NAME="Name";
    private HomeFragment homeFragment;
    private HomeFragment bookFragment;
    private HomeFragment musicFragment;
    private HomeFragment videoFragment;
    private HomeFragment gameFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.first_layout);
        Toolbar toolbar=(Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground ,"主页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "书籍"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "音乐"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher_foreground, "游戏"))
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
        homeFragment=HomeFragment.newInstance("https://github.com/Dickkk");
        bookFragment=HomeFragment.newInstance("https://www.jianshu.com/p/0550500f8f56");

        musicFragment=HomeFragment.newInstance("https://www.jianshu.com/p/0550500f8f56");

        videoFragment=HomeFragment.newInstance("http://www.youku.com");
        gameFragment=HomeFragment.newInstance("http://www.gamersky.com");
        getFragmentManager().beginTransaction().replace(R.id.frag_content,homeFragment).commit();
//        bottomNavigationBar
//                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//        Button button1= (Button) findViewById(R.id.button1);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this,"hello findbyviewbuton",Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent("com.example.chaoice3240.myaction");
//                intent.putExtra("key","张超");
//                intent.addCategory("com.example.chaocie3240.mycategory");
//                startActivityForResult(intent,1);
//                Log.d(TAG, "onClick: click ");
//            }
//        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode)
        {
            case 1:
                if(resultCode==RESULT_OK)
                {
                    Log.d(TAG, "onActivityResult: "+data.getStringExtra("result"));
                }break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.additem:
                Toast.makeText(this,"add click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.removeitem:
                Toast.makeText(this,"remove click",Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this,"default",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
    public void sendMessage(View view)
    {
        Intent intent=new Intent(this,DisplayMessageActivity.class);
        EditText editText=(EditText) findViewById(R.id.editTextName);
        intent.putExtra(EXTRA_NAME,editText.getText().toString());
        startActivity(intent);
    }

    @Override
    public void onTabSelected(int position) {
        switch (position)
        {
            case 0:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,homeFragment).commit();
            }break;
            case 1:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,bookFragment).commit();
            }break;
            case 2:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,musicFragment).commit();
            }break;
            case 3:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,videoFragment).commit();
            }break;
            case 4:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,gameFragment).commit();
            }break;
            default:{
                getFragmentManager().beginTransaction().replace(R.id.frag_content,homeFragment).commit();
            }break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
