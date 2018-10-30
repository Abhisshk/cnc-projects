package ImageFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codencolors.statustan.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JokesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JokesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public
class JokesFragment extends Fragment {

    public
    JokesFragment() {
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
        return inflater.inflate ( R.layout.fragment_jokes, container, false );
    }
}