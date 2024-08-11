/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_pratico;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author bento
 */
public class MyFile implements Serializable, Comparable<MyFile> {

    //Vai conter em formato String o nome do ficheiro ou diretoria
    private String fileName;

    //vai conter em formato String o caminho do ficheiro ou diretoria
    private String path;

    //vai conter em formato String o tipo de ficheiro que é, se é “.png”, “.jpg”, etc
    private String type;

    //vai conter num long o tamanho de um ficheiro ou diretoria
    private long size;

    //vai conter, em formato Date, a data de criação do ficheiro
    private Date creationDateTime;

    //vai conter, em formato Date, a data da modificação do ficheiro
    private Date modificationDateTime;

    //vai conter, em formato Date a data do último acesso do ficheiro
    private Date lastAccessDateTime;

    //vai conter num inteiro a quantidade de ficheiros que está subjacente a uma diretoria
    private int itens;

    //é um Index logo vai ter um construtor que dará valores aos atributos de ficheiros ou diretorias, logo este subIndex faz com que se crie quantos Index’s quantos ficheiros ou diretorias subjacentes a uma diretoria raiz
    private Index subIndex;

    //vai conter em formato boolean se o Index que se está a criar é um ficheiro e devolve verdadeiro se sim
    private boolean isFile;

    //vai conter em formato boolean se o Index que se está a criar é uma diretoria e devolve verdadeiro se sim
    private boolean isDirectory;

    //vai conter em formato File o ficheiro ou diretoria que se está a construir
    public File f;

    /**
     * Construtor da classe
     *
     * @param path - Path do ficheiro
     * @param fileName - Nome do ficheiro
     */
    public MyFile(String path, String fileName, File f) {
        this.path = path;
        this.fileName = fileName;
        itens = 1;
        this.f = f;
    }

    /**
     * Vai buscar o nome do ficheiro
     *
     * @return esse mesmo nome do ficheiro
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Dá um valor ao nome do ficheiro
     *
     * @param fileName - nome do ficheiro
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Vai retornar o path do ficheiro
     *
     * @return a string do path do ficheiro
     */
    public String getPath() {
        return path;
    }

    /**
     * Dá um valor ao path do ficheiro
     *
     * @param path - string que contém o path do ficheiro
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Vai retornar o tipo de ficheiro: ".jpg", ".png", ".txt", ".exe", etc...
     *
     * @return o tipo de ficheiro
     */
    public String getType() {
        return type;
    }

    /**
     * Dá um valor ao tipo de ficheiro: ".jpg", ".png", ".txt", ".exe", etc...
     *
     * @param type tipo do ficheiro, seja este ".jpg", ".png", ".txt", ".exe",
     * etc...
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Vai retornar o tamanho do ficheiro
     *
     * @return o tamanho do ficheiro
     */
    public long getSize() {
        return size;
    }

    /**
     * Dá um valor ao tamanho do ficheiro
     *
     * @param size - tamanho do ficheiro
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * Vai retornar a data de criação do ficheiro
     *
     * @return a data de criação do ficheiro
     */
    public Date getCreationDateTime() {
        return creationDateTime;
    }

    /**
     * Dá um valor à data de criação do ficheiro
     *
     * @param creationDateTime - data de criação do ficheiro
     */
    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    /**
     * Vai retornar a data de modificação do ficheiro
     *
     * @return a data de modificação do ficheiro
     */
    public Date getModificationDateTime() {
        return modificationDateTime;
    }

    /**
     * Dá um valor à data de modificação do ficheiro
     *
     * @param modificationDateTime - data de modificação do ficheiro
     */
    public void setModificationDateTime(Date modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    /**
     * Vai retornar a data do último acesso do ficheiro
     *
     * @return a data do último acesso do ficheiro
     */
    public Date getLastAccessDateTime() {
        return lastAccessDateTime;
    }

    /**
     * Dá um valor à data do último acesso do ficheiro
     *
     * @param lastAccessDateTime - data do último acesso do ficheiro
     */
    public void setLastAccessDateTime(Date lastAccessDateTime) {
        this.lastAccessDateTime = lastAccessDateTime;
    }

    /**
     * Vai retornar a quantidade de ficheiros duma certa diretoria(int)
     *
     * @return à quantidade de ficheiros duma certa diretoria
     */
    public int getItens() {
        return itens;
    }

    /**
     * Dá um valor à quantidade de ficheiros duma certa diretoria(int)
     *
     * @param itens - quantidade de ficheiros duma certa diretoria
     */
    public void setItens(int itens) {
        this.itens = itens;
    }

    /**
     * Vai retornar os ficheiros subjacentes a um ficheiro (Index)
     *
     * @return - de um Index, com os ficheiros subjacentes a um ficheiro
     */
    public Index getSubIndex() {
        return subIndex;
    }

    /**
     * Dá um Index aos ficheiros subjacentes a um ficheiro
     *
     * @param subIndex - um Index que contém os ficheiros subjacentes a um
     * ficheiros
     */
    public void setSubIndex(Index subIndex) {
        this.subIndex = subIndex;
    }

    /**
     * Vai devolver se é ou não um ficheiro, se não for devolve false, se for um
     * ficheiro, devolve true
     *
     * @return a um boolean que contém a informação se é um ficheiro ou não
     */
    public boolean isIsFile() {
        return isFile;
    }

    /**
     * Atribui-se que é um ficheiro, seja neste caso mandando em parâmetro
     * "true", ou não se neste caso for mandado em parâmetro "false"
     *
     * @param isFile - boolean que contém a informação se é um ficheiro ou não,
     * "true" se for, "false" se não for
     */
    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }

    /**
     * Devolve se é ou não uma diretoria, se não for devole false, se for uma
     * diretoria, devolve true
     *
     * @return a um boolean que contém a informação se é uma diretoria ou não
     */
    public boolean isIsDirectory() {
        return isDirectory;
    }

    /**
     * Atribui-se que é um ficheiro, seja neste caso mandando em parâmetro
     * "true", ou não se neste caso for mandado em parâmetro "false"
     *
     * @param isDirectory - boolean que contém a informação se é uma diretoria
     * ou não, "true" se for, "false" se não for
     */
    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    /**
     * Compara o tamanho de dois ficheiros ou diretorias, para colocar na JTree,
     * de forma decrescente
     *
     * @param o - ficheiro ou diretoria mandada em parâmetro
     * @return a 1 se o ficheiro mandando em parâmetro é maior, retorna a -1 se
     * ficheiro mandando em parâmetro é menor, retorna 0 se for igual
     */
    @Override
    public int compareTo(MyFile o) {
        if (size < o.size) {
            return 1;
        } else if (size > o.size) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Devolve uma string que contém o tamanho de um ficheiro, ou diretoria, e
     * se for uma diretoria também contem o número de ficheiros subjacentes a
     * uma diretoria
     *
     * @return
     */
    @Override
    public String toString() {
        if (isFile) {
            return fileName + " " + getSizeAsText();
        } else {
            return fileName + " " + getSizeAsText() + " " + itens + " itens";
        }
    }

    /**
     * Vai retornar o tamanho de um ficheiro/diretoria em KB - KiloByte
     *
     * @return devolve o tamanho de um ficheiro/diretoria em KB,MB dum ficheiro
     */
    public String getSizeAsText() {
        boolean si = true;
        return humanReadableByteCount(size, si);
    }

    // 
    /**
     * From: https://programming.guide/worlds-most-copied-so-snippet.html
     * Transforma bytes em KB,MB, etc
     *
     * @param bytes - quantidade total de Bytes
     * @param si - flag se quer o valor do tamanho em binário ou não, true se
     * não quiser, false se quer o tamanho em binario
     * @return ao valor de KB,MB, etc dum ficheiro
     */
    public static strictfp String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        long absBytes = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absBytes < unit) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(absBytes) / Math.log(unit));
        long th = (long) Math.ceil(Math.pow(unit, exp) * (unit - 0.05));
        if (exp < 6 && absBytes >= th - ((th & 0xFFF) == 0xD00 ? 51 : 0)) {
            exp++;
        }
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
        if (exp > 4) {
            bytes /= unit;
            exp -= 1;
        }
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
