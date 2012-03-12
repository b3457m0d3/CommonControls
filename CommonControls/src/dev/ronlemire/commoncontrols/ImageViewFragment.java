package dev.ronlemire.commoncontrols;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.example.android.actionbarcompat.R;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageViewFragment extends Fragment {
	public static final String MESSAGE_FROM_IMAGEVIEW_INTENT = "dev.ronlemire.commoncontrols.GALLERY_IMAGEVIEW_BROADCAST";
	public static final String OUT_MESSAGE_KEY = "OutMessage";
	public static final String IN_MESSAGE_KEY = "InMessage";
	//private String inMessage;
	private View rootView;
   private Intent intent;
	
	// *****************************************************************************
	// Singleton method used to pass variables to a new Fragment instance.
	// *****************************************************************************
	public static ImageViewFragment newInstance(String inMessage) {
		ImageViewFragment imageViewFragment = new ImageViewFragment();
		Bundle argumentsBundle = new Bundle(); // create a new Bundle
		argumentsBundle.putString(IN_MESSAGE_KEY, inMessage);
		imageViewFragment.setArguments(argumentsBundle);
		return imageViewFragment;
	}	

	// *****************************************************************************
	// Fragment Life Cycle events
	// *****************************************************************************
	@Override
	public void onCreate(Bundle argumentsBundle) {
		super.onCreate(argumentsBundle);
		intent = new Intent(MESSAGE_FROM_IMAGEVIEW_INTENT);
		//this.inMessage = getArguments().getString(IN_MESSAGE_KEY);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.imageview_fragment, null);
		// context = rootView.getContext();
		
//        ImageView imgView = (ImageView)rootView.findViewById(R.id.image3);
//
//		/*
//		 * imgView.setImageResource( R.drawable.icon );
//		 * 
//		 * imgView.setImageBitmap(BitmapFactory.decodeResource(
//		 * this.getResources(), R.drawable.manatee14) );
//		 */
//        
//        // ***********************************
//        // get images from device
//        // ***********************************
////        imgView.setImageDrawable(Drawable.createFromPath("/mnt/sdcard/Download/Ron1.jpg") );
////        imgView.setImageURI(Uri.parse("file://mnt/sdcard/Download/Ron2.jpg")); 
//        
//        // ***********************************
//        // get images from web site
//        // ***********************************
//        String image_URL = "http://192.168.1.64:8088/Ron3.jpg";
//        ImageView bmImage = (ImageView)rootView.findViewById(R.id.image3);
//        BitmapFactory.Options bmOptions;
//        bmOptions = new BitmapFactory.Options();
//        bmOptions.inSampleSize = 1;
//        Bitmap bm = LoadImage(image_URL, bmOptions);
//        bmImage.setImageBitmap(bm);
		
		
		return rootView;
	}		
   	
	private void SendMessage(String message) {
		intent.putExtra(OUT_MESSAGE_KEY, message);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		getActivity().sendBroadcast(intent);	
	}
	
//    private Bitmap LoadImage(String URL, BitmapFactory.Options options)
//    {       
//     Bitmap bitmap = null;
//     InputStream in = null;       
//        try {
//            in = OpenHttpConnection(URL);
//            bitmap = BitmapFactory.decodeStream(in, null, options);
//            in.close();
//        } catch (IOException e1) {
//        }
//        return bitmap;               
//    }
//    
//    private InputStream OpenHttpConnection(String strURL) throws IOException{
//    	 InputStream inputStream = null;
//    	 URL url = new URL(strURL);
//    	 URLConnection conn = url.openConnection();
//
//    	 try{
//    	  HttpURLConnection httpConn = (HttpURLConnection)conn;
//    	  httpConn.setRequestMethod("GET");
//    	  httpConn.connect();
//
//    	  if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
//    	   inputStream = httpConn.getInputStream();
//    	  }
//    	 }
//    	 catch (Exception ex)
//    	 {
//    	 }
//    	 return inputStream;
//    	}	   
}