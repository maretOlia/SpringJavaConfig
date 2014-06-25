<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
  <head>
   <!-- Here is a link to your external CSS page -->
   <link rel="stylesheet" type="text/css" href="http://localhost:8080/css/main.css">
  </head>
<body>

<title>${message}</title>

<div id="container" style="height:500px;width:500px">
  <div id="banner" style="background-color:#66CDAA;height:100px;width:500px;"><br>
   <b style="font-family:arial;color:#FFFFFF;font-size:20px;">Let's see whether this strange code works...</b>
  </div>

  <div id="page" style="background-color:#F5F5F5;height:400px;width:500px;float:left;">
    <h1 style="font-family:arial;color:#66CDAA;font-size:15px;">Please, make your order!</h4>
    <br>

    <!-- Here we are binding input fields in Order - type object -->

    <form:form method="post" action="make_order" modelAttribute="order" >

      <label><span>Pick the product:</span>

      <label><select name="productName" style="width:152px;font-family:arial;color:grey;font-size:12px;">
               <option>${Good_product}</option>
               <option>${Wonderful_product}</option>
               <option>${The_best_one}</option>
               <option>${Beautiful_product}</option>
             </select>
      </label>

      <label><span>Your name:</span></label>
      <label> <input type="text" name="customerName"/></label>
      <label><input type="submit" value="Try this code ;)"/></label>
    </form:form>
    <br>
   </div>
</div>
</body>
</html>