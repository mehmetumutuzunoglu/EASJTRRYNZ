package com.mehmetumutuzunoglu.easjtrrynz.base

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mehmetumutuzunoglu.easjtrrynz.R

open class BaseActivity : AppCompatActivity() {
    companion object {
        const val ITEM_ID = "itemId"
    }

    fun showErrorDialog() {
        showErrorDialog(
            getString(R.string.error_dialog_title),
            getString(R.string.error_dialog_message),
            getString(R.string.error_dialog_button_text)
        )
    }

    fun showErrorDialog(title: String?, message: String?, buttonText: String?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton(buttonText) { dialogInterface, _ ->
            dialogInterface.dismiss()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
}