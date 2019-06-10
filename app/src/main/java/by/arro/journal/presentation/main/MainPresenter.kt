package by.arro.journal.presentation.main

interface MainPresenter {

    fun onAttachView(view: MainView)

    fun onFirstAttachView(view: MainView)

    fun onDetach()

    fun onDestroy()

    fun onUpdateClicked()
}