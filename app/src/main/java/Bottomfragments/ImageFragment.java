package Bottomfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codencolors.statustan.R;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

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

public
class ImageFragment extends Fragment {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public
    ImageFragment() {
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
       View view= inflater.inflate ( R.layout.fragment_image, container, false );
        viewPager = (ViewPager)view. findViewById(R.id.viewpager);
        tabLayout = (TabLayout)view. findViewById(R.id.tabs);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setHasOptionsMenu ( true );

        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
       return  view;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager ());
        adapter.addFragment(new StatusFragment (), "STATUS");
        adapter.addFragment(new JokesFragment (), "JOKES");
        adapter.addFragment(new ShayariFragment (), "SHAYARI");
        adapter.addFragment(new PunFragment (), "PUN");
        adapter.addFragment(new ASCIIFragment (), "ASCII");
        adapter.addFragment(new QuotesFragment (), "QUOTES");
        adapter.addFragment(new PoemsFragment (), "POEMS");
        adapter.addFragment(new DialogsFragment (), "DIALOGS");
        adapter.addFragment(new MemesFragment (), "MEMES");


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
