package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListView2Fragment extends Fragment {
	public static final String MESSAGE_FROM_LISTVIEW2_INTENT = "dev.ronlemire.commoncontrols.GALLERY_LISTVIEW2_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ListView2Fragment newInstance(String inMessage) {
		ListView2Fragment listView2Fragment = new ListView2Fragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		listView2Fragment.setArguments(argumentsBundle);
		return listView2Fragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_LISTVIEW2_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.listview2_fragment, null);
		// context = rootView.getContext();

    	ListView lvListView2 = (ListView) rootView.findViewById(R.id.lvListView2);

        Cursor c = getActivity().managedQuery(Contacts.CONTENT_URI,
                null, null, null, Contacts.DISPLAY_NAME + " ASC");

        String[] cols = new String[]{Contacts.DISPLAY_NAME};
        int[]   views = new int[]   {android.R.id.text1};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(),
                android.R.layout.simple_list_item_1,
                c, cols, views);
        lvListView2.setAdapter(adapter);
        
        //TODO: will not build with next line. Not sure what to pass.
        //lvListView2.setOnItemClickListener(getActivity());		
		
		return rootView;
	}	
	
    public void onItemClick(AdapterView<?> adView, View target, int position, long id) {
		Log.v("ListViewActivity", "in onItemClick with " + ((TextView) target).getText() +
				". Position = " + position + ". Id = " + id);
		Uri selectedPerson = ContentUris.withAppendedId(
				Contacts.CONTENT_URI, id);
		Intent intent = new Intent(Intent.ACTION_VIEW, selectedPerson);
		startActivity(intent);
	}
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}