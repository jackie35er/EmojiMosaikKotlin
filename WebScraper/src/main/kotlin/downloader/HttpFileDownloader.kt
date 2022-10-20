package downloader

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

class HttpFileDownloader(private val fileLink: String, private val destination: String): Runnable {

    override fun run() {
        val fileStream = URL(fileLink).openStream()
        Files.copy(fileStream, Paths.get(destination + fileLink.substringAfterLast("/")), StandardCopyOption.REPLACE_EXISTING)
    }
}
