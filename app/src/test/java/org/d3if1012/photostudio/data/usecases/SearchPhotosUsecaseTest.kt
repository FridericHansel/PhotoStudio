package org.d3if1012.photostudio.data.usecases

import com.MockTestUtil
import org.d3if1012.photostudio.data.DataState
import org.d3if1012.photostudio.data.repository.ImagineRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SearchPhotosUsecaseTest {

    @MockK
    private lateinit var repository: ImagineRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `test invoking SearchPhotosUsecase gives list of photos`() = runBlocking {
        // Given
        val usecase = SearchPhotosUsecase(repository)
        val givenPhotos = MockTestUtil.createPhotos(3)

        // When
        coEvery { repository.searchPhotos(any(), any(), any()) }
            .returns(flowOf(DataState.success(givenPhotos)))

        // Invoke
        val photosListFlow = usecase("", 1, 1)

        // Then
        MatcherAssert.assertThat(photosListFlow, CoreMatchers.notNullValue())

        val photosListDataState = photosListFlow.first()
        MatcherAssert.assertThat(photosListDataState, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(photosListDataState, CoreMatchers.instanceOf(DataState.Success::class.java))

        val photosList = (photosListDataState as DataState.Success).data
        MatcherAssert.assertThat(photosList, CoreMatchers.notNullValue())
        MatcherAssert.assertThat(photosList.size, CoreMatchers.`is`(givenPhotos.size))
    }
}
