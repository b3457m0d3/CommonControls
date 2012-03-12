package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.StyleSpan;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class StylesFragment extends Fragment {
	public static final String MESSAGE_FROM_STYLES_INTENT = "dev.ronlemire.commoncontrols.GALLERY_STYLES_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static StylesFragment newInstance(String inMessage) {
		StylesFragment stylesFragment = new StylesFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		stylesFragment.setArguments(argumentsBundle);
		return stylesFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_STYLES_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.styles_fragment, null);
		// context = rootView.getContext();

        
        TextView tv =(TextView)rootView.findViewById(R.id.tv);
        tv.setAutoLinkMask(Linkify.ALL);
        tv.setText("Please visit http://www.androidbook.com or email me at davemac327@gmail.com.");

        TextView tv3 =(TextView)rootView.findViewById(R.id.tv3);
        tv3.setText("Styling the content of a TextView dynamically",
                TextView.BufferType.SPANNABLE);
        Spannable spn = (Spannable) tv3.getText();
        spn.setSpan(new BackgroundColorSpan(Color.RED), 0, 7, 
                     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spn.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC),
                     0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        EditText et =(EditText)rootView.findViewById(R.id.et);
        et.setText("Styling the content of an EditText dynamically");
        Spannable spn2 = (Spannable) et.getText();
        spn2.setSpan(new BackgroundColorSpan(Color.RED), 0, 7, 
                     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spn2.setSpan(new StyleSpan(android.graphics.Typeface.BOLD_ITALIC),
                     0, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}
