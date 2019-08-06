package com.hand.kotlinhelloworld

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

/**
 * kotlin在Android中使用案例
 */
class MainActivity : AppCompatActivity(), OnClickListener {

    var mStrBuilder = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.hint = "请输入数字"
        var count = container.childCount
        for (i in 0..count) {
            var view = container.getChildAt(i) as? TextView
            view?.setOnClickListener(this)
            view?.tag = view?.text
        }

    }

    override fun onClick(v: View?) {
        var text = v as? TextView
        when (text?.text) {
            "1", "2", "3", "4", "5", "6", "7", "8", "9" -> appendText(text?.text.toString())
            "delete" -> deleteText()
            else -> UInt
        }
    }

    private fun appendText(str: String) {
        mStrBuilder.append(str)
        tv.text = mStrBuilder.toString()

    }

    private fun deleteText() {
        if (!mStrBuilder.isEmpty()) {
            mStrBuilder.deleteCharAt(mStrBuilder.lastIndex)
            tv.text = mStrBuilder.toString()
        }
    }

}
