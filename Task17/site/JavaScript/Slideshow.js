var img=new Array();
img[0]=new Image(); img[0].src="image/mikelandhelo/1.jpg";
img[1]=new Image(); img[1].src="image/mikelandhelo/2.jpg";
img[2]=new Image(); img[2].src="image/mikelandhelo/3.jpg";
img[3]=new Image(); img[3].src="image/mikelandhelo/4.jpg";
img[4]=new Image(); img[4].src="image/mikelandhelo/5.jpg";
img[5]=new Image(); img[5].src="image/mikelandhelo/6.jpg";
img[6]=new Image(); img[6].src="image/mikelandhelo/7.jpg";

var interval=1000; 
var n=1;
var pause;
var k = 0;
function Start()
{
 k++;
 if (k==1)
   Changed();
}   
function Changed()
{
  document.images.slide.src=img[n].src;
  (n==(img.length-1))?n=0:n++;
  pause = setTimeout("Changed()",interval);
}

function Stop()
{
 k = 0;
 clearTimeout(pause);
} 