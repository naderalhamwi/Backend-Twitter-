document.getElementById("getData").addEventListener("click", gty);

let name = document.forms["rigisterform"]["name"].value;

let data = {
  "username" : name,
  "password": "Test123",
  "email": "Test@gmail.com",
  "phonenumber": "1234567890"
};

let headers = new Headers();
headers.append('Content-Type', 'text/plain');

let post = {
  method: 'POST',
  headers,
  body: JSON.stringify(data),
};

let get = {
  method: 'Get',
  headers,
  body: JSON.stringify(data),
};

function gty(){
  
    fetch('http://localhost:8080/userlogin/resources/user', post)
    .then((response) => {

      return response.json();
    })
    .then((data) => {

    })
    .catch((e) => {

  });

}