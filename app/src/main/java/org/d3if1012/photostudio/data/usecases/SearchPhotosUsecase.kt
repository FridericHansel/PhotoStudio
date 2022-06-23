package org.d3if1012.photostudio.data.usecases

import org.d3if1012.photostudio.data.repository.ImagineRepository
import org.d3if1012.photostudio.utils.AppConstants
import javax.inject.Inject

class SearchPhotosUsecase @Inject constructor(private val repository: ImagineRepository) {
    suspend operator fun invoke(
        query: String,
        pageNum: Int = 1,
        pageSize: Int = AppConstants.API.PHOTOS_PER_PAGE
    ) = repository.searchPhotos(
        query = query,
        pageNumber = pageNum,
        pageSize = pageSize
    )
}
