package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoActivity;
import android.content.Context;
import android.content.Intent;

public class UIUtils {
   
	/**
     * Invoke "home" action, returning to {@link GeoCamMemoActivity}.
     */
    public static void goHome(Context context) {
        final Intent intent = new Intent(context, GeoCamMemoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
