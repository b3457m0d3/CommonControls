package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleCursorAdapter;

public class GridViewFragment extends Fragment {
	public static final String MESSAGE_FROM_GRIDVIEW_INTENT = "dev.ronlemire.commoncontrols.GALLERY_GRIDVIEW_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	// private String inMessage;
	private View rootView;
	private Intent intent;

	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static GridViewFragment newInstance(String inMessage) {
		GridViewFragment gridViewFragment = new GridViewFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		gridViewFragment.setArguments(argumentsBundle);
		return gridViewFragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_GRIDVIEW_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.gridview_fragment, null);
		// context = rootView.getContext();
        
        GridView gv = (GridView)rootView.findViewById(R.id.gridview);
        Cursor c = getActivity().managedQuery(Contacts.CONTENT_URI, 
                null, null, null, Contacts.DISPLAY_NAME);
        String[] cols = new String[]{Contacts.DISPLAY_NAME};
        int[]   views = new int[]   {android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1,
                c, cols, views);
        gv.setAdapter(adapter);
        
		return rootView;
	}

	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);
	}
}
