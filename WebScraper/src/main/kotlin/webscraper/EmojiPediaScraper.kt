package webscraper

import it.skrape.core.document
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape
import it.skrape.selects.eachAttribute
import it.skrape.selects.html5.img

class EmojiPediaScraper(var emojiProvider: EmojiProvider = EmojiProvider.APPLE): EmojiWebscraper {

    override fun getImages(): Images {
        println("Getting images from ${emojiProvider.emojiProviderString}")
        return skrape(HttpFetcher) {
            request {
                url = "https://emojipedia.org/${emojiProvider.emojiProviderString}/"
            }
            extractIt {
                it.httpStatusCode = responseStatus.code
                it.httpStatusMessage = responseStatus.message
                it.imageLinks = document.img {
                    findAll {
                        eachAttribute("data-src")
                    }
                }
            }
        }
    }

    override fun setType(emojiProvider: EmojiProvider) {
        this.emojiProvider = emojiProvider
    }
}