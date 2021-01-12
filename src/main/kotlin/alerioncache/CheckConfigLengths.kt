package alerioncache

import com.displee.cache.CacheLibrary
import java.io.File


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the item packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/Alerion-osrs-source/norse-cache")
    //24921
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/alerion-kronos/Cache")
    //25319


    val latestOsrs = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")

    val currentItemArchive = library.index(2).archive(10)?.files

    println("[Alerion Cache Tool] Current Packed Items Size: ${currentItemArchive?.size}")

    val newItemArchive = newLibrary.index(2).archive(10)?.files

    println("[Alerion Cache Tool] New Cache Items Size: ${newItemArchive?.size}")

    newLibrary.index(2).archives().forEach { archive ->
        if(archive != null) {
            println("[Alerion Cache Tool] New Config ${archive?.id} Size: ${archive?.files?.size}")
        }
    }


    library.index(2).archives().forEach { archive ->
        if(archive != null) {
            println("[Alerion Cache Tool] Current Config ${archive?.id} Size: ${archive?.files?.size}")
        }
    }


    latestOsrs.index(2).archives().forEach { archive ->
        if(archive != null) {
            println("[Alerion Cache Tool] OSRS Latest Config ${archive?.id} Size: ${archive?.files?.size}")
        }
    }

//    newLibrary.index(2).archive(16)?.files()?.forEach { file ->
//        if(file != null) {
//            println("[Alerion Cache Tool] File size: ${file?.data?.size} File Contents: ${file?.data?.toString()} ")
//        }
//    }

}
