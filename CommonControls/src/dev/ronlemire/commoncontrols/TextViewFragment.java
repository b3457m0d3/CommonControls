package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

public class TextViewFragment extends Fragment {
	public static final String MESSAGE_FROM_TEXTVIEW_INTENT = "dev.ronlemire.commoncontrols.GALLERY_TEXTVIEW_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static TextViewFragment newInstance(String inMessage) {
		TextViewFragment textViewFragment = new TextViewFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		textViewFragment.setArguments(argumentsBundle);
		return textViewFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_TEXTVIEW_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.textview_fragment, null);
		// context = rootView.getContext();

        TextView tv =(TextView)rootView.findViewById(R.id.tv);
        EditText et = (EditText)rootView.findViewById(R.id.et);
        AutoCompleteTextView actv = (AutoCompleteTextView)rootView.findViewById(R.id.actv);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line,
                        new String[] {"English", "Hebrew", "Hindi", "Spanish", "German", "Greek" });

        actv.setAdapter(aa);
        
        MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView)rootView.findViewById(R.id.mactv);
        ArrayAdapter<String> aa2 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line,
                new String[] {"English", "Hebrew", "Hindi", "Spanish", "German", "Greek" });

        mactv.setAdapter(aa2);

        mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
}