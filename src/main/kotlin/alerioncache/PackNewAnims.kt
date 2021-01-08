package alerioncache

import com.displee.cache.CacheLibrary
import com.displee.cache.index.archive.Archive


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the anim packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //1179
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //1202
    val currentNPCsSize = library.index(20).archives()

    println("[Alerion Cache Tool] Current Packed anims Size: ${currentNPCsSize?.size}")

    val newNPCsSize = newLibrary.index(20).archives()

    println("[Alerion Cache Tool] New Cache anims Size: ${newNPCsSize?.size}")

    newNPCsSize.forEachIndexed { i: Int, archive: Archive ->
        if (i in 1179..1202) {
            if(currentNPCsSize.size <= newNPCsSize.size) {
//                val newarc = library.index(20).add(i)
//                println("Found anim $i, $newarc")
                library.index(20).archives()[i] = archive
                println("Added new archive for anims $i ?")
            }
        }
    }

    val addedModelsSize = library.index(20).archives()

    println("[Alerion Cache Tool] Current Packed anims Size: ${addedModelsSize?.size}")

    library.index(20).update()

}
