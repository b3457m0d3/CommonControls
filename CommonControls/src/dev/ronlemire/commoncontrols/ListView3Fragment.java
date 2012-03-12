package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListView3Fragment extends Fragment {
	public static final String MESSAGE_FROM_LISTVIEW3_INTENT = "dev.ronlemire.commoncontrols.GALLERY_LISTVIEW3_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
    private static final String TAG = "ListView3";
	// private String inMessage;
	private View rootView;
	private Intent intent;
	private Cursor cursor = null;
	private int idCol = -1;
	private int nameCol = -1;
	private int timesContactedCol = -1;
	ListView lvListView3;

	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ListView3Fragment newInstance(String inMessage) {
		ListView3Fragment listView3Fragment = new ListView3Fragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		listView3Fragment.setArguments(argumentsBundle);
		return listView3Fragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_LISTVIEW3_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.listview3_fragment, null);
		// context = rootView.getContext();

    	lvListView3 = (ListView) rootView.findViewById(R.id.lvListView3);

		cursor = getActivity().managedQuery(Contacts.CONTENT_URI, null, null, null,
				Contacts.DISPLAY_NAME + " ASC");

		String[] cols = new String[] { Contacts.DISPLAY_NAME };
		idCol = cursor.getColumnIndex(Contacts._ID);
		nameCol = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
		timesContactedCol = cursor.getColumnIndex(Contacts.TIMES_CONTACTED);

		int[] views = new int[] { android.R.id.text1 };

		SimpleCursorAdapter adapter = new SimpleCursorAdapter(getActivity(),
				android.R.layout.simple_list_item_multiple_choice, cursor,
				cols, views);

        lvListView3.setAdapter(adapter);

        lvListView3.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		return rootView;
	}
    
    public void doClick(View view) {
        int count=lvListView3.getCount();
        SparseBooleanArray viewItems = lvListView3.getCheckedItemPositions();
        for(int i=0; i<count; i++) {
        	if(viewItems.get(i)) {
        		// CursorWrapper cw = (CursorWrapper) lv.getItemAtPosition(i);
        		cursor.moveToPosition(i);
        		long id = cursor.getLong(idCol);
        		String name = cursor.getString(nameCol);
        		int timesContacted = cursor.getInt(timesContactedCol);
        		Log.v(TAG, name + " is checked. Times contacted = " + timesContacted +
        				". Position = " + i + ". Id = " + id);
        	}
        }
    }
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);
	}
}
