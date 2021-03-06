package additionalData;

import java.util.Map;

import static java.util.Map.entry;

public class AdditionToPublication {

    /*TYPE OF PUBLICATIONS AND REQUIERED ATRIBUTE (+) AND OPTIONAL ATRIBUTE (o) */
    private static Map<String, Character> article = Map.ofEntries(
            entry("author", '+'), entry("journal", '+'), entry("month", 'o'), entry("note", 'o'), entry("number", 'o'), entry("pages", 'o'), entry("title", '+'), entry("volume", 'o'), entry("year", '+')
    );
    private static Map<String, Character> book = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("howpublished", 'o'), entry("month", 'o'), entry("note", 'o'), entry("number", 'o'), entry("publisher", '+'),entry("series", 'o'), entry("title", '+'), entry("volume", 'o'), entry("year", '+')
    );
    private static Map<String, Character> booklet = Map.ofEntries(
            entry("address", 'o'), entry("author", 'o'), entry("howpublished", 'o'), entry("month", 'o'), entry("note", 'o'), entry("title", '+'), entry("year", 'o')
    );
    private static Map<String, Character> inbook = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("chapter", 'o'), entry("edition", 'o'), entry("editor", '+'), entry("month", 'o'),entry("note", 'o'),entry("number", 'o'), entry("pages", '+'), entry("publisher", '+'), entry("series", 'o'), entry("title", '+'), entry("type", 'o'), entry("volume", 'o'), entry("year", '+')
    );
    private static Map<String, Character> incollection = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("booktitle", '+'), entry("chapter", 'o'), entry("edition", 'o'), entry("editor", 'o'), entry("month", 'o'),entry("note", 'o'),entry("number", 'o'), entry("pages", 'o'), entry("publisher", '+'), entry("series", 'o'), entry("title", '+'), entry("type", 'o'), entry("volume", 'o'), entry("year", '+')
    );
    private static Map<String, Character> inproceedings = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("booktitle", '+'), entry("chapter", 'o'), entry("editor", 'o'), entry("month", 'o'),entry("note", 'o'), entry("number", 'o'), entry("organization", 'o'),  entry("pages", 'o'), entry("publisher", 'o'), entry("series", 'o'), entry("title", '+'), entry("volume", 'o'), entry("year", '+')
    );
    private static Map<String, Character> manual = Map.ofEntries(
            entry("address", 'o'), entry("author", 'o'), entry("edition", 'o'), entry("month", 'o'),entry("note", 'o'), entry("organization", 'o'),  entry("title", '+'), entry("pages", 'o'), entry("publisher", 'o'), entry("year", '+')    );

    private static Map<String, Character> mastersthesis = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("month", 'o'),entry("note", 'o'), entry("school", '+'),  entry("title", '+'), entry("type", 'o'), entry("year", '+')    );

    private static Map<String, Character> misc = Map.ofEntries(
            entry("author", 'o'), entry("howpublished", '+'), entry("month", 'o'), entry("note", 'o'), entry("number", 'o'), entry("title", 'o'), entry("year", 'o')
    );
    private static Map<String, Character> proceedings = Map.ofEntries(
            entry("address", 'o'), entry("author", '+'), entry("month", 'o'), entry("note", 'o'), entry("number", 'o'), entry("organization", 'o'), entry("publisher", 'o'), entry("series", 'o'), entry("title", '+'), entry("volume", 'o'), entry("year", '+')    );

    private static Map<String, Character> techreport = Map.ofEntries(
            entry("address", 'o'), entry("editor", 'o'), entry("institution", '+'), entry("month", 'o'), entry("note", 'o'), entry("number", 'o'), entry("title", '+'), entry("type", 'o'), entry("year", '+')
    );
    private static Map<String, Character> unpublished = Map.ofEntries(
            entry("author", '+'), entry("month", 'o'), entry("note", '+'), entry("title", '+'), entry("year", 'o')
    );

    public static Map<String, Map<String, Character>> type = Map.ofEntries(
            entry("article", article),
            entry("book", book),
            entry("booklet", booklet),
            entry("inbook", inbook),
            entry("incollection", incollection),
            entry("inproceedings???conference", inproceedings),
            entry("manual", manual),
            entry("mastersthesis, phdthesis", mastersthesis),
            entry("misc", misc),
            entry("proceedings", proceedings),
            entry("tech report", techreport),
            entry("unpublished", unpublished)
    );

    /*CATEGORIES OF PUBLICATIONS*/
    public static Map<String, String> category = Map.ofEntries(
            entry("AAA", "Vedeck?? monografie vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("AAB", "Vedeck?? monografie vydan?? v dom??cich vydavate??stv??ch"),
            entry("ABA", "??t??die charakteru vedeckej monografie v ??asopisoch a zborn??koch vydan?? v\n" +
                    "zahrani??n??ch vydavate??stv??ch"),
            entry("ABB", "??t??die charakteru vedeckej monografie v ??asopisoch a zborn??koch vydan?? v\n" +
                    "dom??cich vydavate??stv??ch"),
            entry("ABC", "Kapitoly vo vedeck??ch monografi??ch vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("ABD", "Kapitoly vo vedeck??ch monografi??ch vydan?? v dom??cich vydavate??stv??ch"),
            entry("ACA", "Vysoko??kolsk?? u??ebnice vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("ACB", "Vysoko??kolsk?? u??ebnice vydan?? v dom??cich vydavate??stv??ch"),
            entry("ACC", "Kapitoly vo vysoko??kolsk??ch u??ebniciach vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("ACD", "Kapitoly vo vysoko??kolsk??ch u??ebniciach vydan?? v dom??cich vydavate??stv??ch"),
            entry("ADC", "Vedeck?? pr??ce v zahrani??n??ch karentovan??ch ??asopisoch"),
            entry("ADD", "Vedeck?? pr??ce v dom??cich karentovan??ch ??asopisoch"),
            entry("ADE", "Vedeck?? pr??ce v ostatn??ch zahrani??n??ch ??asopisoch"),
            entry("ADF", "Vedeck?? pr??ce v ostatn??ch dom??cich ??asopisoch"),
            entry("ADM", "Vedeck?? pr??ce v zahrani??n??ch ??asopisoch registrovan??ch v datab??zach Web of\n" +
                    "Science alebo SCOPUS"),
            entry("ADN", "Vedeck?? pr??ce v dom??cich ??asopisoch registrovan??ch v datab??zach Web of Science\n" +
                    "alebo SCOPUS"),
            entry("AEC", "Vedeck?? pr??ce v zahrani??n??ch recenzovan??ch vedeck??ch zborn??koch, monografi??ch"),
            entry("AED", "Vedeck?? pr??ce v dom??cich recenzovan??ch vedeck??ch zborn??koch, monografi??ch"),
            entry("AEG", "Abstrakty vedeck??ch pr??c v zahrani??n??ch karentovan??ch ??asopisoch"),
            entry("AEH", "Abstrakty vedeck??ch pr??c v dom??cich karentovan??ch ??asopisoch"),
            entry("AEM", "Abstrakty vedeck??ch pr??c v zahrani??n??ch ??asopisoch registrovan??ch v datab??zach\n" +
                    "Web of Science alebo SCOPUS"),
            entry("AEN", "Abstrakty vedeck??ch pr??c v dom??cich ??asopisoch registrovan??ch v datab??zach Web\n" +
                    "of Science alebo SCOPUS"),
            entry("AFA", "Publikovan?? pozvan?? pr??spevky na zahrani??n??ch vedeck??ch konferenci??ch"),
            entry("AFB", "Publikovan?? pozvan?? pr??spevky na dom??cich vedeck??ch konferenci??ch"),
            entry("AFC", "Publikovan?? pr??spevky na zahrani??n??ch vedeck??ch konferenci??ch"),
            entry("AFD", "Publikovan?? pr??spevky na dom??cich vedeck??ch konferenci??ch"),
            entry("AFE", "Abstrakty pozvan??ch pr??spevkov zo zahrani??n??ch vedeck??ch konferenci??"),
            entry("AFF", "Abstrakty pozvan??ch pr??spevkov z dom??cich vedeck??ch konferenci??"),
            entry("AFG", "Abstrakty pr??spevkov zo zahrani??n??ch vedeck??ch konferenci??"),
            entry("AFH", "Abstrakty pr??spevkov z dom??cich vedeck??ch konferenci??"),
            entry("AFK", "Postery zo zahrani??n??ch konferenci??"),
            entry("AFL", "Postery z dom??cich konferenci??"),
            entry("AGI", "Spr??vy o vyrie??en??ch vedeckov??skumn??ch ??loh??ch"),
            entry("AGJ", "Prihl????ky patentov, prihl????ky ????itkov??ch vzorov, prihl????ky dizajnov, prihl????ky\n" +
                    "ochrann??ch zn??mok, prihl????ky dodatkov??ch ochrann??ch osved??en??, prihl????ky\n" +
                    "topografi?? polovodi??ov??ch v??robkov, prihl????ky ozna??en?? p??vodu v??robkov, prihl????ky\n" +
                    "zemepisn??ch ozna??en?? v??robkov, prihl????ky na udelenie ????achtite??sk??ch osved??en?? "),
            entry("BAA", "Odborn?? kni??n?? publik??cie vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("BAB", "Odborn?? kni??n?? publik??cie vydan?? v dom??cich vydavate??stv??ch"),
            entry("BBA", "Kapitoly v odborn??ch kni??n??ch publik??ci??ch vydan?? v zahrani??n??ch\n" +
                    "vydavate??stv??ch"),
            entry("BBB", "Kapitoly v odborn??ch kni??n??ch publik??ci??ch vydan?? v dom??cich vydavate??stv??ch"),
            entry("BCB", "U??ebnice pre stredn?? a z??kladn?? ??koly"),
            entry("BCI", "Skript?? a u??ebn?? texty"),
            entry("BCK", "BCK Kapitoly v u??ebniciach a v u??ebn??ch textoch"),
            entry("BDA", "Hesl?? v odborn??ch terminologick??ch slovn??koch a encyklop??di??ch vydan??ch v\n" +
                    "zahrani??n??ch vydavate??stv??ch"),
            entry("BDB", "Hesl?? v odborn??ch terminologick??ch slovn??koch a encyklop??di??ch vydan??ch v\n" +
                    "dom??cich vydavate??stv??ch"),
            entry("BDC", "Odborn?? pr??ce v zahrani??n??ch karentovan??ch ??asopisoch"),
            entry("BDD", "Odborn?? pr??ce v dom??cich karentovan??ch ??asopisoch"),
            entry("BDE", "Odborn?? pr??ce v ostatn??ch zahrani??n??ch ??asopisoch"),
            entry("BDF", "Odborn?? pr??ce v ostatn??ch dom??cich ??asopisoch"),
            entry("BDM", "Odborn?? pr??ce v zahrani??n??ch ??asopisoch registrovan??ch v datab??zach Web of\n" +
                    "Science alebo SCOPUS"),
            entry("BDN", "Odborn?? pr??ce v dom??cich ??asopisoch registrovan??ch v datab??zach Web of Science\n" +
                    "alebo SCOPUS"),
            entry("BEE", "Odborn?? pr??ce v zahrani??n??ch zborn??koch (konferen??n??ch aj nekonferen??n??ch)"),
            entry("BEF", "Odborn?? pr??ce v dom??cich zborn??koch (konferen??n??ch aj nekonferen??n??ch)"),
            entry("BFA", "Abstrakty odborn??ch pr??c zo zahrani??n??ch podujat?? (konferencie,...)"),
            entry("BFB", "Abstrakty odborn??ch pr??c z dom??cich podujat?? (konferencie,...)"),
            entry("BGG", "Normy"),
            entry("CAA", "Umeleck?? monografie, dramatick?? diela, scen??re, umeleck?? preklady publik??ci??,\n" +
                    "autorsk?? katal??gy vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("CAB", "Umeleck?? monografie, dramatick?? diela, scen??re, umeleck?? preklady publik??ci??,\n" +
                    "autorsk?? katal??gy vydan?? v dom??cich vydavate??stv??ch"),
            entry("CBA", "Kapitoly v umeleck??ch monografi??ch, kapitoly umeleck??ch prekladov publik??ci??,\n" +
                    "vydan??ch v zahrani??n??ch vydavate??stv??ch"),
            entry("CBB", "Kapitoly v umeleck??ch monografi??ch, kapitoly umeleck??ch prekladov publik??ci??,\n" +
                    "vydan??ch v dom??cich vydavate??stv??ch"),
            entry("CAI", "Hudobn?? diela (partit??ry, notov?? materi??ly) vydan?? v zahrani??n??ch vydavate??stv??ch"),
            entry("CAJ", "Hudobn?? diela (partit??ry, notov?? materi??ly) vydan?? v dom??cich vydavate??stv??ch"),
            entry("CDC", "Umeleck?? pr??ce a preklady v zahrani??n??ch karentovan??ch ??asopisoch"),
            entry("CDD", "Umeleck?? pr??ce a preklady v dom??cich karentovan??ch ??asopisoch"),
            entry("CDE", "Umeleck?? pr??ce a preklady v zahrani??n??ch nekarentovan??ch ??asopisoch"),
            entry("CDF", "Umeleck?? pr??ce a preklady v dom??cich nekarentovan??ch ??asopisoch"),
            entry("CEC", "Umeleck?? pr??ce, dramatick?? diela, scen??re a preklady v zborn??koch, kni??n??ch\n" +
                    "publik??ci??ch a skupinov??ch katal??goch vydan??ch v zahrani??n??ch vydavate??stv??ch"),
            entry("CED", "Umeleck?? pr??ce, dramatick?? diela, scen??re a preklady v zborn??koch, kni??n??ch\n" +
                    "publik??ci??ch a skupinov??ch katal??goch vydan??ch v dom??cich vydavate??stv??ch"),
            entry("CGC", "Umeleck?? a architektonick?? ??t??die a projekty - v zahrani????"),
            entry("CGD", "Umeleck?? a architektonick?? ??t??die a projekty - doma"),
            entry("CIA", "Sklada??ka k v??stave (menej ako 8 s.) vydan?? v zahrani????"),
            entry("CIB", "Sklada??ka k v??stave (menej ako 8 s.) vydan?? doma"),
            entry("CJA", "Katal??g k v??stave (viac ako 8 s. a menej ako 1 AH) vydan?? v zahrani????"),
            entry("CJB", "Katal??g k v??stave (viac ako 8 s. a menej ako 1 AH) vydan?? doma"),
            entry("CKA", "Katal??g k v??stave (viac ako 1 AH) vydan?? v zahrani????"),
            entry("CKB", "Katal??g k v??stave (viac ako 1 AH) vydan?? doma"),
            entry("DAI", "Dizerta??n?? a habilita??n?? pr??ce "),
            entry("EAI", "Preh??adov?? pr??ce"),
            entry("EAJ", "Odborn?? preklady publik??ci?? "),
            entry("EDI", "Recenzie v ??asopisoch a zborn??koch"),
            entry("EDJ", "Preh??adov?? pr??ce, odborn?? pr??ce, preklady noriem; odborn?? preklady v ??asopisoch,\n" +
                    "zborn??koch"),
            entry("FAI", "Redak??n?? a zostavovate??sk?? pr??ce kni??n??ho charakteru (bibliografie, encyklop??die,\n" +
                    "katal??gy, slovn??ky, zborn??ky, atlasy,...)"),
            entry("GAI", "Spr??vy"),
            entry("GHG", "Pr??ce zverejnen?? sp??sobom umo????uj??cim hromadn?? pr??stup"),
            entry("GII", "R??zne publik??cie a dokumenty, ktor?? nemo??no zaradi?? do ??iadnej z\n" +
                    "predch??dzaj??cich kateg??ri??")
    );

}

