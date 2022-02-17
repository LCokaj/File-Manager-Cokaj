package com.example.cokajsl;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Gestore
{
    String nomefile;

    public Gestore()
    {

    }
    public String leggiFIle(String nomefile, Context c)
    {
        String testo;
        StringBuilder concatena= new StringBuilder();

        try {
            BufferedReader fileDaLeggere=new BufferedReader(
                    new InputStreamReader(c.openFileInput(nomefile)));
            while((testo=fileDaLeggere.readLine())!=null){
                concatena.append(testo+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return concatena.toString();
    }
    public String scriviFile(String nomefile,Context c)
    {
        FileOutputStream fileDaScrivere;
        String risultato="";
        String cfile="leon";
        try {
            fileDaScrivere=c.openFileOutput(nomefile,Context.MODE_PRIVATE);
            fileDaScrivere.write(cfile.getBytes());
            fileDaScrivere.close();
            risultato="Scrittua andata a buon fine";
        } catch (FileNotFoundException e) {
         risultato="Impossibile trovare il file";
        } catch (IOException e) {
            risultato="Errore di I/O";
        }


        return risultato;

    }
}
