package by.arro.journal.presentation.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import by.arro.journal.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupPresenter()
        initViews()
    }

    override fun setSum(sum: Int) {
        textViewSum.text = sum.toString()
    }

    override fun setUpdateType(type: UpdateType) {
        val resId = when (type) {
            UpdateType.INCREASE -> R.string.plus
            UpdateType.DECLINE -> R.string.minus
        }

        buttonUpdate.setText(resId)
    }

    override fun onDestroy() {
        if (isChangingConfigurations) {
            presenter.onDetach()
        } else {
            presenter.onDestroy()
        }

        super.onDestroy()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return presenter
    }

    private fun initViews() {
        buttonUpdate.setOnClickListener { presenter.onUpdateClicked() }
    }

    private fun setupPresenter() {
        presenter = (lastCustomNonConfigurationInstance as MainPresenter?)?.apply {
            onAttachView(this@MainActivity)
        } ?: MainPresenterImpl().apply {
            onFirstAttachView(this@MainActivity)
        }
    }
}
