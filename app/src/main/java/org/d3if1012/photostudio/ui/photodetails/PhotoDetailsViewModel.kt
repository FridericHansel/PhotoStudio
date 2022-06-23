package org.d3if1012.photostudio.ui.photodetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if1012.photostudio.model.PhotoModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotoDetailsViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableLiveData<PhotoDetailsUiState>()
    var uiStateLiveData: LiveData<PhotoDetailsUiState> = _uiState

    private var _photoModel = MutableLiveData<PhotoModel>()
    var photoModelLiveData: LiveData<PhotoModel> = _photoModel

    fun initPhotoModel(photo: PhotoModel) {
        _photoModel.value = photo
    }
}
