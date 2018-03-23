import cn.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Text2018031 {
    //添加图书
    @Test
    public void t2Insert(){
        String path="MyBatis-config.xml";
        try {
            InputStream is=Resources.getResourceAsStream(path);
            //3创建SqlSessionFactory
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
            //4创建SqlSession
            SqlSession session=factory.openSession();
            Book book=new Book();

            book.setBookName("未来已来");
            book.setBookAuthor("马云");
            book.setBookID(6);
            book.setBookPrice("261");
            //执行
            int count = session.insert("addBook", book);
            session.commit();
            if (count>0){
                System.out.println("add OK!");
            }else {
                System.out.println("add failed");
            }
            //6关闭
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void t1() {
        //1.
        String path= "MyBatis-config.xml";
        //2.输入流
        try {
            InputStream is= Resources.getResourceAsStream(path);
            //3.
            SqlSessionFactoryBuilder build=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=build.build(is);
            SqlSession sqlSession = factory.openSession();
            List<Book> list=sqlSession.selectList("findAIIBooks");
            System.out.println(list.size());
            for (Book book:list) {
                System.out.println(book.getBookName());
            }
            //6关闭
          sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }







}
