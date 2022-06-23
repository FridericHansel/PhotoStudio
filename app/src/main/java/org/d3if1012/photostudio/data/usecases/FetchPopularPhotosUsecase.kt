package org.d3if1012.photostudio.data.usecases

import org.d3if1012.photostudio.data.repository.ImagineRepository
import org.d3if1012.photostudio.utils.AppConstants
import javax.inject.Inject

class FetchPopularPhotosUsecase @Inject constructor(private val repository: ImagineRepository) {
    suspend operator fun invoke(
        pageNum: Int = 1,
        pageSize: Int = AppConstants.API.PHOTOS_PER_PAGE,
        orderBy: String = "popular"
    ) = repository.loadPhotos(
        pageNumber = pageNum,
        pageSize = pageSize,
        orderBy = orderBy
    )
}
