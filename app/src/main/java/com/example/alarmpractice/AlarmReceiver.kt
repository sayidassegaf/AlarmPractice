package com.example.alarmpractice

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat


class AlarmReceiver : BroadcastReceiver() {
    private var NotificationManager: NotificationManager? = null
    private val NOTIFICATION_ID = 0

    // Notification channel ID.
    private val PRIMARY_CHANNEL_ID = "primary_notification_channel"

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
       // TODO("AlarmReceiver.onReceive() is not implemented")
        NotificationManager = (NotificationManager)
        context.getSystemService(Context.NOTIFICATION_SERVICE);
        deliverNotification(context);
    }

    private fun deliverNotification(context: Context) {
        val contentIntent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            context,
            NOTIFICATION_ID,
            contentIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder = NotificationCompat.Builder(context, PRIMARY_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_stand_up)
            .setContentTitle("Stand Up Alert")
            .setContentText("You should stand up and walk around now!")
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL);

    //    val notificationManager =
          //  ContextCompat.getSystemService(
           //     this,
           //     android.app.NotificationManager::class.java
          //  ) as NotificationManager

        NotificationManager?.notify(NOTIFICATION_ID, builder.build())
    }
}
