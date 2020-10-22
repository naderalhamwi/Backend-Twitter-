document.getElementById("getData").addEventListener("click", event=>{
  saveData();
  event.preventDefault();
});

document.getElementById("loginB").addEventListener("click", event=>{
  getData();
  event.preventDefault();
});

function saveData(){
  let form = document.getElementById("rigisterform");
  let name = form.elements.name.value;
  let password = form.elements.password.value;
  let email = form.elements.email.value;
  let phonenumber = form.elements.phoneNumber.value;

  

  let data = {
    "username" : name,
    "password": password,
    "email": email,
    "phonenumber": phonenumber
  };

  postMethod(data);


}

function  postMethod(data){
    fetch('http://localhost:8080/userlogin/resources/user',{
      method: 'POST',
      headers:{
        'Content-Type': 'text/plain',
      },
      body: JSON.stringify(data),
    })
    .then((response) => {
      window.open("Home.html", target = "_self");
      return response.json();
    })
    .then((data) => {

    })
    .catch((e) => {

  });
}


function getData(){
  let form = document.getElementById("loginform");

  let email = form.elements.email.value;
  let password = form.elements.password.value;

  let data = {
    "email": email,
    "password": password,
  };


  getMethod(data);

}


function getMethod(data){
  let base64 = require('base-64');


let headers = new Headers();

//headers.append('Content-Type', 'text/json');
headers.append('Authorization', 'Basic' + base64.encode(data[email] + ":" + data[password]));

fetch('http://localhost:8080/userlogin/resources/user',{
      method: 'GET',
      headers
    })
    .then((response) => {
      window.open("Home.html", target = "_self");
      return response.json();
    })
    .then((data) => {

    })
    .catch((e) => {

  });
}