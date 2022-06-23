package org.d3if1012.photostudio.ui.photodetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import coil.load
import org.d3if1012.photostudio.base.BaseFragment
import org.d3if1012.photostudio.model.PhotoModel
import dagger.hilt.android.AndroidEntryPoint
import photostudio.databinding.PhotoDetailsFragmentBinding

@AndroidEntryPoint
class PhotoDetailsFragment : BaseFragment<PhotoDetailsFragmentBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> PhotoDetailsFragmentBinding
        get() = PhotoDetailsFragmentBinding::inflate

    private val viewModel: PhotoDetailsViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var photo = arguments?.getParcelable<PhotoModel>("photo")
        if (photo == null) {
            findNavController().popBackStack()
            return
        }

        setupViews()
        initObservations()

        viewModel.initPhotoModel(photo)
    }

    fun setupViews() {
    }

    fun initObservations() {
        viewModel.photoModelLiveData.observe(viewLifecycleOwner) { photo ->
            bi.photoView.load(photo.urls.full)
        }
    }
}
