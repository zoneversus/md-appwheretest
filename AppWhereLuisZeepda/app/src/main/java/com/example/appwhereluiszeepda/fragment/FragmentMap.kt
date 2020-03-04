package com.example.appwhereluiszeepda.fragment

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.appwhereluiszeepda.R
import com.example.appwhereluiszeepda.controller.MerchantController
import com.example.appwhereluiszeepda.model.MerchantModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class FragmentMap : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var controller: MerchantController
    var mapFragment : SupportMapFragment?=null
    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpMap()
        init()
        controller.getViewHolder().merchants.observe(viewLifecycleOwner, Observer { pubList ->
            setMarks(pubList.merchants)
             })
    }

    private fun init(){
        controller = MerchantController()
        mapFragment = childFragmentManager.findFragmentById(R.id.Map) as SupportMapFragment
        mapFragment?.getMapAsync(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false)
    }
    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
    }
    fun setMarks(lista:List<MerchantModel>){
        for (i in 0 until lista.size){
            val mark = LatLng(lista[i].latitude, lista[i].logitude)
            mMap.addMarker(MarkerOptions().position(mark).title(lista[i].merchantName))

        }

    }
    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        mMap.uiSettings.isZoomControlsEnabled = true
        controller.getMerchant()
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                LatLng(
                    19.4153107,
                    -99.1804615
                ), 12.0f
            )
        )
    }


}
