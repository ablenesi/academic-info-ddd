package edu.ubb.academicinfo.model

import android.os.Parcel
import android.os.Parcelable

data class Semester(val name: String, val media: Float, val credits: Int, val courses: MutableList<Course>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readFloat(),
            parcel.readInt(),
            parcel.createTypedArray(Course.CREATOR).toMutableList())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeFloat(media)
        parcel.writeInt(credits)
        parcel.writeTypedArray(courses.toTypedArray(), 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Semester> {
        override fun createFromParcel(parcel: Parcel): Semester {
            return Semester(parcel)
        }

        override fun newArray(size: Int): Array<Semester?> {
            return arrayOfNulls(size)
        }
    }
}
