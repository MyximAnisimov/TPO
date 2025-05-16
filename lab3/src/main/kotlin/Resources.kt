package org.example

import org.openqa.selenium.By

object Frames {
    val leftSideBar: By = By.xpath("//frame[@name='Obsah']")
    val rightSideBar: By = By.xpath("//frame[@name='vpravo']")
}

object Links {
    val linkNextPage: By = By.xpath("//a[@title=' Next ']")
    val linkOnNewTabEng: By = By.xpath("//a[@href='http://www.heavenly-angels.org']")
    val linkOnNewTabCz: By = By.xpath("//a[@title=' www.andele-nebe.cz ']")
    val linkOnNewTabDe: By = By.xpath("//a[@href='http://www.himmels-engel.de']")
    val linkPng: By = By.xpath("//a[b=\"Картинки\"]")
    val linkVideos: By = By.xpath("//a[@href=\"video_ru.htm\"]")
    val linkOnDownloadPps: By = By.xpath("//a[@href=\"video/presentation/10_roses.pps\"]")
}

object Pngs {
    val pngHumanHeart: By = By.xpath("//img[@src='img_0000/preview/tn_obr003.jpg']")
}