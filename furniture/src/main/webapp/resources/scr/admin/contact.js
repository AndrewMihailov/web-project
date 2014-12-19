
$(onload);

function onload() {
	setPresender('contact');
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
