package com.suhail.securityfindings.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suhail.securityfindings.dataStore.DataStoreFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    val dataStoreFile: DataStoreFile
) : ViewModel() {

    var oneTimeForOnBoarding = MutableLiveData<Boolean>()

    init {
        checkFromDataStore()
    }

    private fun checkFromDataStore() {
        viewModelScope.launch {
            dataStoreFile.getDataStore().collect {
                oneTimeForOnBoarding.postValue(it)
            }
        }
    }
}