// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoCreateActivity;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoHomeActivity;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoMapActivity;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


/**
 * The UIUtils helper class. Provides static access functions that create activity intents.
 */
public class UIUtils {
   
	/**
	 * Invoke "home" action, returning to {@link GeoCamMemoHomeActivity}.
	 *
	 * @param context the context
	 */
    public static void goHome(Context context) {
        final Intent intent = new Intent(context, GeoCamMemoHomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    
    /**
     * Creates the memo.
     *
     * @param context the context
     */
    public static void createMemo(Context context){
        final Intent intent = new Intent(context, GeoCamMemoCreateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    
    /**
     * Show map view.
     *
     * @param context the context
     * @param memoMessage the memo message
     */
    public static void showMapView(Context context, GeoCamMemoMessage memoMessage) {
    	final Intent intent = new Intent(context, GeoCamMemoMapActivity.class);
    	intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	intent.putExtra(context.getString(R.string.latitude), memoMessage.getLatitude());
    	intent.putExtra(context.getString(R.string.longitude), memoMessage.getLongitude());
    	intent.putExtra(context.getString(R.string.accuracy), memoMessage.getAccuracy());
    	context.startActivity(intent);    	
    }
    
    
    /**
     * Display an exception to the user.
     *
     * @param context the context
     * @param e the e
     * @param additionalMessage the additional message
     */
    public static void displayException(Context context, Exception e, String additionalMessage)
    {
    	StringBuilder sb = new StringBuilder();
    	if(additionalMessage != null)
    	{
    		sb.append(additionalMessage + ": ");
    	}
    	if(e.getLocalizedMessage() != null){
        	sb.append(e.getLocalizedMessage());    		
    	}
    	Toast.makeText(context, sb.toString(), Toast.LENGTH_LONG).show();
    }
}
