var countYES=0, countNO=0;
function seeValues()
{
 	if  (document.Question.yesno[0].checked==true) {
	      countYES+=1; 
		  alert("Спасибо за участие в опросе!"+"\n"+"Но вы не правы!"+"\n"+"Ренессанс - это эпоха возрождения античной культуры после долгого ее забвения!")}
    else {
	      countNO+=1; 
          alert("Спасибо за участие в опросе!"+"\n"+"Вы оказались правы!")  }
}

function Results()
{
   alert("Согласны с утверждением: "+countYES+",\n"+"не согласны: "+countNO+".");
}		  