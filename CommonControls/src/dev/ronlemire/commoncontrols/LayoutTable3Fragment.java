package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LayoutTable3Fragment extends Fragment {
	public static final String MESSAGE_FROM_LAYOUTTABLE3_INTENT = "dev.ronlemire.commoncontrols.GALLERY_LAYOUTTABLE3_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static LayoutTable3Fragment newInstance(String inMessage) {
		LayoutTable3Fragment layoutTable3Fragment = new LayoutTable3Fragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		layoutTable3Fragment.setArguments(argumentsBundle);
		return layoutTable3Fragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_LAYOUTTABLE3_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.layouttable3_fragment, null);
		// context = rootView.getContext();

		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}

