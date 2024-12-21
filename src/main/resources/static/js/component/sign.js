	var can;
	var ct;
	var ox=0,oy=0,x=0,y=0;
	var mf=false;
	  function mam_draw_init(){
	    //初期設定
	    can=document.getElementById("can2");
	    can.addEventListener("touchstart",onDown,false);
	    can.addEventListener("touchmove",onMove,false);
	    can.addEventListener("touchend",onUp,false);
	    can.addEventListener("mousedown",onMouseDown,false);
	    can.addEventListener("mousemove",onMouseMove,false);
	    can.addEventListener("mouseup",onMouseUp,false);
	    ct=can.getContext("2d");
	    ct.strokeStyle="#000000";
	    ct.lineWidth=5;
	    ct.lineJoin="round";
	    ct.lineCap="round";
	    //clearCan2();
	  }
	  function onDown(event){
	    mf=true;
	    ox=event.touches[0].clientX-event.target.getBoundingClientRect().left;
	    oy=event.touches[0].clientY-event.target.getBoundingClientRect().top;
	    event.stopPropagation();
	  }
	  function onMove(event){
	    if(mf){
	      x=event.touches[0].clientX-event.target.getBoundingClientRect().left;
	      y=event.touches[0].clientY-event.target.getBoundingClientRect().top;
	      drawLine();
	      ox=x;
	      oy=y;
	      event.preventDefault();
	      event.stopPropagation();
	    }
	  }
	  function onUp(event){
	    mf=false;
	    event.stopPropagation();
	  }

	  function onMouseDown(event){
	    ox=event.clientX-event.target.getBoundingClientRect().left;
	    oy=event.clientY-event.target.getBoundingClientRect().top ;
	    mf=true;
	  }
	  function onMouseMove(event){
	    if(mf){
	      x=event.clientX-event.target.getBoundingClientRect().left;
	      y=event.clientY-event.target.getBoundingClientRect().top ;
	      drawLine();
	      ox=x;
	      oy=y;
	    }
	  }
	  function onMouseUp(event){
	    mf=false;
	  }
	  function drawLine(){
	    ct.beginPath();
	    ct.moveTo(ox,oy);
	    ct.lineTo(x,y);
	    ct.stroke();
	  }
	  function clearCan(){
	    ct.clearRect(0, 0, can.width, can.height);
	  }
	  function getBlobFromCanvas(){
		  const base64 = can.toDataURL("image/png");              // "data:image/png;base64,iVBORw0k～"
		  const tmp  = base64.split(",");                     // ["data:image/png;base64,", "iVBORw0k～"]
		  const data = atob(tmp[1]);                          // 右側のデータ部分(iVBORw0k～)をデコード
		  const mime = tmp[0].split(":")[1].split(";")[0];    // 画像形式(image/png)を取り出す

		  // Blobのコンストラクタに食わせる値を作成
		  let buff = new Uint8Array(data.length);
		  for (let i = 0; i < data.length; i++) {
		    buff[i] = data.charCodeAt(i);
		  }

		  return(
		    new Blob([buff], { "image/png": mime })
		  );
	  }
	  function getImgDataFromCanvas(){
		  const base64 = can.toDataURL("image/png");              // "data:image/png;base64,iVBORw0k～"
		  const tmp  = base64.split(",");                     // ["data:image/png;base64,", "iVBORw0k～"]
		  return tmp[1];
	  }
	  // Canvasに描かれているオブジェクトのRGBA配列の値（0 ～ 255）を集計する
	  function getRGBASummary() {
		  var image = can.getContext("2d").getImageData(0, 0, can.width, can.height);
		  var data = image.data;
		  var sum = data.reduce(function(prev, current, i, arr) { return prev+current; });
		  return sum;
	  }
	  function checkRGBASummary() {
		  var sum = getRGBASummary();
		  if (sum > 0) {
			  return true;
		  } else {
			  return false;
		  }
	  }

