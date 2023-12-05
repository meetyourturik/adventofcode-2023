package com.turik.adventofcode.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5Part1 {

    static List<Almanac> parseMap(List<long[]> maps) {
        List<Almanac> res = new ArrayList<>();
        for (long[] map: maps) {
            res.add(new Almanac(map[1], map[0], map[2]));
        }
        return res;
    }

    static long getNext(List<Almanac> almanacs, long source) {
        for (Almanac almanac: almanacs) {
            if (almanac.fits(source)) {
                return almanac.getDestN(source);
            }
        }
        return source;
    }

    public static void main(String[] args) {
        long[] seeds = new long[]{4239267129L, 20461805L, 2775736218L, 52390530L, 3109225152L, 741325372L, 1633502651L, 46906638L, 967445712L, 47092469L, 2354891449L, 237152885L, 2169258488L, 111184803L, 2614747853L, 123738802L, 620098496L, 291114156L, 2072253071L, 28111202L};

        List<long[]> seedToSoilMap = List.of(
            new long[]{803774611L, 641364296L, 1132421037L},
            new long[]{248421506L, 1797371961L, 494535345L},
            new long[]{1936195648L, 2752993203L, 133687519L},
            new long[]{2069883167L, 2294485405L, 458507798L},
            new long[]{2804145277L, 283074539L, 358289757L},
            new long[]{3162435034L, 2886680722L, 1132532262L},
            new long[]{2528390965L, 4019212984L, 275754312L},
            new long[]{766543479L, 248421506L, 34653033L},
            new long[]{742956851L, 1773785333L, 23586628L},
            new long[]{801196512L, 2291907306L, 2578099L}
        );

        List<long[]> soilToFertMap = List.of(
            new long[]{2497067833L, 718912393L, 1047592994L},
            new long[]{3544660827L, 4222700866L, 72266430L},
            new long[]{770426288L, 3365742958L, 209338740L},
            new long[]{3698421476L, 2775964622L, 508284117L},
            new long[]{1441878450L, 1818019282L, 725791090L},
            new long[]{417593992L, 265113557L, 15217985L},
            new long[]{979765028L, 3760587444L, 462113422L},
            new long[]{2167669540L, 2543810372L, 143892547L},
            new long[]{3616927257L, 3284248739L, 81494219L},
            new long[]{4206705593L, 2687702919L, 88261703L},
            new long[]{2380194851L, 3575081698L, 116872982L},
            new long[]{0L, 280331542L, 15942291L},
            new long[]{718912393L, 1766505387L, 51513895L},
            new long[]{152480435L, 0L, 265113557L},
            new long[]{2311562087L, 3691954680L, 68632764L},
            new long[]{15942291L, 296273833L, 136538144L}
        );

        List<long[]> fertToWaterMap = List.of(
            new long[]{0L, 402310798L, 253353164L},
            new long[]{778924681L, 2773042028L, 194127973L},
            new long[]{2853824225L, 2967170001L, 585461563L},
            new long[]{3827117536L, 3909653920L, 385313376L},
            new long[]{4259877071L, 3552631564L, 35090225L},
            new long[]{973052654L, 3635167948L, 222704323L},
            new long[]{253353164L, 0L, 389964349L},
            new long[]{2230088185L, 778924681L, 571954391L},
            new long[]{1195756977L, 1490392659L, 342200935L},
            new long[]{2802042576L, 3857872271L, 51781649L},
            new long[]{643317513L, 389964349L, 12346449L},
            new long[]{4212430912L, 3587721789L, 47446159L},
            new long[]{3439285788L, 2385210280L, 387831748L},
            new long[]{1677471499L, 1832593594L, 552616686L},
            new long[]{1537957912L, 1350879072L, 139513587L}
        );

        List<long[]> waterToLightMap = List.of(
            new long[]{1548505089L, 767179152L, 4433418L},
            new long[]{3833169479L, 2956286720L, 133538400L},
            new long[]{2966709060L, 3309731935L, 102304094L},
            new long[]{1552938507L, 844050660L, 203612289L},
            new long[]{4257043426L, 3089825120L, 37923870L},
            new long[]{2862957901L, 3567999512L, 28008008L},
            new long[]{127112704L, 319767838L, 4466599L},
            new long[]{840317941L, 174506417L, 34039792L},
            new long[]{2890965909L, 3596007520L, 40520529L},
            new long[]{15787022L, 2007458428L, 111325682L},
            new long[]{2398090681L, 21771313L, 152735104L},
            new long[]{1094590916L, 1294380254L, 4387553L},
            new long[]{517844904L, 840169267L, 3881393L},
            new long[]{2556445662L, 1535118242L, 8735340L},
            new long[]{1266005567L, 2376897884L, 172496096L},
            new long[]{874357733L, 1314885059L, 220233183L},
            new long[]{3696946976L, 2820064217L, 136222503L},
            new long[]{2271345339L, 208546209L, 111221629L},
            new long[]{703336145L, 477538609L, 136981796L},
            new long[]{389299157L, 1710880680L, 59057725L},
            new long[]{4183266377L, 2766992510L, 22982117L},
            new long[]{521726297L, 324234437L, 53105792L},
            new long[]{1438501663L, 1881931289L, 110003426L},
            new long[]{131579303L, 1298767807L, 16117252L},
            new long[]{2102535156L, 614520405L, 152658747L},
            new long[]{0L, 2549393980L, 15787022L},
            new long[]{1098978469L, 1543853582L, 167027098L},
            new long[]{3966707879L, 2789974627L, 30089590L},
            new long[]{2255193903L, 0L, 16151436L},
            new long[]{1756550796L, 377340229L, 100198380L},
            new long[]{574832089L, 2360386712L, 16511172L},
            new long[]{2382566968L, 1991934715L, 15523713L},
            new long[]{3069013154L, 3636528049L, 627933822L},
            new long[]{2766992510L, 3178543922L, 79332992L},
            new long[]{2931486438L, 3274509313L, 35222622L},
            new long[]{3996797469L, 4264461871L, 30505425L},
            new long[]{2846325502L, 3257876914L, 16632399L},
            new long[]{2033978459L, 771612570L, 68556697L},
            new long[]{4206248494L, 3127748990L, 50794932L},
            new long[]{2550825785L, 16151436L, 5619877L},
            new long[]{591343261L, 1769938405L, 111992884L},
            new long[]{448356882L, 1047662949L, 69488022L},
            new long[]{4027302894L, 3412036029L, 155963483L},
            new long[]{147696555L, 2118784110L, 241602602L},
            new long[]{1856749176L, 1117150971L, 177229283L}
        );

        List<long[]> lightToTempMap = List.of(
            new long[]{2549521624L, 1806050718L, 400234502L},
            new long[]{1279003707L, 1469066403L, 336984315L},
            new long[]{2063720323L, 2518736018L, 367281175L},
            new long[]{4240496851L, 236622733L, 54470445L},
            new long[]{3737038415L, 1201359870L, 20798035L},
            new long[]{1170741345L, 1222157905L, 108262362L},
            new long[]{1925074187L, 1330420267L, 138646136L},
            new long[]{3757836450L, 291093178L, 323945285L},
            new long[]{3424587617L, 2206285220L, 312450798L},
            new long[]{236622733L, 2886017193L, 934118612L},
            new long[]{4138496410L, 1042644754L, 102000441L},
            new long[]{4081781735L, 1144645195L, 56714675L},
            new long[]{2431001498L, 615038463L, 118520126L},
            new long[]{1615988022L, 733558589L, 309086165L},
            new long[]{2949756126L, 3820135805L, 474831491L}
        );

        List<long[]> tempToHumMap = List.of(
            new long[]{725888341L, 86282489L, 843183510L},
            new long[]{3782717746L, 1630698708L, 99613080L},
            new long[]{2529768467L, 2786969418L, 347392693L},
            new long[]{2195908552L, 2059541517L, 89214959L},
            new long[]{3062107482L, 2168182310L, 90554707L},
            new long[]{1730470902L, 3134362111L, 465437650L},
            new long[]{2964061476L, 2688923412L, 98046006L},
            new long[]{2285123511L, 2358509211L, 13167510L},
            new long[]{2877161160L, 3875960109L, 61807956L},
            new long[]{0L, 929465999L, 639605852L},
            new long[]{3484769060L, 2148756476L, 19425834L},
            new long[]{2298291021L, 1730311788L, 170053852L},
            new long[]{639605852L, 0L, 86282489L},
            new long[]{3504194894L, 2371676721L, 119346975L},
            new long[]{4275382932L, 3599799761L, 19584364L},
            new long[]{2468344873L, 2491023696L, 61423594L},
            new long[]{3623541869L, 1900365640L, 159175877L},
            new long[]{4138906810L, 2552447290L, 136476122L},
            new long[]{3918976473L, 3656029772L, 219930337L},
            new long[]{2938969116L, 4269874936L, 25092360L},
            new long[]{3882330826L, 3619384125L, 36645647L},
            new long[]{3152662189L, 3937768065L, 332106871L},
            new long[]{1630698708L, 2258737017L, 99772194L}
        );

        List<long[]> humToLocMap = List.of(
            new long[]{1426868383L, 2786540732L, 64165562L},
            new long[]{1639911414L, 2027746720L, 730664673L},
            new long[]{857589555L, 0L, 114197007L},
            new long[]{2370576087L, 1887556908L, 140189812L},
            new long[]{3396523523L, 1265337150L, 488817864L},
            new long[]{1491033945L, 2850706294L, 148877469L},
            new long[]{3885341387L, 2999583763L, 409625909L},
            new long[]{0L, 114197007L, 857589555L},
            new long[]{1293466489L, 1754155014L, 133401894L},
            new long[]{2510765899L, 3409209672L, 885757624L},
            new long[]{1265337150L, 2758411393L, 28129339L}
        );

        List<List<long[]>> maps = List.of(
                seedToSoilMap,
                soilToFertMap,
                fertToWaterMap,
                waterToLightMap,
                lightToTempMap,
                tempToHumMap,
                humToLocMap
        );

        List<List<Almanac>> almanacs = new ArrayList<>();

        for (List<long[]> map: maps) {
            almanacs.add(parseMap(map));
        }

        for (int i = 0; i < seeds.length; i++) {
            for (List<Almanac> almanac: almanacs) {
                seeds[i] = getNext(almanac, seeds[i]);
            }
        }

        System.out.println(Arrays.toString(seeds));
        long min = Long.MAX_VALUE;
        for (long s: seeds) {
            min = Math.min(s, min);
        }
        System.out.println(min);
    }
}
