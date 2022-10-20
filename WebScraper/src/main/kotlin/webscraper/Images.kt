package webscraper

import it.skrape.core.document
import it.skrape.fetcher.HttpFetcher
import it.skrape.fetcher.extractIt
import it.skrape.fetcher.skrape
import it.skrape.selects.eachAttribute
import it.skrape.selects.html5.img

data class Images(
    var httpStatusCode: Int = 0,
    var httpStatusMessage: String = "",
    var imageLinks: List<String> = emptyList()
)
