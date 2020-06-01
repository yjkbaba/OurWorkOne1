package com.example.ourworkone1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.ourworkone1.bean.Tab;
import com.example.ourworkone1.fragment.CartFragment;
import com.example.ourworkone1.fragment.CategoryFragment;
import com.example.ourworkone1.fragment.HomeFragment;
import com.example.ourworkone1.fragment.HotFragment;
import com.example.ourworkone1.fragment.MineFragment;
import com.example.ourworkone1.weiget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LayoutInflater mInflater;
    private FragmentTabHost mTabHost;
    private List<Tab> mTabs = new ArrayList<>(4);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTab();
    }

    private void initTab() {
        //Tab tab_home = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        /*Tab tab_home = new Tab(R.string.home,R.drawable.selector_icon_home, HomeFragment.class);
        Tab tab_plan = new Tab(R.string.plan,R.drawable.selector_icon_plan, PlanFragment.class);
        Tab tab_run = new Tab(R.string.run,R.drawable.selector_icon_run, RunFragment.class);
        Tab tab_set = new Tab(R.string.set,R.drawable.selector_icon_set, SetFragment.class);*/
        Tab tab_home = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        Tab tab_hot = new Tab(HotFragment.class,R.string.hot,R.drawable.selector_icon_hot);
        Tab tab_category = new Tab(CategoryFragment.class,R.string.catagory,R.drawable.selector_icon_category);
        Tab tab_cart = new Tab(CartFragment.class,R.string.cart,R.drawable.selector_icon_cart);
        Tab tab_mine = new Tab(MineFragment.class,R.string.mine,R.drawable.selector_icon_mine);
        mTabs.add(tab_home);
        mTabs.add(tab_hot);
        mTabs.add(tab_category);
        mTabs.add(tab_cart);
        mTabs.add(tab_mine);
        mInflater = LayoutInflater.from(this);
        mTabHost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        for(Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabHost.addTab(tabSpec,tab.getFragment(),null);
        }
    }

    private View buildIndicator(Tab tab){
        View view = mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = view.findViewById(R.id.icon_tab);
        TextView text = view.findViewById(R.id.txt_indicator);
        img.setImageResource(tab.getIcon());
        text.setText(tab.getTitle());
        return view;
    }
}
