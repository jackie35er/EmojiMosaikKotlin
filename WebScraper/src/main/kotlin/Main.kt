import downloader.SimpleMultipleFileDownloader
import webscraper.EmojiPediaScraper
import webscraper.EmojiProvider

fun main(){
    val emojiWebscraper = EmojiPediaScraper(EmojiProvider.SAMSUNG)
    val images = emojiWebscraper.getImages()
    val downloader = SimpleMultipleFileDownloader()
    downloader.downloadFiles(images.imageLinks, "src/main/resources/images/${emojiWebscraper.emojiProvider.emojiProviderString}/")
}
