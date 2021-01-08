package alerioncache

import com.displee.cache.CacheLibrary
import java.io.File


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the item packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //37547
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //40938
    val currentItemArchive = library.index(2).archive(6)?.files

    println("[Alerion Cache Tool] Current Packed Items Size: ${currentItemArchive?.size}")

    val newItemArchive = newLibrary.index(2).archive(6)?.files

    library.index(2).remove(6)

    newLibrary.index(2).archive(6)?.let { library.index(2).add(it, 6, null, true) }


    println("[Alerion Cache Tool] New Packed Items Size: ${newItemArchive?.size}")

//    if (newItemArchive != null) {
//        newItemArchive.forEach { (index, file) ->
//            if(index in 37548..40937) {
//                println("[Alerion Cache Tool] Found new item with id $index and data length of ${file?.data?.size}")
//                if(file.data != null)
//                    library.index(2).archive(6)?.add(index, file.data!!, false)
//            }
//        }
//    }

    library.index(2).update()

}
