package alerioncache

import com.displee.cache.CacheLibrary
import com.displee.cache.index.archive.Archive


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the model packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //40921
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //41516
    val currentNPCsSize = library.index(7).archives()

    println("[Alerion Cache Tool] Current Packed models Size: ${currentNPCsSize?.size}")

    val newNPCsSize = newLibrary.index(7).archives()

    println("[Alerion Cache Tool] New Cache models Size: ${newNPCsSize?.size}")

    newNPCsSize.forEachIndexed { i: Int, archive: Archive ->
//        if (i in 40922..41514) {
            if(i > 41516)
                return;
//            if(currentNPCsSize.size <= newNPCsSize.size) {
//                val newarc = library.index(7).add(i)
//                println("Found model $i, $newarc")
                library.index(7).archives()[i] = archive
                println("Replaced archive for model $i ?")
//            }
//        }
    }

    val addedModelsSize = library.index(7).archives()

    println("[Alerion Cache Tool] Current Packed models Size: ${addedModelsSize?.size}")

    library.index(7).update()

}
