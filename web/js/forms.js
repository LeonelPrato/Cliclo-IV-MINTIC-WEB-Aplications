$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

function authenticateUser() {

    $.ajax({
        url: "http://localhost:8080/api/user/" + $("input[name=emailLogIn]").val() + "/" + $("input[name=passwordLogIn]").val(),
        type: "GET",
        datatype: "JSON",
        success: function(responseLogIn){
            console.log(responseLogIn);
            $("#resultLogIn").empty();
            if (responseLogIn.name == "NO DEFINIDO"){
                $("#resultLogIn").append("No existe un usuario");
            }else{
                $("#resultLogIn").append("Bienvenido " + "\'" + responseLogIn.name + "\'");
            }
        }
    });
}

function SignInUser() {

    let myData={
        email:$("input[name=emailSignIn]").val(),
        name:$("input[name=nameSignIn]").val(),
        password:$("input[name=passwordSignIn]").val()
    };

    let dataToSend=JSON.stringify(myData);

    $.ajax({
        url:"http://localhost:8080/api/user/new",
        type:"POST",
        contentType: "application/json",
        data:dataToSend,
        datatype:"JSON",
        success:function(responseUsers) {
            $("#resultLogIn").append("Cuenta creada de forma correcta");
        }
    });

}