package traing.prob336;

import java.util.*;

/**
 * Palindrome Pairs
 * Link: https://leetcode.com/problems/palindrome-pairs/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/3/17
 */
public class Solution {
    private Node root = new Node();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) buildTrie(words[i], i);

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Node node = this.root;
            int ind = 0;
            boolean b = false;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (node.nodes[c] != null) node = node.nodes[c];
                else {
                    b = true;
                    break;
                }
                ind++;
            }
            if (!b) {
                Deque<Node> queue = new ArrayDeque<>();
                queue.offer(node);
                while (!queue.isEmpty()) {
                    Node n = queue.poll();
                    if (n.word != null) {
                        if (n.ind != i && isPalindrome(n.word, ind, n.word.length() - 1)) res.add(Arrays.asList(i, n.ind));
                    }
                    for (Node next : n.nodes) if (next != null) queue.offer(next);
                }
            }
        }
        return res;
    }
    private void buildTrie(String word, int ind) {
        Node node = this.root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (node.nodes[c] == null) node.nodes[c] = new Node();
            node = node.nodes[c];
        }
        node.word = new StringBuilder(word).reverse().toString();
        node.ind = ind;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) if (s.charAt(start++) != s.charAt(end--)) return false;
        return true;
    }

    class Node {
        Node[] nodes = new Node[256];
        String word = null;
        int ind = 0;

        public Node() {
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

//        System.out.println(s.palindromePairs("bat,tab,cat".split(",")));
        System.out.println(s.palindromePairs("abcd,dcba,lls,s,sssll".split(",")));
//        System.out.println(s.palindromePairs(new String[]{"ib", "cjcehd", "dfjcahcehhdf", "gh", "ideabce",
//                "accfcdhjfhebigh", "cbjchaeiiciefceg", "hg", "abj", "dddcdjbefdeceedafhfi", "jbgdi", "aejbjiedecggdbbd",
//                "aejgcaabafbfiafi", "a", "fdb", "fhbgcdjechabhg", "bcdbajbdehibahecig", "jfhadahhhaagjaaf",
//                "bagdeccgddaja", "gchaaf", "bgbbd", "jjcgciihhfeageaadid", "gdbedgc", "ehbjfhgigdbiabgddhig",
//                "hjgdeiccfbgieb", "cehhifiba", "hdjjgjdbaeeedcgcdbf", "fafejeiga", "ecdcfaedjhcced", "cghbibcagcijdhe",
//                "egbbehafiechcb", "be", "ji", "geagddiccjeh", "fjfc", "dfhcgccccfbfbgdhejfe", "jjcahegcicjgdbce",
//                "dfabhjjghjgddiaie", "fijbcj", "hbgefd", "idd", "ac", "fjcjafhiiaggjbdica", "ahidjficci", "fefcdjiahcb",
//                "ijfaeajaeg", "adjbfcee", "ghcdfihifffdhehgje", "fcf", "jiaa", "jbacghaghecdhfejfhe", "chdbbjcfafa",
//                "badaiaeaabhhd", "gefhhbihddg", "haccghbagfddebhbheh", "aidc", "hgeedfbggdgcfhbgfc", "idfedagdijf",
//                "idhfiiegebebaebbifbc", "f", "dhhfdeic", "hafhigfeeddgihegdgg", "cjge", "hjaehejbidcddhhfb",
//                "bcjcefceebiegcac", "igjdccccjeibagj", "jafcdigedibbhhdh", "ggchiaed", "cgccbbbai", "ghjajhfjdahebgbbga",
//                "cdfajhj", "gbjbjffia", "hfbciee", "egggidabbae", "bbe", "ccjddfefcahfaf", "acgdbgajgjeeieefh",
//                "ififgbbgigbahdacb", "hhejdchie", "bfjejjaiadgbic", "dfjdabbidcgjc", "iaccbb", "fjdbhhdiifdibjcfj",
//                "efbcaafcihjfj", "j", "fagiiffcfiddai", "fhjgfjebdfdgifeadg", "cgaagcihhjg", "aidacecgcce",
//                "fedfgcfefjjhhdjcbedd", "higf", "dghfacijijchbf", "gbijbdbhbjh", "ehh", "hcecbjbjf", "hfadhifdhdjijgiicdb",
//                "ghfaighbgj", "hjcfbhhihiiidj", "hgbjj", "ae", "hccfb", "icfhcgi", "hdjjfifa", "bdjafhgdjdhfjbde",
//                "fbhjdghhcde", "fdfiefgdibgbhc", "i", "jbfbficceabgbgjg", "agigdbbbeahfahjbg", "ffaiiagdjjgegeb", "c",
//                "ijgjjab", "gehdfjcigfgfig", "ebgjdedidhb", "fgfadjbficcjecga", "hci", "egbhi", "fbga", "dif",
//                "jbgjcbcagjedhgdhca", "e", "ihd", "gfgadggfdfg", "eabdcejeh", "dheajbjfcgdbgiagi", "jbfafcfahdjihhigda",
//                "iececeei", "jhegd", "aeibbadegjidafbdbfca", "jedccabehdgad", "jadfggfcihbie", "chiijbfigiadcb", "ba",
//                "hddcedhiebhdeehhaa", "bhgbjiebfgbdjggbgbcf", "bjb", "abcaccecifdfjcjfiege", "eibhbhcjffdbgja",
//                "iahjhgbfidahjcj", "gahbbgjaicgb", "gaehhiihajgebgcchdj", "hd", "ejfghbigchfg", "ch", "idfajahf",
//                "fheicdaieicgiaiaibe", "hbch", "dhghgdcbbaeghg", "ddaabhji", "eaehbjddgfeaaghg", "bfhaiabcbbffe",
//                "haaffcjadeh", "dbhiajjeidaiefhhd", "gg", "dibdjhbfbbedachji", "ccfajgiciagadca", "cccei", "igdbe",
//                "jjjhj", "gebeci", "fadgbibgjcfbadccad", "dgchfchci", "jeaibcabibgddeg", "edbcgdcjhggaddceg",
//                "hijcdbdhag", "ihhegghdhagccebab", "jdgghfidcbjcdiacg", "ijbcafebi", "hegjbfggebggjhjf", "ahfbgfcd",
//                "ggdiaiaccfg", "egjai", "efffbifdaiecefcjbd", "gaegagjeebbedcdjc", "bhjebfiijbiacba", "iaf",
//                "ffiaccjagficjah", "dhjbdaebbigdbbcbe", "dcfecachejgedcg", "ijbhibdggiefbgfgd", "bdhajigaaeif", "id",
//                "bcbceiceedabgeee", "gfcgcehjddjhhaa", "cdaifiiecbjdacgafheb", "ahdjii", "abefadfjadgcdeaie",
//                "gedfjggbhejagcacafig", "iiebagedbcbhj", "jd", "daficgheabdafbhjb", "cicbiagahhjefiifcach",
//                "aceciciedjd", "fidaajhbj", "dacib", "d", "ajcfjiebbdghaaggj", "fhbgbhbfc", "idafccgi",
//                "ddbfecfcaadfchjidceg", "cdggfbabgfcebfjfiaib", "ceiafjffijcbfeecjfie", "hfbdafdeahhdefddabce",
//                "hcfcbaieagjgecg", "abbfiajehjbcigaaejhb", "gccbieijijeggddi", "bcgajjcbhjhdibeccgf", "ghe", "fj",
//                "diedbbhgjfggd", "ici", "eecbhgc", "aagbjfgiaccacbcdjb", "acgadcfdhaacge", "gfhjbbhhdhcdhcej",
//                "hecdaedhbhffe", "bihfgjffha", "bbbjgbhdefhfde", "ifcjefggjdaefj", "dhajihieeiicjdd",
//                "afgcafbfebbfjjbba", "jddddfccfbbgfefaf", "cicb", "hjfgaedadgbafjeee", "faebfcc", "hdjiaiacjaia",
//                "ajfdhhbjhhh", "haeccchf", "bhi", "ajhbh", "ejfecffajigjjegcae", "fedffhbcbhjji", "dcbcjdgjicg",
//                "bjdcicjgidcifiae", "dfhiedidga", "bdijahc", "aifh", "eebbdg", "hhfb", "ddfigeidhgjiaeheahh",
//                "hdccebbgagijgfed", "efdahcibj", "bajfjej", "hebajecgacacbfgfbi", "hfafabfddgbde", "aadibihfj",
//                "hghaibgghjfgjdcc", "dbdjhgiagbaicbeibh", "jgcgciddfgjhcjiaigd", "ijeacgfehaihcjegadhc", "gieaadbedfg",
//                "gj", "ghbdgbjgjieej", "fbbjd", "fg", "bfjbceehjfbea", "edbaahhhgbbeheb", "cdjagaf",
//                "hcdechddcjjaabhhjb", "fjggcagecffjafijic", "gddhge", "jicefdgejchefhfbfea", "ha", "jhf", "hbagbjiihj",
//                "hh", "ajh", "cgbfgbfhbgfgfcjbjd", "ahheficahajjdcbfc", "cbdjcgfcefcbcaghic", "ccig",
//                "jihcdigdbeefcgdhbj", "hdhgfaafghaadehajcj", "di", "gdidejcaehb", "ejjhfjeejiiaagb",
//                "abifhggfbfhcaecebbf", "bdcfhejdiijah", "bhdfbe", "ijbjhjfgdgacfha", "caegdgcbfibdcdeeifgh", "faadjeic",
//                "iaabgfcdcebibjbhd", "aidcdhegehcebg", "iffbbi", "jhefbefad", "gfi", "fafci", "eifhbdfhdahhgiafage",
//                "bdghehedgcfejbf", "agajfejdjcdeeehidf", "jbhjdcfjfbbchbbhdhb", "hdej", "ig", "fbifcjcdfgdeef", "iec",
//                "ihbjhcfdjdgeb", "effhhedficacbici", "ejac", "geeefccifaf", "ga", "jbfghefdgf", "dfcdgedhiggcgcedbfic",
//                "jcgegibefjihaf", "ddcicabhieegi", "hijeb", "gbcifig", "gbaciadfeahcjghicdae", "ihbgabajhejbcjjb", "bch",
//                "dedgddfdaih", "idcihhdeeahaebha", "efbjchegihijabj", "jbhjdbafbiadidahce", "dafhbbdcibibbhhahe",
//                "djfaebhibegejb", "hfhgcjjdbdjbadhf", "adf", "hdcicbhfechij", "abaajhfai", "cghijaa", "hiiahehjiafjibdg",
//                "ajjaajheiecijh", "ceeb", "fjabbdc", "diehf", "jjbeiajjddebbbgaae", "fhdbghhebjcbfedcdhab",
//                "iaafdifggcagc", "dacihddijeeeibaghjah", "cdcfagaabdgdcc", "jigghbb", "aehfe", "hhcecfacijafigbfij",
//                "deebcfhhaejhic", "ggadgijafe", "hchcijfebffi", "hiib", "jgfbgaffgcjbe", "ieagccjccgfj", "bcbddiijjfd",
//                "iaeed", "cebagdhiifibadibhje", "bj", "bggeegigjcffb", "dcbegfbi", "ijg", "aicdebcdhhigb",
//                "hdjbidahjdeegihjci", "jffjdfedcfiaa", "aggdiechjhhegc", "fibhbifaifihehjf", "daea", "ciccaafehgbhd",
//                "faeejaihicahbbj", "iebaciegbgibfdgdba", "accejcdjgfidiaa", "bhfddfjfgied", "bhhigf", "ijbbaeeg",
//                "fcbfja", "ceffadbefbajadihgd", "hajfcgjha", "jbdcbgeii", "ebeacgdi", "adcccc", "bdjhbbdhg",
//                "chedaacifgdbibac", "afgdhgbgjcgfiafjjfd", "ffcg", "becfedjgaj", "gegaabbccfdfffgbiffb", "dfdchbhd",
//                "igeacjbbfcf", "ccc", "iiefahbcgceghee", "jihjgdcedbd", "icbcacdjefbchgfdg", "iaigcabhfhhigbdcahbc",
//                "jbhaeddb", "cbedce", "gjhjjdjghhbgajccabcg", "ejcff", "fgaachhbbaf", "fcgffffgg", "fdea", "cihafahcbhig",
//                "digbebafccd", "dighcdfcicgeeg", "jeacffedhdjaaff", "fdcibf", "haaidaejdgfigjcaeeha", "hfgegcgejjjgdjjeaj",
//                "bcadifdcfca", "jeh", "abejjdhijbb", "jieieagjejfijafec", "ghceaeb", "ceejd", "bcjjddbfcfageciai", "hdcdj",
//                "hddebdbi", "hecaecijgcicah", "dae", "jdfhhgjfgc", "ggebjf", "gfaijbe", "bibcdibjjf", "chajajfa", "aahdi",
//                "dbgd", "ccic", "difjigfbgec", "agfhecgjdhgef", "hafefegeje", "jdabbdcefghdhibc", "abcjabdjcecjjdb", "feggh",
//                "aigdejdidjj", "jedbfcc", "ibicbfe", "jdehbhbaaejfcb", "fabghhef", "affjcfjjidifjdfgbbgc", "icifcigcbcdiagbgeif",
//                "biicjhbhidee", "ccgacbigjcaj", "ccadfaabjh", "bhicfgfa", "hadgjebaiehiagb", "df", "jdbefi", "dfaciafibecejigig",
//                "fgjdaj", "cgagifjijfdjcheabbf", "igcdedjjjaha", "dig", "gfgdcgibjjgibjjicc", "aehjd", "hihdeadh", "jfjicafaabiegcfa",
//                "bcadfgefbh", "dbdaeh", "af", "afaijhdjfdeghbjihe", "figedggaj", "jdcchdadhifa", "fgddfdeeehebfhde", "efj",
//                "edcgaidb", "h", "hfjfdcjihgbhadefdacf", "beiaabedjadigceejfb", "bceibjdiabfgfjdib", "fhbbbdeghajefeacff",
//                "hjfde", "gbcbegafj", "b", "bhedfiiifcggfaiff", "gciegghhdg", "ieead", "ee", "jafaajafddeifgdeggh", "cgcbh",
//                "fcahcjdcbe", "ehcgcibbf", "jgceecihfdceahhc", "dbahabcdajcbfacb", "aaaj", "ceicab", "ghiea", "jagfaiidhg",
//                "ijefjbachdihidida", "cfhgeeaii", "jbidfhbec", "ahehjajehgj", "eh", "gaijibbibfcgfh", "hgjdcgbhbhcgcghdhd",
//                "jdagecifahaheaj", "cejheaihbajcgdjb", "jecbiiagebegcgabg", "caajbdigciaihabde", "ffdcigijbhjdc", "jbaigdhhibhfbdiejf",
//                "achgebbicjfhjdja", "jebcejeifiacbaefggg", "cihbieigbbidccc", "dgbhbagehfjigeba", "iii", "abce", "fjc",
//                "hgjgdhhajghciegga", "ejaeaa", "bjiej", "jfffhaaejhdii", "ddjh", "hha", "ahfefgbf", "giijdjj",
//                "jadjjgdajbbgg", "eggfei", "bcbjejcecff", "gbdbfbadidehea", "eifbeeefebhbbfebaj", "hfccaddhjgfhhajjfb",
//                "iffhbfad", "ccicdbfcaifefcecjjdf", "jg", "gfjajbcb", "faagjihb", "jjbjdibggeh", "ecbdcabhe",
//                "ggicjebfbcdbiajhhi", "hiejbbdhbgbgafifei", "aeecjebdjdcdejggdabh", "hddcjchcbifad", "bibafbdib",
//                "acchefiacgbebijg", "efjggjjgfffffie", "cbdagecfaebhgbdficd", "gfebceie", "fbjdejdjf",
//                "jbejifcdghhaajhhjbb", "degijf", "eihca", "hihefajifaehefh", "ifegcdgjf", "hgbjhigabdfhhhgib", "eidhja",
//                "iihhbbhbid", "dcijfcgjhicjg", "icjfdigeicgjgjaj", "gicfcccfjgibajji", "agfcc", "geifabacai", "aciifafejdf",
//                "ebji", "ej", "bhidggaiajjcda", "jfhdf", "ggdbggeafahdfdjjibh", "fiicegbijjegghchfhcg", "igfif",
//                "fhjbhdfjdieafh", "ijhgbdgja", "fbaehceajgi", "dbihcdhccjbgcdhhh", "dd", "hgbjhhgea", "dfefgb", "jjhacbfg",
//                "higjficicfceaec", "bifbgaefjbbcffabbci", "fagdg", "ffeigjiccahccddbedhd", "hegjgee", "iajgeihdf", "hheceee",
//                "jdjiebiadjfcbc", "ehejd", "ehajcicg", "gdhigcddjgjjgijgeaaa", "ijeaabeidibcaad", "achhagfbg", "ejfcifffegeg",
//                "djjfaeedf", "fcjd", "ihgggaddhidfeged", "hhcgjggbdfbibacagef", "jcgcbdhbeejcdfbj", "fbchddadghdbfbijaca",
//                "cbhfajadgdj", "iafihbjefjaijgi", "hbb", "fjj", "abcabgca", "gdaihdj", "idj", "gibhbjdhccfjadjgjid", "gd",
//                "ifdjhicgeheghieccba", "jigcificcdecfj", "hcdhaje", "efdjg", "beacjddiacah", "fcehddbjd", "cdigdhcdjcf",
//                "digahfgiiaaihgi", "ciachfed", "ehejicgcidjiaeeddffb", "accjgcdhcajifagh", "jc", "gcghhjcehj", "ieghicdbhce",
//                "eeb", "ibehhchdjahcegjgb", "jeegfdaeha", "gahgbb", "jihijfijfjgdiehcbj", "dbbdiciihcc", "jhiahdfgajgjchcg",
//                "acbcadggaag", "hdjfdigcaiaba", "gfjicf", "egfaeaahcijfai", "cjfebjaagbcdhihadded", "dihjg", "gccbbbh",
//                "dda", "hehcjgcfbijhfbi", "hhdaghjgccdggg", "cccdfi", "gbiifibbegbeeeb", "ic", "ied", "agiibe", "hcccgdcecg",
//                "fibjcbjdajgjhdaadhhi", "ccafd", "baccehffdgahfeafcjhh", "ccidbjfeecidgijadg", "acbgfggfjjddeac", "fe",
//                "jgheebbchieh", "aegifffehebjadeb", "ahage", "gddfb", "cjjb", "iccjajicacebghiaf", "dabicfjjgef", "jfjcjigfie",
//                "ghhbadchbjcbchbided", "ifedifdjdcifeebcjh", "fbajef", "dghjhbhbgdeafa", "ahbaajd", "ccadhaicgbdcggiibdfi",
//                "chcihgdcici", "eggiihbfbjfhbdfahj", "dgjgegadh", "jhjdja", "ahjjdfhbhdehhaihc", "icgcjaeibcfebg",
//                "cfceffcdbi", "bcccga", "eahjggffbbecae", "jigahhh", "jdi", "jdgabiiidjagj", "hajigadgacfcjbahiba",
//                "ebahc", "cdbbgjdjehgef", "fcadcgh", "ghcacabaj", "igijiechadbghhbfb", "jjb", "aedd", "ebjgeegaaci",
//                "cdajdfhjhcj"}));
    }
}
