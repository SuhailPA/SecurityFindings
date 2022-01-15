package com.suhail.securityfindings.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.suhail.securityfindings.dataStore.DataStoreFile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewPagerViewModel
@Inject constructor(
    val dataStoreFile: DataStoreFile
) : ViewModel() {
    val goToNextPage = MutableLiveData<Boolean>()
    fun updateDataInDataStore() {
        viewModelScope.launch {
            dataStoreFile.saveToDataStore(true)
            goToNextPage.postValue(true)
        }

    }
}