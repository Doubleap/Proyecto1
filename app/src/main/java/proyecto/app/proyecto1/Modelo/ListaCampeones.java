package proyecto.app.proyecto1.Modelo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaCampeones {
    private Campeon Annie;
    private Campeon Olaf;
    private Campeon Galio;
    private Campeon TwistedFate;
    private Campeon XinZhao;
    private Campeon Urgot;
    private Campeon Leblanc;
    private Campeon Vladimir;
    private Campeon Fiddlesticks;
    private Campeon Kayle;
    private Campeon MasterYi;
    private Campeon Alistar;
    private Campeon Ryze;
    private Campeon Sion;
    private Campeon Sivir;
    private Campeon Soraka;
    private Campeon Teemo;
    private Campeon Tristana;
    private Campeon Warwick;
    private Campeon Nunu;
    private Campeon MissFortune;
    private Campeon Ashe;
    private Campeon Tryndamere;
    private Campeon Jax;
    private Campeon Morgana;
    private Campeon Zilean;
    private Campeon Singed;
    private Campeon Evelynn;
    private Campeon Twitch;
    private Campeon Karthus;
    private Campeon Chogath;
    private Campeon Amumu;
    private Campeon Rammus;
    private Campeon Anivia;
    private Campeon Shaco;
    private Campeon DrMundo;
    private Campeon Sona;
    private Campeon Kassadin;
    private Campeon Irelia;
    private Campeon Janna;
    private Campeon Gangplank;
    private Campeon Corki;
    private Campeon Karma;
    private Campeon Taric;
    private Campeon Veigar;
    private Campeon Trundle;
    private Campeon Swain;
    private Campeon Caitlyn;
    private Campeon Blitzcrank;
    private Campeon Malphite;
    private Campeon Katarina;
    private Campeon Nocturne;
    private Campeon Maokai;
    private Campeon Renekton;
    private Campeon JarvanIV;
    private Campeon Elise;
    private Campeon Orianna;
    private Campeon MonkeyKing;
    private Campeon Brand;
    private Campeon LeeSin;
    private Campeon Vayne;
    private Campeon Rumble;
    private Campeon Cassiopeia;
    private Campeon Skarner;
    private Campeon Heimerdinger;
    private Campeon Nasus;
    private Campeon Nidalee;
    private Campeon Udyr;
    private Campeon Poppy;
    private Campeon Gragas;
    private Campeon Pantheon;
    private Campeon Ezreal;
    private Campeon Mordekaiser;
    private Campeon Yorick;
    private Campeon Akali;
    private Campeon Kennen;
    private Campeon Garen;
    private Campeon Leona;
    private Campeon Malzahar;
    private Campeon Talon;
    private Campeon Riven;
    private Campeon KogMaw;
    private Campeon Shen;
    private Campeon Lux;
    private Campeon Xerath;
    private Campeon Shyvana;
    private Campeon Ahri;
    private Campeon Graves;
    private Campeon Fizz;
    private Campeon Volibear;
    private Campeon Rengar;
    private Campeon Varus;
    private Campeon Nautilus;
    private Campeon Viktor;
    private Campeon Sejuani;
    private Campeon Fiora;
    private Campeon Ziggs;
    private Campeon Lulu;
    private Campeon Draven;
    private Campeon Hecarim;
    private Campeon Khazix;
    private Campeon Darius;
    private Campeon Jayce;
    private Campeon Lissandra;
    private Campeon Diana;
    private Campeon Quinn;
    private Campeon Syndra;
    private Campeon AurelionSol;
    private Campeon Kayn;
    private Campeon Zoe;
    private Campeon Zyra;
    private Campeon Kaisa;
    private Campeon Gnar;
    private Campeon Zac;
    private Campeon Yasuo;
    private Campeon Velkoz;
    private Campeon Taliyah;
    private Campeon Camille;
    private Campeon Braum;
    private Campeon Jhin;
    private Campeon Kindred;
    private Campeon Jinx;
    private Campeon TahmKench;
    private Campeon Lucian;
    private Campeon Zed;
    private Campeon Kled;
    private Campeon Ekko;
    private Campeon Vi;
    private Campeon Aatrox;
    private Campeon Nami;
    private Campeon Azir;
    private Campeon Thresh;
    private Campeon Illaoi;
    private Campeon RekSai;
    private Campeon Ivern;
    private Campeon Kalista;
    private Campeon Bard;
    private Campeon Rakan;
    private Campeon Xayah;
    private Campeon Ornn;
    private Campeon Pyke;

    public int getTotalCampeones(){
        return 141;
    }
    public Campeon getCampeon(int index){
        switch(index) {
            case 1:
            return getAnnie();
            case 2:
            return getOlaf();
            case 3:
            return getGalio();
            case 4:
            return getTwistedFate();
            case 5:
            return getXinZhao();
            case 6:
            return getUrgot();
            case 7:
            return getLeblanc();
            case 8:
            return getVladimir();
            case 9:
            return getFiddlesticks();
            case 10:
            return getKayle();
            case 11:
            return getMasterYi();
            case 12:
            return getAlistar();
            case 13:
            return getRyze();
            case 14:
            return getSion();
            case 15:
            return getSivir();
            case 16:
            return getSoraka();
            case 17:
            return getTeemo();
            case 18:
            return getTristana();
            case 19:
            return getWarwick();
            case 20:
            return getNunu();
            case 21:
            return getMissFortune();
            case 22:
            return getAshe();
            case 23:
            return getTryndamere();
            case 24:
            return getJax();
            case 25:
            return getMorgana();
            case 26:
            return getZilean();
            case 27:
            return getSinged();
            case 28:
            return getEvelynn();
            case 29:
            return getTwitch();
            case 30:
            return getKarthus();
            case 31:
            return getChogath();
            case 32:
            return getAmumu();
            case 33:
            return getRammus();
            case 34:
            return getAnivia();
            case 35:
            return getShaco();
            case 36:
            return getDrMundo();
            case 37:
            return getSona();
            case 38:
            return getKassadin();
            case 39:
            return getIrelia();
            case 40:
            return getJanna();
            case 41:
            return getGangplank();
            case 42:
            return getCorki();
            case 43:
            return getKarma();
            case 44:
            return getTaric();
            case 45:
            return getVeigar();
            case 46:
            return getTrundle();
            case 47:
            return getSwain();
            case 48:
            return getCaitlyn();
            case 49:
            return getBlitzcrank();
            case 50:
            return getMalphite();
            case 51:
            return getKatarina();
            case 52:
            return getNocturne();
            case 53:
            return getMaokai();
            case 54:
            return getRenekton();
            case 55:
            return getJarvanIV();
            case 56:
            return getElise();
            case 57:
            return getOrianna();
            case 58:
            return getMonkeyKing();
            case 59:
            return getBrand();
            case 60:
            return getLeeSin();
            case 61:
            return getVayne();
            case 62:
            return getRumble();
            case 63:
            return getCassiopeia();
            case 64:
            return getSkarner();
            case 65:
            return getHeimerdinger();
            case 66:
            return getNasus();
            case 67:
            return getNidalee();
            case 68:
            return getUdyr();
            case 69:
            return getPoppy();
            case 70:
            return getGragas();
            case 71:
            return getPantheon();
            case 72:
            return getEzreal();
            case 73:
            return getMordekaiser();
            case 74:
            return getYorick();
            case 75:
            return getAkali();
            case 76:
            return getKennen();
            case 77:
            return getGaren();
            case 78:
            return getLeona();
            case 79:
            return getMalzahar();
            case 80:
            return getTalon();
            case 81:
            return getRiven();
            case 82:
            return getKogMaw();
            case 83:
            return getShen();
            case 84:
            return getLux();
            case 85:
            return getXerath();
            case 86:
            return getShyvana();
            case 87:
            return getAhri();
            case 88:
            return getGraves();
            case 89:
            return getFizz();
            case 90:
            return getVolibear();
            case 91:
            return getRengar();
            case 92:
            return getVarus();
            case 93:
            return getNautilus();
            case 94:
            return getViktor();
            case 95:
            return getSejuani();
            case 96:
            return getFiora();
            case 97:
            return getZiggs();
            case 98:
            return getLulu();
            case 99:
            return getDraven();
            case 100:
            return getHecarim();
            case 101:
            return getKhazix();
            case 102:
            return getDarius();
            case 103:
            return getJayce();
            case 104:
            return getLissandra();
            case 105:
            return getDiana();
            case 106:
            return getQuinn();
            case 107:
            return getSyndra();
            case 108:
            return getAurelionSol();
            case 109:
            return getKayn();
            case 110:
            return getZoe();
            case 111:
            return getZyra();
            case 112:
            return getKaisa();
            case 113:
            return getGnar();
            case 114:
            return getZac();
            case 115:
            return getYasuo();
            case 116:
            return getVelkoz();
            case 117:
            return getTaliyah();
            case 118:
            return getCamille();
            case 119:
            return getBraum();
            case 120:
            return getJhin();
            case 121:
            return getKindred();
            case 122:
            return getJinx();
            case 123:
            return getTahmKench();
            case 124:
            return getLucian();
            case 125:
            return getZed();
            case 126:
            return getKled();
            case 127:
            return getEkko();
            case 128:
            return getVi();
            case 129:
            return getAatrox();
            case 130:
            return getNami();
            case 131:
            return getAzir();
            case 132:
            return getThresh();
            case 133:
            return getIllaoi();
            case 134:
            return getRekSai();
            case 135:
            return getIvern();
            case 136:
            return getKalista();
            case 137:
            return getBard();
            case 138:
            return getRakan();
            case 139:
            return getXayah();
            case 140:
            return getOrnn();
            case 141:
            return getPyke();
            default:
                return getAatrox();
        }
    }

    public Campeon getAnnie() {
        return Annie;
    }

    public void setAnnie(Campeon annie) {
        Annie = annie;
    }

    public Campeon getOlaf() {
        return Olaf;
    }

    public void setOlaf(Campeon olaf) {
        Olaf = olaf;
    }

    public Campeon getGalio() {
        return Galio;
    }

    public void setGalio(Campeon galio) {
        Galio = galio;
    }

    public Campeon getTwistedFate() {
        return TwistedFate;
    }

    public void setTwistedFate(Campeon twistedFate) {
        TwistedFate = twistedFate;
    }

    public Campeon getXinZhao() {
        return XinZhao;
    }

    public void setXinZhao(Campeon xinZhao) {
        XinZhao = xinZhao;
    }

    public Campeon getUrgot() {
        return Urgot;
    }

    public void setUrgot(Campeon urgot) {
        Urgot = urgot;
    }

    public Campeon getLeblanc() {
        return Leblanc;
    }

    public void setLeblanc(Campeon leblanc) {
        Leblanc = leblanc;
    }

    public Campeon getVladimir() {
        return Vladimir;
    }

    public void setVladimir(Campeon vladimir) {
        Vladimir = vladimir;
    }

    public Campeon getFiddlesticks() {
        return Fiddlesticks;
    }

    public void setFiddlesticks(Campeon fiddlesticks) {
        Fiddlesticks = fiddlesticks;
    }

    public Campeon getKayle() {
        return Kayle;
    }

    public void setKayle(Campeon kayle) {
        Kayle = kayle;
    }

    public Campeon getMasterYi() {
        return MasterYi;
    }

    public void setMasterYi(Campeon masterYi) {
        MasterYi = masterYi;
    }

    public Campeon getAlistar() {
        return Alistar;
    }

    public void setAlistar(Campeon alistar) {
        Alistar = alistar;
    }

    public Campeon getRyze() {
        return Ryze;
    }

    public void setRyze(Campeon ryze) {
        Ryze = ryze;
    }

    public Campeon getSion() {
        return Sion;
    }

    public void setSion(Campeon sion) {
        Sion = sion;
    }

    public Campeon getSivir() {
        return Sivir;
    }

    public void setSivir(Campeon sivir) {
        Sivir = sivir;
    }

    public Campeon getSoraka() {
        return Soraka;
    }

    public void setSoraka(Campeon soraka) {
        Soraka = soraka;
    }

    public Campeon getTeemo() {
        return Teemo;
    }

    public void setTeemo(Campeon teemo) {
        Teemo = teemo;
    }

    public Campeon getTristana() {
        return Tristana;
    }

    public void setTristana(Campeon tristana) {
        Tristana = tristana;
    }

    public Campeon getWarwick() {
        return Warwick;
    }

    public void setWarwick(Campeon warwick) {
        Warwick = warwick;
    }

    public Campeon getNunu() {
        return Nunu;
    }

    public void setNunu(Campeon nunu) {
        Nunu = nunu;
    }

    public Campeon getMissFortune() {
        return MissFortune;
    }

    public void setMissFortune(Campeon missFortune) {
        MissFortune = missFortune;
    }

    public Campeon getAshe() {
        return Ashe;
    }

    public void setAshe(Campeon ashe) {
        Ashe = ashe;
    }

    public Campeon getTryndamere() {
        return Tryndamere;
    }

    public void setTryndamere(Campeon tryndamere) {
        Tryndamere = tryndamere;
    }

    public Campeon getJax() {
        return Jax;
    }

    public void setJax(Campeon jax) {
        Jax = jax;
    }

    public Campeon getMorgana() {
        return Morgana;
    }

    public void setMorgana(Campeon morgana) {
        Morgana = morgana;
    }

    public Campeon getZilean() {
        return Zilean;
    }

    public void setZilean(Campeon zilean) {
        Zilean = zilean;
    }

    public Campeon getSinged() {
        return Singed;
    }

    public void setSinged(Campeon singed) {
        Singed = singed;
    }

    public Campeon getEvelynn() {
        return Evelynn;
    }

    public void setEvelynn(Campeon evelynn) {
        Evelynn = evelynn;
    }

    public Campeon getTwitch() {
        return Twitch;
    }

    public void setTwitch(Campeon twitch) {
        Twitch = twitch;
    }

    public Campeon getKarthus() {
        return Karthus;
    }

    public void setKarthus(Campeon karthus) {
        Karthus = karthus;
    }

    public Campeon getChogath() {
        return Chogath;
    }

    public void setChogath(Campeon chogath) {
        Chogath = chogath;
    }

    public Campeon getAmumu() {
        return Amumu;
    }

    public void setAmumu(Campeon amumu) {
        Amumu = amumu;
    }

    public Campeon getRammus() {
        return Rammus;
    }

    public void setRammus(Campeon rammus) {
        Rammus = rammus;
    }

    public Campeon getAnivia() {
        return Anivia;
    }

    public void setAnivia(Campeon anivia) {
        Anivia = anivia;
    }

    public Campeon getShaco() {
        return Shaco;
    }

    public void setShaco(Campeon shaco) {
        Shaco = shaco;
    }

    public Campeon getDrMundo() {
        return DrMundo;
    }

    public void setDrMundo(Campeon drMundo) {
        DrMundo = drMundo;
    }

    public Campeon getSona() {
        return Sona;
    }

    public void setSona(Campeon sona) {
        Sona = sona;
    }

    public Campeon getKassadin() {
        return Kassadin;
    }

    public void setKassadin(Campeon kassadin) {
        Kassadin = kassadin;
    }

    public Campeon getIrelia() {
        return Irelia;
    }

    public void setIrelia(Campeon irelia) {
        Irelia = irelia;
    }

    public Campeon getJanna() {
        return Janna;
    }

    public void setJanna(Campeon janna) {
        Janna = janna;
    }

    public Campeon getGangplank() {
        return Gangplank;
    }

    public void setGangplank(Campeon gangplank) {
        Gangplank = gangplank;
    }

    public Campeon getCorki() {
        return Corki;
    }

    public void setCorki(Campeon corki) {
        Corki = corki;
    }

    public Campeon getKarma() {
        return Karma;
    }

    public void setKarma(Campeon karma) {
        Karma = karma;
    }

    public Campeon getTaric() {
        return Taric;
    }

    public void setTaric(Campeon taric) {
        Taric = taric;
    }

    public Campeon getVeigar() {
        return Veigar;
    }

    public void setVeigar(Campeon veigar) {
        Veigar = veigar;
    }

    public Campeon getTrundle() {
        return Trundle;
    }

    public void setTrundle(Campeon trundle) {
        Trundle = trundle;
    }

    public Campeon getSwain() {
        return Swain;
    }

    public void setSwain(Campeon swain) {
        Swain = swain;
    }

    public Campeon getCaitlyn() {
        return Caitlyn;
    }

    public void setCaitlyn(Campeon caitlyn) {
        Caitlyn = caitlyn;
    }

    public Campeon getBlitzcrank() {
        return Blitzcrank;
    }

    public void setBlitzcrank(Campeon blitzcrank) {
        Blitzcrank = blitzcrank;
    }

    public Campeon getMalphite() {
        return Malphite;
    }

    public void setMalphite(Campeon malphite) {
        Malphite = malphite;
    }

    public Campeon getKatarina() {
        return Katarina;
    }

    public void setKatarina(Campeon katarina) {
        Katarina = katarina;
    }

    public Campeon getNocturne() {
        return Nocturne;
    }

    public void setNocturne(Campeon nocturne) {
        Nocturne = nocturne;
    }

    public Campeon getMaokai() {
        return Maokai;
    }

    public void setMaokai(Campeon maokai) {
        Maokai = maokai;
    }

    public Campeon getRenekton() {
        return Renekton;
    }

    public void setRenekton(Campeon renekton) {
        Renekton = renekton;
    }

    public Campeon getJarvanIV() {
        return JarvanIV;
    }

    public void setJarvanIV(Campeon jarvanIV) {
        JarvanIV = jarvanIV;
    }

    public Campeon getElise() {
        return Elise;
    }

    public void setElise(Campeon elise) {
        Elise = elise;
    }

    public Campeon getOrianna() {
        return Orianna;
    }

    public void setOrianna(Campeon orianna) {
        Orianna = orianna;
    }

    public Campeon getMonkeyKing() {
        return MonkeyKing;
    }

    public void setMonkeyKing(Campeon monkeyKing) {
        MonkeyKing = monkeyKing;
    }

    public Campeon getBrand() {
        return Brand;
    }

    public void setBrand(Campeon brand) {
        Brand = brand;
    }

    public Campeon getLeeSin() {
        return LeeSin;
    }

    public void setLeeSin(Campeon leeSin) {
        LeeSin = leeSin;
    }

    public Campeon getVayne() {
        return Vayne;
    }

    public void setVayne(Campeon vayne) {
        Vayne = vayne;
    }

    public Campeon getRumble() {
        return Rumble;
    }

    public void setRumble(Campeon rumble) {
        Rumble = rumble;
    }

    public Campeon getCassiopeia() {
        return Cassiopeia;
    }

    public void setCassiopeia(Campeon cassiopeia) {
        Cassiopeia = cassiopeia;
    }

    public Campeon getSkarner() {
        return Skarner;
    }

    public void setSkarner(Campeon skarner) {
        Skarner = skarner;
    }

    public Campeon getHeimerdinger() {
        return Heimerdinger;
    }

    public void setHeimerdinger(Campeon heimerdinger) {
        Heimerdinger = heimerdinger;
    }

    public Campeon getNasus() {
        return Nasus;
    }

    public void setNasus(Campeon nasus) {
        Nasus = nasus;
    }

    public Campeon getNidalee() {
        return Nidalee;
    }

    public void setNidalee(Campeon nidalee) {
        Nidalee = nidalee;
    }

    public Campeon getUdyr() {
        return Udyr;
    }

    public void setUdyr(Campeon udyr) {
        Udyr = udyr;
    }

    public Campeon getPoppy() {
        return Poppy;
    }

    public void setPoppy(Campeon poppy) {
        Poppy = poppy;
    }

    public Campeon getGragas() {
        return Gragas;
    }

    public void setGragas(Campeon gragas) {
        Gragas = gragas;
    }

    public Campeon getPantheon() {
        return Pantheon;
    }

    public void setPantheon(Campeon pantheon) {
        Pantheon = pantheon;
    }

    public Campeon getEzreal() {
        return Ezreal;
    }

    public void setEzreal(Campeon ezreal) {
        Ezreal = ezreal;
    }

    public Campeon getMordekaiser() {
        return Mordekaiser;
    }

    public void setMordekaiser(Campeon mordekaiser) {
        Mordekaiser = mordekaiser;
    }

    public Campeon getYorick() {
        return Yorick;
    }

    public void setYorick(Campeon yorick) {
        Yorick = yorick;
    }

    public Campeon getAkali() {
        return Akali;
    }

    public void setAkali(Campeon akali) {
        Akali = akali;
    }

    public Campeon getKennen() {
        return Kennen;
    }

    public void setKennen(Campeon kennen) {
        Kennen = kennen;
    }

    public Campeon getGaren() {
        return Garen;
    }

    public void setGaren(Campeon garen) {
        Garen = garen;
    }

    public Campeon getLeona() {
        return Leona;
    }

    public void setLeona(Campeon leona) {
        Leona = leona;
    }

    public Campeon getMalzahar() {
        return Malzahar;
    }

    public void setMalzahar(Campeon malzahar) {
        Malzahar = malzahar;
    }

    public Campeon getTalon() {
        return Talon;
    }

    public void setTalon(Campeon talon) {
        Talon = talon;
    }

    public Campeon getRiven() {
        return Riven;
    }

    public void setRiven(Campeon riven) {
        Riven = riven;
    }

    public Campeon getKogMaw() {
        return KogMaw;
    }

    public void setKogMaw(Campeon kogMaw) {
        KogMaw = kogMaw;
    }

    public Campeon getShen() {
        return Shen;
    }

    public void setShen(Campeon shen) {
        Shen = shen;
    }

    public Campeon getLux() {
        return Lux;
    }

    public void setLux(Campeon lux) {
        Lux = lux;
    }

    public Campeon getXerath() {
        return Xerath;
    }

    public void setXerath(Campeon xerath) {
        Xerath = xerath;
    }

    public Campeon getShyvana() {
        return Shyvana;
    }

    public void setShyvana(Campeon shyvana) {
        Shyvana = shyvana;
    }

    public Campeon getAhri() {
        return Ahri;
    }

    public void setAhri(Campeon ahri) {
        Ahri = ahri;
    }

    public Campeon getGraves() {
        return Graves;
    }

    public void setGraves(Campeon graves) {
        Graves = graves;
    }

    public Campeon getFizz() {
        return Fizz;
    }

    public void setFizz(Campeon fizz) {
        Fizz = fizz;
    }

    public Campeon getVolibear() {
        return Volibear;
    }

    public void setVolibear(Campeon volibear) {
        Volibear = volibear;
    }

    public Campeon getRengar() {
        return Rengar;
    }

    public void setRengar(Campeon rengar) {
        Rengar = rengar;
    }

    public Campeon getVarus() {
        return Varus;
    }

    public void setVarus(Campeon varus) {
        Varus = varus;
    }

    public Campeon getNautilus() {
        return Nautilus;
    }

    public void setNautilus(Campeon nautilus) {
        Nautilus = nautilus;
    }

    public Campeon getViktor() {
        return Viktor;
    }

    public void setViktor(Campeon viktor) {
        Viktor = viktor;
    }

    public Campeon getSejuani() {
        return Sejuani;
    }

    public void setSejuani(Campeon sejuani) {
        Sejuani = sejuani;
    }

    public Campeon getFiora() {
        return Fiora;
    }

    public void setFiora(Campeon fiora) {
        Fiora = fiora;
    }

    public Campeon getZiggs() {
        return Ziggs;
    }

    public void setZiggs(Campeon ziggs) {
        Ziggs = ziggs;
    }

    public Campeon getLulu() {
        return Lulu;
    }

    public void setLulu(Campeon lulu) {
        Lulu = lulu;
    }

    public Campeon getDraven() {
        return Draven;
    }

    public void setDraven(Campeon draven) {
        Draven = draven;
    }

    public Campeon getHecarim() {
        return Hecarim;
    }

    public void setHecarim(Campeon hecarim) {
        Hecarim = hecarim;
    }

    public Campeon getKhazix() {
        return Khazix;
    }

    public void setKhazix(Campeon khazix) {
        Khazix = khazix;
    }

    public Campeon getDarius() {
        return Darius;
    }

    public void setDarius(Campeon darius) {
        Darius = darius;
    }

    public Campeon getJayce() {
        return Jayce;
    }

    public void setJayce(Campeon jayce) {
        Jayce = jayce;
    }

    public Campeon getLissandra() {
        return Lissandra;
    }

    public void setLissandra(Campeon lissandra) {
        Lissandra = lissandra;
    }

    public Campeon getDiana() {
        return Diana;
    }

    public void setDiana(Campeon diana) {
        Diana = diana;
    }

    public Campeon getQuinn() {
        return Quinn;
    }

    public void setQuinn(Campeon quinn) {
        Quinn = quinn;
    }

    public Campeon getSyndra() {
        return Syndra;
    }

    public void setSyndra(Campeon syndra) {
        Syndra = syndra;
    }

    public Campeon getAurelionSol() {
        return AurelionSol;
    }

    public void setAurelionSol(Campeon aurelionSol) {
        AurelionSol = aurelionSol;
    }

    public Campeon getKayn() {
        return Kayn;
    }

    public void setKayn(Campeon kayn) {
        Kayn = kayn;
    }

    public Campeon getZoe() {
        return Zoe;
    }

    public void setZoe(Campeon zoe) {
        Zoe = zoe;
    }

    public Campeon getZyra() {
        return Zyra;
    }

    public void setZyra(Campeon zyra) {
        Zyra = zyra;
    }

    public Campeon getKaisa() {
        return Kaisa;
    }

    public void setKaisa(Campeon kaisa) {
        Kaisa = kaisa;
    }

    public Campeon getGnar() {
        return Gnar;
    }

    public void setGnar(Campeon gnar) {
        Gnar = gnar;
    }

    public Campeon getZac() {
        return Zac;
    }

    public void setZac(Campeon zac) {
        Zac = zac;
    }

    public Campeon getYasuo() {
        return Yasuo;
    }

    public void setYasuo(Campeon yasuo) {
        Yasuo = yasuo;
    }

    public Campeon getVelkoz() {
        return Velkoz;
    }

    public void setVelkoz(Campeon velkoz) {
        Velkoz = velkoz;
    }

    public Campeon getTaliyah() {
        return Taliyah;
    }

    public void setTaliyah(Campeon taliyah) {
        Taliyah = taliyah;
    }

    public Campeon getCamille() {
        return Camille;
    }

    public void setCamille(Campeon camille) {
        Camille = camille;
    }

    public Campeon getBraum() {
        return Braum;
    }

    public void setBraum(Campeon braum) {
        Braum = braum;
    }

    public Campeon getJhin() {
        return Jhin;
    }

    public void setJhin(Campeon jhin) {
        Jhin = jhin;
    }

    public Campeon getKindred() {
        return Kindred;
    }

    public void setKindred(Campeon kindred) {
        Kindred = kindred;
    }

    public Campeon getJinx() {
        return Jinx;
    }

    public void setJinx(Campeon jinx) {
        Jinx = jinx;
    }

    public Campeon getTahmKench() {
        return TahmKench;
    }

    public void setTahmKench(Campeon tahmKench) {
        TahmKench = tahmKench;
    }

    public Campeon getLucian() {
        return Lucian;
    }

    public void setLucian(Campeon lucian) {
        Lucian = lucian;
    }

    public Campeon getZed() {
        return Zed;
    }

    public void setZed(Campeon zed) {
        Zed = zed;
    }

    public Campeon getKled() {
        return Kled;
    }

    public void setKled(Campeon kled) {
        Kled = kled;
    }

    public Campeon getEkko() {
        return Ekko;
    }

    public void setEkko(Campeon ekko) {
        Ekko = ekko;
    }

    public Campeon getVi() {
        return Vi;
    }

    public void setVi(Campeon vi) {
        Vi = vi;
    }

    public Campeon getAatrox() {
        return Aatrox;
    }

    public void setAatrox(Campeon aatrox) {
        Aatrox = aatrox;
    }

    public Campeon getNami() {
        return Nami;
    }

    public void setNami(Campeon nami) {
        Nami = nami;
    }

    public Campeon getAzir() {
        return Azir;
    }

    public void setAzir(Campeon azir) {
        Azir = azir;
    }

    public Campeon getThresh() {
        return Thresh;
    }

    public void setThresh(Campeon thresh) {
        Thresh = thresh;
    }

    public Campeon getIllaoi() {
        return Illaoi;
    }

    public void setIllaoi(Campeon illaoi) {
        Illaoi = illaoi;
    }

    public Campeon getRekSai() {
        return RekSai;
    }

    public void setRekSai(Campeon rekSai) {
        RekSai = rekSai;
    }

    public Campeon getIvern() {
        return Ivern;
    }

    public void setIvern(Campeon ivern) {
        Ivern = ivern;
    }

    public Campeon getKalista() {
        return Kalista;
    }

    public void setKalista(Campeon kalista) {
        Kalista = kalista;
    }

    public Campeon getBard() {
        return Bard;
    }

    public void setBard(Campeon bard) {
        Bard = bard;
    }

    public Campeon getRakan() {
        return Rakan;
    }

    public void setRakan(Campeon rakan) {
        Rakan = rakan;
    }

    public Campeon getXayah() {
        return Xayah;
    }

    public void setXayah(Campeon xayah) {
        Xayah = xayah;
    }

    public Campeon getOrnn() {
        return Ornn;
    }

    public void setOrnn(Campeon ornn) {
        Ornn = ornn;
    }

    public Campeon getPyke() {
        return Pyke;
    }

    public void setPyke(Campeon pyke) {
        Pyke = pyke;
    }
}
