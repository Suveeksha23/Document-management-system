/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 *
 */

class TimePair
{
    File file;
    Document d;

    public TimePair(File file,Document d) 
    {
        this.file=file;
        this.d=d;
    }
}

public class handlerClass {
    static List<Category> categoryList=new ArrayList<>();
    static List<Document> documentList=new ArrayList<>();
    static List<Topic> topicList=new ArrayList<>();
    static Set<String> tagSet = new HashSet<>();

    static public void addNewCategory(int categoryId,String categoryName){
        categoryList.add(new Category(categoryId,categoryName));
    }
    
    static public void addNewDocument(int categoryId, int topicId, int documentId, Tag documentTags, String documentName){
        documentList.add(new Document(categoryId, topicId, documentId, documentTags, documentName));
    }
    
    static public void addNewTopic(int topicId, String topicName, String folderPath){
        topicList.add(new Topic(topicId, topicName, folderPath));
    }
    
    static public void addNewTag(String documentName,String tag)
    {
        for(int i=0;i<documentList.size();i++)
        {
            Document d=documentList.get(i);
            if(d.getDocumentName().equals(documentName))
                d.getDocumentTags().tagList.add(tag);
        }
    }
    
   
    static public void deleteCategory(String categoryName)
    {
        Iterator itr=categoryList.iterator();
        int cId=-1;
        while(itr.hasNext())
        {
            Category c=(Category)itr.next();
            if(c.getCategoryName().equals(categoryName))
            {
                cId=c.getCategoryId();
                itr.remove();
                break;
            }
        }
        
        if(cId!=-1)
        {
            itr=documentList.iterator();
            while(itr.hasNext())
            {
                Document d=(Document)itr.next();
                //if document with same category as one deleted above is found delete it
                
                if(d.getCategoryId()==cId)
                {
                    String path = "";
                    for(int i=0;i<topicList.size();i++)
                    {
                        if(topicList.get(i).getTopicId() == d.getTopicId())
                        {
                            path = topicList.get(i).getFolderPath() +"/" +d.getDocumentName();
                        }
                    }
                    Runtime ob = Runtime.getRuntime();
                    try
                    {
                        ob.exec("rm "+path);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    itr.remove();
                }
            }
        }
        else
            JOptionPane.showMessageDialog(null,"error in delete document");
    }
    
    static public void deleteDocument(String documentName, int topicId)
    {
        Iterator itr=documentList.iterator();
        while(itr.hasNext())
        {
            Document c=(Document)itr.next();
            if(c.getDocumentName().equals(documentName) && c.getTopicId() == topicId)
            {
                itr.remove();
                String path = "";
                for(int i=0;i<topicList.size();i++)
                {
                    if(topicList.get(i).getTopicId() == topicId)
                    {
                        path = topicList.get(i).getFolderPath() +"/" +documentName;
                    }
                }
                Runtime ob = Runtime.getRuntime();
                try
                {
                    ob.exec("rm "+path);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
    
    static public void deleteTopic(String topicName)
    {
        Iterator itr=topicList.iterator();
        int tId=-1;
        String path = "";
        String path2 = "";
        while(itr.hasNext())
        {
            Topic t=(Topic)itr.next();
            if(t.getTopicName().equals(topicName))
            {
                tId = t.getTopicId();
                path2 += t.getFolderPath();
                path += t.getFolderPath();
                itr.remove();
                break;
            }
        }
        if(tId!=-1)
        {
            itr=documentList.iterator();
            Runtime ob = Runtime.getRuntime();
            while(itr.hasNext())
            {
                Document d=(Document)itr.next();
                //if document with same category as one deleted above is found delete it 
                if(d.getTopicId() == tId)
                {
                    path += "/";
                    path += d.getDocumentName();
                    try
                    {
                        ob.exec("rm "+path);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    itr.remove();
                }
            }
            try
            {
                ob.exec("rm "+path2);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"error in delete topic");
    }
    
    
    static public void populateCategory()
    {
        try 
        {
            File file=new File("category.txt");
            Scanner sc=new Scanner(file);

            while (sc.hasNextLine())
            {
                String details[] = sc.nextLine().split(" ");
                String categoryName = details[1];
                int categoryID =   Integer.parseInt(details[0]);
                addNewCategory(categoryID, categoryName);
            }
            sc.close();
        } 
        catch (Exception e) 
        {
            System.out.println("miniproject.handlerClass.populateCategory()");
        }
        
    }
    
       
    static public void populateDocument()
    {
        try 
        {
            File file=new File("document.txt");
            Scanner sc=new Scanner(file);

            while (sc.hasNextLine())
            {
                String details[] = sc.nextLine().split(" ");
                int documentID = Integer.parseInt(details[0]);
                int categoryID = Integer.parseInt(details[1]);
                int topicID = Integer.parseInt(details[2]);
                String tag = details[3];
                                
                Tag documentTag=new Tag();
                
                documentTag.tagList=new ArrayList<>(Arrays.asList(tag.split(",")));
                tagSet.addAll(documentTag.tagList);

                String fileName = details[4];
                addNewDocument(categoryID, topicID, documentID, documentTag, fileName);
            }
            sc.close();
        } 
        catch (Exception e) 
        {
            System.out.println("miniproject.handlerClass.populateDocument()");
        }
        
    }
    
    static public void populateTopic()
    {
        try 
        {
            File file=new File("topic.txt");
            Scanner sc=new Scanner(file);

            while (sc.hasNextLine())
            {    
                String details[] = sc.nextLine().split(" ");
                int topicID = Integer.parseInt(details[0]);
                String topicName = details[1];
                String folderPath = details[2];
                addNewTopic(topicID,topicName,folderPath);
            }
            sc.close();
        } 
        catch (Exception e) 
        {
            System.out.println("miniproject.handlerClass.populateDocument()");
        }
    }
    
    public static void populateEverything()
    {
        populateDocument();
        populateCategory();
        populateTopic();
    }
    
    static public void exportData()
    {
        try 
        {
              
            FileWriter file;
            file=new FileWriter("document.txt");
            for(Document d : documentList)
            {
                String tagString="";
                for(String s : d.getDocumentTags().tagList )
                {
                    tagString=tagString+ s + ",";
                }
                tagString=tagString.substring(0, tagString.length() -1 );
                file.write(d.getDocumentId()+" "+d.getCategoryId()+" "+d.getTopicId()+" "+tagString+" "+d.getDocumentName()+"\n");
            }
            file.close();
            file=new FileWriter("topic.txt");
            for(Topic t : topicList)
                file.write(t.getTopicId()+" "+t.getTopicName()+" "+t.getFolderPath()+"\n");
            file.close();
            file=new FileWriter("category.txt");
            for(Category c : categoryList)
                file.write(c.getCategoryId()+" "+c.getCategoryName()+"\n");
            
            file.close();
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    static public void importData()
    {
        documentList=new ArrayList<>();
        categoryList=new ArrayList<>();
        topicList=new ArrayList<>();
        
        populateEverything();
    }
    
    static public void printDocumentList()
    {
        for(int i=0;i<documentList.size();i++)
        {
            System.out.println(documentList.get(i).getDocumentName() + " "+documentList.get(i).getTopicId());
        }
    }
}
