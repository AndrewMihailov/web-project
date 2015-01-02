
$(onload);

function onload() {
	setPresender('contact');
	
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}

function initCheck() {
	var param = {'fio' : 'iffilled',
			'telNumber' : 'isPhone',
			'type' : 'iffilled',
			'email' : 'isEmail',
			'address' : 'iffilled'
			};
	return check(param);
}
