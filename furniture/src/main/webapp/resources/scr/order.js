$(onload)

function onload() {
	$('#add').off('click');
	$('#add').on('click', function (){
		if ($('#product').val() != null && $('#product').val() != "")
			$.getJSON("/furniture/get-product", { id: $('#product').val() }, function (product) {
				$('<tr>').append(
						$('<input>', {style: 'display:none;', value: product.id}),
						$('<td>', {text: locale == 'ru' ? product.nameRu : product.nameEn }),
						$('<td>', {text: product.price}),
						$('<td>').append(
						$('<a>', {text: 'X', href: '#', click: function () {
							var oldTotal = $('#total').val();
							$('#total').val(oldTotal - product.price);
							$(this).parent().parent().remove();
						}}))
				).appendTo('#product-list');
				var oldTotal = $('#total').val();
				$('#total').val((oldTotal - 0) + (product.price - 0));
			});
	});
	
	$('#load_products').click(function () {
		$.getJSON("/furniture/load-products-from-category",
				{ id: $('#category').val() },
				function (productList) {
					var productSelect = $('#product');
					productSelect.empty();
					for (var i in productList) {
						product = productList[i]
						$('<option>', { value : product.id,
							text : locale == 'ru' ? product.nameRu : product.nameEn })
							.appendTo(productSelect);
					}
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
	if (!initCheck())
		return false;
	var index = 0;
	$('table tr input').each(function (i, e) {
		$(this).prop('name', 'products['+index+++'].product.id');
	});
    flag = true;
    $(form).submit();
    return false;
}

function initCheck() {
	var param = {'fio' : 'iffilled',
			'phone' : 'isPhone',
			'address' : 'iffilled'
			};
	var flag = true;
	if ($('#product-list').children().children().size() == 1) {
		$('#list_error').show();
		flag = false;
	} else
		$('#list_error').hide();
	return check(param);
}

