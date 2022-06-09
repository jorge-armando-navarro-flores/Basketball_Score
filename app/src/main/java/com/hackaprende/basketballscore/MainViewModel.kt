package com.hackaprende.basketballscore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var _localScore: MutableLiveData<Int> = MutableLiveData()
    private var _visitorScore: MutableLiveData<Int> = MutableLiveData()

    val localScore: LiveData<Int>
        get() = _localScore

    val visitorScore: LiveData<Int>
        get() = _visitorScore

    init {
        resetScores()
    }

    fun resetScores() {
        _localScore.value = 0
        _visitorScore.value = 0
    }

    fun addPointsToScore(points: Int, isLocal: Boolean) {
        if (isLocal) {
            _localScore.value = _localScore.value?.plus(points)
        } else {
            _visitorScore.value = _visitorScore.value?.plus(points)
        }
    }

    fun decreaseLocalScore() {
        if (_localScore.value!! > 0) {
            _localScore.value = _localScore.value?.minus(1)
        }
    }

    fun decreaseVisitorScore() {
        if (_visitorScore.value!! > 0) {
            _visitorScore.value = _visitorScore.value?.minus(1)
        }
    }
}