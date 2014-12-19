
$(onload);

function onload() {
	setPresender('photo');
	
	$('#load_products').click(function () {
		$.getJSON("/furniture/admin/load-products-from-category",
				{ id: $('#category').val() },
				function (productList) {
					var productSelect = $('#product');
					productSelect.empty();
					for (var i in productList) {
						product = productList[i]
						$('<option>', { value : product.id,
							text : product.nameRu + ' | ' + product.nameEn })
							.appendTo(productSelect);
					}
				});
	});
}

function initCheck() {
	var param = {'image1' : 'isImageSelected',
			'product' : 'iffilled'
	};
	return check(param);
}

function isImageSelected(eid) {
	var keepImg = $('#keepimg').prop('checked');
	return checkField(eid, !($('#' + eid).val() == "" && (!keepImg || keepImg == undefined)));
}