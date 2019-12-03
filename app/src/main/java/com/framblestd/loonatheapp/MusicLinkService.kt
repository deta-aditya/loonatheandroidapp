package com.framblestd.loonatheapp

import android.app.Activity
import android.content.Intent
import android.net.Uri

object MusicLinkService {
    fun open(activity: Activity, link: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        activity.startActivity(browserIntent)
    }
}