$(document)
		.ready(
				function() {
					var currentPosition = 0;
					var slideWidth = 1200;
					var slides = $('.slide');
					var numberOfSlides = slides.length;

					// Удалить полосу прокрутки в JS
					$('#slidesContainer').css('overflow', 'hidden');

					// Обернуть все .slides в div #slideInner
					slides.wrapAll('<div id="slideInner"></div>')
					// Float left to display horizontally, readjust .slides
					// width
					.css({
						'float' : 'left',
						'width' : slideWidth
					});

					// Установить ширину #slideInner равной общей ширине всех
					// слайдов
					$('#slideInner').css('width', slideWidth * numberOfSlides);

					// Вставить левый и правый элементы управления в DOM
					$('#slidesContainer')
							.prepend(
									'<span class="control" id="leftControl">Move left</span>')
							.append(
									'<span class="control" id="rightControl">Move right</span>');

					// Скрыть левый элемент управления при первой загрузке
					manageControls(currentPosition);

					// Создать слушатели события щелчка .controls
					$('.control')
							.bind(
									'click',
									function() {
										// Определить новое положение
										currentPosition = ($(this).attr('id') == 'rightControl') ? currentPosition + 1
												: currentPosition - 1;

										// Скрыть/показать элементы управления
										manageControls(currentPosition);
										// Move slideInner using margin-left
										$('#slideInner')
												.animate(
														{
															'marginLeft' : slideWidth
																	* (-currentPosition)
														});
									});

					// manageControls: Скрывает и показывает элементы управления
					// в зависимости от currentPosition
					function manageControls(position) {
						// Скрыть левый элемент управления, если position –
						// первый слайд
						if (position == 0) {
							$('#leftControl').hide()
						} else {
							$('#leftControl').show()
						}
						// Скрыть правый элемент управления, если position –
						// последний слайд
						if (position == numberOfSlides - 1) {
							$('#rightControl').hide()
						} else {
							$('#rightControl').show()
						}
					}
					$('#rightControl').hide();
					$('#leftControl').hide();
					
					//while (1) 
						setInterval(function (){
							currentPosition++;
							if (currentPosition >= numberOfSlides)
								currentPosition = 0;
							$('#slideInner')
							.animate(
									{
										'marginLeft' : slideWidth
												* (-currentPosition)
									});
						}, 5000);
				});
