package by.arro.journal.presentation.main

interface MainView {

    fun setSum(sum: Int)

    fun setUpdateType(type: UpdateType)
}

enum class UpdateType {
    INCREASE,
    DECLINE
}