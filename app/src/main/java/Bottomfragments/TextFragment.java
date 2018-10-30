package Bottomfragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import ImageFragments.ASCIIFragment;
import ImageFragments.DialogsFragment;
import ImageFragments.JokesFragment;
import ImageFragments.MemesFragment;
import ImageFragments.PoemsFragment;
import ImageFragments.PunFragment;
import ImageFragments.QuotesFragment;
import ImageFragments.ShayariFragment;
import ImageFragments.StatusFragment;
import TextFragments.ASCII;
import TextFragments.Dialogs;
import TextFragments.Jokes;
import TextFragments.Memes;
import TextFragments.Poems;
import TextFragments.Pun;
import TextFragments.Quotes;
import TextFragments.Shayari;
import TextFragments.Status;
import adapter.SourceAdapter;
import model.Source;

import com.android.volley.toolbox.JsonObjectRequest;
import com.codencolors.statustan.AppController;
import com.codencolors.statustan.R;

public
class TextFragment extends Fragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public
    TextFragment() {
        // Required empty public constructor
    }



    @Override
    public
    void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

    }

    @Override
    public
    View onCreateView(LayoutInflater inflater, ViewGroup container,
                      Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate ( R.layout.fragment_text, container, false );
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);
        tabLayout = (TabLayout)view. findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setHasOptionsMenu ( true );

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
    private void setupViewPager(ViewPager viewPager) {
        TextFragment.ViewPagerAdapter adapter = new ViewPagerAdapter ( getFragmentManager () );
        adapter.addFragment(new Status (), "STATUS");
        adapter.addFragment(new Jokes (), "JOKES");
        adapter.addFragment(new Shayari (), "SHAYARI");
        adapter.addFragment(new Pun (), "PUN");
        adapter.addFragment(new ASCII (), "ASCII");
        adapter.addFragment(new Quotes (), "QUOTES");
        adapter.addFragment(new Poems (), "POEMS");
        adapter.addFragment(new Dialogs (), "DIALOGS");
        adapter.addFragment(new Memes (), "MEMES");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}


