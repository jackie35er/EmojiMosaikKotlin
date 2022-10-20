package downloader

interface MutlipleFileDownloader {

    fun downloadFiles(files: List<String>, destination: String)
}