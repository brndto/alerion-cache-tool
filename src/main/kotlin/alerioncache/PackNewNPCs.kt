package alerioncache

import com.displee.cache.CacheLibrary


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the NPC packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/alerion2/Cache")
    //24921
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //25319
    val currentNPCsSize = library.index(2).archive(9)?.files

    println("[Alerion Cache Tool] Current Packed NPCs Size: ${currentNPCsSize?.size}")

    val newNPCsSize = newLibrary.index(2).archive(9)?.files

    println("[Alerion Cache Tool] New Packed NPCs Size: ${newNPCsSize?.size}")

    if (newNPCsSize != null) {
        newNPCsSize.forEach { (index, file) ->
            if(index > 9469) {
                println("[Alerion Cache Tool] Found new NPC with id $index and data length of ${file?.data?.size}")
                if(file.data != null) {
                    library.index(2).archive(9)?.add("" + index, file.data!!, false)
                }
            }
        }
    }

    library.index(2).update()

}
