<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
   <!-- Here can be a link to your external CSS page -->
    <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/main.css">
  </head>
<body>

<title>${message}</title>

<div id="container" style="height:500px;width:500px">
  <div id="banner" style="background-color:#66CDAA;height:100px;width:500px;">
   <br>
     <b style="font-family:arial;color:#FFFFFF;font-size:20px;">Wow! This code works!
     </b>
  </div>

 <div id="page" style="background-color:#F5F5F5;height:400px;width:500px;float:left;">

    <h1 style="font-family:arial;color:#66CDAA;font-size:15px;">Here your order information:</h4>
    <br>

    <p>Order id:   <b>${order_id}</b></p>
    <p>Product name:   <b>${product_name}</b></p>
    <p>Customer name:   <b>${customer_name}</b></p>
    <br>
    <a href="http://localhost:8080/SpringJavaConfig-1.0-SNAPSHOT/order_page"><p style="font-family:arial;color:#66CDAA;font-size:15px;">Back to order page</p></a>
  </div>
</div>

</body>
</html>