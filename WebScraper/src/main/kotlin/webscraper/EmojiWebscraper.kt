package webscraper

interface EmojiWebscraper {
    fun getImages(): Images

    fun setType(emojiProvider: EmojiProvider)
}