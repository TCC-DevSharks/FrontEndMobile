package br.senai.sp.jandira.tcc.model.article

import android.os.Parcel
import android.os.Parcelable

data class articleResponse(
    val id: Int,
    val titulo: String,
    val descricao: String,
    val imagem: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(titulo)
        parcel.writeString(descricao)
        parcel.writeString(imagem)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<articleResponse> {
        override fun createFromParcel(parcel: Parcel): articleResponse {
            return articleResponse(parcel)
        }

        override fun newArray(size: Int): Array<articleResponse?> {
            return arrayOfNulls(size)
        }
    }
}

