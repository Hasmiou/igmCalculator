package com.sdz.hasmiou.igmcalculator.Services;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public class Serializer {
    /**
     * Cette méthode permet de sérialiser un objet puis l'ajouter dans un fichier
     * @param fileName
     * @param objet
     * @param ctx
     */
    public static void serialize(String fileName, Object objet, Context ctx){
        try{
            FileOutputStream file = ctx.openFileOutput(fileName, ctx.MODE_PRIVATE);
            ObjectOutputStream oos;
            try {
                oos = new ObjectOutputStream(file);
                oos.writeObject(objet);
                oos.flush();
                oos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * Prend en argument un fichier sérialisé puis retourne son contenu au format objet
     * @param fileName
     * @param ctx
     * @return
     */
    public static  Object unSerialize(String fileName, Context ctx){
        try{
            FileInputStream file = ctx.openFileInput(fileName);
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(file);
                try {
                    Object object = ois.readObject();
                    ois.getClass();
                    return object;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }catch (StreamCorruptedException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        return null;
    }
}
