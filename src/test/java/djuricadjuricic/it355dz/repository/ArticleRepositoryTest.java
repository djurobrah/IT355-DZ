/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package djuricadjuricic.it355dz.repository;

import djuricadjuricic.it355dz.domain.Article;
import djuricadjuricic.it355dz.service.DataLoader;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Djurica Djuricic
 */
public class ArticleRepositoryTest
{
    @Autowired
    DataLoader dataLoader;
    
    @Autowired
    ArticleRepository articleRepository;
    
    @Test
    public void testFindBySlug()
    {
        System.out.println("findBySlug");
        String slug = "";
//        ArticleRepository instance = new ArticleRepositoryImpl();
        Article expResult = null;
        //Article result = instance.findBySlug(slug);
        assertEquals(expResult, result);
    }

    /**
//     * Test of findArticlesByOrderByPostedDesc method, of class ArticleRepository.
//     */
//    @Test
//    public void testFindArticlesByOrderByPostedDesc()
//    {
//        System.out.println("findArticlesByOrderByPostedDesc");
//        ArticleRepository instance = new ArticleRepositoryImpl();
//        Iterable<Article> expResult = null;
//        Iterable<Article> result = instance.findArticlesByOrderByPostedDesc();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAllByUser_id method, of class ArticleRepository.
//     */
//    @Test
//    public void testFindAllByUser_id()
//    {
//        System.out.println("findAllByUser_id");
//        long userID = 0L;
//        ArticleRepository instance = new ArticleRepositoryImpl();
//        Iterable<Article> expResult = null;
//        Iterable<Article> result = instance.findAllByUser_id(userID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
}
