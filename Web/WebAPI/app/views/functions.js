<script type="text/javascript">
 function changeBackground(boton)
 {
	alert("!");
 	var campo=boton.id;	 
 	var general=document.getElementById("general");
 	switch (campo) {
 	case 'red': general.style.background-color='FF0000';
 		break;
	case 'blue': general.style.background-color='00CCFF';
 		break;
	case 'green': general.style.background-color='00FF00';
 		break;
	case 'yellow': general.style.background-color='FFFF00';
 		break;
	case 'pink': general.style.background-color='FF0099';
 		break;
 	}		
 };
 </script>