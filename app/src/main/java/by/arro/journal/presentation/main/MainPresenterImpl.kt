package by.arro.journal.presentation.main

class MainPresenterImpl : MainPresenter {
    private var view: MainView? = null

    private var sum: Int = 0
    private var updateType: UpdateType = UpdateType.INCREASE

    override fun onFirstAttachView(view: MainView) {
        this.view = view
        view.renderAll()
    }

    override fun onAttachView(view: MainView) {
        this.view = view
        view.renderAll()
    }

    override fun onUpdateClicked() {
        when {
            sum > 9 -> setUpdateType(UpdateType.DECLINE)
            sum < 1 -> setUpdateType(UpdateType.INCREASE)
        }

        when (updateType) {
            UpdateType.INCREASE -> sum++
            UpdateType.DECLINE -> sum--
        }

        view?.setSum(sum)
    }

    override fun onDetach() {
        view = null
    }

    override fun onDestroy() {
        view = null
    }

    private fun setUpdateType(type: UpdateType) {
        updateType = type
        view?.setUpdateType(type)
    }

    private fun MainView.renderAll() {
        setSum(sum)
        setUpdateType(updateType)
    }
}