package org.d3if1012.photostudio.ui.photodetails

sealed class PhotoDetailsUiState

object LoadingState : PhotoDetailsUiState()
object ContentState : PhotoDetailsUiState()
class ErrorState(val message: String) : PhotoDetailsUiState()
