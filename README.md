# Backend-Twitter-

Tester med hjälp av ARC:
  länken = (http://localhost:8080/userlogin/resources/user).
  Importera databasens filen (usersinfo.sql) med hjälp av XAMPP och starta den.  
  använda länken övan för att kunna skapa, tarbort eller ändara en användare. 
  -1 att skapa användare:
      Glömm ej att starta XAMPP app för databasen !
      a) i ARC program så behöver man ange länken för sitt webbserver app.
      b) man väljer metoden POST.
      c) sedan på HEADERS så skapar man en header, header namne ska vara (Content-Type), och Parameter value ska vara (text/plain)
      d) man gå sedan till BODY där väljer man i Body content type (text/plain). 
      e) skriver man följande json fil {"username":"Test","password":"Test123","email":"Test@gmail.com","phonenumber":"1234567890"}.
      f) Tryck på SEND
      resultatet:
        användaren "Test" ska skapas och sparas på databasen om den inte fins, om den fins så kommer den inte skapas en gång till, då får man ett fel medelande på programet  
   -2 att ändra en användare:
      Glömm ej att starta XAMPP app för databasen !
