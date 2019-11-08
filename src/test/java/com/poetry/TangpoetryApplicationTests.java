package com.poetry;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TangpoetryApplicationTests {



    @Test
    public void contextLoads() throws Exception{
        /*for(int i = 20000; i < 58000; i=i+1000) {
//            String filePathh = "D:/poem/tang/poet.tang.zh.20000.json";
//            String sqlPath = "D:/poem/sql/poem.tang.zh.20000.sql";
            String filePathh = "D:/poem/tang/poet.tang.zh."+i+".json";
            String sqlPath = "D:/poem/sql/poem.tang.zh."+i+".sql";
            InputStream inputStream = new FileInputStream(filePathh);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            List<Poem> poems = JSON.parseArray(sb.toString(), Poem.class);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sqlPath, true)));
            for (Poem poem : poems) {
                String p = poem.getParagraphs();
                p = p.replace("[\"", "");
                p = p.replace("\"]", "");
                p = p.replace("\",\"", "");
                poem.setParagraphs(p);

                String s = poem.getStrains();
                s = s.replace("[\"", "");
                s = s.replace("\"]", "");
                s = s.replace("\",\"", "");
                poem.setStrains(s);

                String sql = "insert into tang(TITLE,POEM,AUTHOR,STRAINS) VALUES ('" + poem.getTitle() + "','" + poem.getParagraphs() + "','" + poem.getAuthor() + "','" + poem.getStrains() + "');";
                out.write(sql);
                out.write("\n");
                out.flush();
            }
            out.close();
        }
        */
    }

    @Test
    public void ChangPoet() throws Exception{
      /*  String filePathh = "D:/poem/tang/poet.tang.zh.20000.json";
        InputStream inputStream = new FileInputStream(filePathh);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line=br.readLine())!=null){
            sb.append(line);
        }
        List<Poet> poets = JSON.parseArray(sb.toString(), Poet.class);
        String sqlPath = "D:/poet.tang.0.sql";
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sqlPath,true)));
        for(int i=0;i<poets.size(); i++){
            Poet poet = poets.get(i);
            String num =getNumber(i+1+"");
            String sql = "insert into poet(NAME,DESCRIPTION,NUM,TYPE) VALUES ('"+ poet.getName()+"','"+poet.getDesc()+"','"+num+"',1);";
            out.write(sql);
            out.write("\n");
            out.flush();
        }
        out.close();
        */
    }

    public String getNumber(String n){
        String num="P";
        for(int i=0;i<5-n.length(); i++){
            num+="0";
        }
        num+=n;
        return num;
    }
}
