package com.nextsofts.serviciomusica;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.widget.Toast;

/**
 * Created by ariel on 26-01-18.
 */
public class ServicioMusica extends Service {

    MediaPlayer reproductor;
    private static final int ID_NOTIFICACION_CREAR=1;

    @Override
    public void onCreate(){
        Toast.makeText(this,"Servicio creado",Toast.LENGTH_SHORT).show();
        reproductor=MediaPlayer.create(this,R.raw.audio);
    }

    @Override
    public int onStartCommand(Intent intenc,int flags,int idArranque){
        Notification.Builder notific=new Notification.Builder(this)
                .setContentTitle("creando servicio de musica")
                .setSmallIcon(R.drawable.image)
                .setContentText("pulsa en el boton para ver")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),android.R.drawable.ic_media_play))
                .setWhen(System.currentTimeMillis()+1000*60*60)
                .setContentInfo("mas info");

        PendingIntent intencionPendiente=PendingIntent.getActivity(this,0,new Intent(this,MainActivity.class),0);
        notific.setContentIntent(intencionPendiente);

        NotificationManager notificationManaget= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManaget.notify(ID_NOTIFICACION_CREAR,notific.build());


        Toast.makeText(this,"servicio arrancado"+idArranque,Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        Toast.makeText(this,"servicio detenido",Toast.LENGTH_SHORT).show();
        NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ID_NOTIFICACION_CREAR);
        reproductor.stop();
    }
    @Override
    public IBinder onBind(Intent intencion){
        return null;
    }
}
