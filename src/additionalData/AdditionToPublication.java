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
            entry("inproceedings≈conference", inproceedings),
            entry("manual", manual),
            entry("mastersthesis, phdthesis", mastersthesis),
            entry("misc", misc),
            entry("proceedings", proceedings),
            entry("tech report", techreport),
            entry("unpublished", unpublished)
    );

    /*CATEGORIES OF PUBLICATIONS*/
    public static Map<String, String> category = Map.ofEntries(
            entry("AAA", "Vedecké monografie vydané v zahraničných vydavateľstvách"),
            entry("AAB", "Vedecké monografie vydané v domácich vydavateľstvách"),
            entry("ABA", "Štúdie charakteru vedeckej monografie v časopisoch a zborníkoch vydané v\n" +
                    "zahraničných vydavateľstvách"),
            entry("ABB", "Štúdie charakteru vedeckej monografie v časopisoch a zborníkoch vydané v\n" +
                    "domácich vydavateľstvách"),
            entry("ABC", "Kapitoly vo vedeckých monografiách vydané v zahraničných vydavateľstvách"),
            entry("ABD", "Kapitoly vo vedeckých monografiách vydané v domácich vydavateľstvách"),
            entry("ACA", "Vysokoškolské učebnice vydané v zahraničných vydavateľstvách"),
            entry("ACB", "Vysokoškolské učebnice vydané v domácich vydavateľstvách"),
            entry("ACC", "Kapitoly vo vysokoškolských učebniciach vydané v zahraničných vydavateľstvách"),
            entry("ACD", "Kapitoly vo vysokoškolských učebniciach vydané v domácich vydavateľstvách"),
            entry("ADC", "Vedecké práce v zahraničných karentovaných časopisoch"),
            entry("ADD", "Vedecké práce v domácich karentovaných časopisoch"),
            entry("ADE", "Vedecké práce v ostatných zahraničných časopisoch"),
            entry("ADF", "Vedecké práce v ostatných domácich časopisoch"),
            entry("ADM", "Vedecké práce v zahraničných časopisoch registrovaných v databázach Web of\n" +
                    "Science alebo SCOPUS"),
            entry("ADN", "Vedecké práce v domácich časopisoch registrovaných v databázach Web of Science\n" +
                    "alebo SCOPUS"),
            entry("AEC", "Vedecké práce v zahraničných recenzovaných vedeckých zborníkoch, monografiách"),
            entry("AED", "Vedecké práce v domácich recenzovaných vedeckých zborníkoch, monografiách"),
            entry("AEG", "Abstrakty vedeckých prác v zahraničných karentovaných časopisoch"),
            entry("AEH", "Abstrakty vedeckých prác v domácich karentovaných časopisoch"),
            entry("AEM", "Abstrakty vedeckých prác v zahraničných časopisoch registrovaných v databázach\n" +
                    "Web of Science alebo SCOPUS"),
            entry("AEN", "Abstrakty vedeckých prác v domácich časopisoch registrovaných v databázach Web\n" +
                    "of Science alebo SCOPUS"),
            entry("AFA", "Publikované pozvané príspevky na zahraničných vedeckých konferenciách"),
            entry("AFB", "Publikované pozvané príspevky na domácich vedeckých konferenciách"),
            entry("AFC", "Publikované príspevky na zahraničných vedeckých konferenciách"),
            entry("AFD", "Publikované príspevky na domácich vedeckých konferenciách"),
            entry("AFE", "Abstrakty pozvaných príspevkov zo zahraničných vedeckých konferencií"),
            entry("AFF", "Abstrakty pozvaných príspevkov z domácich vedeckých konferencií"),
            entry("AFG", "Abstrakty príspevkov zo zahraničných vedeckých konferencií"),
            entry("AFH", "Abstrakty príspevkov z domácich vedeckých konferencií"),
            entry("AFK", "Postery zo zahraničných konferencií"),
            entry("AFL", "Postery z domácich konferencií"),
            entry("AGI", "Správy o vyriešených vedeckovýskumných úlohách"),
            entry("AGJ", "Prihlášky patentov, prihlášky úžitkových vzorov, prihlášky dizajnov, prihlášky\n" +
                    "ochranných známok, prihlášky dodatkových ochranných osvedčení, prihlášky\n" +
                    "topografií polovodičových výrobkov, prihlášky označení pôvodu výrobkov, prihlášky\n" +
                    "zemepisných označení výrobkov, prihlášky na udelenie šľachtiteľských osvedčení "),
            entry("BAA", "Odborné knižné publikácie vydané v zahraničných vydavateľstvách"),
            entry("BAB", "Odborné knižné publikácie vydané v domácich vydavateľstvách"),
            entry("BBA", "Kapitoly v odborných knižných publikáciách vydané v zahraničných\n" +
                    "vydavateľstvách"),
            entry("BBB", "Kapitoly v odborných knižných publikáciách vydané v domácich vydavateľstvách"),
            entry("BCB", "Učebnice pre stredné a základné školy"),
            entry("BCI", "Skriptá a učebné texty"),
            entry("BCK", "BCK Kapitoly v učebniciach a v učebných textoch"),
            entry("BDA", "Heslá v odborných terminologických slovníkoch a encyklopédiách vydaných v\n" +
                    "zahraničných vydavateľstvách"),
            entry("BDB", "Heslá v odborných terminologických slovníkoch a encyklopédiách vydaných v\n" +
                    "domácich vydavateľstvách"),
            entry("BDC", "Odborné práce v zahraničných karentovaných časopisoch"),
            entry("BDD", "Odborné práce v domácich karentovaných časopisoch"),
            entry("BDE", "Odborné práce v ostatných zahraničných časopisoch"),
            entry("BDF", "Odborné práce v ostatných domácich časopisoch"),
            entry("BDM", "Odborné práce v zahraničných časopisoch registrovaných v databázach Web of\n" +
                    "Science alebo SCOPUS"),
            entry("BDN", "Odborné práce v domácich časopisoch registrovaných v databázach Web of Science\n" +
                    "alebo SCOPUS"),
            entry("BEE", "Odborné práce v zahraničných zborníkoch (konferenčných aj nekonferenčných)"),
            entry("BEF", "Odborné práce v domácich zborníkoch (konferenčných aj nekonferenčných)"),
            entry("BFA", "Abstrakty odborných prác zo zahraničných podujatí (konferencie,...)"),
            entry("BFB", "Abstrakty odborných prác z domácich podujatí (konferencie,...)"),
            entry("BGG", "Normy"),
            entry("CAA", "Umelecké monografie, dramatické diela, scenáre, umelecké preklady publikácií,\n" +
                    "autorské katalógy vydané v zahraničných vydavateľstvách"),
            entry("CAB", "Umelecké monografie, dramatické diela, scenáre, umelecké preklady publikácií,\n" +
                    "autorské katalógy vydané v domácich vydavateľstvách"),
            entry("CBA", "Kapitoly v umeleckých monografiách, kapitoly umeleckých prekladov publikácií,\n" +
                    "vydaných v zahraničných vydavateľstvách"),
            entry("CBB", "Kapitoly v umeleckých monografiách, kapitoly umeleckých prekladov publikácií,\n" +
                    "vydaných v domácich vydavateľstvách"),
            entry("CAI", "Hudobné diela (partitúry, notové materiály) vydané v zahraničných vydavateľstvách"),
            entry("CAJ", "Hudobné diela (partitúry, notové materiály) vydané v domácich vydavateľstvách"),
            entry("CDC", "Umelecké práce a preklady v zahraničných karentovaných časopisoch"),
            entry("CDD", "Umelecké práce a preklady v domácich karentovaných časopisoch"),
            entry("CDE", "Umelecké práce a preklady v zahraničných nekarentovaných časopisoch"),
            entry("CDF", "Umelecké práce a preklady v domácich nekarentovaných časopisoch"),
            entry("CEC", "Umelecké práce, dramatické diela, scenáre a preklady v zborníkoch, knižných\n" +
                    "publikáciách a skupinových katalógoch vydaných v zahraničných vydavateľstvách"),
            entry("CED", "Umelecké práce, dramatické diela, scenáre a preklady v zborníkoch, knižných\n" +
                    "publikáciách a skupinových katalógoch vydaných v domácich vydavateľstvách"),
            entry("CGC", "Umelecké a architektonické štúdie a projekty - v zahraničí"),
            entry("CGD", "Umelecké a architektonické štúdie a projekty - doma"),
            entry("CIA", "Skladačka k výstave (menej ako 8 s.) vydaná v zahraničí"),
            entry("CIB", "Skladačka k výstave (menej ako 8 s.) vydaná doma"),
            entry("CJA", "Katalóg k výstave (viac ako 8 s. a menej ako 1 AH) vydaný v zahraničí"),
            entry("CJB", "Katalóg k výstave (viac ako 8 s. a menej ako 1 AH) vydaný doma"),
            entry("CKA", "Katalóg k výstave (viac ako 1 AH) vydaný v zahraničí"),
            entry("CKB", "Katalóg k výstave (viac ako 1 AH) vydaný doma"),
            entry("DAI", "Dizertačné a habilitačné práce "),
            entry("EAI", "Prehľadové práce"),
            entry("EAJ", "Odborné preklady publikácií "),
            entry("EDI", "Recenzie v časopisoch a zborníkoch"),
            entry("EDJ", "Prehľadové práce, odborné práce, preklady noriem; odborné preklady v časopisoch,\n" +
                    "zborníkoch"),
            entry("FAI", "Redakčné a zostavovateľské práce knižného charakteru (bibliografie, encyklopédie,\n" +
                    "katalógy, slovníky, zborníky, atlasy,...)"),
            entry("GAI", "Správy"),
            entry("GHG", "Práce zverejnené spôsobom umožňujúcim hromadný prístup"),
            entry("GII", "Rôzne publikácie a dokumenty, ktoré nemožno zaradiť do žiadnej z\n" +
                    "predchádzajúcich kategórií")
    );

}

