
/**
 * Function for to login of the users
 * @returns
 */
function login(){
	$.ajax({
		type: "GET",
		url: "/user/login/" + $("#documento").val() +"/"+ $("#password").val(),
		success: function(resp){
			localStorage.setItem("user",$("#documento").val())
			if(resp==true){
				swal({
					  title: "Correcto",
					  text: "Ingreso con exito",
					  icon: "success",
					  timer: 3000
				});
				location.href="/inicio.html"				
			}else{
				swal({
					  title: "Error",
					  text: "Usuario no existe",
					  icon: "error",
				});
			}			
		},
		error: function(XMLHttpRequest, textStatus, errorThrown) { 
			swal({
				  title: "Error",
				  text: "Usuario no existe",
				  icon: "error",
			}); 
        }
	})
}