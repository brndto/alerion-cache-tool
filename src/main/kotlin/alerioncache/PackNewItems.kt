package alerioncache

import com.displee.cache.CacheLibrary
import java.io.File


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the item packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //24921
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //25319
    val currentItemArchive = library.index(2).archive(10)?.files

    println("[Alerion Cache Tool] Current Packed Items Size: ${currentItemArchive?.size}")

    val newItemArchive = newLibrary.index(2).archive(10)?.files

    println("[Alerion Cache Tool] New Packed Items Size: ${newItemArchive?.size}")

    if (newItemArchive != null) {
        newItemArchive.forEach { (index, file) ->
            if(index > 24604) {
                println("[Alerion Cache Tool] Found new item with id $index and data length of ${file?.data?.size}")
                if(file.data != null)
                    library.index(2).archive(10)?.add("" + index, file.data!!, false)
            }
        }
    }

    library.index(2).update()

}
