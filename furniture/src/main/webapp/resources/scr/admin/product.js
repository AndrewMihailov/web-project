
$(onload);

function onload() {
	setPresender('product');
	
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}

function initCheck() {
	var param = {'nameRu' : 'iffilled',
			'nameEn' : 'iffilled',
			'price' : 'iffilled'
			};
	return check(param);
}
