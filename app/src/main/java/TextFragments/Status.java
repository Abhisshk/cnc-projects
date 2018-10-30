package TextFragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.codencolors.statustan.AppController;
import com.codencolors.statustan.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Bottomfragments.TextFragment;
import adapter.SourceAdapter;
import model.Source;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;


public
class Status extends Fragment {
    private static final String TAG=TextFragment.class.getSimpleName ();
    private static final String URL="   ";
    private RecyclerView recyclerView;
    private List<Source> list;
    private SourceAdapter adapter;
    private
    ProgressBar progressBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public
    Status() {
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
        View view= inflater.inflate ( R.layout.fragment_status_text, container, false );
        recyclerView=view.findViewById ( R.id.recycler_view );
        progressBar=(ProgressBar) view.findViewById ( R.id.progressbar );
        list=new ArrayList<> ();
        adapter=new SourceAdapter ( list, getActivity () );
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager ( getActivity () );
        recyclerView.addItemDecoration ( new DividerItemDecoration ( recyclerView.getContext (), DividerItemDecoration.VERTICAL ) );
        recyclerView.setLayoutManager ( mLayoutManager );
        recyclerView.hasFixedSize ();
        recyclerView.setNestedScrollingEnabled(true);
        progressBar.showContextMenu ();
        Log.v ( "###", "oasfgdfgd" );
        recyclerView.setItemAnimator ( new DefaultItemAnimator () );
        recyclerView.setAdapter ( adapter );
        add ();
        return view;
    }
    private
    void add() {
        progressBar.setVisibility ( View.VISIBLE );
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                ( Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override

                    public
                    void onResponse(JSONObject response) {
                        JSONArray jsonArray=null;
                        Log.v ( "#####","all okkkk" );
                        try {
                            jsonArray=response.getJSONArray ( "articles" );
                            progressBar.setVisibility ( View.GONE );
                        } catch (JSONException e) {
                            e.printStackTrace ();
                        }
                        for (int i = 0; i < response.length(); ++i) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                JSONObject object=jsonObject.getJSONObject ( "source" );
                                Source source = new Source (list);

                                source.setTitle(jsonObject.getString("title"));
                                source.setDescription (jsonObject.getString("description"));
                                source.setName (object.getString("name"));
                                Log.v ( "#","offf" );
                                source.setPublishedAt (jsonObject.getString("publishedAt"));
                                Log.v ( "##","oggg" );
                        //     source.setUrlToImage ( jsonObject.getInt ( "urlToImage" ) );
                                list.add ( source );
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", error.toString());
                    }
                });

        AppController.getInstance ().addToRequestQueue ( jsonObjectRequest);
    }
}
