package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EditTextFragment extends Fragment {
	public static final String MESSAGE_FROM_EDITTEXT_INTENT = "dev.ronlemire.commoncontrols.GALLERY_EDITTEXT_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static EditTextFragment newInstance(String inMessage) {
		EditTextFragment editTextFragment = new EditTextFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		editTextFragment.setArguments(argumentsBundle);
		return editTextFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_EDITTEXT_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.edittext_fragment, null);
		// context = rootView.getContext();

		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}

=============================================================================================================================
Paste into Activity
=============================================================================================================================

public void StartEditTextFragment() {
	if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE
			&& isTablet()) {
		Fragment editTextFragment = (Fragment) fm
				.findFragmentById(R.id.sample_replacer);
		editTextFragment = EditTextFragment.newInstance("EditText");

		fm.beginTransaction()
			.replace(R.id.sample_replacer, editTextFragment)
			.commit();
	} else {
		EditTextFragment editTextFragment = EditTextFragment
				.newInstance("EditText");
		getSupportFragmentManager().beginTransaction()
				.replace(MainActivity.sampleListView.getId(), editTextFragment)
				.commit();
	}
}	



