function getInformationUsers(){
    $.ajax({
        url: "http://localhost:8080/api/user/all",
        type: "GET",
        datatype: "JSON",
        success: function(responseUsers){
            console.log(responseUsers);
            $("#resultUsers").empty();
            printResponseUsers(responseUsers);
        }
    });
}

function printResponseUsers(items){

    let myTable = "<table border=1>";

    myTable += "<tr><thead><th>Id</th><th>Email</th><th>Name</th><th>Pasword</th></thead></tr>";

    for(i=0; i<items.length; i++) {
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].password + "</td>";
        myTable += "</tr>";
    }

    myTable += "</table>";

    $("#resultUsers").append(myTable);
}

function saveInformationUsers(){
    let myData={
        email:$("#emailUser").val(),
        name:$("#nameUser").val(),
        password:$("#passwordUser").val()
    };

    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:"http://localhost:8080/api/user/new",
        type:"POST",
        contentType: "application/json",
        data:dataToSend,
        datatype:"JSON",
        success:function(responseUsers) {
            $("#resultUsers").empty();
            $("#idUser").val("");
            $("#emailUser").val("");
            $("#nameUser").val("");
            $("#passwordUser").val("");
            getInformationUsers();
            alert("Se ha guardado un Usuario.")
        }
    });
}