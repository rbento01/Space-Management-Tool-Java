/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_pratico;

import java.io.File;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author bento
 */
public class MyTreeNode extends DefaultMutableTreeNode {

    //Vai conter a informação em File de cada nodo da árvore
    public File file;

    public MyTreeNode(String o, File f) {
        super(o);
        file = f;
    }

}
