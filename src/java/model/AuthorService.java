/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Scott
 */
public class AuthorService {
    //LinkedHashMap<String,Object> records = new LinkedHashMap<>();
    public List getAuthors(){
        Author a1 = new Author(01, "David Clark", new Date(62,4,5));
        Author a2 = new Author(02, "Brad Bishop", new Date(62,4,5));
        Author a3 = new Author(03, "Volker Nostrala", new Date(62,4,5));
        //Author a4 = new Author(04, "Matt Marks", LocalDateTime.now());
        
        //List<String> Authors = new ArrayList<>();
        List<Author> Authors = new ArrayList<>();
        
        Authors.add(a1);
        Authors.add(a2);
        Authors.add(a3);
        
        
//        Authors.add(a1.getAuthorName());
//        Authors.add(String.valueOf(a1.getAuthorId()));
//        Authors.add(String.valueOf(a1.getDateAdded()));
//        
//        Authors.add(a2.getAuthorName());
//        Authors.add(String.valueOf(a2.getAuthorId()));
//        Authors.add(String.valueOf(a2.getDateAdded()));
//        
//        Authors.add(a3.getAuthorName());
//        Authors.add(String.valueOf(a3.getAuthorId()));
//        Authors.add(String.valueOf(a3.getDateAdded()));
//        
//        Authors.add(a4.getAuthorName());
//        Authors.add(String.valueOf(a4.getAuthorId()));
//        Authors.add(String.valueOf(a4.getDateAdded()));
        
        return Authors;
    }
}
//    }
//    public List reterive(){
//        List getIt = getAuthors();
//        int index = 0;
//        int COUNTER = 0;
//        List<String> Author1 = new ArrayList();
//        List<String> Author2 = new ArrayList();
//        for(Object e : getIt){
//            if(COUNTER==0||COUNTER==3||COUNTER==9){
//                
//            }
//            COUNTER++;
//        }
//        return Author1;
//    }
//}
////    request.setAttribute("firstAuthorName", aus.getAuthors().get(0));
//    }
    
//    public List getAuthors2(){
//        Author a1 = new Author(01, "David Clark", LocalDateTime.now());
//        Author a2 = new Author(02, "Brad Bishop", LocalDateTime.now());
//        Author a3 = new Author(03, "Volker Nostrala", LocalDateTime.now());
//        Author a4 = new Author(04, "Matt Marks", LocalDateTime.now());
//        
//        List<Author> Authors = new ArrayList<>();
//        Authors.add(a1);
//        Authors.add(a2);
//        Authors.add(a3);
//        Authors.add(a4);
//        
//        List<Map<String,Object>> result = new ArrayList<>();
//        
//            Authors.stream().forEach((a) -> {
//            Map<String,Object> generic = new LinkedHashMap<>();
//            generic.put("authorName", a.getAuthorName());
//            generic.put("authorId", a.getAuthorId());
//            generic.put("dateAdded", a.getDateAdded());
//            result.add(generic);
//                });
//        
//        return  Authors;
//    }
    
    

    
    
//    Testing Purposes - Left in to show a little bit of my process.
//    public static void main(String[] args) {
//        AuthorService aus = new AuthorService();
//        List test = aus.getAuthor1();
//        List test2 = aus.getAuthor2();
//        List test3 = aus.getAuthor3();
//        System.out.println(test + "\n\n\n" + test2 + "\n\n\n" + test3);
//        System.out.println(aus.getAuthors());
//          for(int i = 0; i < 3; i++){
//          System.out.println(aus.getAuthors2());
//          }
//            System.out.println(aus.getAuthors());
//    }
    
//    for(int i = 0; i < 3; i++){
//            System.out.println(aus.reterive());
//        }}
    
//}

