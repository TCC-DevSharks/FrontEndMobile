package br.senai.sp.jandira.tcc.model.consult

import androidx.versionedparcelable.VersionedParcelize

import android.os.Parcel
import android.os.Parcelable

data class ConsultResponsePaciente(
    val idConsulta: Int,
    val idGestante: Int,
    val especialidade: String,
    val nome: String,
    val dia: String,
    val hora: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(idConsulta)
        parcel.writeInt(idGestante)
        parcel.writeString(especialidade)
        parcel.writeString(nome)
        parcel.writeString(dia)
        parcel.writeString(hora)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ConsultResponsePaciente> {
        override fun createFromParcel(parcel: Parcel): ConsultResponsePaciente {
            return ConsultResponsePaciente(parcel)
        }

        override fun newArray(size: Int): Array<ConsultResponsePaciente?> {
            return arrayOfNulls(size)
        }
    }
}