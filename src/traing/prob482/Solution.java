package traing.prob482;

/**
 * License Key Formatting
 * Link: https://leetcode.com/problems/license-key-formatting/description/
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 7/31/17
 */
public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (sb.length() % (K + 1) == K) sb.append("-");
                sb.append(toUpper(S.charAt(i)));
            }
        }
        return sb.reverse().toString();
    }

    private String toUpper(char c) {
        int diff = 'z' - c;
        if (diff >= 0 && diff < 26) { // lowercase
            return Character.toString((char) (c - 32));
        }
        return Character.toString(c);
    }

    public static void main(String[] args) {
        final Solution s = new Solution();
        System.out.println(s.licenseKeyFormatting("2-4A0r7-4k", 4));
        System.out.println(s.licenseKeyFormatting("2-4A0r7-4k-", 4));
        System.out.println(s.licenseKeyFormatting("2-4A0r7-4k", 3));
        System.out.println(s.licenseKeyFormatting("ab-------", 3));
        System.out.println(s.licenseKeyFormatting("abc-------", 3));
        System.out.println(s.licenseKeyFormatting("UTA-XNEgROjKOOAXGmsI-jHIFfYpchhncBdgBlsfGVL-ofeOTavZxVtIo-llx-hIDuA-CFvYPdBswVWBTGhyDLRZcrseODPEwXY-X-GH-sUFHtBvv-DsTkMJFi-OFsXTMYQNJyDMAKsanNuBL-pHV-HtLOEejxcyMbsjZKfpP-RBO-fEDUHBweDMVRkm-dNoZ-wODyOmOIecCfUVHdBiGVWRAwUAg-qQCt-clSwzPOsbwJoKnGDyLwh-NqxDdxrAqi-AnvaQ-KC-ynfMBoGgjkxdlLNDqHOfDc-nTWZpJMpRewLDoRA-WkFtJKvGpkNJJAvzqA-nDbUyBNWtMRaByMSUf-RPb-aLaTAZSALY-dDbZPW-cU-nEnmjBfgDVVsIl-cULcpRSHLl-DLC-r-OLlLcrJpOjpgjMCayM-M-VyjJ-lUMrJw-aykxDac-tDU-mQNhloNLqVSEvxbcyI-IjOC-Xhzv-tGfkFjR-IrPxmNLVQtYjxNKgg-MvddnoNhgXMhwCMLJxI-tQAItAkQPsgRoxlSXEsAkBlAVsYkrPmpKhz-wNXcJRjjTDxUwKwevISvFjRimIGCPXSFVhymPNhrFBRlx-KixQgVNKp-Kzi-rlHl-FlUtmHc-jB-aN-M-Ik-b-ABtyKlppVG-deceCH-Fk-nmBtXwqxrxFzsOOiZXeyKSFEEW-rP-yCjyzI-i-oJeBMaAjQkyjiENdoAwUd-ULDrOpZuPXkiJh-rfOHKavSQNrFJfOMnAnsDx-U-guPdNP-rGt-VxyRRRb-vRJuGBmLxmdYToFQRirJdWtqjkbL-ZFTlLja-GHOzzOdjbKUqpfGZMOSjwMdaEkMU-fCp-LbWMa-lc-pxmRDKHvj-s-nJQjBvhxB-gE-n-BnWnS-WvcWqTZUUTRScc-WjUQJiZjDFXQsEmMXNNAOXlYWZulZClWPoi-IWclXQhMRWgK-kLRKP-gCKPJPtrFWzWaGvVwYoluSt-lOntudBZAzjtWzqLnTRJsDNstKLe-sXScfifEAvGdIyZTOCM-BzFIZNuOdLTBNnYYohXLGEW-GNWkoBjgQrUWzKGDTKdRtssanFboPwSXYCS-EZWWfB-jWyYt-wxfYQZtLPnlHWkblbqcSWtCZYuRnpHfWXeh-AgunIfa-ugoNzaoXuk-zur-iunWaMhrr-Ch-bbxKsMgww-qaYeYhDmXUFoaWwb-EhljOEwWBKqaVrnyXaxPT-gUEXdVQe-iiJNRQvkmES-Fyqlgcikzat-nmRAYYugMonfxkeTJuc-C-uf-nMbo-qDReDsCVVTyfs-dWBrfCJDIhxBaKCbkOSpMxtBlFzO-As-bWTPuyEpH-qHmpbUbNOGmxPEmH-bUEFHRLHmegkxq-f-JJncrJhnicr-Ci-eoJkf-KuVUy-sols-ZlwHQCYsV-uViAJyyPlNcEk-NOPLUFEnpW-TCWe-bqIzwEqWZLYIrN-ZEYAHmNI-WsuFHMJXEugDtXdZ-Zu-kyTSc-rM-wEoZyL-SEmNxHDNRAwizJgOdUxSsVPgXDIYVpinLZeRZRKrBoJaQrefUat-khiDWyuPfmD-h-IZBkiWRgHPwGnTkqkRZObT-LkhUoxoRASPldxgzM-kJ-pZOwBxjXy-nQRICLAnTc-xZh-Jt-FHjkoYUAQVzVbCcPLvt-ev-kBFNnKL-JYO-VkVhF-gK-d-Qz-zok-SXllwwPiOIIlUCcZBDlWcJNNNuULvPCZbLHjYTEInjQ-JIDzFQwKMlEDR-PeRFNSGezCUgGZ-cjz-HyGgUs-vBYrZGVhGTkzH-a-ZvxcGbxjxLHElXWJWC-Z-Z-pxgdTOQTdFwOGeIxECp-CxDTrLJlGsXdxQtVZoz-tnCpTZwcKQWuq-TtEKaXIDEEevommgEJIAKlx-zqB-ugwBnfWzbBuHYrUML-qLWmFqDMPMAAm-yhBEO-FMXG-UMRUZU-QOmoQnmD-ryQ-wQZdmF-DXqbAbGiuNJUAQqblbtPdFSlizMCCvvxfTKBCnPw-ayGlycDlQdYseeZTcSfOmxgsWrj-zi-hrzeeumJTn-hdhBLYQz-OmWaB-EVMRpWR-uYq-d-EpbPRH-hhZa-WpVdf-VZlWy-mRnGKon-WQo-IKhAk-gAKPrifjRMboyTMdHkEj-cDxHFhSrtPRsPZAzdpAC-NB-urvhWaEoGAdWebAwLUvNWdLGq-UUhauvQDesMWCZsDU-VlCDupeohiIqSEQDSvbu-Oqu-u-jtVBLVlhshZ-RzVVEkLlKP-fnezwoJkAlUSlFlAUZ-Nszf-BK-Pw-SgWBlalPHv-jmVKJWBTKrZaXMSkgVq-xUOZAEtGWDsTwOawgrBzRbv-qIPm-kuaHYKsKi-TjTAmGwC-HMKUOKzYt-cAT-XIPHccsAKhCDiAmz-VHjrymiiOmHXKI-QenGBcPuj-tTsxFF-NUlf-LbDvQO-LCDCkBCyL-jzKCOBCQnxbpjlMPsM-ewarGndgDiWx-hxEumZ-S-AgDDfJPtkHnhoJNP-AaPHZP-W-mRzT-dROKNsz-VQATLhcnVJATVwxuoPFr-aVYRSVxYzWDnRFNhNRexqlYGJBbeqOMJEKvSuVNHJ-PvZXUoBh-PfLeguXVbplTbEaYwgZ-SrNuLCLnyHKwuhSCASAGpjEYi-a-bvlgfPbQRoy-adPNWtaOPtSnpHodVKZBnEAhgo-H-ywGzJQ-iSG-MdHBThRnJzWArMzhsCS-D-mahUr-GiWgupQmw-WMMBHJAlZmSTWTLvejGDUPr-dQ-NAbwwnnRAqBcuG-cTfjakVDMu-hrveIZLVJCMiq-NvwDq-qXNVxyqiBvVZJCfxxP-v-CwmZCelr-nPGu-Blis-PBNHzsFRqmHkQvTOgVBklW-OAMezKHt-GDtPpHRYfQqpb-RsKTLzXZd-QGZWpehNIYbzmBOa-sS-nzKezeUq-gZxGAitlkavfKznMunyohV-IPCflBIZkfIbbJfkGozVtTiqXrLOrSDdwKAVCAD-KEUBqxV-HdmkfdB-pbDiHW-DGtHAtqycAn-zUEJ-LvBqUSO-KhhwHnPVveseyzjoSDedqPOSVyGZqUWUZRH-VbNIibSbBbsBbYKEz-asHvDQvC-eKyGiMAoYvqd-cTkXVtLzfQSsxAfzqL-TmOdci-ledPyhOsvfi-EgmkMpDQrtEVxLTGf-paEqw-HNPkTocDTqIQ-Iuzs-olXWaFXaMBImiOmmSZf-bIVctyXgOtkKamsFasbxRymEOrsZ-pKSLkEdOjqnzSUOfdTznG-CXCXY-tpraMHqYLteWxutNbHEnTCD-vorL-RgtzEzdf-hhkURFYInUAPlDQQCuaGA-DovpRDSwCnpzuq-T-bVMzOGRGOXAyWPEVyT-mO-Xj-qdKn-DfrMAJEkL-ZLJzDjGShLctqxng-jR-EggITvOALlXRxFkvKg-pEfoY-AK-LtfeCRSdIoRXRYieMyXhPBmIuYRmfQqAhByMwbZLGodCPhajsLWUvLs-RuREDldIGrmkwaRTIQrFuSWfpTruZFGBRfk-uGMEYsGjWFTlu-PIuNEO-qv-osyyLXmNRI-sAdcKgxYWIJKPPLkvQ-cVJGrvVaMeuDpVtYLLWfAFNfGzsscazM-IpJaWwmuxhOkcwbWKzsF-CTCNFq-gtkv-ETDUB-byx-LwLnxIkoYtU-NYDro-MblcucD-N-GjahJDOMO-yUwpYIyjoVpAObgC-PXl-k-KCVeKAjfqyQUsBRhmlXgAQ-yJh-lhAbdPYePfWPwPIZrDV-pOOSqtCDMspUEn-plmSwQibLyAkkTGXjHEaAKQjgBvGNbboC-otsvn-MKlzCTlUml-kRfORqaEyol-L-E-KjSLDlQBhBK-jnlan-LtyGJJfgTyFvBWDmxsQHgUTVVvxYVbvwfUoWShz-fl-RhpMrRv-leHiqhLovGqpb-ynVbsQcyQJPLdVtNOhfceFfMVDq-bGqEPoGSqIutft-GFqMJJwza-KLj-I-yiFw-sL-xdlhHFmz-LEKM-Qyiv-LU-c-cOiWA-RRYvMvQFaPPFXalghoikgwCufN-GSmxXaQeZpv-yVQle-fbQ-zhAXQZZS-aWdwG-XIEqalzAZRhdIzcbG-UQNDIujHQ-MkxoEB-NKrF-BHY-d-kYkhQjvss-rysqPGrWpvLUFpoUxWq-tijrTT-niqhkQypRZYHEhExDf-xDPFuSiETnxSuoXRZGFuJPs-jyYNLexOZLnXWtH-QvaDAa-cVMkcHFLFtNCareZk-GqlTpVAMcSIj-BEMwh-TGbCAoN-soq-oHBUZBsEqmGnxnhLkK-jaMZcxaUlQUmlw-nPgW-vGOGrdnMzIEIoh-quPWBkGDilbmfITIzZs-bqjdmmC-DqbwHulZU-BY-BctaRtDbsTCkNZZVwJBOB-qummErmJPuCqvhI-CsyNtJkFqIKcAoDcFdiCjNNsLL-JHk-MIsLYcyT-iYKZb-u-p-VuzmElU-LYTXDMTbDllUzcbYiYAcWWWnNMSsfnlCcadrvvq-xWalFuE-st-og-IfQTbh-TdcINlExzvwJKUMEYtjuyKlaKLyvQC-oGYSnhwshBJ-GFXtcl-HFJsaniUOlYifszXvseWUVOCxKeHwjDQsiFRZhwMqeKKQVfyJtY-r-l-joGPqaYNNqCO-LYwOOLjtF-gDbJRxhbcqV-AU-PLDCVqYubjiBVdlU-gA-rfHvX-xmr-MQ-cvKMOUnAl-DC-GBnSSFBqXyQGtFtA-m-ZqQFQTzjvOiWGZZwF-ZwZ-en-mncoA-tIeKAccqHuYZeL-byga-WfcBQNrYYWxTNGBFmHmEKDaFhMaqcDHgJ-vAwa-nJ-Esy-JqkYWbA-aEtLaqGVyiRbsVZwpoZ-iImwiSmJTD-vNC-m-zkzWBszsJXfuQSWRwULPaEGbewla-t-HpcixqmXPINrlDNWtaFUFN-XfxAgOT-ouPmErzSPU-HFhwN-ryFWX-FJbrCSbmme-eFcmGfnnJqPshQt-sU-ST-yewwrSLleN-bymHgWkzITObORlzqnteVTJK-YggJ-OlqHzlA-DWeMdcFcyLJsDBB-ZYeUZtWkwGJFIxTp-f-DAN-F-TnbdXP-eauCjsy-Mr-wkk-ClDwhGUgJwi-DeHAsPyt-VWT-w-ACkYjxHeTJiHtFrpdPdYh-Bnwtq-YonBLxQ-V-BLifxyphNXtCxY-w-sILpvp-dGyYuZmOZYjdei-VDvCpO-aoM-jk-vAby-C-QWjPmL-wHKdHRJZrsaDMztNdyApEL-rsrawSVFdZHUrYo-ZmmDOjNKBZQazlkOGFBqDwOcwuDzFL-sxoQX-HjpvCMdcoxf-StJpwOPOXSRkDpVbhLPOQBR-ZMlePda-p-ZhCJAlvOKhjP-OswEL-WsSozGQUKZRzIhJRlqhCBruXxApMWMBkOCqKMQNS-CisnIjAfAfx-tZzQDoUKsVxyeiaNcL-gx-bUraLDJsgBt-YKlHQjwXeTeuTmCqMOjri-uOGYhKGwj-a-ABgXtSkEyIlGFK-CDlkBKszUm-VODSUXeeipqQcemJeMmcAxlYPutbBZJSaqU-rUeCbCEzbDWOPEBlj-gDwjPKSIcipyq-MpIAG-s-HSqnntqRTNIKWFAOQsOXOikS-xsJMQN-uDrydUUJPfYTQNyQXODa-sVPjJcyQLdpYVJFBvUwsloKTYnJlnwLoL-DytZWjZKs-tIktwW-gthMtkECxJmCVDUlSDyCmpjRJlehpjWyD-vnxn-cwJkkNUGCE-fVjrkLLOIFWLRWoWjqqHglcAjzq-AYTHEqWolFORKxMEdDE-uAerJBV-VCCHQQKAOJRGAudcsDpWBblBiwyUxQJSnnoGL-nuWJ-dUBCIBMhWMzndDJty-PacQa-QUMFXzoDMKjXYPwwIX-UbfQ-oA-dhcDlHLDIykiki-oKAWA-vJSUG-MjrkeF-aXHvVT-AiL-Iz-piwXcciYetB-XsqHxCiTkltDaFUT-DlOFRQ-sbJSiAjHYoKoX-SV-RQXTfx-VClju-qrqT-aok-a-bJIXWfO-YedCjAUURfYkuC-VEYnzXm-B-hJCfDuqgMynOd-HMaRCynsJjOzatN-RiOzOuxHFlJrccwACbtCpQOkVMtpzSLdbyCbYbUznB-NiIGUPb-oc-xGRYM-ipgN-FALmXzr-GCUD-JXVTJNzIT-qDruKjzynrQnHjHJb-nNkixgBdEV-wuQukAbjkR-nKx-giZd-WAvTubXpFlnGXyjEN-rb-vfVnLBMaifRNnqvtjbjKhbTbcIzJO-BRQsNvzElhdTFYkJNM-LRzYKAgzWuTg-FUawVEEKtxgxrnobWjIifKLC-vxmJSwkBLdlHWJLDcPQ-TYtSWNAySl-OjzTeipznQTLovzo-YOsm-RvjKpyOQ-GySBKTjdeBQPVPxDCOId-aoOD-RuIekdIyrqXTrRYMgxwsrxdvOByCKxnzW-nLhUUlPcKhj-vNnPxtoKsTCHGCPhT-Q-nWquuBTQVU-ZSshNs-n-QFJeho-pznYjqwFLYPvPBduHbKeWu-IJKyvcCRcuYVMszSJibSQFAxrdOaaaRI-ADbdJLt-y-Rvve-r-EdfXsax-PKF-xnMTrjyxEJZCvLzMueBj-UDLTzbrwHaotVDcBNzfRFGZjlR-EsXdgFTpXYQN-DrAxDsiWkQDWZf-tA-VpncA-yyBgwoBD-aTY-jjsCCTXdq-leeC-eykPNFfgWJEICKDB-wp-Mdbtzl-J-DW-gBuxeI-xGBUEmvpkxJiEwUyzDdhWbKctp-z-j-pONK-cbsiuD-eKJSZjy-gsIs-B-lnVZ-fvv-PebXGwDUpUDDBQtsYntzbjYh-vOgJrvTncrnbTNP-jbrttLqWxBMPd-fvpmPIbvrNXcGnBR-LkcnOA-HKqqM-DekJm-HAqULbhnswQYxurVJCdy-GwsYT-drDC-cVYbOBapPOCugkJNVM-LfF-HBbQotH-IWvwFnzsJDgVzJavB-YdJNvt-idAJvbDzIMOrfBaQBvcmbUNwkw-Bh-nawlCJKmxUmgluhwl-Q-LMGGAoFQNOoFSRYvSrirNFSnMoo-w-da-HFAASBGzMRmv-XgjPQMs-FadnBNhBlkqWtrgEAwI-KkS-l-FC-OGbbgsleXopFBlkHZKnUfYIpdigIhnyZSuvoMWrfarfxkHOJBJlkgaSCMkBb-z-aLSIyBpTFuUdDH-xDGCRuimzjZTzaJJiN-lQRClpEtYQZENht-GRQHWVJI-rWvudScJxjRwK-LdXApLhtWaHxtx-p-Xuq-PomwAG-Gj-WyPXRVkcXcyUKstooftrhyjy-VSo-ljQcPbcw-aZG-hsZq-OUcBbWMAukJsTm-lDV-PqXpTbQCdeaxqkMVCtdGdbdZbHeSHM-XUkwiTYOzMwVNfJmxq-GUrmfOlGNjChdIdJgAAHZiFJXWSi-ybnCodqPCbEQqYsq-zEizRoAp-GA-Au-aAMLQBI-SdXZUvdDHYY-mlmDmjeOOCTRnIz-Bu-mloYstDlmvJRUAzkPgeXwTE-HsJCUH-VKEvr-OYaIdVzxU-O-vtJs-WxJdEOkCzDKhazWVTwEUnbRJwcVCNhCCvUKuR-zBQHuHwgyGliw-lIjm-FeHZfyrCT-ABQasZE-QulU-UaTWwdDc-bXu-ssIpSOKtESBXHpMkckbBlBFLIVRris-JQQxz-wRlyAQnkvPJGHKB-zLnOZZUp-XMjKTJJgJxYwKpsJifa-wJc-pQq-BCulNsHgJCh-ktfRxu-UDXUmnP-UZN-lnCMofpEHVRVOSzbErm-JUYtaqvo-qQpvEHHBfMHrSb-e-H-PTZtDwA-uumsBW-RDPkFDHGuDbDjXX-oYQQTCuWHnp-K-ZgJnOKMIDxHrQToYcoLrIAoBVzZxrm-yDhFnkvRmqDIrUsOKyUJc-G-PBXZEwWjopFyAxuVJVUF-ZiUk-fkAOAOHDBqPMVQITaSbIokRQNIUlO-FTyfeCZHy-VF-ReIfj-oD-ELZPcZAPbmiqJeZBPKaPtT-DorymYGVvjl-pSM-pXtNvN-cMMfAOACoIMHGf-PnvpI-dRxFxTlpDSIVyPBNCTKiH-BpKFjwCmDOtcePDKqXwrY-NiHMI-DWYqFyePXiuJv-QHDx-VUOLxJkUSJfxkxmN-OqEYIP-YpLQIZILJ-UxHAOtXEQTrGa-hpkJLCppKyytGuJMuaDdGMWnn-beY-gbGyWYjba-izWVOA-YXvPhgT-kSTgoRBKolmCOw-fXWm-falzVHTCHjMVJFnbCAFYvyJSKWRmQevgQr-fpYhIargvReBkSoc-vNzNjReXbr-POVrALTqBp-ToDymtUNXFTrYr-WLmRtK-UdZ-dIiXavmwBeadniXDiG-XUhanZVaPoyOTzsYracbhNPztZdPZVKPzLaKrpaWBdfTAQaNXBFz-bswzALmaeAUzUuDyEMFpCaXLkrOLTsPcZN-cwelOLbF-fTWXmtEjWxX-AG-fzKf-I-ZNIbMiycHNtfYHrdjyfR-HcG-in-gZOroyqdpgmNOCeB-SEgmSgPmffQq-maqm-Dycx-nNa-ComVfObTMgiEBrpQ-j-GfCHqCmNkoQmVgYBfE-NhHZcFehvEc-vQZgDJvgFsXghFvnA-IWSTQsWMuwIMZU-daF-bjoHsM-ucIRDB-PHrWnlrIMtjuGtCEjgg-fpGLkJVNSFVDZ-yBuDoEbEc-P-OVelqBqra-Q-oZM-evBXY-TqBNoHppRYIdoOQqhS-eOdmAXXDs-MPcEJQ-QorzsGxmvdKa-GTx-YMLLcVMfiJimCNcnonT-Lpif-gRBeKTwxJGEjexbxzmKBFlvJwnlGAYsDppOryZvM-m-WdzLfmWeNnB-bCZdYdJWElF-NuBEeHTadNydUNJlxNT-sWds-CcfSvnHS-auuwbAYM-eyBARjlFKoFaboeg-TXTS-CQQfRcgvb-NiZyvLozaUeNqdsh-eOrCSk-ddtjw-fsgoSOGXrzYzSx-HPTYWSVQSPJrjnWCVnE-luYnPcemTMCFetGHputkrP-REEaslaFjDGbJUjK-zMiGcY-JlRSo-tjXFXFGSplPXFIfwRbNf-iv-TOdpFfxmOP-O-IrIsJ-WftEmLC-RnivXxfNBR-XYMGNTPDIncdkWF-OgslFDeTjSVBVxrfSqzaHzdYoWfxve-hBwWbvu-thlOoxEdI-q-cAKihmmSpgEsPAzyWLoNIMadyvA-Efp-cePyvay-EnUEOZPNawrBea-ijNmNHFsq-QBRQ-kFIAeRL-iwIJVYT-EIH-GyxhlzwMFa-W-FosoKd-bcRPzkskYVm-qtNtA-WgriM-lKG-j-DHslHuQl-p-aWj-x-AtDSUZOChzdwd-ZNfiGfFzeys-TkbtPrh-PdLpxzbIcXgvSpr-vdIjCMurtQP-qkTpoaHIGnU-eDk-nTzLHNlrxALJ-PxfmWnYvHo-K-IYAAMAxrqEVtLzFjkHaRdTlp-ZVAG-XsaepjOZchZjycqfqQyrulsQWrlGvg-FiiX-IeWjMx-UrZGwjVlhwa-gllAISTr-gHCjxR-JzoHd-FJY-g-Gd-K-RNQkfZNKb-fiDrlnzEgBJ-bF-PHcgkEDrkmqjPvUkHP-tGEG-yXyUzW-fygVqaySFyXcuCswwdMxNmJjlT-wscm-BhXoYfDSleFUyKoJaabhyVbhzdrQ-CaaWMzfqF-AnUaRupVgn-GXRosX-xIWbuYfeY-pIc-Ak-hbJBx-OjxYbNNa-PWNpd-SMAfRdCRzGdhNVFgtYXZb-qvhUhXPUMbnpItN-jf-sCBYjVBucmZ-PhffmrisClzMolXZJTPBNEbiyzSsndONAUypOt-Nw-pUiUawxQnvn-mCNoKkB-zujnTGgsauwJvEvZkpGNgoqiaeGdEP-vhKQ-gAVqIxCcTAjSIy-NPwPqomajfyrMR-KR-ljwvAiwCfBsXYSzMbvVIKylXBWRSjnsIegZDoeDwRVoCUnUsmzjQhKtNGyMPA-mEukFHSryXAMejuHym-SIx-D-o-HFcV-gDLvjxuOLJDmmghtAkFf-JxXkV-IlVjwFpZyNixNFkVcpDcYzT-X-s-hyzUBKIdmBj-ATsTLpMfS-dpcBGyOVRabKJbmlOSVjr-DbwKoMvsSqBSQnavvTaSOuiWElxjYlvcVdDhWxH-NTJtwh-g-UnNupabeKje-VXl-HdBrKGaVDg-Bc-H-BtE-ObbDnysYBtmPQo-ZEw-dOYoHruHCThrbSYoUNbRfWNlRfuMxmm-ny-wBzfdkZMGUg-NNZSOuSg-RqvHhr-e-kTJ-Ii-aWTdLYMM-yTvgdVKAcZxUFlaLGZtoH-tIWIIkeYnVYUZDudmiYu-TMIgMKev-AmgicjjcIFzrcRhVvAtR-Iowi-ueAozgFn-w-AxlrttI-BoKjayuCvfxQwNI-HXydhu-bBKAGqtaDmrmRrhxpxtJPkBocyg-wLFYXFVNoFL-Xl-acueRVBERCs-MVuyCixRHE-yu-iGYEBP-YKBWIBDm-KEHUvebgZ-IpwPJ-nanbxl-aeJrlBBzxWRKNp-kGEsSfWMvr-rws-CSgspBWTIXWLYWjVpmmhDhWKUXlKRAonO-GMjOxTGq-XrjET-ZVNKKct-RHb-sociMK-HPqt-FAUXHqHdi-Dv-mGLWwPDbFMLCId-t-UJEyyqNGR-YkmLmzrSRMznMJXyMfeFa-VxXTMN-fkkBTeFbZ-d-BlkS-lMdcsZiFyPF-LGuEz-R-ErcHKFoTspUmp-aYIs-GNJhiYdytt-vkFIl-SXwYAkxXCTQpbzTOGHW-jKtpXfoaxPiHiwxyPWycBpFCbv-UVZ-MAQ-rn-gekODi-YZCLmRxfIqnsfValQseLZVDJrF-pDbiXVxm-mTGs-mN-sx-rdj7274", 3));
    }
}
