import java.sql.*;
import java.util.ArrayList;

public class JDBC_Main {


    public static void main(String[] args) throws SQLException {

        Connection connection = null;//baglantiyi connectionkilasi ile sagliyoruz.Baglantiyi yapamama durumuna karsi try catch yapacagiz

        DbHelper helper=new DbHelper();
        Statement statement=null; // statement =cumle,ifade,cumlecik.Bu bizim SQL cumlecigimizle ilgili islemleri yapacak
        ResultSet resultSet; //Sonuclar

        try {

            connection=helper.getConnetcion();
            statement=connection.createStatement();//gonderilecek sorgu bu baglantiya gidecek
            resultSet=statement.executeQuery("SELECT TOP (1000) [firstName]\n" +    //execute calistir  demek bu sorguyu calistir
                    "      ,[lastName]\n" +
                    "  FROM [CoolSIS_111].[dbo].[stdApplications]");//resultSet bu sql cumlecigini calistir demek
            ArrayList<Student> students=new ArrayList<Student>();


            while (resultSet.next()){ //bu tek tek gez demek
                System.out.println(resultSet.getString("firstName")+"             "+resultSet.getString("lastName"));
                students.add(new Student(resultSet.getString("firstName"),resultSet.getString("lastName")));

            }
            System.out.println(students.size());
           // connection = DriverManager.getConnection(dbURL, username, password);//drivermanager bizim driverlar konnektorlere ulasmamizi saglayan onlari yoneten class
           // System.out.println("Baglanti olustu");//bu basarsa baglantimiz var demek
        } catch (SQLException exception) {
            //System.out.println(exception.getMessage());//bunu hatayi gormek icinyapiyorum
            helper.showErrorMessage(exception);
        }
        finally {
            connection.close();//buda isimiz bittiginde baglantiyi kapatiyor
        }
    }
}
