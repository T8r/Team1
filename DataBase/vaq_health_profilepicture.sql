-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vaq_health
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `profilepicture`
--

DROP TABLE IF EXISTS `profilepicture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profilepicture` (
  `userID` int(11) NOT NULL,
  `image` blob,
  PRIMARY KEY (`userID`),
  CONSTRAINT `ppUSERFK` FOREIGN KEY (`userID`) REFERENCES `user` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profilepicture`
--

LOCK TABLES `profilepicture` WRITE;
/*!40000 ALTER TABLE `profilepicture` DISABLE KEYS */;
INSERT INTO `profilepicture` VALUES (1,'‰PNG\r\n\Z\n\0\0\0\rIHDR\0\0\0\0\0\0\0\0\0Ã¦$\È\0\0\0PLTE\0\0\0\0ÿÿÿUªÿ?¿3™\ÌUª\ÔH‘\Ú?Ÿ\ß8©\âL™\åE¢\Ð?”\ÔNœ\×H£\ÚD™\Ý?Ÿ\ßK¥\áF›\ÔC¡\Ö?™\ØH\ÚE¢\ÜB›\Ý?Ÿ\ßG˜\ÖDœ\×B \ÙHš\ÚFž\ÛD¡\ÝAœ\ÞGŸ\×Eš\ØC\ÙA \ÚF›\ÛDž\ÜC¡\ÝGœ\×FŸ\ØD›\ÙB\ÚG \ÛEœ\ÜCž\ÜB \ÝF\ÙEŸ\ÙCœ\ÚGž\ÛF \ÜDœ\ÜCž\ÝF›\ÙE\ÙDŸ\ÚCœ\ÛFž\ÛEŸ\ÜD\ÝGž\ÙEœ\ÙD\ÚCŸ\ÛFœ\ÛEž\ÜDŸ\ÜC\ÙFž\ÚEœ\ÚDž\ÛCŸ\ÛE\ÜDž\ÜCœ\ÙF\ÚEž\ÚDœ\ÛCž\ÛFŸ\ÛE\ÜDž\ÙCœ\ÚE\ÚEŸ\ÛD\ÛFž\ÛEŸ\ÜD\ÙCž\ÚFœ\ÚE\ÚDŸ\ÛC\ÛEž\ÜEœ\ÙD\ÚFž\ÚE\ÚDž\ÛDŸ\ÛF\ÜEž\ÙDœ\ÚC\ÚEž\ÚE\ÛDž\ÛCŸ\ÛE\ÙDž\ÚD\ÚE\ÚEž\ÛD\ÛDž\ÛEœ\ÙE\ÚDž\ÚD\ÚEž\ÛDž\ÛD\ÛEž\ÙE\ÚD\ÚDž\ÚE\ÛEž\ÛDž\ÛD\ÛEž\ÚE\ÚD\ÚEž\ÛE\ÛDž\ÛDž\ÛE\ÚEž\ÚD\ÚDž\ÛEž\ÛE\ÛDž\ÛE\ÚE\ÚCž\ÚD\ÛEž\ÛEž\ÛD\ÛDž\ÚE\ÚEœ\ÚDž\ÛD\ÛEž\ÛCž\ÛD\ÚEž\ÚE\ÙCž\ÛDž\ÛE\ÛEž\ÛD\ÚDœ\ÚEž\ÙE\ÛDž\ÛEž\ÛE\ÛCž\ÚD\ÚEœ\ÙEž\ÙC\ÛDž\ÛEž\ÛEœ\ÚDž\ÚE\ÙEœ\ÙCž\ÛD\ÛEž\ÛE\ÚCœ\ÚDž\ÙE\ÙEž\ÛCž\ÛDœ\ÛEž\ÚC\ÚDœ\ÙEž\ÙE\ÛCž\ÛDž\ÛEœ\ÚEž\ÚC\ÙDœ\ÙEž\ÛCœ\ÛCž\ÛE\ÚEœ\ÚCž\ÙD\ÙEž\ÛEž\ÛCœ\ÛDž\ÛE\ÚEœ\ÙCž\ÙEœ\ÛEž\ÛCž\ÛCœ\ÛEž\ÙE\ÙCœ\ÙDž\ÛEœ\ÛEž\ÛCž\ÛEœ\ÙEž\ÙCœ\ÙCž\ÛEž\ÛEœ\ÛCž\ÛC\ÙEœ\ÙEž\ÙCœ\ÛDž\ÛEž\ÛCœ\ÛCž\ÙEœ\ÙEœ\ÙCž\ÛCœ\ÛEž\ÛEž\ÛCœ\ÙCž\ÙEœ\ÙEžÛ¨µù~\0\0\0ÿtRNS\0	\n\r\Z !\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~€‚ƒ„…†‡ˆ‰Š‹ŒŽ‘’“”•–—˜™š›œžŸ ¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿ÀÁ\Â\Ã\Ä\Å\Æ\Ç\È\É\Ê\Ë\Ì\Í\Î\Ï\Ð\Ñ\Ò\Ó\Ô\Õ\Ö\×\Ø\Ù\Ú\Û\Ü\Ý\Þ\ß\à\á\â\ã\ä\å\æ\ç\è\é\ê\ë\ì\í\î\ïðñòóôõö÷øùúûüýþ\ë\Ù5\0\0?IDAT\íÁ	œOõþ?ð\×ù\Îbc{\"[ER’+¡½,!*M]\ËM¤RI)´¨KŠ\"*¢”r•HYRBd_“\ìB\Ìböyý\ïÿ>~\çs\Îw3\ßu\Î\çû}?ŸB!„B!„Bˆ\ÐS\ëòk;\ÜÜ¥g\Ï.7w¸öòZ¥ Â‚qA‡„\ç®MLfÉ‰kç¼˜p}-\"D¹š<0\éûS,Â©\ï^¿¿‰\"´DµùŸ\Ó,¶S‹F\\\"ª÷[DýôjÚ«;\êzm\Ã\È:\Z«>t-}ô\ã\àjZrÝ¼0›~µ\à„nª<™H¿\Ù7*B\'\r¦¦Ñ¯\ÎM©¡‹+?Í¥\ß\å\Ìo¡ƒf‹X”Ó›—Î<f\ØÀ„¾½zõM8l\Ì\ä¹\Ë6ŸfQ>o\át\Ï\ãy¤ošýx\ç¦\åP ò\Í:ø\à\×.÷£NViJ6³kFB“H)ò²‡f\îfa²Þ¨\0\áT‘ƒN±`\ß\ëQˆ\ï9\ã0ö×€Gºv+´qT3š>õ+´©5„ó\ÄMaA6ª¯5|j;©„\Ã\Üò\'ó;ûvø\Æh5-™ù%v‚p’²3˜ß–~e\àe¶1¿w\Ê@8F«½\Ìç«ŽüÄ¸ñæ³«9„3D<™Å¼\æ7_5[À¼2‡»  òRæµ )ü\îŠ/˜\×\â\n%®y\"óX\Õ\Ñj\ró\Ø{D	\ë“Fw‰\Ý\rˆ\Ñ\ë\0Ý¥ö‚(I®	t—ñL¨ôó™t÷‚Qbb\æ\Ó\Ý\êK`M~¢»£!JHü\ZºI~Ä…€s=šJ7+*B”ˆ÷\Ð\ÍOõ\r\×\ÓÍŽZ% Á\Úe?‰ ‰z!‡vû\êB]\ã#´;\ÜA\Ô\î\í^d—ÿE»U\ÕT5¤\Ýñ¦A\Õø/Ú½… ‹žL»\ã ‚¨Á\Úd\' Ì¡\ÍÁºAs\áÚœ½%\â\Ö\Ú\ì«$ñ{hs¨)J\ÈGh³£\"DPÄ¬¡Í¾º(1õÿ ÍŠhˆ pÍ§\ÍÎš(Aµ÷\Ð\æ\"ð&\ÐfK”¨j\Ûh3\"\àú\Òfg”°j¿Ñ¦\'D€5O£e_-”¸\ÚÐ’\Ò\" *\'\Òr¨. ÁQZ~«\0@KiIj\nGhžB\Ë\"D\àŒ¢%\ë8\Äm9´…˜VY´$À1Ñ’q9D€”\ÝK\Ë\ëp·h\ÙQ\Z\"0fÐ²*\n½––· \âfZWƒ£\Ô:N\Ëõw€Jöµp˜ö¹T~…ð¿)´<\Çy‰–W ü®--?E\Âq¢7P\Éi\ág‘[©$×ƒ5J¥²\Þ\á_ƒhyŽ4˜–~~U\é•\Õ.8R\Ä\ÏTŽ•ƒð§)T2.C5Í¢ò\n„5Ê¦ò\ëE*™u!ü\çc*ûc\àX±©¼\á7\Íh\é\ëM%\çù’\Ê*\æú™\Ê|?¹’––p´khi\áŸRY\0‡[L\åC¿hK¥)®%•\ì:þ0•\Ê|8\ÞT&AøA•4*M\àxÍ©¤T‚ðÝ“T¾‚–Sy\Âg®D*¡[©\ì6 |u3•-4\à\ÚI¥=„¯R\é-<L\åcUÏ¦\élh!.…¦\Ìx\ß¡ò641“\Ê\0ß¬¥\ÒšhCe„O.¢²Ù€&Œ]4\åÖ„ð\Å(*£ 1T†Aø\â*õ¡&T\Ö@ø •\Ð\Èšr*Ax¯•Q\Ð\È*÷@xo•&\ÐHK*Bx-*‰¦C4\â:A\Ó\Éoµ¡ò´ò•\æ\Þ\ZI¥´Ò‡\Êoý‡Jeh¥•O!¼\ä:M\Ó.h&‘¦c„wšP™\Í|D¥!„w ’\0\Í¢r„w&Qi\Í4§2\Â;\ßÓ”	Í”Ê¦i	„WŒS4m‚vv\Òt\Â+P™\r\íÌ§R\Â¨<íŒ¦\Ò\Â	T:C;=©ô†ðÆ‹TšB;­¨<á¹T\ÊA;U¨Ì„ð\ÆZšNC?F*M+!¼‘H\Ófhh\'M»!¼‘L\ÓRhh%M\'!¼Ce.4ôM¹ž«Ee244J\Ï]Ne4ô2•\Æž»–\Ê0h\è	*­ <×\Ê@hh•¶ž»™J44JG\Ïu¡\Ò\ZJ r+„\çzR\é\rõ¡\Ò\r\Âs=©ô‚†úP\é\á¹.Tú@CR¹\Âs·Py\Z\ZH¥#„\ç:Py\Z\ZJ¥-„\ç\ÚR\n\r¤\Ò\n\ÂsÍ©<\r½H¥1„\ç.¤2	\ZšJ¥\Z„\çb©Ì††\æQ‰‚ðB\ZM‹¡¡e4ð\Æ!š\ÖBCi\Ú\áM4ý\r£\égo|ASv´SŠ\Ê|o¼I\åh§>•‰\ÞxŒJh\çz*Bx£;•»¡¨\Üá–Tž…v^¢r„7\â¨|\í,¤)\'\Â+h\Ú\í\ì¦\é7\ï,¡)-š‰Ê¢i!„w^¥Rš¹”\Ê8\ï<H¥;4s/•\Þ\ÞiI\å%h\æu*—Ax\':¦e\Ð\Ì*šR\" ¼ô3M§h%\"™¦•ÞšL¥´r)•‰\Þ\êK¥´ò•\ÞjDe:´ò•!¼e¥i7´òMû!¼÷1•j\ÐH*3!¼÷0•ž\ÐH*÷Ax\ïb*Ó ‘\ÙT\ê@x\Ï8BÓŸ´\á:NS\"„/fSim´ 2\r\ÂwQm<M¥3„/*dÓ´\Úø¦ô2>YISfh¢JM\ß@øf$•¾\Ð\ÄCT†@ø\æR*_@K¨Ôƒð\Ñš\Ò\ÊB2i\Ú\á«\ç¨\Ü-ô¡2\n\ÂW©|-|E¥>„Ï¶Ó”Y	\Z¨–M\Ó&\ß=G\åh`(•\'!|×€Ê\ÐÀF*u ü`\r•úp¼\ÆT¾ƒð‡‡¨Œƒ\ã½F¥/„?”?GÓ±(8\\\Ì)š’\Ë@ø\Å*=\àp}¨Ì€ðŽT–\Ã\á\ÖP¹\Â?Œ\ÝT\Z\ÂÑšR\Ùb@ø\ÉP*o\ÂÑ¦Sy\Â_*¤Ò”RV5¦³e!üf:•‘p°\ç¨ü\Â® r(\ZŽUú•K!ü\è{*}\àXQù\nÂŸn¡²\Ý‡Š\ÜK¥=„?Û¨t‡Cõ¦²Þ€ð«û¨l6\àH»¨ô„ð¯\èCT:Ã‘î¢²/\ÂÏ†R\ÙhÀ\\[©<\áo¥P\é\êM\å@4„\ß\r¡²\'Ž½Ÿ\Ê\0ÿ+}„\Ê\08\Î`*DCÀ*Gb\á0q\'¨ô‡„˜ƒTž‚\Ã<Oe4D@<@%¥¥N\Z•^±•Ê‡p”O©¬wA\ÈÍ´´ƒ\\OK{ˆ@1–Sù\ÅÇˆ\ÜJ\å?\Ó<—\Ê 8\Æ0*\ÙM \è*Iµ\àuR¨L‚¤Ê§¨,„3_S9^\" ¡¥¡-÷CV\ÄF*G*\Â*§ò“\"ÀZ\çRù%\Ïø„JNˆ€›LK”¸{hy\"ð\âþ¤r²JX­¿©ì‹…‚[hYl D\ß\Ð\Ò\"(>¢eJ\ÔpZf@Güq*™W¢µÎ¢r¤\"D\ÜNË¾ò(1•\ÐrD\ÐL£\åS%\Äø’–\ÉÁSv/-ÿB	y‚–]±Atu6•œN(·\æR\Éj	T\Ï\Ðrº>JÀ\Ågi\\\Ëh\Ù‡ «°‡–¯\\AV\å-‹#dQKi9P\"\è\Úf\Ó2\Í@P³hÉ¼\Z¢Œ \Íh\Õ´\nQŒOhó\0‚\èa\Ú|d@”ˆ\ØM´dwE\ÐôÌ¡e]D	©}Œ–\Ì[$]²h9\\¢\Ä\\“AKZG\Å\Í´¤]	Q‚ú\Ò&µ‚ C\ZmzA”¨§hs\îF\Ü\í\é´y¢dSh“q\'\ì\î,Ú¼Q\Ò\"\Ð&\ç~Tÿ\\\Ú\ÌuA”¸˜U´a `ŒÑ´[^\n\Â\ÊýL»\éQ\èY´[]\Â*l Ý²òˆJ+i÷S„CTú•v;\Z!\0.\ÝC»\r\å!#~+í’º\Ã\ï\îN¡Ý¦ŠRyÝ¼¿ŠžL7k*@8J\Üwt³¦.ü¨þ\Ït³$\Âab\ÒMÒƒü\ÄB7ó£!\'ò}º[T~Q\ãkº{\'ÂŒ§\é\î\äƒ.ø\Ìõ\Ð)º\Én@8S\Ï4ºûñ\nø¨\Å\Ït—\ÚÂ±®:Fw9oV‚\â\ßÊ¥»C\Í!¬ö:\æqvt¼T\î¹$æ±¦&„£Eÿ›y/”~’y½\át=“˜×‰1\Õ\à¡\ê/üÅ¼\Ît…\Ð@£_™OÆŒ\ËQ|F‹Y\ÌgC=-D\Íf~›‡\×@±\Ô\Z±ùe=	¡‹V»X€œ¥ƒ\ê¡õý6—\Ø\ÞB#¥_\Éfö¼Ù¹\nQ³Ë¿c²Ç—‚\ÐK\Ó\Õ,\Ì\á/ž¹»u\rWk\î~ö\Ë\Ã,ÌŠ&\Ú1z\åù¤\'nûù»E‹¾ûy[b\Ï\çð\Ý„Ž\ÊM8GŸ¥¾¡«\Z“3é“Œ7ªA\è¬ÎŒ,z-kzm\Ý]0þ4½rj\\MˆPPf\Ðzl\×Ã±¡\Âhû\Î\ßôÀ©©\×!¥ÔŸ¥°X’t†A\Ñ\×O\Ø\Â\"l]4D\èª\Ñ\å…%\'Y ¿¾Û¹:D\è3\êt\è÷ü¬•›÷>“•u\æð\Þ\Í+f\é\×\áBB!„B!„B!BFD|½K.oÕ¶\Ã-]zö\ìrK‡¶­.¿¤^|DHs\Õh\Óû‰W\Þ_ôÓžS¹,@\î©=?-zÿ•\'z·©a@„ˆF\ÝGL]²;Å–¶\ë\ë©#\îl¡¹J\×\ryoý9z)uÝ»ƒ\ÛU„\ÐRt\ë\Ç¤ü¹pø\Õ\Ñ:©x\ÛK«\Ó\èGi+\Ç\ÝRB\Ñ^\Ù\Ê@\È\Ý2¡}„£\Õ°0™”ôùCµ œÉ¸z\â6Á\Öñ­‡1ZLHd\Ð\ì{ùr\Â9.{\á7\Ù\î\çC8B\Õ\Û\éÌ£\ÛW}þ\îÄ±£G˜Ð·W¯¾	‡=vâ»Ÿ¯\Ú~4“\ØúX<D	suú$“Å‘¾gé´§\îmS7\ÎÀy\å.js\ïSÓ—ý–Á\â\Èøøz¢\äTµE:ó\Ã\ÔAÿ¨\á‚G\\5\Ú\rz{\ÍYi\ïÈª%\Âh· ‹\ç—øñ·\Ö6\à5\ã\Â\ÛF\Íûƒ\ç—ùi[\"\Ø\"{®\çùd®}­{MøE­“\Öeñ|\Öv€¦²ƒ÷³pY+ž¼6~UúO­\Ìb\á~,\ÕÇf¡öO\í‡€(\×õ\íD\ê\äóU!‚¡Ú¤t\"{\Ù\à†È¸xÈ·\Ù,Ä¹‰ñVù\åT,{\éCñ‚øþ\ßf³`\É/T€¤òc’X \ìe\Å#hªXž\Ã(eFf¶‰GU¶:ùx,D ½± \É\ÓZ(\Æ\Õï¦° ö2 üîªµ,ÈýÊ¢\Ä\Ä%¬eA~h\á_5g±\03›¡„]>+“ù\å¾W\r\ÂbžLa~\'_¨¨1\î4óKz<\Z\ÂO®\ß\Ëüv?‡(3h/ó\Ûý¨ð.óû\å\Ä\Õuó›Z\Âgwe>¿\ÞaÀaŒ®[˜Ï¡; |S\ã3æ³µ›rõ\ØÁ|\æU…ðž\Ñ\ïoæµ£§q÷n\æuª¯\á¥ÊŸ3¯ý#\à`‘O2¯ù!¼\Òñ0óÈ˜PW\áµ,\æñ\çuž+õ\nóú¬>4\Ðhó\È\á¡K71-\×C7lg\ëBx\Â\èŽ\î\Î\r„6¢F¥\Ñ]\Êý\Å3ƒy,«­4üžyL†(¦:¿\Ð\ÝÉ¾4cô;MwkkAK§“t÷Qh¨\Ú<º;\Þ¢h\Æ\Èº9q4\Õ\í$\Ýd3 ŠPv\Ý}U\rÚª¹”\î\æ\ÆBœW\ÍMt“ö¨¹†¥\Ó\Íúj\ç\ÑôOºùµ14\×t\Ý$^\nQ¨Ng\é\æ•R\Ð^\Ìtów{ˆB<˜E»³]z¦\Ð.³DAŒ\èf{#„ˆÆ»\é\æ\"Ÿ\ÈYt3¯,BF¹\Ï\èfzDÑŸ\Ò.{˜bŒÈ¡\Ý\Ü(7¥¿¢\Ý_\íb:œ¦\Ý16e¿§Ýžú9\ï£Ý²X¥\ÂO´[]	!¨\ÊO´[]\âÿ\Äo¢ÝœRI¥?¡Ý†JÿSy+\í\Æ\ZQ®ñ´ûµ\"\Ä•\Û@›\ì~arh³6e~ MFW„´»²h³¢4\Â^\Ì2Ú¤Ý„w{:m¾ŽF˜‹ú’6\É\×!\äuL¥Í‚H„µˆy´ùûj„k\Ï\Ò\æÂ˜ñ6mN\\Ž°\Ð\â$m\ÞDA›“M&š¦\ÍP„­ž´9\Ûa\ãªdZr»\"LµI§%¥\r\ÂH»s´œ»\na©ÁIZ\Ò; ¬Ü”I\Ëñ‹†\â÷Ò’u\ÂL·lZvUD\Ø)µ†–Üž;½i³\"\n\áf*m# \Í$„™~´y\á\Èx‡6÷ ¬´L§\å‹„¥\È%´œk†0ÿ-\Ê L•\ÛB\Ë\ï6\"¾¥\å@u„­Ó²Ø…pñ2-IMÆ®H¡\å9„‰\Ûh\Óa­m:!,T;A\ËKs¯\Ór¤2Â€ñ5-\ßF \ÌE­¢e¡\Ð7˜–ñ{Õ\Ð\Ò!\ï²t*­ \Ð&‹J\ê\Åq1[i\éñ_ÿ¤ec4B\Û´|l@ü—±–	i\×\Ñògˆÿ‰?B%÷\Z„°\Ò{©\ä^ñn¤eG)„®—i¡L¢eBVól*£!”˜­T2› DEn¤r\î›¦\éT\ÖF 4¤\åŸn†\Ó2!©a\Z•Ÿ\\n\"¡’R!\ÈXJ%³	DWdSù!\èvZž‡\Èg-r¢÷R\ÙU\n\"Ÿ\Ø}T¶G\"\Ô<NK[ˆt¤\åQ„˜jITÞ(\ÐûTNWFhy—\ÊÉŠªr†\Êd„”¹TA\â1*Ù—!„«¨ìˆ„(Dô^*KBn¤\åFˆBu¦¥B†±Ž\Êbˆ\ÂË©¬6*î ’u1\Äy4Ë¡rB„k3•7 \Î\ë*\ë„†T’\ã!Î«f\Z•\Û\"vRQ„×©ü\êB(\èC%©Dª£\Ò!Àµ“\ÊXˆ\"½Be³ý\ÝN\åLEˆ\"UI¡\Ò	ú[I\åYˆbx™\ÊRh¯•\Ó\å!Š¡r•f\Ð\Ý<*c!Š\å*³¡¹º94eT‡(–³iÊº\0z{“\ÊLˆbšKe\"´V1…\Êe\Åt%•³å ³!T–B\Û**@c\Æ6*7A[g*¡±k¨l7 Š\Íõ•–\Ð\×ûT@x`0•w ­\n\çhJ‰ƒð@¥tš’\ËBWR™	\á‘9T )c•6\é@e4ÕŠ\ÊN\Â#®}TšAOoPy\ÂCOQ-¹Ó”Y\ÂCµrhJ4 £vT>…ð\Øb*WAGS©tƒðØ½T^ƒ†\"OÐ”\\\Z\Âcq\é4tA?¨Ì…ð\ÂB*m¡Ÿw©tƒð\Â=T&C;Q§iJ.\rá…¸tšŽE@7\í©Ì…ð\Ê\çT®†n&P\é\ná•»©Œn¶Ò”Z\Z\Â+e3hZ\ÍÔ¦²\ÂK\ËiÊ­½ô§2\ÂK#¨ô^>§\Ò\ÂKM©ÌV¢“h\Úg@x\É8L\Ó\É\è\äz*S!¼6“Jk\è\äE*!¼v•§¡“4e\ÆAx­RM_C#Q\çhú\Âh:}\\Ee<„Þ \ÒúxŒJg\ÜEeôñ•*>¸€\Êh\Ã8N\Óo>ù“¦\ÐF*³ |2Jm\è\â>* |2„J/\è\â5*—Aø¤%•— ‹\å4¥F@ø$*ƒ¦\ÅÐ„ñM\ë |´™¦ƒ\ÐDu*\ïAø\è#*• ‡©…ð\ÑT®ƒFP\é\0\á£[©†>¤R\ÂGµ©¼=l¡\é8„¯Œ34­ƒ\\\é4-‡ð\Ù4%\ÐA-*ÿ†ð\Ù4*•¡ƒ¶T†Aøl•+¡ƒ>TºBø\ìn*=¡ƒg¨\\\á³\ÖTFB3©T„ðYu*oC+h:k@ø\ÌH£\é\è ‘¦-~°›¦\Ý\Ð@d6M_BøÁ74¥»\à|Õ©L†ðƒiT*\ÂùšPy\Â^¤\Ò\0\Îw•A~ð/*­\á|wR\é\á÷Q¹\Î7€J\'?¸\Êýp¾\'©4‡ðƒ\ÖT†\Ãù^£r!„4¤ò2œo6•2~P‰\Êt8\ßhJ7 üÀ•C\Ó\çp¾\å4ý\ágiZ\çû¦C~q‚¦\ï\à|\ëh\Ú\á‡hZ\ç\ÛL\Ó.¿\ØO\Óz8\ßNš¶@ø\Å.š¶ÀùöÑ´\Â/¶Ð´\Îw¦!üb=Mû\á|\'hú\Â/\Ö\Ðt\Î÷7M\ßBø\Å\nšNÀù\Ñô#„_l )Î·“¦\í~ñM›\á|?\Ót\Â/ŽÓ´\ZÎ·Œ¦T\Â\\4-†óÍ¡r!„4 ò>œ\ïi*·CøAw*#\à|]©<\á\ÏS¹\Î×\Ê\ç~ð•:p¾ˆ4š’KAø,6¦d\ZXN\å&Ÿu¦²:Ne\n„\ÏÞ£ò(tÐ˜\ÊñR>Š=M¥t` r?„P\Ù=¼Ne“\ác;•—¡‡Kh¹\Â\'7RÉ­M|Oe­áƒˆMT–@w\Ñr„ú\Ñ\Òºˆ>D\å\ÏX¯\Å¥’	mô§e\"„\×Þ¤¥/ô¹‡Jn{/\ÝD\Ë\Öh¤-+Bx¥\ÊQZn‡NŒµ´,0 ¼\àZD\ËJZiœA\ËX/L¤\å\\Chfm\îƒðX\Úƒn\"\×Ó’\Ù\ÂC7f\Óòƒ\ÚiœJKJ;t<GKrCh\è.Ú¤^\áNi´\é-½L›s Š\í\Æ4ÚŒž\"–\Ð&£7D1õË¤Í—.hª\â6Ú1 ŠÁõ\í6•ƒ¶ªÿF»91EŠý”v;«@c \Ý\æFEh¼vûkAk\r\Ò.ù^ˆó1ú£\Ý\áz\Ð\\\ÃDºy¯,D¡\Ê}@7{\ëA{5¶\ÐMb\'ˆB\Ürn~©ŠP~%Ý½[¢\0•f\ÓÝ·q	1\Ó\Ý\áD\Æ=\Ç\ènv)„\ã_\Ùt·¢)„›\æ?\Ð]Ö£B\Çõ\'\è.gJ%¥Ê´\\º;\Ú!¥ö:\æñ÷Se!þ§Ü³g™Ç5b¢\Æ\æ0\ã\Ãb ;\â$ó\È\Z‰\Ð\Óúw\æuhPi„¹2CŽ2¯\ÝW\"$•\Î|N<]a¬òs\'™Ï”X„ªŽ¿1Ÿ\ä\×.@˜ªóf*ó\Ù\Ù!,\æ¹æ“½\àzaÇ¸\á‹\æ“öT4B[£\å,ÀŽG\Ë!¬”º‡ø¦>Bž\Ñu2óÂ„«ý¬T`\ç\í\ÂAÔ ¿XßŸ¹a \îsûYcG\"\\”wŽ\Éýþ\á*iU®dRŸC8©öj*”½,¡BT\åþ\ß\æ°@)\ã« \ÜTÂ‚e-T!§\Î?—e³`I\ã\âŽ\â\Çý\Í\Âl\Z\Ó\Â@\Èp]9v3srl%„«²\îe¡ŽÌº§\nB@µÞ³²P»ŽE8‹è¼’\ç±ñ\å¥¡±ØŽ~\åy|w›aïŠ·“x«_\èT\Z*{\ã¸5™<³o5ƒøÿ\Êö\ßÀó\Êúib·\Z\ÐH\Í;\'®\Í\ây­{°„\Ò\â\í\Ó,\Âó†^\Ç+\Ýz\Øü,Â©©W@¸+\Õõ³%kó\Ì^‡*\Ófðû[²Y”ôO;GC bÿÕ¹,ZÎŽŸ\î\\\Ïq\Õ\ï2z\Þ\Î-weBˆB\Õ|ôûKÊº#\îh…uq\ç3Ö§²X²—¬Q„ªý¿\Ébqe\íþr\â€Nõ¢tQõo0qÑž,W\æ\×	ñ\ÅR¾\ç¬ôDv\âwïŽ¾¿C\Ã\Ò¸\Ò\r;\Ü?ú½\ïÿÈ¡\'Ž\Í\ì^\Â®«žÿ…žûkÓ—\ïŒy¤këº¥\áW¥/º¦\ÛÀ\ç§-úõ/znýsWº <Wµ\×ôýôV\Òþ\rK>|côÀ»o½ö²\Ú\å\\ð«\\\íË®½õž£\ßøhÉ†\Ä$z\ë÷i=\ã!¼W¯ÿ¼\ãô]\î™\Ã{7ÿø\ís\Þ{k\Òø±O:\è\áþ	ý\î\ës\ï½}\î\ë—\Ðÿ‘ACGŒ;~\Ò[\ï\Íù\â\Û7\ï=|&—¾;öqB]Ÿ\rû\Í\ØC\Í\ì~\ïþú„\ßT»óµÕ©\ÔB\êªW»U…ð¿\ÈfMßœM\Ë\ÞôNB\ÓHˆ\0Šm\Õÿ­“\é8I?Ly\è\Ê\ÒA\áj\Ðc\Ì\'\Û3\é™\Û\æ\é^\ßlQ—\Ü9z\î†3,1¯Ÿ;º\Û\ÅQ%É¨ÜºÏ˜~>\Ê :²ö\Ã\çz_]\ÂAb\ZvJûÁŠ\ÝI˜¤\Ý+fM\èÔ „ƒ\Å5j\ïˆWg/ù\å@\Zý\àÜ\r_\Ï~uÄ½\í\ÅA\è\Å({QËŽ\Ý†¿8eÎ¢\ï\Ö\íø\ãd:‹”~ò\í\ë¾ûrÎ”†\'t\ï\Øò¢2!$*.¾V½K¯¸º]‡N7\Ýr[\ç®Ý»w\í|\Û-7u\ê\Ð\î\ê+.­W+>.B!„B!„Bjþ\ØµÌ¹	l\0\0\0\0IEND®B`‚');
/*!40000 ALTER TABLE `profilepicture` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-15 13:49:00
