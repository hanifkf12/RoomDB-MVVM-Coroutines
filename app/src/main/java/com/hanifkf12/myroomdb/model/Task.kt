package com.hanifkf12.myroomdb.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "task_table")
class Task(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int?,
    var name : String,
    var people : String
) : Parcelable