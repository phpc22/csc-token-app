public class EstadoLink {
    public static String getLinkPorEstado(String sigla){
        switch (sigla){
            case "SP": return "https://www.nfce.fazenda.sp.gov.br/NFCePortal/";
            case "SC": return "https://sat.sef.sc.gov.br/tax.NET/RequestClientCertificate.aspx";
            case "RS": return "https://www.sefaz.rs.gov.br/NFCe/NFCe_CSC/";
            case "PR": return "https://www.sped.fazenda.pr.gov.br/modules/conteudo/conteudo.php?conteudo=263";
            case "MG": return "https://www.sped.fazenda.mg.gov.br/spedmg/nfce/";
            case "RJ": return "https://www.fazenda.rj.gov.br/sefaz/content/connfce";
            case "BA": return "https://www.sefaz.ba.gov.br/nfce/";
            case "AC": return "https://www.sefaz.ac.gov.br/nfce/";
            case "AM": return "https://sistemas.sefaz.am.gov.br/nfce/";
            case "CE": return "https://nfce.sefaz.ce.gov.br/";
            case "DF": return "https://www.receita.fazenda.df.gov.br/nfce/";
            case "ES": return "https://internet.sefaz.es.gov.br/informacoes/nfce/";
            case "GO": return "https://www.sefaz.go.gov.br/nfce/";
            case "MA": return "https://www.sefaz.ma.gov.br/nfce/";
            case "MS": return "https://www.sefaz.ms.gov.br/nfce/";
            case "MT": return "https://www.sefaz.mt.gov.br/nfce/";
            case "PA": return "https://www.sefaz.pa.gov.br/nfce/";
            case "PB": return "https://www.sefaz.pb.gov.br/nfce/";
            case "PE": return "https://nfce.sefaz.pe.gov.br/";
            case "PI": return "https://www.sefaz.pi.gov.br/nfce/";
            case "RN": return "https://www.set.rn.gov.br/";
            case "RO": return "https://www.sefin.ro.gov.br/";
            case "RR": return "https://www.sefaz.rr.gov.br/";
            case "SE": return "https://www.sefaz.se.gov.br/";
            case "TO": return "https://www.sefaz.to.gov.br/nfce/";

        }
        return sigla;
    }

}
