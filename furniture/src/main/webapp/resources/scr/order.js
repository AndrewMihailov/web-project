$(onload)

function onload() {
	$('#add').click(function (){
		$.getJSON("/furniture/get-product", { id: $('#product').val() }, function (product) {
			$('<tr>').append(
					$('<input>', {hidden: true, value: product.id}),
					$('<td>', {text: product.name}),
					$('<td>', {text: product.price}),
					$('<td>').append(
					$('<a>', {text: 'X', href: '#', click: function () {
						var oldTotal = $('#total').text();
						$('#total').text(oldTotal - product.price);
						$(this).parent().parent().remove();
					}}))
			).appendTo('#product-list');
			var oldTotal = $('#total').text();
			$('#total').text((oldTotal - 0) + (product.price - 0));
		});
	});
	$('form[name="order"]').submit(function(e) {
	    if(!flag){
	        e.preventDefault();
	        sendData(this);
	    }
	});
}

var flag = false;
function sendData(form) {
	var index = 0;
	$('table tr input').each(function (i, e) {
		$(this).prop('name', 'products['+index+++'].product.id');
	});
    flag = true;
    $(form).submit();
    return false;
}

