package dev.ronlemire.commoncontrols;

import com.example.android.actionbarcompat.R;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryFragment extends Fragment {
	public static final String MESSAGE_FROM_GALLERY_INTENT = "dev.ronlemire.commoncontrols.GALLERY_FRAGMENT_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static GalleryFragment newInstance(String inMessage) {
		GalleryFragment galleryFragment = new GalleryFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		galleryFragment.setArguments(argumentsBundle);
		return galleryFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_GALLERY_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.gallery_fragment, null);
		// context = rootView.getContext();

        Gallery gallery = (Gallery)rootView.findViewById(R.id.gallery);
        ManateeAdapter manateeAdapter = new ManateeAdapter(getActivity());
        gallery.setAdapter(manateeAdapter);
		
		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
	
    public static class ManateeAdapter extends BaseAdapter {
        private static final String TAG = "ManateeAdapter";
        private static int convertViewCounter = 0;
		private Context mContext;
        private LayoutInflater mInflater;

        static class ViewHolder {
            ImageView image;
        }
        
        private int[] manatees = {
                R.drawable.manatee00, R.drawable.manatee01, R.drawable.manatee02,
                R.drawable.manatee03, R.drawable.manatee04, R.drawable.manatee05,
                R.drawable.manatee06, R.drawable.manatee07, R.drawable.manatee08,
                R.drawable.manatee09, R.drawable.manatee10, R.drawable.manatee11,
                R.drawable.manatee12, R.drawable.manatee13, R.drawable.manatee14,
                R.drawable.manatee15, R.drawable.manatee16, R.drawable.manatee17,
                R.drawable.manatee18, R.drawable.manatee19, R.drawable.manatee20,
                R.drawable.manatee21, R.drawable.manatee22, R.drawable.manatee23,
                R.drawable.manatee24, R.drawable.manatee25, R.drawable.manatee26,
                R.drawable.manatee27, R.drawable.manatee28, R.drawable.manatee29,
                R.drawable.manatee30, R.drawable.manatee31, R.drawable.manatee32,
                R.drawable.manatee33 };
        
        private Bitmap[] manateeImages = new Bitmap[manatees.length];
        private Bitmap[] manateeThumbs = new Bitmap[manatees.length];

        public ManateeAdapter(Context context) {
        	Log.v(TAG, "Constructing ManateeAdapter");
        	this.mContext = context;
        	mInflater = LayoutInflater.from(context);
        	
        	for(int i=0; i<manatees.length; i++) {
        		manateeImages[i] = BitmapFactory.decodeResource(
        				context.getResources(), manatees[i]);
        		manateeThumbs[i] = Bitmap.createScaledBitmap(manateeImages[i],
        				100, 100, false);
        	}
        }
        
    	public int getCount() {
    		Log.v(TAG, "in getCount()");
    		return manatees.length;
    	}

    	public int getViewTypeCount() {
    		Log.v(TAG, "in getViewTypeCount()");
    		return 1;
    	}
    	
    	public int getItemViewType(int position) {
    		Log.v(TAG, "in getItemViewType() for position " + position);
    		return 0;
    	}

    	public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            
            Log.v(TAG, "in getView for position " + position + 
            		", convertView is " +
            		((convertView == null)?"null":"being recycled"));

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.gridimage_fragment, null);
                convertViewCounter++;
                Log.v(TAG, convertViewCounter + " convertViews have been created");

                holder = new ViewHolder();
                holder.image = (ImageView) convertView.findViewById(R.id.gridImageView);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.image.setImageBitmap(manateeImages[position]);

            return convertView;
        }

    	public Object getItem(int position) {
    		Log.v(TAG, "in getItem() for position " + position);
    		return manateeImages[position];
    	}

    	public long getItemId(int position) {
    		Log.v(TAG, "in getItemId() for position " + position);
    		return position;
    	}
    }

}

