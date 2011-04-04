package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoCreateActivity;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoHomeActivity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class UIUtils {
   
	/**
     * Invoke "home" action, returning to {@link GeoCamMemoHomeActivity}.
     */
    public static void goHome(Context context) {
        final Intent intent = new Intent(context, GeoCamMemoHomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    
    public static void createMemo(Context context){
        final Intent intent = new Intent(context, GeoCamMemoCreateActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    
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
