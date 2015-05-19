<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
<form action="/controller/orderline.create?id=${product.id}" method="get">

<h1>${product.name}</h1>
<h2>Details  ${product.id}</h2>
<div>Code: ${product.code}</div>
<div>Price: ${product.price}</div>
<div>Description: ${product.description}</div>
<div>Quantita: <input type="number" name="quantita"/></div>
<div><input type="submit" name="sumbit" value="aggiungi" /></div>
</form>
			

</body>
</html>