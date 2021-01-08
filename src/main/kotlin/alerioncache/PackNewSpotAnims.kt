package alerioncache

import com.displee.cache.CacheLibrary
import java.io.File


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the item packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //1815
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //1835
    val currentItemArchive = library.index(2).archive(13)?.files

    println("[Alerion Cache Tool] Current Packed Items Size: ${currentItemArchive?.size}")

    val newItemArchive = newLibrary.index(2).archive(13)?.files

    println("[Alerion Cache Tool] New Packed Items Size: ${newItemArchive?.size}")

    if (newItemArchive != null) {
        newItemArchive.forEach { (index, file) ->
            if(index in 1778..1835) {
                println("[Alerion Cache Tool] Found new item with id $index and data length of ${file?.data?.size}")
                if(file.data != null)
                    library.index(2).archive(13)?.add("" + index, file.data!!, false)
            }
        }
    }

    library.index(2).update()

}
