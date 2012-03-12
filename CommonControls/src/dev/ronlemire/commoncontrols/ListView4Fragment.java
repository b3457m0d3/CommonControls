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
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListView4Fragment extends Fragment {
	public static final String MESSAGE_FROM_LISTVIEW4_INTENT = "dev.ronlemire.commoncontrols.GALLERY_LISTVIEW4_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	// private String inMessage;
	private View rootView;
	private Intent intent;
	private static final String TAG = "ListView4";
	private SimpleCursorAdapter adapter = null;
	private ListView lvListView4 = null;

	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ListView4Fragment newInstance(String inMessage) {
		ListView4Fragment listView4Fragment = new ListView4Fragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		listView4Fragment.setArguments(argumentsBundle);
		return listView4Fragment;
	}

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_LISTVIEW4_INTENT);
		// this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.listview4_fragment, null);
		// context = rootView.getContext();

		lvListView4 = (ListView) rootView.findViewById(R.id.lvListView4);

		String[] projection = new String[] { Contacts._ID,
				Contacts.DISPLAY_NAME };
		Cursor c = getActivity().managedQuery(Contacts.CONTENT_URI, projection, null, null,
				Contacts.DISPLAY_NAME);

		String[] cols = new String[] { Contacts.DISPLAY_NAME };
		int[] views = new int[] { android.R.id.text1 };

		adapter = new SimpleCursorAdapter(getActivity(),
				android.R.layout.simple_list_item_multiple_choice, c, cols,
				views);

        lvListView4.setAdapter(adapter);

        lvListView4.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

		return rootView;
	}

	public void doClick(View view) {
		if (!adapter.hasStableIds()) {
			Log.v(TAG, "Data is not stable");
			return;
		}
		long[] viewItems = lvListView4.getCheckedItemIds();
		for (int i = 0; i < viewItems.length; i++) {
			Uri selectedPerson = ContentUris.withAppendedId(
					Contacts.CONTENT_URI, viewItems[i]);

			Log.v(TAG, selectedPerson.toString() + " is checked.");
		}
	}

	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);
	}
}
