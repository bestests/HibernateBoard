var contextRoot = "http://localhost:8008/HibernateBoard/board/";

var getParams = function (url) {
  if(url.indexOf("?") == -1) return null;

  var paramObj = new Object;
  var params   = url.split("?")[1];
  var paramArr = [];

  if(params.indexOf("&") >= 0) {
    paramArr = params.split("&");
  } else {
    paramArr[0] = params;
  }

  for(var i = 0 ; i < paramArr.length ; i++) {
    var param = paramArr[i].split("=");

    paramObj[param[0]] = param[1];
  }

  return paramObj;
};