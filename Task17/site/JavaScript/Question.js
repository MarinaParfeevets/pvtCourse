var countYES=0, countNO=0;
function seeValues()
{
 	if  (document.Question.yesno[0].checked==true) {
	      countYES+=1; 
		  alert("������� �� ������� � ������!"+"\n"+"�� �� �� �����!"+"\n"+"��������� - ��� ����� ����������� �������� �������� ����� ������� �� ��������!")}
    else {
	      countNO+=1; 
          alert("������� �� ������� � ������!"+"\n"+"�� ��������� �����!")  }
}

function Results()
{
   alert("�������� � ������������: "+countYES+",\n"+"�� ��������: "+countNO+".");
}		  