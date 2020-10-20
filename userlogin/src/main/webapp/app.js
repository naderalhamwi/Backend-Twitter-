const body = `{
    "username": "Test",
    "password": "Test123",
    "email": "Test@gmail.com",
    "phonenumber": "1234567890"
  }`;
  
  const init = {
    method: 'GET',
    body
  };
  
  fetch('http://localhost:8080/userlogin/resources/user', init)
  .then((response) => {
    return response.json(); // or .text() or .blob() ...
  })
  .then((text) => {
    // text is the response body
  })
  .catch((e) => {
    // error in e.message
  });