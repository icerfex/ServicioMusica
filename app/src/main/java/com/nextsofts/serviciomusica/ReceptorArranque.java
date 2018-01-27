package com.nextsofts.serviciomusica;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ariel on 27-01-18.
 */
public class ReceptorArranque extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
       context.startService(new Intent(context,ServicioMusica.class));

    }
}
