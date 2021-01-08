package alerioncache

import com.displee.cache.CacheLibrary
import com.displee.cache.index.archive.Archive


fun main(args: Array<String>) {
    println("[Alerion Cache Tool] Starting up the maps packer...")

    val library = CacheLibrary("F:/RSPS/Alerion Git/Alerion-osrs-source/norse-cache")
    //3678
    val newLibrary = CacheLibrary("F:/RSPS/Alerion Git/2020-12-16-rev193/cache")
    //3848
    val currentNPCsSize = library.index(5).archives()

    println("[Alerion Cache Tool] Current Packed maps Size: ${currentNPCsSize?.size}")

    val newNPCsSize = newLibrary.index(5).archives()

    println("[Alerion Cache Tool] New Cache maps Size: ${newNPCsSize?.size}")

    newNPCsSize.forEachIndexed { i: Int, archive: Archive ->
        if (i in 270..271 || i in 628..629) {
            println(newLibrary.index(5).archive(i)?.files?.size)
            println(newLibrary.index(5).archive(i)?.files()?.size)
            println(library.index(5).archive(i)?.files?.size)
            var files = newLibrary.index(5).archive(i)?.copyFiles();
            files?.forEach { file ->
                println(file.data?.size)
                if(file.data?.size != null)
                    library.index(5).archive(i)?.add(file, true);
            }
        }
    }
//
    val addedModelsSize = library.index(5).archives()

    println("[Alerion Cache Tool] Current Packed maps Size: ${addedModelsSize?.size}")

    library.index(5).update()

}
