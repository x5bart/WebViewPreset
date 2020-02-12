package com.x5bart.webviewpreset

import android.content.Context

class MyPreference(context: Context) {

    private val PREFERENCE_NAME = "SharedPreferenceExample"
    private val PREFERENCE_LAST_URL = "LastUrl"

    private val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getLastUrl(): String? {
        return preference.getString(
            PREFERENCE_LAST_URL,
            "https://media.premierbetpartners.com/redirect.aspx?pid=2179&bid=1476"
        )
    }

    fun setLastUrl(url: String) {
        val editor = preference.edit()
        editor.putString(PREFERENCE_LAST_URL, url)
        editor.apply()
    }

}