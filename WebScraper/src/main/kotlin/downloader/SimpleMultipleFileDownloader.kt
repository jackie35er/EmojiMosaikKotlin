package downloader

import java.io.File

class SimpleMultipleFileDownloader : MutlipleFileDownloader {

    override fun downloadFiles(files: List<String>, destination: String) {
        File(destination).mkdirs()
        println("Files to download: ${files.size}")
        var prozent = 0.1
        files.forEachIndexed {
            index, it ->
            if(index != 0 &&  index/files.size.toDouble()  >= prozent){
                println("${(prozent * 100).toInt()}% done")
                prozent += 0.1
            }
            val fileDownloader = HttpFileDownloader(it, destination)
            fileDownloader.run()
        }
        println("finished downloading")
    }
}