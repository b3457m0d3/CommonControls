package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ListOfControlsFragment extends Fragment {
	public static final String SAMPLE_LIST_FRAGMENT_BROADCAST_INTENT = "dev.ronlemire.fragmentTemplate.SAMPLE_LIST_FRAGMENT_BROADCAST";
	public static final String SAMPLE_SELECTED = "sampleSelected";
	public static final String IN_MESSAGE_KEY = "InMessage";
	public static final String OUT_MESSAGE_KEY = "ReturnMessage";
	private View rootView;
//	private String inMessage;
	private String activities[] = null;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ListOfControlsFragment newInstance(String inMessage) {
		ListOfControlsFragment listFragment = new ListOfControlsFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		listFragment.setArguments(argumentsBundle);
		return listFragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
//		this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.list_of_controls_fragment, null);
		// context = rootView.getContext();

	    Resources res = getResources();
        activities = res.getStringArray(R.array.list_activities);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(rootView.getContext(), 
            R.array.list_titles, android.R.layout.simple_list_item_1);

    	ListView lvLeftPanel = (ListView) rootView.findViewById(R.id.lvSampleList);
    	lvLeftPanel.setAdapter(adapter);
    	lvLeftPanel.setOnItemClickListener(new OnItemClickListener() {
    		@Override
    		public void onItemClick(AdapterView<?> parent, View view,
    			int position, long id) {
    			Intent intent = new Intent(SAMPLE_LIST_FRAGMENT_BROADCAST_INTENT);
    			intent.putExtra(SAMPLE_SELECTED, activities[position]);
    			getActivity().sendBroadcast(intent);
    		}
    	});		
		
		return rootView;
	}
}
