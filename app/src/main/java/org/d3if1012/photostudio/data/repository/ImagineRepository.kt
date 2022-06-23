package org.d3if1012.photostudio.data.repository

import org.d3if1012.photostudio.data.DataState
import org.d3if1012.photostudio.model.PhotoModel
import kotlinx.coroutines.flow.Flow

interface ImagineRepository {
    suspend fun loadPhotos(pageNumber: Int, pageSize: Int, orderBy: String): Flow<DataState<List<PhotoModel>>>
    suspend fun searchPhotos(query: String, pageNumber: Int, pageSize: Int): Flow<DataState<List<PhotoModel>>>
}
