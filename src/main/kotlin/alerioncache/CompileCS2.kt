package alerioncache

import com.displee.cache.CacheLibrary
import java.io.File


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the item packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/Alerion-osrs-source/norse-cache") //
    //24921
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/alerion-kronos/Cache") //10187
    //25319


    val latestOsrs = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")

    val currentItemArchive = library.index(12).archives()

    println("[Alerion Cache Tool] Current Packed CS2 Size: ${currentItemArchive?.size}")

    val newItemArchive = newLibrary.index(12).archives()

    println("[Alerion Cache Tool] New Cache CS2 Size: ${newItemArchive?.size}")

    newLibrary.index(12).archives().forEach { archive ->
        if(archive != null && archive.id > 4000) {
            println("[Alerion Cache Tool] New CS2 ${archive?.id} Size: ${archive?.files?.size}")
        }
    }


    library.index(12).archives().forEach { archive ->
        if(archive != null && archive.id > 10187) {
            println("[Alerion Cache Tool] Current CS2 ${archive?.id} Size: ${archive?.files?.size}")
        }
    }

//    val cacheFrom = library //CacheLibrary.create("...")
//    val cacheTo = newLibrary //CacheLibrary.create("...")
//    val index = cacheTo.index(12)
//    cacheFrom.index(12).cache()
//    index.clear()
//    index.add(*cacheFrom.index(12).archives())
//    index.update()

//    latestOsrs.index(12).archives().forEach { archive ->
//        if(archive != null) {
//            println("[Alerion Cache Tool] OSRS Latest CS2 ${archive?.id} Size: ${archive?.files?.size}")
//        }
//    }

//    newLibrary.index(2).archive(16)?.files()?.forEach { file ->
//        if(file != null) {
//            println("[Alerion Cache Tool] File size: ${file?.data?.size} File Contents: ${file?.data?.toString()} ")
//        }
//    }

}
