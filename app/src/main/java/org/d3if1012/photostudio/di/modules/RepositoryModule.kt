package org.d3if1012.photostudio.di.modules

import android.app.Application
import org.d3if1012.photostudio.data.remote.UnsplashApiService
import org.d3if1012.photostudio.data.repository.ImagineRepository
import org.d3if1012.photostudio.data.repository.ImagineRepositoryImpl
import org.d3if1012.photostudio.utils.StringUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }

    @Singleton
    @Provides
    fun provideImagineRepository(stringUtils: StringUtils, apiService: UnsplashApiService): ImagineRepository {
        return ImagineRepositoryImpl(stringUtils, apiService)
    }
}
