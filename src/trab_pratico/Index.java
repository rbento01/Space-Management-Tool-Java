/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_pratico;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

/**
 * author
 *
 * @author bento
 */
public class Index {

    //Cria-se um array list de ficheiros com o nome de "itens"
    ArrayList<MyFile> itens;

    //Cria-se um ficheiro inicial
    MyFile ini;

    /**
     * Construtor que constrói basicamente o File Chooser, vai ditar uma
     * diretoria e todos os ficheiros e diretorias subjacente a esta
     *
     * @param start - Diretoria inicial
     */
    public Index(String start) throws IOException {

        //Array List que contém ficheiros/diretorias
        itens = new ArrayList();

        //diretoria inicial com a classe File
        File base = new File(start);

        //ficheiro inicial com a classe MyIndex
        ini = new MyFile(base.getPath(), base.getName(), base);

        //Vai-se buscar os atributos de um certo ficheiro usando a classe BasicFileAttributes, sendo neste caso o ficheiro/diretoria inicial
        BasicFileAttributes attr = Files.readAttributes(base.toPath(), BasicFileAttributes.class);

        //Vai atribuir a data de criação do ficheiro
        ini.setCreationDateTime(new Date(attr.creationTime().toMillis()));

        //Vai atribuir a data do último acesso do ficheiro em milisegundos
        ini.setLastAccessDateTime(new Date(attr.lastAccessTime().toMillis()));

        //Vai atribuir a data de modificação do ficheiro em milisegundos
        ini.setModificationDateTime(new Date(attr.lastModifiedTime().toMillis()));

        //Vai atribuir o boolean se é uma diretoria, se for devolve "true", se não for devolve "false"
        ini.setIsDirectory(base.isDirectory());

        //Vai atribuir o boolean se é um ficheiro, se for devolve "true", se não for devolve "false"
        ini.setIsFile(base.isFile());

        //Vai atribuir os ficheiros subjacentes a um ficheiro
        ini.setSubIndex(this);

        //Vai conter todos os ficheiros e/ou diretorias da diretoria inicial
        File conteudo[] = base.listFiles();

        //Vai iterar e colocar no File file todo o conteúdo de "conteudo", indo de 1 a 1 querendo dizer que "file" vai conter todos os ficheiros do ficheiro/diretoria inicial
        for (File file : conteudo) {

            //Cria um novo MyFile com o primeiro, depois o segundo, etc..., ficheiro
            MyFile f = new MyFile(file.getPath(), file.getName(), file);

            //Vai à classe MyFile e insere o tamanho do ficheiro
            f.setSize(file.length());

            //Vai à classe MyFile e insere o tipo do ficheiro, ".jpg", ".png", etc.
            f.setType(file.getName().substring(file.getName().lastIndexOf(".") + 1));

            //Vai-se atribuir os atributos do ficheiro
            attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);

            //Vai atribuir a data de criação do ficheiro
            f.setCreationDateTime(new Date(attr.creationTime().toMillis()));

            //Vai atribuir a data do último acesso do ficheiro
            f.setLastAccessDateTime(new Date(attr.lastAccessTime().toMillis()));

            //Vai atribuir a data de modificação do ficheiro
            f.setModificationDateTime(new Date(attr.lastModifiedTime().toMillis()));

            //Vai atribuir se é ou não uma diretoria
            f.setIsDirectory(file.isDirectory());

            //Vai atribuir se é ou não um ficheiro 
            f.setIsFile(file.isFile());

            //No caso de ser uma diretoria
            if (file.isDirectory()) {
                //Vai repetir o processo todo, buscando os ficheiros todos de uma diretoria
                f.setSubIndex(new Index(file.getPath()));

                //Vai buscar o resultado da soma de tamanhos entre todos os ficheiros de uma certa diretoria
                f.setSize(f.getSubIndex().getSize());

                //Vai buscar o número total de ficheiros de uma certa diretoria
                f.setItens(f.getSubIndex().getItens());
            }
            //Coloca toda a informação obtida no Array List "itens"
            itens.add(f);

        }
        //Vai ordenar os elementos de ArrayList
        Collections.sort(itens);
    }

    /**
     * Vai buscar a base
     *
     * @return um MyFile contendo as informações da base
     */
    public MyFile getBase() {
        return ini;
    }

    /**
     * Dá um valor ao ficheiro inicial
     *
     * @param ini MyFyle do ficheiro inicial
     */
    public void setBase(MyFile ini) {
        this.ini = ini;
    }

    /**
     * Vai somar os tamanhos dos ficheiros de uma certa diretoria
     *
     * @return o tamanho dos ficheiros de uma certa diretoria
     */
    public long getSize() {
        //Inicia-se o valor da soma a 0
        long s = 0;

        //Vai-se iterar em que o MyFile f tenha todos os valores do Array List itens
        for (MyFile f : itens) {
            //Somatório do tamanho de todos os ficheiros
            s += f.getSize();
        }
        //Retorna da soma
        return s;
    }

    /**
     * Vai obter a quantidade total de ficheiros de uma certa diretoria
     *
     * @return a quantidade total de ficheiros de uma certa diretoria
     */
    public int getItens() {
        //Inicia-se a quantidade de ficheiros a 0
        int s = 0;

        //Vai-se iterar em que o MyFile f tenha todos os valores do Array List itens
        for (MyFile f : itens) {
            //Somatório da quantidade de ficheiros 
            s += f.getItens();
        }
        //Retorna a quantidade total de ficheiros de uma certa diretoria
        return s;
    }

    /**
     * Vai criar uma árvore com os MyFiles, com a restrição dos meses
     *
     * @param root - raiz da árvore
     */
    public void createTreeMes(MyTreeNode root, int indexMes) throws IOException, java.lang.NullPointerException {
        //Vai iterar este for para cada um das diretorias e ficheiros
        for (MyFile f : itens) {
            //Vai criar um MyTreeNode com o ficheiro ou diretoria em questão
            MyTreeNode item = new MyTreeNode(f.toString(), f.f);

            //Vai criar um File com a diretoria do ficheiro ou diretoria
            File aux = new File(f.getPath());

            //Vai obter em formato Date o tempo atual
            Date referenceDate = new Date(System.currentTimeMillis());

            //Vai obter em formato Calendar a time zone e o tempo
            Calendar c = Calendar.getInstance();

            //Transfere do formato Date para um formato Calendar
            c.setTime(referenceDate);

            //Retira "indexMes" ao tempo atual
            c.add(Calendar.MONTH, -(indexMes));

            //Vai obter os atributos do ficheiro ou diretoria em questão
            BasicFileAttributes tempo = Files.readAttributes(aux.toPath(), BasicFileAttributes.class);

            //Vai obter em formato Date a data de ultimo acesso do ficheiro ou diretoria em questão
            Date ultAced = new Date(tempo.lastAccessTime().toMillis());

            //Se for uma diretoria
            if (f.isIsDirectory()) {
                //adiciona na árvore
                root.add(item);
                //se ainda tiver mais que 0 ficheiros ou diretorias subjacentes a uma certa diretoria continua a adiconar 
                if (f.getSubIndex() != null) {
                    //vai criar a árvore 
                    f.getSubIndex().createTreeMes(item, indexMes);
                }
                //No entanto se for um ficheiro, tem que se comparar o tempo atual, com o tempo que o ficheiro foi acessado, se o tempo de acesso for maior que a data atual menos indexMes's mostra na árvore  
            } else if (ultAced.before(c.getTime())) {
                //adiciona na raiz da árvore
                root.add(item);
                //se ainda tiver mais que 0 ficheiros ou diretorias subjacentes a uma certa diretoria continua a adiconar 
                if (f.getSubIndex() != null) {
                    ////vai criar a árvore 
                    f.getSubIndex().createTreeMes(item, indexMes);
                }
            }
        }
    }

    void createTreeTerm(MyTreeNode root, String string) throws IOException, java.lang.NullPointerException {
        //Vai iterar este for para cada um das diretorias e ficheiros
        for (MyFile f : itens) {
            //Vai criar um MyTreeNode com o ficheiro ou diretoria em questão
            MyTreeNode item = new MyTreeNode(f.toString(), f.f);

            //Se for uma diretoria
            if (f.isIsDirectory()) {
                //adiciona na árvore
                root.add(item);
                //se ainda tiver mais que 0 ficheiros ou diretorias subjacentes a uma certa diretoria continua a adiconar 
                if (f.getSubIndex() != null) {
                    //vai criar a árvore 
                    f.getSubIndex().createTreeTerm(item, string);
                }
                //No entanto, se for um ficheiro, temos que verificar se a terminação que o utilizador, com o terminação do tipo de ficheiro, se for entra no else if
            } else if (f.getType().equals(string) || string.equals("." + f.getType())) {
                //Se for uma diretoria
                root.add(item);
                //se ainda tiver mais que 0 ficheiros ou diretorias subjacentes a uma certa diretoria continua a adiconar 
                if (f.getSubIndex() != null) {
                    //vai criar a árvore 
                    f.getSubIndex().createTreeTerm(item, string);
                }
            }
        }
    }

    void createTreeMesTerm(MyTreeNode root, int indexMes, String string) throws IOException, java.lang.NullPointerException {
        //Vai iterar este for para cada um das diretorias e ficheiros
        for (MyFile f : itens) {
            //Vai criar um MyTreeNode com o ficheiro ou diretoria em questão
            MyTreeNode item = new MyTreeNode(f.toString(), f.f);

            //Vai criar um File com a diretoria do ficheiro ou diretoria
            File aux = new File(f.getPath());

            //Vai obter em formato Date o tempo atual
            Date referenceDate = new Date(System.currentTimeMillis());

            //Vai obter em formato Calendar a time zone e o tempo
            Calendar c = Calendar.getInstance();

            //Transfere do formato Date para um formato Calendar
            c.setTime(referenceDate);

            //Retira "indexMes" ao tempo atual
            c.add(Calendar.MONTH, -(indexMes));

            //Vai obter os atributos do ficheiro ou diretoria em questão
            BasicFileAttributes tempo = Files.readAttributes(aux.toPath(), BasicFileAttributes.class);

            //Vai obter em formato Date a data de ultimo acesso do ficheiro ou diretoria em questão
            Date ultAced = new Date(tempo.lastAccessTime().toMillis());

            //Se for uma diretoria
            if (f.isIsDirectory()) {
                //adiciona à tree
                root.add(item);
                //se ainda tiver mais que 0 ficheiros ou diretorias subjacentes a uma certa diretoria continua a adiconar 
                if (f.getSubIndex() != null) {
                    //cria a árvore
                    f.getSubIndex().createTreeTerm(item, string);
                }
                //No entanto, se a o utilizador colocou duas restrições, temos que verificar com ambos os createTree previamente feitos, logo temos que ir ver a terminação e a diferença de meses
            } else if ((f.getType().equals(string) || string.equals("." + f.getType())) && ultAced.before(c.getTime())) {
                //adiciona à arvore
                root.add(item);
                if (f.getSubIndex() != null) {
                    //Vai criar a árvore
                    f.getSubIndex().createTreeTerm(item, string);
                }
            }
        }
    }
}
