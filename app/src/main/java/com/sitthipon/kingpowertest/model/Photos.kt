package com.sitthipon.kingpowertest.model


import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Photos(
    @SerializedName("albumId")
    var albumId: Int? = null,
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("url")
    var url: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(albumId)
        parcel.writeValue(id)
        parcel.writeString(thumbnailUrl)
        parcel.writeString(title)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photos> {
        override fun createFromParcel(parcel: Parcel): Photos {
            return Photos(parcel)
        }

        override fun newArray(size: Int): Array<Photos?> {
            return arrayOfNulls(size)
        }
    }
}