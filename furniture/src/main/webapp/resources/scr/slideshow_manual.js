$(function() {
	var elWrap = $('#slider'), el = elWrap.find('.slide'), indexImg = 1, indexMax = el.length;
	
	if (indexMax == 0) {
		$('#slideshow').empty();
	}

	function change() {
		el.hide();
		el.filter(':nth-child(' + indexImg + ')').show();
	}

	function autoCange() {
		indexImg++;
		if (indexImg > indexMax) {
			indexImg = 1;
		}
		change();
	}

	$('#next').click(function() {
		indexImg++;
		if (indexImg > indexMax) {
			indexImg = 1;
		}
		change();
	});
	$('#prev').click(function() {
		indexImg--;
		if (indexImg < 1) {
			indexImg = indexMax;
		}
		change();
	});
});